pluginManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("scoped-data-plugin")
}
plugins {
    id("scoped-data-settings-plugin")
}
includeBuild("included-build1")
include(":proj1")
include(":proj1:proj11")
include(":proj1:proj12")
include(":proj2")

gradle.lifecycle.beforeProject {
    project.repositories {
        mavenCentral()
    }
}
