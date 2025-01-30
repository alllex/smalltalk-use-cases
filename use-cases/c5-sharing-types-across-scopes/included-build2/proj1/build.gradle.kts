import com.example.scopeddata.LanguageMetadata

//plugins {
//    id("org.springframework.boot") version "3.3.1"
//}
plugins {
    java
    id("scoped-data-project-plugin")
}

buildscript {
    dependencies {
        classpath("org.apache.commons:commons-lang3:3.17.0")
        //classpath("api-build:api:1.0")
    }
}

val metadata = objects.newInstance(LanguageMetadata::class)
metadata.setLanguageFrom("Kotlin", this.toString())
val metadataProperty = objects.property(LanguageMetadata::class)
metadataProperty.set(metadata)
isolated.models.register(LanguageMetadata::class, metadataProperty)
