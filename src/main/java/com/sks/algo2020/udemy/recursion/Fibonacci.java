package com.sks.algo2020.udemy.recursion;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class Fibonacci {

    public static int fibonacci_dynamicProgramming(int n) {
        int[] a = new int[n + 1];
        int result = fibonacci_better(n, a);
        System.out.println("First " + n + " Fibonacci series = " + Arrays.toString(a));
        return result;
    }

    public static int fibonacci_better(int n, int[] a) {
        if (n == 0 || n == 1) {
            a[n] = n;
            return n;
        }
        if (a[n] == 0)
            a[n] = fibonacci_better(n - 1, a) + fibonacci_better(n - 2, a);
        return a[n];
    }

    public static int fibonacci(int n, int[] a) {
        if (n == 0) {
            a[0] = 0;
            return 0;
        } else if (n == 1) {
            a[1] = 1;
            return 1;
        }
        if (a[n - 1] == 0)
            a[n - 1] = fibonacci(n - 1, a);
        if (a[n - 2] == 0)
            a[n - 2] = fibonacci(n - 2, a);
        a[n] = a[n - 1] + a[n - 2];
        return a[n];
    }

    public static int nthFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ll = 0;
        int l = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = ll + l;
            ll = l;
            l = next;
        }
        return next;
    }

    public static int nthFibonacci_recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return nthFibonacci_recursive(n - 1) + nthFibonacci_recursive(n - 2);
    }

    public static void printFibonacci_recursive(int n) {
        printFibonacci_recursive(n, 0, 0, 0);
    }

    private static void printFibonacci_recursive(int n, int p, int ll, int l) {
        if (p == 0) {
            System.out.print(0);
        } else if (p == 1) {
            System.out.print(1);
        } else if (p == 2) {
            System.out.print(1);
            ll = 0;
            l = 1;
        } else {
            System.out.print(l + ll);
        }
        if (p == n) return;
        else System.out.print(",");
        printFibonacci_recursive(n, ++p, l, l + ll);
    }

    public static void printFibonacci(int n) {
        int l = 1;
        int ll = 0;
        int next;
        for (int i = 0; i <= n; i++) {
            if (i < 2)
                System.out.print(i);
            else {
                next = l + ll;
                System.out.print(next);
                ll = l;
                l = next;
            }
            if (i < n)
                System.out.print(",");
        }
    }

    public static void main(String[] args) {
        System.out.println("### ITERATIVE APPROACH ###");
        printFibonacci(15);
        System.out.println("\n### RECURSIVE APPROACH ###");
        printFibonacci_recursive(15);
        System.out.println("\n### ITERATIVE : nth Fibonacci ###");
        System.out.println(nthFibonacci(0));
        System.out.println(nthFibonacci(1));
        System.out.println(nthFibonacci(2));
        System.out.println(nthFibonacci(4));
        System.out.println(nthFibonacci(7));
        System.out.println(nthFibonacci(10));
        System.out.println("\n### RECURSIVE : nth Fibonacci ###");
        System.out.println(nthFibonacci_recursive(0));
        System.out.println(nthFibonacci_recursive(1));
        System.out.println(nthFibonacci_recursive(2));
        System.out.println(nthFibonacci_recursive(4));
        System.out.println(nthFibonacci_recursive(7));
        System.out.println(nthFibonacci_recursive(10));
        System.out.println("\n### DYNAMIC PROGRAMMING : nth Fibonacci ###");
        System.out.println(fibonacci_dynamicProgramming(11));

    }
}
