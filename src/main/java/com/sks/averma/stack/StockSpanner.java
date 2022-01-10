package com.sks.averma.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than its price on the given day.
 */
public class StockSpanner {
    /**
     * Time Complexity: O(n), traversing the array only once
     * Space Complexity: O(n) for stack, worst case all element will be pushed to stack(e.g. array in reverse order)
     */
    public static int[] span(int[] stocks) {
        if (stocks == null || stocks.length == 0) return null;
        int[] ss = new int[stocks.length];
        int[] ngl = nearestGreaterLeftIndex(stocks);
        System.out.println("ngLeftIndexes = " + Arrays.toString(ngl));
        for (int i = 0; i < stocks.length; i++) {
            ss[i] = i - ngl[i];
        }
        return ss;
    }

    private static int[] nearestGreaterLeftIndex(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] ngl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) ngl[i] = -1;
            else {
                if (nums[stack.peek()] > nums[i]) ngl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
                    ngl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(i);
        }
        return ngl;
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85, 200};
        test(stocks);
    }

    private static void test(int[] stocks) {
        System.out.println("Stocks = " + Arrays.toString(stocks));
        System.out.println("Stock Spanner Array = " + Arrays.toString(span(stocks)));
    }
}
