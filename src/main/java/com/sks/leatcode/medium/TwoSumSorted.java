package com.sks.leatcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Your solution must use only constant extra space.
 */
public class TwoSumSorted {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int len = numbers.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            else j--;
        }
        return null;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> twoSum_allPairs(int[] numbers, int target) {
        List<List<Integer>> out = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return out;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) left++;
            else if (sum == target) {
                out.add(Arrays.asList(left, right));
                left++;
                right--;
            } else right--;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        demo(nums, target);

        nums = new int[]{1, 1, 1, 1, 1, 1, 1};
        target = 2;
        demo(nums, target);
    }

    private static void demo(int[] nums, int target) {
        System.out.println("\nNumbers = " + Arrays.toString(nums) + ", Target = " + target);
        System.out.println("Output(Indices) = " + Arrays.toString(new TwoSumSorted().twoSum(nums, target)));
        System.out.println("All-Pairs(Indices) = " + new TwoSumSorted().twoSum_allPairs(nums, target));
    }
}
