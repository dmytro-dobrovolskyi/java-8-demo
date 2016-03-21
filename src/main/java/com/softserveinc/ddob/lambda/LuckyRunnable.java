package com.softserveinc.ddob.lambda;

import java.util.Random;

public class LuckyRunnable {
    public static Runnable luckyRunnable() {
        int luckyNumber = new Random().nextInt();

        Runnable luckyRunnable = () -> {
            System.out.println("Your luck number is " + luckyNumber);
        };

        // luckyNumber = 777;

        return luckyRunnable;
    }
}
