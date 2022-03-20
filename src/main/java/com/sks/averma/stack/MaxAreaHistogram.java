package com.sks.averma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */
public class MaxAreaHistogram {
    /**
     * Time Complexity:  O(n) Traversing array 3 times, but in sequence, no nested loop
     * Space Complexity: O(n) for stack
     */
    public static int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) return -1;
        int max = 0;
        int[] nsLeft = nsLeftIndex(heights);
        System.out.println("nsLeftIndex  = " + Arrays.toString(nsLeft));
        int[] nsRight = nsRightIndex(heights);
        System.out.println("nsRightIndex = " + Arrays.toString(nsRight));
        for (int i = 0; i < heights.length; i++) {
            int width = nsRight[i] - nsLeft[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }

    private static int[] nsLeftIndex(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] nsl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else {
                if (nums[stack.peek()] < nums[i]) nsl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
                    nsl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsl;
    }

    private static int[] nsRightIndex(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] nsr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = nums.length;
            else {
                if (nums[stack.peek()] < nums[i]) nsr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
                    nsr[i] = stack.isEmpty() ? nums.length : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsr;
    }

    public static void main(String[] args) {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        test(heights);

        heights = new int[]{2, 1, 5, 6, 2, 3};
        test(heights);

        heights = new int[]{2, 4};
        test(heights);

        heights = new int[]{3, 1, 3, 2, 0};
        test(heights);

        heights = new int[]{4, 0, 0, 3, 0};
        test(heights);

        heights = new int[]{1, 1};
        test(heights);
    }

    private static void test(int[] heights) {
        System.out.println("\nHeights = " + Arrays.toString(heights));
        System.out.println("Max Area in Histogram = " + maxArea(heights));
    }
}
