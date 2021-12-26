package com.sks.averma.dp.mcm;

/**
 * If a chain of matrices is given, we have to find the minimum number of the correct sequence of matrices to multiply.
 * The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 * Note:no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:
 * (ABC)D = (AB)(CD) = A(BCD) = ....
 * However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency.
 * For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
 * 1. (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 * 2. A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 * Clearly the first parenthesization requires less number of operations.
 */

import java.util.Arrays;

/**
 * Idea::
 * Note ; We'll be given an array arr[ ] which represents the chain of matrices such that the ith matrix arr[i] is of dimension arr[i-1] x arr[i].
 * That's why we start out 'k' i.e partition from 'i' =1 so that arr[ 1] is of dimentions arr[1-1] * arr[1] else we'll get index out of bound error Eg arr[0-1] * arr[0] is not possible
 * So first half of the array is from i to k & other half is from k+1 to j
 * Also we need to find the cost of multiplication of these 2 resultant matrixes (first half & second half) which is nothing but arr[i-1] * arr[k] * arr[j]
 */
public class MatrixChainMultiplication {
    /**
     * RECURSION
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * There are so many overlapping subproblems . Let's optimize it using DP
     */
    public static int mcm_recursion(int[] arr) {
        return mcm_recursion(arr, 1, arr.length - 1);
    }

    private static int mcm_recursion(int[] arr, int i, int j) {
        if (i >= j) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = mcm_recursion(arr, i, k) + mcm_recursion(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }

    /**
     * RECURSION
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * There are so many overlapping subproblems . Let's optimize it using DP
     */
    public static int mcm_memoization(int[] arr) {
        int len = arr.length;
        int[][] memo = new int[len + 1][len + 1];
        Arrays.fill(memo, -1);
        return 0;// mcm_memoization(arr, 1, arr.length - 1, memo);
    }

    public static int mcm_memoization(int[] arr, int i, int j, int[] memo) {
        if (i >= j) return 0;
        for (int k = i; k <= j; k++) {
            if (memo[k] != -1)
                return memo[k];
            else
                memo[k] = mcm_memoization(arr, i, k, memo) + mcm_memoization(arr, k + 1, j, memo) + arr[i - 1] * arr[k] * arr[j];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        System.out.println("Recursion: Array = " + Arrays.toString(arr) + ", Min math ops to multiply = " + mcm_recursion(arr));
    }
}
