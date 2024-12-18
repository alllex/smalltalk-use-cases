plugins {
    `java-library`
}

val projectPath = project.path

// Allow finding projects that are libraries
isolated.models.register(LibraryMarker::class, providers.provider {
    LibraryMarker(projectPath)
})

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}
