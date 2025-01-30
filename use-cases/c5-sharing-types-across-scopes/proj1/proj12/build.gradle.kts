import com.example.scopeddata.LanguageMetadata

plugins {
    id("scoped-data-project-plugin")
    `java-library`
    `groovy-gradle-plugin`
}

buildscript {
    dependencies {

        //classpath("api-build:api:1.0")
        classpath("org.apache.commons:commons-lang3:3.14.0")
    }
}

val sourceLocation = this.toString()
isolated.models.register(LanguageMetadata::class, objects.property(LanguageMetadata::class).value(objects.newInstance(LanguageMetadata::class).apply {
    this.setLanguageFrom("Kotlin", sourceLocation)
}))
