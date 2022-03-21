package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange_MinCoins {
    public static int coinChange_topDown(int[] coins, int amount) {
        int[][] td = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) td[i][j] = 0;
                if (i == 0) td[i][j] = Integer.MAX_VALUE - 1;
                if (i == 1 && j > 0) {
                    if (j % coins[i - 1] == 0) td[i][j] = j / coins[i - 1];
                    else td[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        for (int j = 1; j <= amount; j++) {

        }
        //for (int[] t : td)
        //  System.out.println(Arrays.toString(t));
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j)
                    td[i][j] = Math.min(1 + td[i][j - coins[i - 1]], td[i - 1][j]);
                else td[i][j] = td[i - 1][j];
            }
        }
        return td[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : td[coins.length][amount];
    }

    public static int coinChange_memoization(int[] coins, int amount) {
        int minCoins = coinChange_memoization(coins, coins.length, amount, 0, Integer.MAX_VALUE, new Integer[coins.length + 1][amount + 1]);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private static int coinChange_memoization(int[] coins, int n, int amount, int minCoins, int result, Integer[][] mem) {
        if (n == 0) return Integer.MAX_VALUE;
        if (amount == 0) return Math.min(result, minCoins);
        if (mem[n][amount] != null) return mem[n][amount];
        if (coins[n - 1] <= amount)
            mem[n][amount] = Math.min(coinChange_memoization(coins, n, amount - coins[n - 1], minCoins + 1, result, mem),
                    coinChange_memoization(coins, n - 1, amount, minCoins, result, mem));
        else
            mem[n][amount] = coinChange_memoization(coins, n - 1, amount, minCoins, result, mem);

        return mem[n][amount];
    }

    public static int coinChange_recursion(int[] coins, int amount) {
        int minCoins = coinChange_recursion(coins, coins.length, amount, 0, Integer.MAX_VALUE);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private static int coinChange_recursion(int[] coins, int n, int amount, int minCoins, int result) {
        if (n == 0) return Integer.MAX_VALUE;
        if (amount == 0) return Math.min(result, minCoins);
        if (coins[n - 1] <= amount)
            return Math.min(coinChange_recursion(coins, n, amount - coins[n - 1], minCoins + 1, result),
                    coinChange_recursion(coins, n - 1, amount, minCoins, result));
        else
            return coinChange_recursion(coins, n - 1, amount, minCoins, result);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        demo(coins, amount);

        coins = new int[]{2};
        amount = 3;
        demo(coins, amount);
    }

    private static void demo(int[] coins, int amount) {
        System.out.println("\ncoins = " + Arrays.toString(coins) + ", amount = " + amount);
        System.out.println("[Recursion] Minimum no. of coins = " + coinChange_recursion(coins, amount));
        System.out.println("[Memoization] Minimum no. of coins = " + coinChange_memoization(coins, amount));
        System.out.println("[Top Down] Minimum no. of coins = " + coinChange_topDown(coins, amount));
    }
}
