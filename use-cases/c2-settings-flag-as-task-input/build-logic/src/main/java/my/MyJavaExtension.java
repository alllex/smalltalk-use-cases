package my;

import org.gradle.api.provider.Property;

public interface MyJavaExtension {

    Property<Boolean> getProgressiveMode();

}
