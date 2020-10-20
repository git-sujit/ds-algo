package com.sks.learn.ctci6.chap8_recursion_DP;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time.
 * Implement a method to count how many ways the child can run up the stairs.
 */
public class TripleStep {
    /**
     * RECURSION
     * Time Complexity : O(3^n), Max number of nodes in recursion tree
     * Space Complexity: O(n), Max depth of recursion tree
     */
    public static int countWays_recursion(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays_recursion(n - 1) + countWays_recursion(n - 2) + countWays_recursion(n - 3);
    }

    /**
     * MEMOIZATION: Top Down
     * Time Complexity : O(n)
     * Space Complexity: O(n), storage for mem[]
     */
    public static int countWays_memoization(int n) {
        int[] mem = new int[n + 1];
        return countWays_memoization(n, mem);
    }

    private static int countWays_memoization(int n, int[] mem) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        //Check & Update Combined
        if (mem[n] == 0)
            mem[n] = countWays_memoization(n - 1, mem) + countWays_memoization(n - 2, mem) + countWays_memoization(n - 3, mem);

        return mem[n];
    }

    /**
     * DYNAMIC PROGRAMMING: Bottom Up
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    public static int countWays_dp(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Build DP Table
        int[] mem = new int[n + 1];
        mem[0] = 1;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++)
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];

        return mem[n];
    }

    public static void main(String[] args) {
        testCountWays(1);
        testCountWays(2);
        testCountWays(3);
        testCountWays(5);
        testCountWays(10);
        testCountWays(15);

        testTripleStep_time(35);
    }

    private static void testCountWays(int n) {
        System.out.println("\nRecursion   : countWays(" + n + ") = " + countWays_recursion(n));
        System.out.println("Memoization : countWays(" + n + ") = " + countWays_memoization(n));
        System.out.println("Dynamic Prog: countWays(" + n + ") = " + countWays_dp(n));
    }

    private static void testTripleStep_time(int n) {
        System.out.println("\n##### Time Complexity Analysis");
        long t1 = System.currentTimeMillis();
        System.out.println("Recursion   : countWays(" + n + ") = " + countWays_recursion(n));
        long t2 = System.currentTimeMillis();
        System.out.println("Recursion: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        System.out.println("Memoization : countWays(" + n + ") = " + countWays_memoization(n));
        t2 = System.currentTimeMillis();
        System.out.println("Memoization: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        System.out.println("Dynamic Prog: countWays(" + n + ") = " + countWays_dp(n));
        t2 = System.currentTimeMillis();
        System.out.println("Dynamic Programming: Time Taken = " + (t2 - t1) + "ms");
    }
}
