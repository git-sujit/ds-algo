package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Given a set of non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 */

/**
 * Recursive Solution
 * The recursive approach is to generate all possible sums from all the values of array and to check which solution is the most optimal one.
 * To generate sums we either include the i’th item in set 1 or don’t include, i.e., include in set 2.
 * Time Complexity: O(2^n)
 */

public class MinimumSubsetSumDifference {
    /**
     * The problem can be solved using dynamic programming when the sum of the elements is not too big.
     * We can create a 2D array dp[n+1][sum+1] where n is number of elements in given set and sum is sum of all elements. We can construct the solution in bottom up manner.
     * <p>
     * Time Complexity = O(n*sum), where n is the number of elements and sum is sum of all elements.
     * Note that the above solution is in Pseudo Polynomial Time (time complexity is dependent on the numeric value of input).
     */
    public static int minimumSubsetSumDifference(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr)
            sum += a;

        Boolean[][] t = prepareSubsetSumTopDownMatrix(arr, sum, n);

        Boolean[] lastRow = t[n];
        //System.out.println("Last Row = " + Arrays.toString(lastRow));

        int min_diff = Integer.MAX_VALUE;
        /*-for (int j = sum / 2; j >= 0; j--)
            if (lastRow[j]) {
                min_diff = sum - 2 * j;
                break;
            }
         */
        //More readable code
        for (int j = 0; j <= sum / 2; j++) {
            if (lastRow[j]) {
                min_diff = Math.min(min_diff, Math.abs(2 * j - sum));
            }
        }
        //System.out.println("Total Sum = " + sum);
        return min_diff;
    }

    private static Boolean[][] prepareSubsetSumTopDownMatrix(int[] arr, int sum, int n) {
        Boolean[][] t = new Boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) t[i][j] = false;
                if (j == 0) t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        /*-System.out.println("Top-Down Matrix");
        for (Boolean[] b : t)
            System.out.println(Arrays.toString(b));*/
        return t;
    }

    /**
     * Recursion
     */
    public static int minimumSubsetSumDifference_recursion(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return minimumSubsetSumDifference_recursion(arr, arr.length, 0, 0);
    }

    private static int minimumSubsetSumDifference_recursion(int[] arr, int n, int s1, int s2) {
        if (n == 0) return Math.abs(s1 - s2);
        return Math.min(minimumSubsetSumDifference_recursion(arr, n - 1, s1 + arr[n - 1], s2),
                minimumSubsetSumDifference_recursion(arr, n - 1, s1, s2 + arr[n - 1]));
    }

    /**
     * Recursion
     */
    public static int minimumSubsetSumDifference_memoization(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        for (int a : arr)
            sum += a;
        int maxDiff = sum;
        Integer[][] mem = new Integer[arr.length + 1][maxDiff + 1];
        minimumSubsetSumDifference_recursion(arr, arr.length, 0, 0, mem);
        System.out.println(Arrays.deepToString(mem));
        int minDiff = Integer.MAX_VALUE;
        for (Integer[] m : mem)
            for (int d : m)
                minDiff = Math.min(minDiff, d);
        return minDiff;
    }

    private static void minimumSubsetSumDifference_recursion(int[] arr, int n, int s1, int s2, Integer[][] mem) {
        if (n == 0) return;
        if (mem[n][Math.abs(s1 - s2)] != null) return;
        mem[n][Math.abs(s1 - s2)] = Math.abs(s1 - s2);
        minimumSubsetSumDifference_recursion(arr, n - 1, s1 + arr[n - 1], s2, mem);
        minimumSubsetSumDifference_recursion(arr, n - 1, s1, s2 + arr[n - 1], mem);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        test_minimumSubsetSumDifference(arr);

        int[] arr2 = {1, 2, 7};
        test_minimumSubsetSumDifference(arr2);
    }

    private static void test_minimumSubsetSumDifference(int[] arr) {
        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("Minimum Subset Sum Difference = " + minimumSubsetSumDifference(arr));
        System.out.println("[Recursion]Minimum Subset Sum Difference = " + minimumSubsetSumDifference_recursion(arr));
        System.out.println("[Memoization]Minimum Subset Sum Difference = " + minimumSubsetSumDifference_memoization(arr));
    }
}
