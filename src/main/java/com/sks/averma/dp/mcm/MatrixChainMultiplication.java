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
 * Clearly the first parenthesizing requires less number of operations.
 */

import java.util.Arrays;

/**
 * Idea::
 * Note ; We'll be given an array arr[] which represents the chain of matrices such that the ith matrix arr[i] is of dimension arr[i-1] x arr[i].
 * That's why we start out 'k' i.e partition from 'i' =1 so that arr[1] is of dimensions arr[1-1] * arr[1] else we'll get index out of bound error Eg arr[0-1] * arr[0] is not possible
 * So first half of the array is from i to k & other half is from k+1 to j
 * Also we need to find the cost of multiplication of these 2 resultant matrices (first half & second half) which is nothing but arr[i-1] * arr[k] * arr[j]
 */
public class MatrixChainMultiplication {
    /**
     * RECURSION
     * Time Complexity: O(2^n), n is length of array
     * Space Complexity: O(n)
     * There are so many overlapping sub-problems . Let's optimize it using DP
     */
    public static int mcm_recursion(int[] arr) {
        return mcm_recursion(arr, 1, arr.length - 1);
    }

    private static int mcm_recursion(int[] arr, int i, int j) {
        if (i >= j) return 0;
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = arr[i - 1] * arr[k] * arr[j] + mcm_recursion(arr, i, k) + mcm_recursion(arr, k + 1, j);
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }

    /**
     * Memoization
     * Time Complexity: O(n^3), wherever you find table (n is length of array)
     * Space Complexity: O(n^2), for mem[][]
     */
    public static int mcm_memoization(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int len = arr.length;
        int[][] mem = new int[len][len];
        for (int[] m : mem)
            Arrays.fill(m, -1);
        int val = mcm_memoization(arr, 1, len - 1, mem);
        System.out.println("Mem Table");
        for (int[] m : mem)
            System.out.println(Arrays.toString(m));
        return val;
    }

    private static int mcm_memoization(int[] arr, int i, int j, int[][] mem) {
        if (i >= j) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = arr[i - 1] * arr[k] * arr[j] + mcm_memoization(arr, i, k, mem) + mcm_memoization(arr, k + 1, j, mem);
            ans = Math.min(ans, temp);
        }
        return mem[i][j] = ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        System.out.println("[Recursion] Array = " + Arrays.toString(arr) + ", Min math ops to multiply = " + mcm_recursion(arr));
        System.out.println("[Memoization] Array = " + Arrays.toString(arr) + ", Min math ops to multiply = " + mcm_memoization(arr));
    }
}
