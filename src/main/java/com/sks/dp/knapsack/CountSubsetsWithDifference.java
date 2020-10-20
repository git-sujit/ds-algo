package com.sks.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Given a set of non-negative integers. Divide into two subsets whose difference is DIFF.
 * Count the number of such subsets.
 */
public class CountSubsetsWithDifference {
    public static int countNoSubsetWithGivenDifference(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr)
            sum += a;
        Boolean[][] t = prepareSubsetSumTopDownMatrix(arr, sum, n);

        Boolean[] lastRow = t[n];

        int count = 0;
        for (int j = 0; j <= sum / 2; j++)
            if (Math.abs(sum - 2 * j) == diff) count++;

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
        System.out.println("Count of No of Subsets with Given Difference = " + countNoSubsetWithGivenDifference(arr, diff));
    }
}
