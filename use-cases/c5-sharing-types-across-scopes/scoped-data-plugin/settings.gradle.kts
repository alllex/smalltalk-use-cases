includeBuild("api-build")
include("settings-plugin")
include("project-plugin")
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
