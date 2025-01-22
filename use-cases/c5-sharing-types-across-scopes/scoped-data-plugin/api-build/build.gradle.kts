group = "api-build"

subprojects {
    apply(plugin = "maven-publish")
    version = "1.0"
    afterEvaluate {
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
    }
}
