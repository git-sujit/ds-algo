package com.sks.dp.knapsack;

/**
 * @author : Sujit K Singh
 * Purpose : Knapsack variations : Equal Sum Partition
 * Determine whether a given set of non-negative integers can be partitioned into two subsets such that the sum of elements in both subsets is same
 * <p>
 * How to Identify Knapsack-patters:
 * 1. Given no. of items :: Array
 * 2. Max value / Capacity
 * 3. Choice Diagram
 */

import java.util.Arrays;

/**
 * Following are the two main steps to solve this problem:
 * 1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
 * 2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.
 * <p>
 * The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.
 */
public class EqualSumPartition {

    public static boolean hasEqualSumPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        if (sum % 2 != 0) return false;
        return hasSubsetSum(arr, sum / 2, arr.length);
    }

    private static boolean hasSubsetSum(int[] arr, int sum, int n) {
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

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        int[] arr2 = {1, 5, 3};
        test_equalSumPartition(arr1);
        test_equalSumPartition(arr2);
    }

    private static void test_equalSumPartition(int[] arr) {
        System.out.println("##### Array: " + Arrays.toString(arr));
        System.out.println("Has Equal Sum Partition? : " + hasEqualSumPartition(arr));
    }
}
