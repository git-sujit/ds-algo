package com.sks.leatcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 */
public class SubArraySumK {

    /**
     * Time Complexity: O(n), The entire nums array is traversed only once
     * Space Complexity: O(n), Hashmap map can contain up to n distinct entries in the worst case.
     * Idea: map which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs.
     * We store the data in the form: (sum_i, no. of occurrences of sum_i)
     */
    public static int subarraySum_map(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Map = " + map);
        return count;
    }

    public static int subarraySum_bruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int noa = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) noa++;
            }
        }
        return noa;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        int k = 2;
        test(numbers, k);

        numbers = new int[]{1, 2, 3};
        k = 3;
        test(numbers, k);
    }

    private static void test(int[] numbers, int k) {
        System.out.println("\nNumbers = " + Arrays.toString(numbers) + ", k = " + k);
        System.out.println("Number of continuous subarrays having sum(" + k + ") = " + subarraySum_map(numbers, k));
        System.out.println("[Brute Force] Number of continuous subarrays having sum(" + k + ") = " + subarraySum_bruteForce(numbers, k));
    }
}
