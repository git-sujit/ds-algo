package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Given an array of non-negative integers arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 */
public class CountOfSubsetSum {

    // Time Complexity
    // Space Complexity
    public static int countOfSubsetSum(int[] arr, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) t[i][j] = 0;
                if (j == 0) t[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        /*-
        System.out.println("----- Top-Down Matrix");
        for (int[] a : t)
            System.out.println(Arrays.toString(a));
        */
        return t[n][sum];
    }

    public static int countOfSubsetSum_recursion(int[] arr, int sum, int n) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (arr[n - 1] <= sum)
            return countOfSubsetSum(arr, sum - arr[n - 1], n - 1) + countOfSubsetSum(arr, sum, n - 1);
        else
            return countOfSubsetSum(arr, sum, n - 1);
    }

    public static int countOfSubsetSum_memoization(int[] arr, int sum, int n) {
        return countOfSubsetSum_memoization(arr, sum, n, new Integer[n + 1][sum + 1]);
    }

    private static int countOfSubsetSum_memoization(int[] arr, int sum, int n, Integer[][] mem) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (mem[n][sum] != null) return mem[n][sum];
        if (arr[n - 1] <= sum)
            mem[n][sum] = countOfSubsetSum_memoization(arr, sum - arr[n - 1], n - 1, mem) + countOfSubsetSum_memoization(arr, sum, n - 1, mem);
        else
            mem[n][sum] = countOfSubsetSum_memoization(arr, sum, n - 1, mem);
        return mem[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        test_countOfSubsetSum(arr, sum);

        arr = new int[]{1, 1, 1, 1};
        sum = 1;
        test_countOfSubsetSum(arr, sum);

        arr = new int[]{1, 2, 3, 3};
        sum = 6;
        test_countOfSubsetSum(arr, sum);
    }

    private static void test_countOfSubsetSum(int[] arr, int sum) {
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Target Sum = " + sum);
        System.out.println("[Top Down]Count of Subset Sum = " + countOfSubsetSum(arr, sum, arr.length));
        System.out.println("[Recursion] Count of Subset Sum = " + countOfSubsetSum_recursion(arr, sum, arr.length));
        System.out.println("[Memoization] Count of Subset Sum = " + countOfSubsetSum_memoization(arr, sum, arr.length));
    }
}
