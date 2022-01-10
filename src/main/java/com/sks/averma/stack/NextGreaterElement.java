package com.sks.averma.stack;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 */
public class NextGreaterElement {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for Stack and Output array
     */
    public static int[] ngLeft(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] ngl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) ngl[i] = -1;
            else {
                if (stack.peek() > nums[i]) ngl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
                    ngl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return ngl;
    }

    //Pair<Element, Index>
    public static Pair<Integer, Integer>[] ngLeft_pair(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Pair<Integer, Integer>[] ngl = new Pair[nums.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            Pair<Integer, Integer> eleIndexPair = new Pair(nums[i], i);
            if (stack.isEmpty()) ngl[i] = new Pair<>(nums[i], -1);
            else {
                if (stack.peek().getKey() > nums[i]) ngl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek().getKey() <= nums[i]) stack.pop();
                    ngl[i] = stack.isEmpty() ? new Pair<>(nums[i], -1) : stack.peek();
                }
            }
            stack.push(eleIndexPair);
        }
        return ngl;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for Stack and Output array
     */
    public static int[] ngRight(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] ngr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) ngr[i] = -1;
            else {
                if (stack.peek() > nums[i]) ngr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
                    ngr[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return ngr;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for Stack and Output array
     */
    public static int[] ngRight_improved(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] ngr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) stack.pop();
            ngr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ngr;
    }


    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int[] ngRight_bruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] ngr = new int[nums.length];
        Arrays.fill(ngr, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ngr[i] = nums[j];
                    break;
                }
            }
        }
        return ngr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        test(nums);

        nums = new int[]{1, 3, 10, 2, 4};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("\nnums = " + Arrays.toString(nums));
        System.out.println("Next Greater Element in Left = " + Arrays.toString(ngLeft(nums)));
        System.out.println("[Pair]Next Greater Element in Left = " + Arrays.toString(ngLeft_pair(nums)));
        System.out.println("Next Greater Element in Right = " + Arrays.toString(ngRight(nums)));
        System.out.println("[Improved] Next Greater Element in Right = " + Arrays.toString(ngRight_improved(nums)));
        System.out.println("[Brute Force] Next Greater Element in Right = " + Arrays.toString(ngRight_bruteForce(nums)));
    }
}
