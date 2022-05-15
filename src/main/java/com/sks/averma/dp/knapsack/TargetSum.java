package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {
    /**
     * Think... TargetSum is actually difference(s1-s2)
     * s1+s2 = total-sum so s1 = (s+ts)/2
     */
    public static int targetSumWays_better(int[] arr, int targetSum) {
        int n = arr.length;
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        int sum = (targetSum + totalSum) / 2;
        return waysForSum(arr, n, sum);
    }

    private static int waysForSum(int[] arr, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        int[][] td = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) td[i][j] = 0;
                if (j == 0) td[i][j] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    td[i][j] = td[i - 1][j - arr[i - 1]] + td[i - 1][j];
                else
                    td[i][j] = td[i - 1][j];
            }
        }
        return td[n][sum];
    }

    // Time Complexity:
    // Space Complexity:
    // Think... TargetSum is actually difference(s1-s2)
    // s1+s2 = total-sum so s1 = (s+ts)/2
    public static int targetSumWays(int[] arr, int targetSum) {
        int n = arr.length;
        int totalSum = 0;
        for (int a : arr)
            totalSum += a;
        Boolean[][] t = prepareSubsetSumTopDownMatrix(arr, totalSum, n);
        Boolean[] lastRow = t[n];
        int noOfWays = 0;
        for (int j = 0; j <= totalSum / 2; j++)
            if (lastRow[j] && Math.abs(totalSum - 2 * j) == targetSum)
                noOfWays++;

        return noOfWays;
    }

    private static Boolean[][] prepareSubsetSumTopDownMatrix(int[] arr, int totalSum, int n) {
        Boolean[][] t = new Boolean[n + 1][totalSum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                if (i == 0) t[i][j] = false;
                if (j == 0) t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
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
        int[] arr = {1, 1, 1, 1, 1};
        int targetSum = 3;
        test_targetSum(arr, targetSum);

        arr = new int[]{1, 1, 2, 3};
        targetSum = 1;
        test_targetSum(arr, targetSum);
    }

    private static void test_targetSum(int[] arr, int targetSum) {
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Target Sum = " + targetSum);
        System.out.println("No. of ways to get Target-Sum = " + targetSumWays(arr, targetSum));
        System.out.println("[Better] No. of ways to get Target-Sum = " + targetSumWays_better(arr, targetSum));
    }
}
