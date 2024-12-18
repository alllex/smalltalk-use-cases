abstract class RenderSamples : DefaultTask() {
    @get:Input
    abstract val samples: ListProperty<LibrarySamples>

    @get:OutputFile
    abstract val output: RegularFileProperty

    @TaskAction
    fun render() {
        render(samples.get(), output.get().asFile)
    }

    private fun render(samples: List<LibrarySamples>, output: File) {
        output.writeText("# Samples for libraries")
        for (samplesOfLibrary in samples) {
            output.appendText("\n\n## Samples for '${samplesOfLibrary.library}'\n")
            for (sample in samplesOfLibrary.samples) {
                output.appendText("\n${sample.name}\n```\n${sample.code}\n```")
            }
        }
    }
}

// Locate all projects that are libraries among all projects and import their samples

// Approach 1: map reduce

// TODO: this approach does not work yet
val allLibraries: Provider<List<LibraryMarker>> =
    isolated.models.request(LibraryMarker::class, allprojects)
        .present // leniently find all projects that are libraries

val allLibrarySamples1: Provider<List<LibrarySamples>> =
    allLibraries.flatMap { libraryMarkers ->
        println("Y: libraryMarkers: $libraryMarkers")
        val libraryProjects = libraryMarkers.map {
            project.findProject(it.projectPath)!!
        }

        val allSamples: Provider<List<LibrarySamples>> =
            isolated.models.request(LibrarySamples::class, libraryProjects)
                .all
        allSamples // strictly require each library to provide samples
    }

// Approach 2: lenient models

val allLibrarySamples2: Provider<List<LibrarySamples>> =
    isolated.models.request(LibrarySamples::class, allprojects)
        .present // leniently

tasks.register<RenderSamples>("samplesDocument") {
    samples = allLibrarySamples2
    output = layout.buildDirectory.file("samples.md")
}
