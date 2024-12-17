pluginManagement {
    includeBuild("build-logic")
}
plugins {
    id("my-settings-plugin")
}

rootProject.name = "c2-settings-flag-as-task-input"

include(":app")

myJava {
    progressiveMode = true
}
