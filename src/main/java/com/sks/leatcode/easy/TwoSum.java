package com.sks.leatcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 **/
public class TwoSum {
    //Time Complexity: O(n^2)
    //Space Complexity: O(1), space required is not dependent on size of input array
    private static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return null;
    }

    // Trading space for speed
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] twoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};

            }
        }
        return null;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    private static int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(num, i);
        }

        return null;
    }

    /**
     * TEST CASES
     */
    private enum ALGO_TYPE {
        BRUTE_FORCE, ONE_PASS_HASH_TABLE, TWO_PASS_HASH_TABLE
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        runTestCases(nums, target);

        nums = new int[]{3, 2, 4};
        target = 6;
        runTestCases(nums, target);

    }

    private static void runTestCases(int[] nums, int target) {
        for (ALGO_TYPE algo_type : ALGO_TYPE.values()) {
            analyseOutput(nums, target, algo_type);
        }
    }

    private static void analyseOutput(int[] nums, int target, ALGO_TYPE algoType) {
        System.out.println("***INPUT : nums = " + Arrays.toString(nums));
        System.out.println("target = " + target);

        int[] out = null;
        if (algoType == ALGO_TYPE.BRUTE_FORCE)
            out = bruteForce(nums, target);
        else if (algoType == ALGO_TYPE.TWO_PASS_HASH_TABLE)
            out = twoPassHashTable(nums, target);
        else if (algoType == ALGO_TYPE.ONE_PASS_HASH_TABLE)
            out = onePassHashTable(nums, target);

        System.out.println("***OUTPUT, AlgoType = " + algoType);
        System.out.println(Arrays.toString(out) + "\n");
    }
}
