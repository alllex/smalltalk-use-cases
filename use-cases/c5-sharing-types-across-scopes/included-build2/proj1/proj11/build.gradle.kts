import com.example.scopeddata.LanguageMetadata

plugins {
    `java-base`
    `java-library`
    //id("scoped-data-project-plugin")
}

buildscript {
    dependencies {
        //classpath("api-build:api:1.0")
        classpath("org.apache.commons:commons-lang3:3.16.0")
        classpath("commons-net:commons-net:3.11.1")
    }
}

val metadata = objects.newInstance(LanguageMetadata::class)
metadata.setLanguageFrom("Java", this.toString())
val metadataProperty = objects.property(LanguageMetadata::class)
metadataProperty.set(metadata)
isolated.models.register(LanguageMetadata::class, metadataProperty)
