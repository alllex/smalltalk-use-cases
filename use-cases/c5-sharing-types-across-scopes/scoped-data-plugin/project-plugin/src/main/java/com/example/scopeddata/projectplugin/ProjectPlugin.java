package com.example.scopeddata.projectplugin;

import com.example.scopeddata.LanguageMetadata;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import com.example.scopeddata.plugin.*;

public class ProjectPlugin implements Plugin<Project> {

    public void apply(Project target) {
        System.out.printf("Applying %s to %s\n", this, target.getProjectDir());
        target.getExtensions().create(this.toString(), LanguageMetadata.class);
        target.afterEvaluate(p -> Debug.debugClassloader(this.getClass().getClassLoader()));
        Debug.debugClassloader(LanguageMetadata.class.getClassLoader());
    }
}
