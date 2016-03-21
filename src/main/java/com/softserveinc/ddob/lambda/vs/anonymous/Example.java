package com.softserveinc.ddob.lambda.vs.anonymous;

public class Example {
    public static Runnable runnableLambda() {
        return () -> System.out.println("I love lambdas!");
    }

    public static Runnable runnableAnonymous() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("I love anonymous classes?");
            }
        };
    }

    public static void main(String[] args) {
        Runnable runnable = runnableLambda();
        runnable.run();
    }
}
