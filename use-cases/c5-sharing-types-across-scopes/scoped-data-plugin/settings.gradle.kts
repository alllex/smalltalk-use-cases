rootProject.name="plugins"


includeBuild("api-build")
include("settings-plugin")
include("codeless-settings-plugin")
include("empty-settings-plugin")
include("project-plugin")
include("project-plugin2")
include("gradle-plugin")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
    }
}

settings.gradle.allprojects {
//    group = "scoped-data-plugin"
//    version = "1.0"
//    beforeEvaluate {
//        plugins.apply("java-gradle-plugin")
//        plugins.apply("maven-publish")
//    }

}
