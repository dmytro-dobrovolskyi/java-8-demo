package com.softserveinc.ddob.capture.util;

import java.util.Arrays;

public class ClassPrinter {
    public static void printClassMetadata(Class<?> clazz) {
        System.out.printf("Class name:\n\t%s\n", clazz.getName());
        System.out.printf("Declared fields:\n\t%s\n", Arrays.toString(clazz.getDeclaredFields()));
        System.out.printf("Declared methods:\n\t%s\n", Arrays.toString(clazz.getDeclaredMethods()));
        System.out.printf("Declared constructors:\n\t%s\n", Arrays.toString(clazz.getDeclaredConstructors()));
    }
}
