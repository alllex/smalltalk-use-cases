rootProject.name="root"

pluginManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("scoped-data-plugin")
}
plugins {
//    id("scoped-data-empty-settings-plugin")
    id("scoped-data-empty-settings-plugin") apply false
    id("scoped-data-project-plugin") apply false
}
includeBuild("included-build1")
includeBuild("included-build2")

include(":proj1")
include(":proj1:proj11")
include(":proj1:proj12")
include(":proj2")
include(":aggregator")

gradle.lifecycle.beforeProject {
    project.repositories {
        mavenCentral()
    }
}
