package com.example.scopeddata.settingsplugin;

import com.example.scopeddata.LanguageMetadata;

import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.isolated.models.ProjectScopeModelRequest;

import java.util.List;

public class SettingsPlugin implements Plugin<Settings> {
    private static final Class<LanguageMetadata> MODEL_TYPE = LanguageMetadata.class;

    @Override
    public void apply(Settings settings) {
        System.out.printf("Applying %s to %s\n", this, settings.getRootDir());
//        settings.getGradle().rootProject((Project rootProject) -> {
//            rootProject.adfterEvaluate(root -> {
//                root.allprojects(p -> {
//                    boolean shouldSkip = Optional.ofNullable(p.findProperty("skipPlugin")).map(it -> it instanceof String && Boolean.parseBoolean((String) it)).orElse(false);
//                    if (p.getParent() != null && !shouldSkip) {
//                        System.out.printf("Parent of %s: %s\n", p, p.getParent());
//                        p.apply(Maps.of("plugin", "scoped-data-project-plugin"));
//                    }
//                });
//            });
//        });

        settings.getGradle().projectsEvaluated(thisGradle -> {
            Gradle parentGradle = thisGradle.getParent();
            if (parentGradle != null) {
                System.out.printf("Skipping included build %s\n", thisGradle);
                return;
            }
            System.out.println("Consuming project custom values at the end of the build");
            System.out.printf("*** Type classloader: %s\n", LanguageMetadata.class.getClassLoader());
            ProjectScopeModelRequest<LanguageMetadata> allProjectMetadata = thisGradle.getRootProject().getIsolated().getModels().requestAllValues(MODEL_TYPE);
            System.out.printf("*** Metadata found: \n");
            List<LanguageMetadata> allMetadata = allProjectMetadata.getPresent().get();
            allMetadata.forEach(x -> {
                System.out.printf("%s = %s (from %s)\n", x.getLanguage(), x.getLanguage().getOrNull(), x.getSource().getOrNull());
            });
        });
    }
}
