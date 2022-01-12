package com.sks.averma.stack;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class RainWaterTrapping {
    public static int waterTrapped(int[] heights) {
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

    public static int waterTrapped_bruteForce_incorrect(int[] heights) {
        if (heights == null || heights.length == 0) return -1;
        int totalWalter = 0;
        for (int i = 1; i < heights.length; i++) {
            int j = 1;
            int maxHeight = 0;
            while (i - j >= 0 && i + j < heights.length) {
                int leftH = heights[i - j];
                int rightH = heights[i + j];
                if (leftH < heights[i + j - 1] || rightH < heights[i + j - 1]) break;
                maxHeight = Math.min(leftH, rightH);
                j++;
            }
            j--;
            System.out.println("i = " + i + ", j = " + j + ", Range = (" + (i - j) + ", " + (i + j) + ")" + ", maxHeight = " + maxHeight);
            for (int k = i - j + 1; k < i + j; k++)
                totalWalter += (maxHeight - heights[k]) * 1;
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
        System.out.println("Total Water Trapped = " + waterTrapped(heights));
        System.out.println("[Brute Force] Total Water Trapped = " + waterTrapped_bruteForce_incorrect(heights));
    }
}
