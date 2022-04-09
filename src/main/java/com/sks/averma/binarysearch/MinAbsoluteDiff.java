package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Given an unsorted array, find the minimum difference between any pair in given array.
 */
public class MinAbsoluteDiff {
    public static int minDiffEle(int[] nums, int n) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (n < nums[m]) e = m - 1;
            else if (n == nums[m]) return nums[m];
            else s = m + 1;
        }
        System.out.println("s = " + s + ", e = " + e);
        if (e == -1) return nums[0];
        if (s == len) return nums[len - 1];
        return Math.abs(n - nums[s]) < Math.abs(n - nums[e]) ? nums[s] : nums[e];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 10};
        int n = 7;
        demo(nums, n);

        n = 2;
        demo(nums, n);

        n = 10;
        demo(nums, n);

        n = 15;
        demo(nums, n);
    }

    private static void demo(int[] nums, int n) {
        System.out.println("\nNums = " + Arrays.toString(nums) + ", n = " + n);
        System.out.println("Element with min diff = " + minDiffEle(nums, n));
    }
}
