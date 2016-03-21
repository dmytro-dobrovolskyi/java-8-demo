package com.softserveinc.ddob.capture;

import com.softserveinc.ddob.capture.util.ClassPrinter;

public class LambdaCapturing {
    public static void main(String[] args) {
        int x = 777;

        Runnable runnable = () -> System.out.println(x + " has been captured.");

        ClassPrinter.printClassMetadata(runnable.getClass());
    }
}
