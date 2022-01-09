package com.sks.averma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 */
public class NextSmallerElement {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for Stack and Output array
     */
    public static int[] nsLeft(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else {
                if (stack.peek() < nums[i]) nsl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() >= nums[i]) stack.pop();
                    nsl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return nsl;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for Stack and Output array
     */
    public static int[] nsRight(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        int[] nsr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = -1;
            else {
                if (stack.peek() < nums[i]) nsr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() >= nums[i]) stack.pop();
                    nsr[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return nsr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        test(nums);

        nums = new int[]{1, 3, 10, 2, 4};
        test(nums);

        nums = new int[]{1, 1, 2, 1};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("\nnums = " + Arrays.toString(nums));
        System.out.println("Next Smaller Element in Left = " + Arrays.toString(nsLeft(nums)));
        System.out.println("Next Smaller Element in Right = " + Arrays.toString(nsRight(nums)));
    }
}
