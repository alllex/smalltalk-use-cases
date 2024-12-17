

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
        output.writeText("# Samples for libraries\n\n")
        for (samplesOfLibrary in samples) {
            output.appendText("## Samples for '${samplesOfLibrary.library}'\n")
            for (sample in samplesOfLibrary.samples) {
                output.appendText("\n${sample.name}\n```\n${sample.code}\n```")
            }
        }
    }
}

// Locate all projects that are libraries among all projects and import their samples

// Approach 1: map reduce

// Approach 2: lenient models


tasks.register<RenderSamples>("samplesDocument") {
    // TODO: configure `samples` input
    samples.add(LibrarySamples("lib", listOf(LibrarySample("sample1", "// comment"))))
    output = layout.buildDirectory.file("samples.md")
}