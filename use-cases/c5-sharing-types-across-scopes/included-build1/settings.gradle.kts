rootProject.name="included1"

pluginManagement {
    repositories {
        mavenCentral()
    }
    includeBuild("../scoped-data-plugin")
}
include(":child-proj1")
include(":child-proj2")

plugins {
    // NOTE: change the order or make this list contain different non-core plugins than other settings scripts in the build
    // to trigger type incompatibilities
    id("scoped-data-empty-settings-plugin") apply false
    id("scoped-data-project-plugin") apply false
}
