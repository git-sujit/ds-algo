package com.sks.hellointerview.twopointers;

import java.util.*;

/**
 * DESCRIPTION (credit Leetcode.com)
 * Given an input integer array nums, write a function to find all unique triplets [nums[i], nums[j], nums[k]]
 * such that i, j, and k are distinct indices, and the sum of nums[i], nums[j], and nums[k] equals zero.
 * Ensure that the resulting list does not contain any duplicate triplets.
 * Input:
 * nums = [-1,0,1,2,-1,-1]
 * Output:
 * [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -1};
        nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("Three-Sum(Brute Force) = " + threeSums_bruteForce(nums));
        System.out.println("Three-Sum(Efficient) = " + threeSums_efficient(nums));
    }

    /**
     * Fix one element & find other two
     * Time Complexity: O(nlon(n))
     * Space Complexity: O(n)
     */
    public static List<List<Integer>> threeSums_efficient(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //Fix one element(i) & find other two(left/right)
        for (int i = 0; i <= nums.length - 3; i++) {
            // Skip duplicate values for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }

    /**
     * Brute Force:
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static Set<List<Integer>> threeSums_bruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                for (int k = j + 1; k < nums.length; k++)
                    if (nums[i] + nums[j] + nums[k] == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        return result;
    }
}
