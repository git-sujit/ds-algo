package com.sks.averma.dupNMissing;

import java.util.*;

public class MultipleMissingAndDuplicatesInArray {
    /**
     * Time Complexity: O(n): Traversing the array once
     * Space Complexity: O(n): For HashMap
     */
    public static List<List<Integer>> missingAndDuplicates(int[] nums) {
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
    }

    private static void test(int[] nums) {
        System.out.println("Numbers = " + Arrays.toString(nums));
        List<List<Integer>> out = missingAndDuplicates(nums);
        System.out.println("Missing Numbers = " + out.get(0));
        System.out.println("Duplicate Numbers = " + out.get(1));
    }
}
