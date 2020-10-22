package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.Arrays;

/**
 * Given sorted array of distinct integers, find a magic index in array
 * - magic index i if : array[i] = i
 */
public class MagicIndex {

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    private static Integer findMagicIndex_bruteForce(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) return null;
        for (int i = 0; i < sortedArray.length; i++)
            if (sortedArray[i] == i) return i;
        return null;
    }

    /**
     * Time Complexity  : O(logn) : Base-2
     * Space Complexity : O(1)
     */
    private static Integer findMagicIndex_half_half_approach(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) return null;
        int s = 0;
        int e = sortedArray.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (sortedArray[m] < m) {
                s = m;
            } else if (sortedArray[m] > m) {
                e = m;
            } else {
                return m;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-10, -5, 0, 2, 3, 5, 10, 90};
        testMagicIndex(sortedArray);

        sortedArray = new int[]{-10, -5, 0, 2, 3, 5, 10, 90, 100};
        testMagicIndex(sortedArray);
    }

    private static void testMagicIndex(int[] sortedArray) {
        System.out.println("Brute Force : Array = " + Arrays.toString(sortedArray) + ", magic index = " + findMagicIndex_bruteForce(sortedArray));
        System.out.println("Half-Half   : Array = " + Arrays.toString(sortedArray) + ", magic index = " + findMagicIndex_half_half_approach(sortedArray));
    }
}
