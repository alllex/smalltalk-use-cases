plugins {
    id("my-java-library")
}

// Contributing some samples at configuration time

val samplesFiles: Set<File> =
    layout.projectDirectory.dir("samples").asFileTree.files

// TODO: can we avoid making file context a configuration input?
val samples = samplesFiles.map {
    LibrarySample(name = it.name, code = it.readText())
}

isolated.models.register(LibrarySamples::class, providers.provider {
    LibrarySamples("Library 1", samples)
})
