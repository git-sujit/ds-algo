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
        System.out.println("Last Row = " + Arrays.toString(lastRow));

        int min_diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--)
            if (lastRow[j]) {
                min_diff = sum - 2 * j;
                break;
            }
        System.out.println("Total Sum = " + sum);
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
        System.out.println("Top-Down Matrix");
        for (Boolean[] b : t)
            System.out.println(Arrays.toString(b));
        return t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        test_minimumSubsetSumDifference(arr);

        int[] arr2 = {1, 2, 7};
        test_minimumSubsetSumDifference(arr2);
    }

    private static void test_minimumSubsetSumDifference(int[] arr) {
        System.out.println("##### Array: " + Arrays.toString(arr));
        System.out.println("Minimum Subset Sum Difference = " + minimumSubsetSumDifference(arr));
    }
}
