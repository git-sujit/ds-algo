package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    /**
     * Sort & two-pointer approach
     * Time Complexity : O(n^2)
     * Space Complexity: O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] closestSum = {Integer.MAX_VALUE, 0}; // abs_diff, sum
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSumClosest(nums, i, target, closestSum);
        }
        return closestSum[1];
    }

    private void twoSumClosest(int[] nums, int start, int target, int[] closestSum) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            int absDiff = Math.abs(target - sum);
            if (absDiff < closestSum[0]) {
                closestSum[0] = absDiff;
                closestSum[1] = sum;
            }
            if (sum < target) left++;
            else right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0, -2};
        int target = 4;
        demo(nums, target);

        nums = new int[]{0, 2, 1, -3};
        target = 1;
        demo(nums, target);
    }

    private static void demo(int[] nums, int target) {
        System.out.println("\nNums = " + Arrays.toString(nums) + ", Target = " + target);
        System.out.println("Triplet-Sum with minimum absolute difference to target = " + new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
