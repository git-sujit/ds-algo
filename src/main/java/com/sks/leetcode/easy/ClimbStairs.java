package com.sks.leetcode.easy;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {

    /**
     * Time Complexity: O(n), Single loop
     * Space Complexity: O(n), DP array
     */
    public static int countWays_topDownDP(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int[] td = new int[n + 1];
        td[0] = 0;
        td[1] = 1;
        td[2] = 2;
        for (int i = 3; i <= n; i++)
            td[i] = td[i - 1] + td[i - 2];
        return td[n];

    }

    /**
     * Time Complexity: O(n), Going to each n once till it becomes <=2
     * Space Complexity: O(n), for memoization array
     */
    public static int countWays_memoization(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        return countWays_memoization(n, mem);
    }

    private static int countWays_memoization(int n, int[] mem) {
        if (mem[n] != -1)
            return mem[n];
        mem[n] = countWays_memoization(n - 1, mem) + countWays_memoization(n - 2, mem);
        return mem[n];
    }

    /**
     * Time Complexity: O(2^n), Call tree: each n-- makes two function calls
     * Space Complexity: O(n), for method stack
     */
    public static int countWays_recursive(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        return countWays_recursive(n - 1) + countWays_recursive(n - 2);
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Stairs = " + n + ", Ways to Climb(Recursion) = " + countWays_recursive(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(Memoization) = " + countWays_memoization(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(TopDown-DP) = " + countWays_topDownDP(n));
        n = 3;
        System.out.println("\nStairs = " + n + ", Ways to Climb(Recursion) = " + countWays_recursive(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(Memoization) = " + countWays_memoization(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(TopDown-DP) = " + countWays_topDownDP(n));
        n = 5;
        System.out.println("\nStairs = " + n + ", Ways to Climb(Recursion) = " + countWays_recursive(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(Memoization) = " + countWays_memoization(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(TopDown-DP) = " + countWays_topDownDP(n));
        n = 10;
        System.out.println("\nStairs = " + n + ", Ways to Climb(Recursion) = " + countWays_recursive(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(Memoization) = " + countWays_memoization(n));
        System.out.println("Stairs = " + n + ", Ways to Climb(TopDown-DP) = " + countWays_topDownDP(n));
    }
}
