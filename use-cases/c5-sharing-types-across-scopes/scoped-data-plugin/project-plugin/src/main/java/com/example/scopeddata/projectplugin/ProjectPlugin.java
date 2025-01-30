package com.example.scopeddata.projectplugin;

import com.example.scopeddata.LanguageMetadata;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import com.example.scopeddata.plugin.*;
import org.gradle.api.isolated.models.ProjectModelScope;
import org.gradle.api.isolated.models.ProjectScopeModelRequest;
import org.gradle.internal.Cast;

import java.util.List;

public class ProjectPlugin implements Plugin<Project> {

    public void apply(Project target) {
        System.out.printf("Applying %s to %s\n", this, target.getProjectDir());
        target.afterEvaluate(p -> Debug.debugClassloader(this.getClass().getClassLoader()));
        Debug.debugClassloader(LanguageMetadata.class.getClassLoader());
        String aggregateChoice = Cast.uncheckedCast(target.findProperty("org.example.scoped-data-project-plugin.aggregate"));
        if ("untyped".equals(aggregateChoice)) {
            System.out.printf("%s is an aggregating project\n", target.getBuildTreePath());
            target.getGradle().projectsEvaluated(g -> collectUntypedData(g.getRootProject().getIsolated().getModels()));
        } else if (aggregateChoice != null && !aggregateChoice.trim().isEmpty()) {
            System.out.printf("%s is an aggregating project\n", target.getBuildTreePath());
            target.getGradle().projectsEvaluated(g -> collectTypedData(g.getRootProject().getIsolated().getModels()));
        } else {
            System.out.printf("%s is NOT an aggregating project\n", target.getBuildTreePath());
        }
    }

    private void collectUntypedData(ProjectModelScope models) {
        ProjectScopeModelRequest<Object> allProjectMetadata = models.requestAllModels();
        System.out.printf("*** Collecting untyped models: \n");
        List<Object> allMetadata = allProjectMetadata.getPresent().get();
        allMetadata.forEach(x -> {
            System.out.println(x);
        });
    }

    private void collectTypedData(ProjectModelScope models) {
        ProjectScopeModelRequest<LanguageMetadata> allProjectMetadata = models.requestAllValues(LanguageMetadata.class);
        System.out.printf("*** Collecting typed models: \n");
        List<LanguageMetadata> allMetadata = allProjectMetadata.getPresent().get();
        allMetadata.forEach(x -> {
            System.out.printf("%s = %s (from %s)\n", x.getLanguage(), x.getLanguage().getOrNull(), x.getSource().getOrNull());
        });
    }
}
