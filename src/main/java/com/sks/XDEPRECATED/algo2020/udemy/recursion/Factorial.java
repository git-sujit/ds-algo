package com.sks.XDEPRECATED.algo2020.udemy.recursion;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) return 1;
        int factorial = 1;
        for (int i = 0; i < n; i++) {
            factorial *= (n - i);
        }
        return factorial;
    }

    public static int factorial_recursive(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("### ITERATIVE APPROACH ###");
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(5));
        System.out.println(factorial(11));
        System.out.println("### RECURSIVE APPROACH ###");
        System.out.println(factorial_recursive(0));
        System.out.println(factorial_recursive(1));
        System.out.println(factorial_recursive(5));
        System.out.println(factorial_recursive(11));
    }
}
