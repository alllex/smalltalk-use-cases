import com.example.scopeddata.LanguageMetadata

plugins {
    id("scoped-data-project-plugin")
    `groovy-gradle-plugin`
}

buildscript {
    dependencies {

        classpath("api-build:api:1.0")
        classpath("org.apache.commons:commons-lang3:3.12.0")
    }
}

val metadata = objects.newInstance(LanguageMetadata::class)
metadata.setLanguageFrom("Pascal", this.toString())
val metadataProperty = objects.property(LanguageMetadata::class)
metadataProperty.set(metadata)
isolated.models.register(LanguageMetadata::class, metadataProperty)
