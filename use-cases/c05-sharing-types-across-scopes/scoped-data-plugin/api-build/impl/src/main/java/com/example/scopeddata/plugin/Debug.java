package com.example.scopeddata.plugin;

import java.net.URL;
import java.net.URLClassLoader;

public class Debug {
    public static void debugClassloader(ClassLoader cl) {
        System.out.printf("Classloader: %s\n", cl);
//        URL[] urls = ((URLClassLoader) cl).getURLs();
//        for (URL url : urls) {
//            System.out.printf("\t%s\n", url);
//        }
    }
}
