package com.sks.leatcode.easy;

import java.util.Arrays;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] copy = new int[nums.length + 1];
        for (int n : nums)
            copy[n]++;
        for (int i = 0; i < copy.length; i++)
            if (copy[i] == 0) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("Numbers = " + Arrays.toString(nums));
        System.out.println("Missing = " + missingNumber(nums));
    }
}
