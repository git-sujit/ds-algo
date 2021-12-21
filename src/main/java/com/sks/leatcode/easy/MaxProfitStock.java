package com.sks.leatcode.easy;

import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class MaxProfitStock {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int maxProfit_bruteForce(int[] prices) {
        int days = prices.length;
        int maxP = 0;
        int buyingDay = 0;
        int sellingDay = 0;
        for (int i = 0; i < days; i++) {
            for (int j = i + 1; j < days; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxP) {
                    buyingDay = i;
                    sellingDay = j;
                    maxP = profit;
                }
            }
        }
        System.out.println("buyingDay=" + buyingDay + ", sellingDay=" + sellingDay);
        return maxP;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Array = " + Arrays.toString(prices));
        System.out.println("Max Profit = " + maxProfit_bruteForce(prices));
        System.out.println("Max Profit = " + maxProfit(prices));
    }
}
