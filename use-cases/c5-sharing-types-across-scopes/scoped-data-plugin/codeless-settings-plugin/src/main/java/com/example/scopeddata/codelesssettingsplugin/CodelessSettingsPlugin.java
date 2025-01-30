package com.example.scopeddata.codelesssettingsplugin;

import com.example.scopeddata.LanguageMetadata;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.isolated.models.ProjectScopeModelRequest;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CodelessSettingsPlugin implements Plugin<Settings> {

    @Override
    public void apply(Settings settings) {
        System.out.printf("Applying %s to %s\n", this, settings.getRootDir());
    }
}
