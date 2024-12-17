plugins {
    application
}

application {
    mainClass = "Main"
}

val progressiveMode = ext.get("javaProgressiveMode") as Provider<Boolean>

tasks.compileJava {
    // TODO: map the provider into a compiler flag, instead of an imperative if
    if (progressiveMode.get()) {
        options.compilerArgs.add("--enable-preview")
    }
}