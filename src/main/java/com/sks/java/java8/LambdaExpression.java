package com.sks.java.java8;
/**
 * Lambda: To enable "Functional Programming" and simple/concise/readable code in Java(Java is mainly OOP)
 * Streams: To enable "Parallel Programming" in java (Leverage Multi-core processors)
 */

/**
 * Lambda expression is anonymous(not having name/setters/return) function.
 * Functional Interface is required to call lambda expression
 */
public class LambdaExpression {
    public static void main(String[] args) {
        testCustomFunctionalInterfaces();
        testExistingFunctionalInterface();
    }

    private static void testExistingFunctionalInterface() {
        oldWays();
        lambdaWays();
    }

    private static void lambdaWays() {
        // No need to create a Class for Runnable
        Runnable job = () -> {
            for (int i = 1; i <= 5; i++)
                System.out.println(i + ". [Lambda]Child-Thread Running");
        };
        Thread th = new Thread(job);
        th.start();
        for (int i = 1; i <= 5; i++)
            System.out.println(i + ". [Lambda] Main-Thread Running");
    }

    private static void oldWays() {
        Runnable job = new MyRunnable();
        Thread th = new Thread(job);
        th.start();
        for (int i = 1; i <= 5; i++)
            System.out.println(i + ". Main-Thread Running");


    }

    private static void testCustomFunctionalInterfaces() {
        int a = 3;
        int b = 4;
        System.out.println("[Old Ways] Sum = " + sum_oldWays(a, b));
        Summable fi = (int i1, int i2) -> (i1 + i2);
        //Type Inference: Compiler resolves the type of method params by looking into interface definition of SAM
        Summable fi1 = (i1, i2) -> (i1 + i2);
        System.out.println("[Lambda] Sum = " + fi.sum(a, b));
        System.out.println("[Lambda+TypeInference] Sum = " + fi1.sum(a, b));

        StringLengthInterface sli = (s) -> s.length();
        String s = "SUJIT";
        System.out.println("String = " + s + ", Length = " + sli.length(s));

        SquareInterface si = (i) -> i * i;
        int i = 9;
        System.out.println("Number = " + i + ", Square = " + si.square(i));
    }

    private static int sum_oldWays(int a, int b) {
        return a + b;
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++)
                System.out.println(i + ". Child-Thread Running");
        }
    }

    @FunctionalInterface
    interface SquareInterface {
        int square(int i);
    }

    @FunctionalInterface
    interface StringLengthInterface {
        int length(String s);
    }

    @FunctionalInterface
    interface Summable {
        // Single Abstract Method-SAM
        public int sum(int a, int b);

        // Multiple default methods
        default void d1() {
        }

        default void d2() {
        }

        // Multiple static methods
        static void s1() {
        }

        static void s2() {
        }

        static void s3() {
        }
    }
}
