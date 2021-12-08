package com.sks.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Knapsack variations : Subset Sum
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * <p>
 * How to Identify Knapsack-patters:
 * 1. Given no. of items :: Array
 * 2. Max value / Capacity
 * 3. Choice Diagram
 */
public class SubsetSum {
    // Time Complexity: O(2^n)
    // Space Complexity: Method-stack will take space
    public static boolean isSubsetSum_recursion(int[] arr, int sum, int n) {
        if (sum == 0) return true; /// This will be first because is sum==0 then true
        if (n == 0) return false;

        if (arr[n - 1] <= sum)
            return isSubsetSum_recursion(arr, sum - arr[n - 1], n - 1) || isSubsetSum_recursion(arr, sum, n - 1);
        else
            return isSubsetSum_recursion(arr, sum, n - 1);
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n*sum) for array
    public static boolean isSubsetSum_memoization(int[] arr, int sum, int n) {
        Boolean[][] mem = new Boolean[n + 1][sum + 1];
        return isSubsetSum_memoization(arr, sum, n, mem);
    }

    private static boolean isSubsetSum_memoization(int[] arr, int sum, int n, Boolean[][] mem) {
        if (sum == 0) return true; /// This will be first because is sum==0 then true
        if (n == 0) return false;

        if (mem[n][sum] != null) return mem[n][sum];

        if (arr[n - 1] <= sum)
            mem[n][sum] = isSubsetSum_memoization(arr, sum - arr[n - 1], n - 1) || isSubsetSum_memoization(arr, sum, n - 1);
        else
            mem[n][sum] = isSubsetSum_memoization(arr, sum, n - 1);

        return mem[n][sum];
    }

    // Problem Statement: Given an array and a TargetSum, check if a subset is present whose sum is TargetSum
    public static boolean isSubsetSum_top_down(int[] arr, int sum, int n) {
        Boolean[][] t = new Boolean[n + 1][sum + 1]; // Default is null
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // First do this... Think.
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
        System.out.println("----- Top-Down Matrix");

        for (Boolean[] b : t)
            System.out.println(Arrays.toString(b));

        return t[n][sum];
    }

    public static void main(String[] args) {
        System.out.println("##### TESTING SUBSET SUM PROBLEM ##### ");
        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        test_subsetSum(arr1, sum1);

        int[] arr2 = {3, 34, 4, 12, 5, 2};
        int sum2 = 30;
        test_subsetSum(arr2, sum2);
    }

    private static void test_subsetSum(int[] arr, int sum) {
        System.out.println("##### Array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Has Subset Sum (Recursion)? : " + isSubsetSum_recursion(arr, sum, arr.length));
        System.out.println("Has Subset Sum (Memoization)? : " + isSubsetSum_memoization(arr, sum, arr.length));
        System.out.println("Has Subset Sum (Top-Down Approach)? : " + isSubsetSum_top_down(arr, sum, arr.length));
    }
}
