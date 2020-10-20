package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.Arrays;

/**
 * Find nth Fibonacci- 0 indexed
 * Fibonacci Series: 0, 1, 1, 2, 3, 5, 8...
 * 5th Fibonacci : 5
 */
public class FibonacciFinder {
    /**
     * RECURSION
     * - Time Complexity : O(2^n), Recursion tree: Total number of nodes will represent runtime since each call only does O(1) work.
     * Exactly O(1.6^n) as tree is left skewed
     * - Space Complexity: O(n), For any recursive algorithm space required is proportional to maximum depth of recursion tree
     * NOTE: Drawing recursion tree is great way to figure out runtime of recursive algorithm
     */
    public static int fibonacci_recursion(int n) {
        if (n == 0 || n == 1) return n;

        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    /**
     * MEMOIZATION
     * - Time Complexity : O(n)
     * - Space Complexity: O(n)
     */
    public static int fibonacci_memoization(int n) {
        int[] mem = new int[n + 1];
        return fibonacci_memoization(n, mem);
    }

    private static int fibonacci_memoization(int n, int[] mem) {
        if (n == 0 || n == 1) return n;

        //Check & Update Combined
        if (mem[n] == 0)
            mem[n] = fibonacci_memoization(n - 1, mem) + fibonacci_memoization(n - 2, mem);

        return mem[n];
    }

    /**
     * DYNAMIC PROGRAMMING
     * - Time Complexity : O(n)
     * - Space Complexity: O(n), mem[] storage
     */
    public static int fibonacci_dp(int n) {
        if (n == 0 || n == 1) return n;

        // Build the matrix, bottom-up
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        System.out.println("DP Table = " + Arrays.toString(mem));
        return mem[n];
    }

    /**
     * JUST BY VARIABLES
     * - Time Complexity : O(n)
     * - Space Complexity: O(1), Just two variables storage
     */
    public static int fibonacci_simplest(int n) {
        if (n == 0 || n == 1) return n;
        int l1 = 0;
        int l2 = 1;
        for (int i = 2; i < n; i++) {
            int temp = l2;
            l2 = l1 + l2;
            l1 = temp;
        }
        return l1 + l2;
    }

    public static void main(String[] args) {
        testFibonacci(0);
        testFibonacci(1);
        testFibonacci(5);
        testFibonacci(8);
        testFibonacci(10);
        testFibonacci(20);


        testFibonacci_time(45);
    }

    private static void testFibonacci(int n) {
        System.out.println("\nRecursion   : fibonacci(" + n + ") = " + fibonacci_recursion(n));
        System.out.println("Memoization : fibonacci(" + n + ") = " + fibonacci_memoization(n));
        System.out.println("Dynamic Prog: fibonacci(" + n + ") = " + fibonacci_dp(n));
        System.out.println("Simplest    : fibonacci(" + n + ") = " + fibonacci_simplest(n));
    }

    private static void testFibonacci_time(int n) {
        System.out.println("\n##### Time Complexity Analysis");
        long t1 = System.currentTimeMillis();
        System.out.println("Recursion   : fibonacci(" + n + ") = " + fibonacci_recursion(n));
        long t2 = System.currentTimeMillis();
        System.out.println("Recursion: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        System.out.println("Memoization : fibonacci(" + n + ") = " + fibonacci_memoization(n));
        t2 = System.currentTimeMillis();
        System.out.println("Memoization: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        System.out.println("Dynamic Prog: fibonacci(" + n + ") = " + fibonacci_dp(n));
        t2 = System.currentTimeMillis();
        System.out.println("Dynamic Programming: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        System.out.println("Simplest    : fibonacci(" + n + ") = " + fibonacci_simplest(n));
        t2 = System.currentTimeMillis();
        System.out.println("Simplest: Time Taken = " + (t2 - t1) + "ms");
    }
}
