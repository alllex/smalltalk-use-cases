import com.example.scopeddata.LanguageMetadata

plugins {
    id("scoped-data-project-plugin")
    id("scoped-data-project-plugin2")
    `groovy-gradle-plugin`
}

val metadata = objects.newInstance(LanguageMetadata::class)
metadata.setLanguageFrom("Cobol", this.toString())
val metadataProperty = objects.property(LanguageMetadata::class)
metadataProperty.set(metadata)
isolated.models.register(LanguageMetadata::class, metadataProperty)
