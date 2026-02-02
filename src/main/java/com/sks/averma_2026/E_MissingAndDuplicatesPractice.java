package com.sks.averma_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E_MissingAndDuplicatesPractice {
    public static void main(String[] args) {
        System.out.println("----- MISSING & DUPLICATES -----");
        test_missingAndDuplicates();

        System.out.println("----- MULTIPLE MISSING & DUPLICATES & SWAP SORT -----");
        test_multipleMissingAndDuplicates();
    }

    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int[] missingAndDuplicate_contantSpace(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int sum = Arrays.stream(nums).sum();
        int squareSum = Arrays.stream(nums).map(x -> x * x).sum();
        int sumOrig = nums.length * (nums.length + 1) / 2;
        int squareSumOrig = nums.length * (nums.length + 1) * (2 * nums.length + 1) / 6;
        int missing = ((squareSumOrig - squareSum) / (sumOrig - sum) + (sumOrig - sum)) / 2;
        int duplicate = missing - (sumOrig - sum);
        return new int[]{missing, duplicate};
    }

    /**
     * Time Complexity: O(n): Traversing the array once
     * Space Complexity: O(1) no additional space is used, only output has extra space
     */
    public static List<List<Integer>> multipleMissingAndDuplicates_swapSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        swapSort(nums);
        // System.out.println("After Swap Sort, nums = " + Arrays.toString(nums));
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

    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     */
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
    }

    /**
     * TEST
     */
    private static void test_missingAndDuplicates() {
        int[] nums = {1, 2, 4, 3, 2, 5};
        System.out.println("\nnums = " + Arrays.toString(nums));
        int[] out = missingAndDuplicate_contantSpace(nums);
        System.out.println("Missing = " + out[0] + ", Duplicate = " + out[1]);

        nums = new int[]{3, 1, 2, 5, 3};
        System.out.println("\nnums = " + Arrays.toString(nums));
        out = missingAndDuplicate_contantSpace(nums);
        System.out.println("Missing = " + out[0] + ", Duplicate = " + out[1]);
        System.out.println("\nnums = " + Arrays.toString(nums));
    }

    private static void test_multipleMissingAndDuplicates() {
        int[] nums = {2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println("Numbers = " + Arrays.toString(nums));

        List<List<Integer>> out = multipleMissingAndDuplicates_swapSort(nums);

        System.out.println("Afetr Swap-Sort, Numbers = " + Arrays.toString(nums));
        System.out.println("[Swap-Sort] Missing = " + out.get(0) + ", Duplicate = " + out.get(1));
    }
}
