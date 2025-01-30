package com.example.scopeddata.emptysettingsplugin;

import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EmptySettingsPlugin implements Plugin<Settings> {

    @Override
    public void apply(Settings settings) {
        System.out.printf("Applying %s to %s\n", this, settings.getRootDir());
    }
}
