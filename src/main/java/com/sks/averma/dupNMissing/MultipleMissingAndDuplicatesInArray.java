package com.sks.averma.dupNMissing;

import java.util.*;

public class MultipleMissingAndDuplicatesInArray {
    /**
     * Time Complexity: O(n): Traversing the array once
     * Space Complexity: O(1) no additional space is used, only output has extra space
     */
    public static List<List<Integer>> multipleMissingAndDuplicates_swapSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        swapSort(nums);
        System.out.println("After Swap Sort, nums = " + Arrays.toString(nums));
        List<Integer> missing = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missing.add(i + 1);
                duplicates.add(nums[i]);
            }
        }
        List<List<Integer>> out = new ArrayList<>();
        out.add(missing);
        out.add(duplicates);
        return out;
    }

    private static void swapSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != (i + 1)) {
                if (nums[nums[i] - 1] == nums[i]) i++;
                else {
                    int t = nums[i];
                    nums[i] = nums[t - 1];
                    nums[t - 1] = t;
                }
            } else {
                i++;
            }
        }
        //System.out.println("Swap Sort = " + Arrays.toString(nums));
    }

    /**
     * Time Complexity: O(n): Traversing the array once
     * Space Complexity: O(n): For Array
     */
    public static List<List<Integer>> missingAndDuplicates_array(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> missing = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int num : nums)
            count[num - 1]++;
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) missing.add(i + 1);
            if (count[i] == 2) duplicates.add(i + 1);
        }
        out.add(missing);
        out.add(duplicates);
        return out;
    }

    /**
     * Time Complexity: O(n): Traversing the array once
     * Space Complexity: O(n): For HashMap
     */
    public static List<List<Integer>> missingAndDuplicates_map(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> out = new ArrayList<>();
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int n : nums)
            numCountMap.put(n, numCountMap.getOrDefault(n, 0) + 1);
        List<Integer> missingNums = new ArrayList<>();
        List<Integer> duplicateNums = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numCountMap.containsKey(i)) missingNums.add(i);
            else if (numCountMap.get(i) > 1) duplicateNums.add(i);
        }
        out.add(missingNums);
        out.add(duplicateNums);
        return out;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 8, 2, 3, 5, 1};
        test(nums);
        //swapSort(nums);
    }

    private static void test(int[] nums) {
        System.out.println("Numbers = " + Arrays.toString(nums));

        List<List<Integer>> out = missingAndDuplicates_map(nums);
        System.out.println("[Map] Missing = " + out.get(0) + ", Duplicate = " + out.get(1));

        out = missingAndDuplicates_array(nums);
        System.out.println("[Array] Missing = " + out.get(0) + ", Duplicate = " + out.get(1));

        out = multipleMissingAndDuplicates_swapSort(nums);
        System.out.println("[Swap-Sort] Missing = " + out.get(0) + ", Duplicate = " + out.get(1));
    }
}
