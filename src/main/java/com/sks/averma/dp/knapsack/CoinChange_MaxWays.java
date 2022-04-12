package com.sks.averma.dp.knapsack;

import java.util.Arrays;
/**
 * Total Number of Ways: add
 * Max value: Math.max()
 * Exists: OR condition
 */

/**
 * You are given an integer array coins representing coins of different denominations and an
 * integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange_MaxWays {
    /**
     * Time complexity : O(S*n)O(S∗n). where S is the amount, n is denomination count
     * Space complexity : O(S)O(S)
     */
    public static int change_topDown(int[] coins, int n, int amount) {
        int[][] td = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0)
                    td[i][j] = 0;
                if (j == 0)
                    td[i][j] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j)
                    td[i][j] = td[i][j - coins[i - 1]] + td[i - 1][j];
                else
                    td[i][j] = td[i - 1][j];
            }
        }
        return td[n][amount];
    }

    public static int change_memoization(int[] coins, int n, int amount, Integer[][] mem) {
        if (n == 0) return 0;
        if (amount == 0) return 1;
        if (mem[n][amount] != null) return mem[n][amount];
        if (coins[n - 1] <= amount)
            mem[n][amount] = change_memoization(coins, n, amount - coins[n - 1], mem) +
                    change_memoization(coins, n - 1, amount, mem);
        else
            mem[n][amount] = change_memoization(coins, n - 1, amount, mem);

        return mem[n][amount];
    }

    public static int change_recursion(int[] coins, int n, int amount) {
        if (n == 0) return 0;
        if (amount == 0) return 1;
        if (coins[n - 1] <= amount)
            return change_recursion(coins, n, amount - coins[n - 1]) +
                    change_recursion(coins, n - 1, amount);
        else
            return change_recursion(coins, n - 1, amount);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        demo(coins, amount);

        coins = new int[]{1, 2, 5};
        amount = 0;
        demo(coins, amount);

        coins = new int[]{1, 2, 5};
        amount = 5;
        demo(coins, amount);
    }

    private static void demo(int[] coins, int amount) {
        System.out.println("\ncoins = " + Arrays.toString(coins) + ", amount = " + amount);
        System.out.println("[Recursion] Total no of ways = " + change_recursion(coins, coins.length, amount));
        System.out.println("[Memoization] Total no of ways = " + change_memoization(coins, coins.length, amount, new Integer[coins.length + 1][amount + 1]));
        System.out.println("[Top Down] Total no of ways = " + change_topDown(coins, coins.length, amount));
    }
}
