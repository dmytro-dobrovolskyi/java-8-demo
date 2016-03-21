package com.softserveinc.ddob.capture;

import com.softserveinc.ddob.capture.util.ClassPrinter;

public class AnonymousCapturing {
    public static void main(String[] args) {
        int x = 777;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(x + " has been captured.");
            }
        };

        ClassPrinter.printClassMetadata(runnable.getClass());
    }
}
