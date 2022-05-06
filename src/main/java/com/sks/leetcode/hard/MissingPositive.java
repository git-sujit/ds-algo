package com.sks.leetcode.hard;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */

public class MissingPositive {
    public static int getSmallestMissingNumber(int[] a) {
        if (a == null || a.length == 0)
            return Integer.MIN_VALUE;
        Arrays.sort(a);
        for (int n : a) {
        }
        return -1;
    }
}
