
pluginManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("../scoped-data-plugin")
}
include(":child-proj1")
include(":child-proj2")

plugins {
    id("scoped-data-settings-plugin")
}
