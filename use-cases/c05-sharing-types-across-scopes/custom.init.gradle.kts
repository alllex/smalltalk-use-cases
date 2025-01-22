initscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("api-build:api:1.0")
        classpath("scoped-data-gradle-plugin:scoped-data-gradle-plugin.gradle.plugin:1.0")
    }
}

apply {
    type(com.example.scopeddata.gradleplugin.GradlePlugin::class.java)
}


