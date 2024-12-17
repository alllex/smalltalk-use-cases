package my;

import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;
import org.gradle.api.provider.Property;

public class SettingsPlugin implements Plugin<Settings> {

    @Override
    public void apply(Settings target) {
        MyJavaExtension myJava =
            target.getExtensions().create("myJava", MyJavaExtension.class);

        final Property<Boolean> javaProgressiveMode = myJava.getProgressiveMode();
        javaProgressiveMode.convention(false);

        // This solution works, but it pushes the value into all projects
        target.getGradle().getLifecycle().beforeProject(project ->
            project.getExtensions().getExtraProperties()
                .set("javaProgressiveMode", javaProgressiveMode)
        );
    }
}
