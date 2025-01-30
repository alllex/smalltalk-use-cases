plugins {

    id("java-gradle-plugin")
    id("maven-publish")
}

dependencies {
    api(project(":api"))
}

repositories {
    mavenCentral()
}

version = "1.0"

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        mavenLocal() // Publish to the local Maven repository (~/.m2/repository)
    }
}
