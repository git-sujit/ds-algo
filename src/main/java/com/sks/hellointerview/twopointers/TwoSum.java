package com.sks.hellointerview.twopointers;

import java.util.Arrays;

/**
 * DESCRIPTION
 * Given a sorted array of integers nums, determine if there exists a pair of numbers that sum to a given target.
 * Example:
 * Input: nums = [1,3,4,6,8,10,13], target = 13
 * Output: True (3 + 10 = 13)
 * Input: nums = [1,3,4,6,8,10,13], target = 6
 * Output: False
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6, 8, 10, 13};
        int target = 13;
        System.out.println("nums = " + Arrays.toString(nums) + ", target = " + target + " => " + hasTwoSum(nums, target));

    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * The two-pointer technique leverages the fact that the input array is sorted to eliminate
     * the number of pairs we consider from O(n2)down to O(n).
     */
    public static boolean hasTwoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }
}
