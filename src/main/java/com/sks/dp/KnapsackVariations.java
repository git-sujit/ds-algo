package com.sks.dp;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Knapsack variations
 * 1. Subset Sum Problem
 * 2. Equal Sum Partition
 * 3. Count of Subset Sum
 * 4. Minimum Subset Sum
 * 5. Target Sum
 * 6. No. of subset
 */
// How to Identify Knapsack-patters:
//    1. Given no. of items :: Array
//    2. Max value / Capacity
//    3. Choice Diagram
public class KnapsackVariations {
    // Problem Statement: Given an array and a TargetSum, check if a subset is present whose sum is TargetSum
    public static boolean subset_sum(int[] arr, int sum, int n) {
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

        return t[n][sum];
    }

    public static void main(String[] args) {
        test_subset_sum();
    }

    private static void test_subset_sum() {
        System.out.println("##### TESTING SUBSET SUM PROBLEM ##### ");
        int[] s1 = new int[]{3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        System.out.println("Array: " + Arrays.toString(s1));
        System.out.println("Sum = " + sum1);
        System.out.println("Has Subset Sum? : " + subset_sum(s1, sum1, s1.length));

        int[] s2 = new int[]{3, 34, 4, 12, 5, 2};
        int sum2 = 30;
        System.out.println("Array: " + Arrays.toString(s2));
        System.out.println("Sum = " + sum2);
        System.out.println("Has Subset Sum? : " + subset_sum(s2, sum2, s2.length));
    }
}
