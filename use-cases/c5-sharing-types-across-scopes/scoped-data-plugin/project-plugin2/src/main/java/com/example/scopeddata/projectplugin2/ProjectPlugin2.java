package com.example.scopeddata.projectplugin2;

import com.example.scopeddata.LanguageMetadata;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import com.example.scopeddata.plugin.*;

public class ProjectPlugin2 implements Plugin<Project> {

    public void apply(Project target) {
        System.out.printf("Applying %s to %s\n", this, target.getProjectDir());
        target.afterEvaluate(p -> Debug.debugClassloader(this.getClass().getClassLoader()));
        Debug.debugClassloader(LanguageMetadata.class.getClassLoader());
    }
}
