package com.sks.averma.stack;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Stack;

public class NearestLeftRight {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int nearestGreaterToLeft_stack(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        int[] ngl = new int[nums.length];
        Stack<Integer> nglStack = new Stack<>();
        nglStack.push(-1);
        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int nearestGreaterToLeft_better(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        boolean found = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (found && nums[i] > n) return nums[i];
            else if (nums[i] == n) found = true;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int nearestGreaterToRight_better(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (found && nums[i] > n) return nums[i];
            else if (nums[i] == n) found = true;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int nearestGreaterToLeft_bruteForce(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        int ngLeft = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > n) {
                        ngLeft = nums[j];
                        break;
                    }
                }
            }
        }
        return ngLeft;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int nearestGreaterToRight_bruteForce(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        int ngLeft = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > n) {
                        ngLeft = nums[j];
                        break;
                    }
                }
            }
        }
        return ngLeft;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int nearestSmallerToLeft_bruteForce(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        int ngLeft = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < n) {
                        ngLeft = nums[j];
                        break;
                    }
                }
            }
        }
        return ngLeft;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int nearestSmallerToRight_bruteForce(int[] nums, int n) {
        if (nums == null || nums.length == 0) throw new InvalidParameterException("Nums array is null/empty");
        int ngLeft = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < n) {
                        ngLeft = nums[j];
                        break;
                    }
                }
            }
        }
        return ngLeft;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        int n = 2;
        test(nums, n);
        n = 1;
        test(nums, n);
        n = 3;
        test(nums, n);
        n = 4;
        test(nums, n);
    }

    private static void test(int[] nums, int n) {
        System.out.println("\nNums = " + Arrays.toString(nums) + ", n = " + n);
        System.out.println("[Better] Nearest greater element to LEFT of " + n + " = " + nearestGreaterToLeft_better(nums, n));
        System.out.println("[Brute-Force] Nearest greater element to LEFT of " + n + " = " + nearestGreaterToLeft_bruteForce(nums, n));
        System.out.println("[Better] Nearest greater element to RIGHT of " + n + " = " + nearestGreaterToRight_better(nums, n));
        System.out.println("[Brute-Force] Nearest greater element to RIGHT of " + n + " = " + nearestGreaterToRight_bruteForce(nums, n));
        System.out.println("[Brute-Force] Nearest smaller element to LEFT of " + n + " = " + nearestSmallerToLeft_bruteForce(nums, n));
        System.out.println("[Brute-Force] Nearest smaller element to RIGHT of " + n + " = " + nearestSmallerToRight_bruteForce(nums, n));
    }
}
