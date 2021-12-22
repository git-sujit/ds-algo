package com.sks.leatcode.easy;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
public class MaximumSubarray_KadanesAlgo {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) return -1;
        int max = nums[0];
        int prevMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            if (prevMax > max)
                max = prevMax;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array = " + Arrays.toString(a) + ", Maximum subarray-sum = " + maxSubArray(a));

        a = new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println("Array = " + Arrays.toString(a) + ", Maximum subarray-sum = " + maxSubArray(a));

    }
}
