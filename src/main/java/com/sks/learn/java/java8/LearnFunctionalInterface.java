package com.sks.learn.java.java8;

/**
 * Functional interface contains SAM(Single Abstract Method), but can have multiple default & static methods
 * E.g: Runnable, Callable, ActionListener, Comparable, Comparator
 * We can use Functional interface to call lambda expression
 */
public class LearnFunctionalInterface {

}

@FunctionalInterface
interface MyFirstFI {
    //Only one abstract method
    public abstract void first();

    // Functional interface can have multiple default methods
    default void m1() {
    }

    //Functional interface can have multiple static methods
    public static void m2() {
    }
}