plugins {
    id("my-java-library")
}

val generateSamplesTask = tasks.register("generateSamples") {
    val outputDir = layout.buildDirectory.dir("generated-samples")
    outputs.dir(outputDir)
    doLast {
        outputDir.get()
            .file("sample1.txt")
            .asFile
            .apply { parentFile.mkdirs() }
            .writeText("// Library 2 sample")
    }
}


val samples = generateSamplesTask.map { task ->
    val samplesDirectory = task.outputs.files.files.first()
    samplesDirectory.listFiles()!!.map { sampleFile ->
        LibrarySample(sampleFile.name, sampleFile.readText())
    }
}

// TODO: this does not work yet

isolated.models.register(LibrarySamples::class, samples.map {
    LibrarySamples("Library 2", it)
})
