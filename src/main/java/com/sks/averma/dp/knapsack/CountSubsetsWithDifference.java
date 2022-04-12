package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Given a set of non-negative integers. Divide into two subsets whose difference is DIFF.
 * Count the number of such subsets.
 */
public class CountSubsetsWithDifference {
    /**
     * Time Complexity : O(2^n)
     * Space Complexity: O(n)
     */
    public static int countNoSubsetWithGivenDifference_recursion(int[] arr, int diff) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        for (int n : arr)
            sum += n;
        int s = (sum + diff) / 2;
        return countSubsetSum(arr, s, arr.length);
    }

    private static int countSubsetSum(int[] arr, int s, int n) {
        if (s == 0) return 1;
        if (n == 0) return 0;
        if (arr[n - 1] <= s)
            return countSubsetSum(arr, s - arr[n - 1], n - 1) + countSubsetSum(arr, s, n - 1);
        else
            return countSubsetSum(arr, s, n - 1);
    }

    /**
     * Time Complexity : O(n^2)
     * Space Complexity: O(n^2)
     */
    public static int countNoSubsetWithGivenDifference_topDown(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr)
            sum += a;
        Boolean[][] t = prepareSubsetSumTopDownMatrix(arr, sum, n);

        Boolean[] lastRow = t[n];

        int count = 0;
        for (int j = 0; j <= sum / 2; j++)
            if (lastRow[j]) {
                if (Math.abs(sum - 2 * j) == diff) count++;
            }

        return count;
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
        int[] arr3 = {1, 1, 2, 3};
        int diff = 1;
        test_countNoSubsetWithGivenDifference(arr3, diff);
    }

    private static void test_countNoSubsetWithGivenDifference(int[] arr, int diff) {
        System.out.println("##### Array: " + Arrays.toString(arr));
        System.out.println("Difference = " + diff);
        System.out.println("[Top Down] Count of No of Subsets with Given Difference = " + countNoSubsetWithGivenDifference_topDown(arr, diff));
        System.out.println("[Recursion] Count of No of Subsets with Given Difference = " + countNoSubsetWithGivenDifference_recursion(arr, diff));
    }
}
