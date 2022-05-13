package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 */
public class ThreeSumSmaller {
    /**
     * Sort & two-pointer approach
     * Time Complexity : O(n^2)
     * Space Complexity: O(1)
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            twoSum(nums, i, target, res);
        }
        return res[0];
    }

    private void twoSum(int[] nums, int start, int target, int[] res) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            if (sum < target) {
                res[0] += right - left;
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0, -2};
        int target = 4;
        demo(nums, target);

        nums = new int[]{0, 0, 0};
        target = 0;
        demo(nums, target);

        nums = new int[]{-2, 0, 1, 3};
        target = 2;
        demo(nums, target);

        nums = new int[]{3, 5, 2, 8, 1};
        target = 7;
        demo(nums, target);

    }

    private static void demo(int[] nums, int target) {
        System.out.println("\nNums = " + Arrays.toString(nums) + ", Target = " + target);
        System.out.println("Count of (triplets-sum < target) = " + new ThreeSumSmaller().threeSumSmaller(nums, target));
    }
}
