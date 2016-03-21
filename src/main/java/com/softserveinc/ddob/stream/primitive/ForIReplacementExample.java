package com.softserveinc.ddob.stream.primitive;

import java.util.stream.IntStream;

public class ForIReplacementExample {
    public static void main(String[] args) {
        int n = 10;

        IntStream
                .range(0, n)
                .forEach(index -> System.out.println(
                        String.format("Executed %d time", index)
                ));
    }
}
