package com.sks.averma.stack;

import java.util.Arrays;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than its price on the given day.
 */
public class StockSpan {
    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        test(stocks);
    }

    private static void test(int[] stocks) {
        System.out.println("Stocks = "+ Arrays.toString(stocks));
    }
}
