package com.sks.leetcode.hard;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    /**
     * Time complexity: O(n), We store the maximum heights upto a point using 2 iterations of O(n) each. We finally update ans using the stored values in O(n).
     * Space complexity: O(n) extra space.Additional O(n) space for left_max and right_max arrays than in Approach 1
     */
    public static int trap(int[] heights) {
        if (heights == null || heights.length == 0) return -1;
        int totalWalter = 0;
        int[] maxLeft = new int[heights.length];
        int ml = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            ml = Math.max(ml, heights[i]);
            maxLeft[i] = ml;
        }
        System.out.println("maxLeft = " + Arrays.toString(maxLeft));
        int[] maxRight = new int[heights.length];
        int mr = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            mr = Math.max(mr, heights[i]);
            maxRight[i] = mr;
        }
        System.out.println("maxRight = " + Arrays.toString(maxRight));
        for (int i = 0; i < heights.length; i++) {
            int eligibleHeight = Math.min(maxRight[i], maxLeft[i]) - heights[i];
            int width = 1;
            totalWalter += (eligibleHeight * width);
        }
        return totalWalter;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        test(heights);

        heights = new int[]{4, 2, 0, 3, 2, 5};
        test(heights);
    }

    private static void test(int[] heights) {
        System.out.println("\nHeights = " + Arrays.toString(heights));
        System.out.println("Total Water Trapped = " + trap(heights));
    }
}
