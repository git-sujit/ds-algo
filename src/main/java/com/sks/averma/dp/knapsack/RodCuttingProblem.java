package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 */
public class RodCuttingProblem {
    /**
     *
     */
    public static int cutRod_topDown(int[] prices, int n) {
        if (prices == null || prices.length == 0 || n == 0 || n != prices.length) return 0;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++)
            lengths[i] = (i + 1);
        Integer[][] td = new Integer[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    td[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (lengths[i - 1] <= j)
                    td[i][j] = Math.max(prices[i - 1] + td[i]/*Note: Not(i-1)*/[j - lengths[i - 1]], td[i - 1][j]);
                else
                    td[i][j] = td[i - 1][j];
            }
        }
        return td[n][n];
    }

    /**
     *
     */
    public static int cutRod_memoization(int[] prices, int n) {
        if (prices == null || prices.length == 0 || n == 0 || n != prices.length) return 0;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++)
            lengths[i] = (i + 1);
        Integer[][] mem = new Integer[n + 1][n + 1];
        return cutRodMaximizeValue_memoization(prices, lengths, n, n, mem);
    }

    private static int cutRodMaximizeValue_memoization(int[] prices, int[] lengths, int max_len, int n, Integer[][] mem) {
        if (n == 0 || max_len == 0) return 0;
        if (mem[max_len][n] != null) return mem[max_len][n];
        if (lengths[n - 1] <= max_len)
            mem[max_len][n] = Math.max(prices[n - 1] +
                            cutRodMaximizeValue_memoization(prices, lengths, max_len - lengths[n - 1], n, mem),
                    cutRodMaximizeValue_memoization(prices, lengths, max_len, n - 1, mem));
        else
            mem[max_len][n] = cutRodMaximizeValue_memoization(prices, lengths, max_len, n - 1, mem);
        return mem[max_len][n];
    }

    /**
     *
     */
    public static int cutRod_recursion(int[] prices, int n) {
        if (prices == null || prices.length == 0 || n == 0 || n != prices.length) return 0;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++)
            lengths[i] = (i + 1);
        //System.out.println("Rods : " + Arrays.toString(lengths));
        //System.out.println("Price: " + Arrays.toString(prices));
        return cutRodMaximizeValue(prices, lengths, n, n);
    }

    private static int cutRodMaximizeValue(int[] prices, int[] lengths, int max_len, int n) {
        if (n == 0 || max_len == 0) return 0;
        if (lengths[n - 1] <= max_len)
            return Math.max(
                    prices[n - 1] + cutRodMaximizeValue(prices, lengths, max_len - lengths[n - 1], n/*Note: Not (n-1)*/),
                    cutRodMaximizeValue(prices, lengths, max_len, n - 1));
        else
            return cutRodMaximizeValue(prices, lengths, max_len, n - 1);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        demo(prices);
    }

    private static void demo(int[] prices) {
        System.out.println("Prices = " + Arrays.toString(prices));
        System.out.println("[Top Down] Maximum Price of cutting : " + cutRod_topDown(prices, prices.length));
        System.out.println("[Memoization] Maximum Price of cutting : " + cutRod_memoization(prices, prices.length));
        System.out.println("Maximum Price of cutting : " + cutRod_recursion(prices, prices.length));
    }
}
