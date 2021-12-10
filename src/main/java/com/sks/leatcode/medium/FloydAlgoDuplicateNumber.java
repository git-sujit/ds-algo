package com.sks.leatcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FloydAlgoDuplicateNumber {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Idea: Cycle detection in LinkedList, Each new element in the sequence is an element in nums at the index of the previous element.
     * The cycle appears because nums contains duplicates. The duplicate node is a cycle entrance.
     * Floyd's algorithm consists of two phases and uses two pointers, usually called tortoise and hare
     * In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise]
     */
    public static int floydTortoiseNHareAlgo(int[] nums) {
        // Phase-1: Find intersection point for tortoise & hare
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase-2: find entrance of the cycle i.e duplicate
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    /**
     * Time Complexity: O(nlogn) [O(nlogn) for Java Quick Sort + O(n) for iteration]
     * Space Complexity: O(logn) [Java Quicksort uses O(logn) space]
     */
    public static int sortAndFind(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return nums[i];

        return -1;
    }

    /**
     * Time Complexity: O(n) : for scanning the nums[] array
     * Space Complexity: O(n) [For preparing hashtable]
     */
    public static int hashAndFind(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n))
                return n;
            else
                set.add(n);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 2};
        test(a);
        a = new int[]{3, 1, 3, 4, 2};
        test(a);
        a = new int[]{1, 1};
        test(a);
    }

    private static void test(int[] nums) {
        System.out.println("\nArray = " + Arrays.toString(nums));
        System.out.println("Algo-sortAndFind = " + sortAndFind(nums));
        System.out.println("Algo-hashAndFind = " + hashAndFind(nums));
        System.out.println("Algo-Floyd'sAlgo = " + floydTortoiseNHareAlgo(nums));
    }
}
