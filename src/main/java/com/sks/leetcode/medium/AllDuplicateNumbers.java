package com.sks.leetcode.medium;

import java.util.*;

/**
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and
 * each integer appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
public class AllDuplicateNumbers {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Intuition: The integers in the input array arr satisfy 1 ≤ arr[i] ≤ n, where n is the size of array
     */
    public static List<Integer> markInArray(int[] nums) {
        List<Integer> out = new ArrayList<>();
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0)
                out.add(Math.abs(n));
            nums[Math.abs(n) - 1] *= -1;
        }

        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> hashAndFind(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> out = new ArrayList<>();
        for (int n : nums) {
            if (set.contains(n))
                out.add(n);
            else
                set.add(n);
        }
        return out;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        test(nums);
        nums = new int[]{1, 1, 2};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("\nArray = " + Arrays.toString(nums));
        System.out.println("Algo-hashAndFind = " + hashAndFind(nums));
        System.out.println("Algo-markInArray = " + markInArray(nums));
    }
}
