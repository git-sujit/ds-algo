package com.sks.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * A subarray is a contiguous subsequence of the array.
 * Return the sum of all odd-length subarrays of arr.
 */
public class SumOddLenSubArray {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int len = arr.length;
        int kmax = (len % 2 == 0) ? len - 1 : len;
        int sum = 0;
        for (int k = 1; k <= kmax; k += 2) {
            sum += sumOfKLength(arr, k);
        }
        return sum;
    }

    private int sumOfKLength(int[] arr, int k) {
        int totalSum = 0;
        int sum = 0;
        int ws = 0;
        int we = 0;
        while (we < arr.length) {
            sum += arr[we];
            if (we - ws + 1 == k) {
                totalSum += sum;
                sum -= arr[ws++];
            }
            we++;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3};
        System.out.println("Nums = " + Arrays.toString(nums));
        System.out.println("Total Sum of odd-length sub-arrays = " + new SumOddLenSubArray().sumOddLengthSubarrays(nums));
    }
}
