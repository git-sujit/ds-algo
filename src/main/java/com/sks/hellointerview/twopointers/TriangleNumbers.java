package com.sks.hellointerview.twopointers;

import java.util.Arrays;

/**
 * DESCRIPTION (credit Leetcode.com)
 * Write a function to count the number of triplets in an integer array nums that could form the sides
 * of a triangle. For three sides to form a valid triangle, the sum of any two sides must be
 * greater than the third side. The triplets do not need to be unique.
 * Input: nums = [11,4,9,6,15,18]
 * Output: 10
 */
public class TriangleNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{11, 4, 9, 6, 15, 18};
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("Valid Traingles = " + countValidTriangles(nums));
    }

    public static int countValidTriangles(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sumOfTwoSides = nums[i] + nums[left];
                //nums[right] will be longest side for sure
                if (sumOfTwoSides > nums[right]) {
                    count++;
                    right--;
                } else {
                    left++;
                    right = nums.length - 1;
                }
            }
        }
        return count;
    }
}
