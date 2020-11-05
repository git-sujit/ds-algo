package com.sks.algo2020.algoexperts.easy;

import java.util.Arrays;

public class BinarySearch {
    /**
     * ITERATION
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static int binarySearch_iterative(int[] array, int target) {
        if (array != null && array.length > 0) {
            int s = 0;
            int e = array.length - 1;
            while (s <= e) {
                int m = (s + e) / 2;
                int p = array[m];
                // Skip m in next iteration because its already checked
                if (target < p)
                    e = m - 1;
                    // Skip m in next iteration because its already checked
                else if (target > p)
                    s = m + 1;
                else
                    return m;
            }
        }
        return -1;
    }

    /**
     * RECURSION
     * Time Complexity  : O(logn), Base-2
     * Space Complexity : O(logn), Base-2
     */
    public static int binarySearch_recursive(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;
        return binarySearch_recursive(array, target, 0, array.length - 1);
    }

    private static int binarySearch_recursive(int[] array, int target, int s, int e) {
        if (s > e)
            return -1;
        int m = (s + e) / 2;
        int p = array[m];
        if (target < p)
            return binarySearch_recursive(array, target, s, m - 1);
        else if (target > p)
            return binarySearch_recursive(array, target, m + 1, e);
        else
            return m;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 0;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 73;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 72;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 44;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        array = new int[]{1, 5, 23, 111};
        target = 111;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 5;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        target = 35;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);

        array = new int[]{};
        target = -1;
        testBinarySearch_iterative(array, target);
        testBinarySearch_recursive(array, target);
    }

    private static void testBinarySearch_recursive(int[] array, int target) {
        System.out.println("\nRecursion, array = " + Arrays.toString(array) + ", target = " + target);
        System.out.println("\t Binary Search Result = " + binarySearch_recursive(array, target));
    }

    private static void testBinarySearch_iterative(int[] array, int target) {
        System.out.println("\nIteration, array = " + Arrays.toString(array) + ", target = " + target);
        System.out.println("\t Binary Search Result = " + binarySearch_iterative(array, target));
    }
}
