package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 */
public class NextPermutation {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int p = nums.length - 1;
        while (p - 1 >= 0) {
            if (nums[p] > nums[p - 1]) {
                int n = p;
                while (n < nums.length && nums[n] > nums[p - 1]) n++;
                swap(nums, p - 1, n - 1);
                break;
            }
            p--;
        }
        //System.out.println("p = " + p + ", nums = " + Arrays.toString(nums));
        reverse(nums, p);
    }

    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private static void reverse(int[] nums, int p) {
        int s = p;
        int e = nums.length - 1;
        while (s < e) {
            int temp = nums[e];
            nums[e] = nums[s];
            nums[s] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] perm = {1, 2, 3};
        demo(perm);

        perm = new int[]{2, 1, 3};
        demo(perm);

        perm = new int[]{3, 2, 1};
        demo(perm);

        perm = new int[]{3, 1, 2};
        demo(perm);
    }

    private static void demo(int[] perm) {
        System.out.println("\nPermutation= " + Arrays.toString(perm));
        nextPermutation(perm);
        System.out.println("Next Perm  = " + Arrays.toString(perm));
    }
}
