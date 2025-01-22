plugins {
    id("java-gradle-plugin")
    id("maven-publish")
}

dependencies {
    implementation ("com.google.guava:guava:33.4.0-jre")
    implementation ("api-build:api:1.0")
    implementation ("api-build:impl:1.0")
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("scopedDataGradlePlugin") {
            id = "scoped-data-gradle-plugin"
            implementationClass = "com.example.scopeddata.gradleplugin.GradlePlugin"
        }
    }
}
version = "1.0"
group = "com.example"
publishing.repositories {
    mavenLocal() // Publish to the local Maven repository (~/.m2/repository)
}

publishing.publications {
    create<MavenPublication>("mavenJava") {
        from(components["java"]) // Ensures compiled classes are included
    }
}
