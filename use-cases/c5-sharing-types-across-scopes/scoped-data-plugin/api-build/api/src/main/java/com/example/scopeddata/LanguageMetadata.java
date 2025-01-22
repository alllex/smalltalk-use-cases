package com.example.scopeddata;

import org.gradle.api.provider.Property;

public interface LanguageMetadata {
    Property<String> getLanguage();
    Property<String> getSource();
    default void setLanguageFrom(String language, String source) {
        getLanguage().set(language);
        getSource().set(source);
    }
}
