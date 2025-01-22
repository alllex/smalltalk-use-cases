package com.example.scopeddata.gradleplugin;

import com.example.scopeddata.LanguageMetadata;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.invocation.Gradle;

/**
 * A plugin that can be applied to an init script.
 */
public class GradlePlugin implements Plugin<Gradle> {

    @Override
    public void apply(Gradle target) {
        System.out.printf("Applying to %s\n", target);
        target.settingsEvaluated(settings -> {
            Project rootProject = settings.getGradle().getRootProject();
            LanguageMetadata languageMetadata = rootProject.getObjects().newInstance(LanguageMetadata.class);
            languageMetadata.setLanguageFrom("*", this.toString());
        });
    }
}
