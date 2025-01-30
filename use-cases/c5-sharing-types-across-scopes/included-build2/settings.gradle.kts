rootProject.name="included2"

pluginManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("../scoped-data-plugin")
}
include(":proj1")
include(":proj1:proj11")
include(":proj1:proj12")
include(":proj2")

plugins {
    //id("scoped-data-codeless-settings-plugin")
    //id("scoped-data-settings-plugin")
    id("scoped-data-empty-settings-plugin") apply false
    id("scoped-data-project-plugin") apply false
}
