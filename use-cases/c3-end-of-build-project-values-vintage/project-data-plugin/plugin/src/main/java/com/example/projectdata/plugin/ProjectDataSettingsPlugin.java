package com.example.projectdata.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.initialization.Settings;
import com.example.projectdata.ProjectData;

public class ProjectDataSettingsPlugin implements Plugin<Settings> {

    @Override
    public void apply(Settings settings) {
        System.out.printf("Applying %s to %s\n", this, settings.getRootDir());
        settings.getGradle().rootProject((Project rootProject) -> {
            System.out.println("Creating project extension under every project");
            rootProject.allprojects(project -> project.getExtensions().create("projectState", ProjectData.class));
        });

        settings.getGradle().buildFinished(result -> {
            System.out.println("Consuming project custom values at the end of the build");
            result.getGradle().getRootProject().getAllprojects().forEach(project -> {
                ProjectData state = project.getExtensions().getByType(ProjectData.class);
                System.out.printf("Project '%s' state: %s\n", project.getName(), state.getAll());
            });
        });
    }
}
