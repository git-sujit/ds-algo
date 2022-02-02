package com.sks.java.java8.predefinedFI;

import java.util.function.Predicate;

/**
 * Predicate: Check a condition & return true/false
 * Its a functional interface in Java, a function that returns true/false
 * Introduced in Java 1.8
 * Package: "java.util.function"
 */
/*- Prototype
interface Predicate {
    boolean test() {
        return true / false;
    }
}*/

public class Test_Predicate {
    public static void main(String[] args) {
        int n = 27;
        Predicate<Integer> p = null;
    }

    public static boolean isGreaterThanTen(int n) {
        return n > 10 ? true : false;
    }
}
