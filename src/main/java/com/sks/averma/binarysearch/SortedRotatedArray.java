package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Sorted array is rotated n times, find n
 */
public class SortedRotatedArray {
    /**
     * numOfRotations = index of minimum element
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     * Remember: %len to avoid array out of bound error
     */
    public static int numOfRotations(int[] a) {
        if (a == null || a.length == 0) return -1;
        if (a.length == 1) return 0;
        int len = a.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int next = (mid + 1) % len;
            int prev = (mid + len - 1) % len;
            if (a[mid] < a[prev] && a[mid] < a[next])
                return mid;
            if (a[s] > a[mid])
                e = mid - 1;
            else if (a[mid] > a[e])
                s = mid + 1;
        }
        return -1;
    }

    public static int find(int[] a, int n) {
        int minEleIndex = numOfRotations(a);
        if (n == a[minEleIndex])
            return minEleIndex;
        int out = binarySearch(a, n, 0, minEleIndex - 1);
        if (out == -1)
            out = binarySearch(a, n, minEleIndex + 1, a.length - 1);
        return out;
    }

    private static int binarySearch(int[] a, int n, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return mid;
            else if (n < a[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] a = {2, 5, 6, 8, 10, 13, 15, 18, 20};
        int[] rotatedA = {15, 18, 20, 2, 5, 6, 8, 10, 13};
        int n = 18;
        test(rotatedA, n);

        rotatedA = new int[]{6, 7, 1, 2, 3, 4, 5};
        n = 4;
        test(rotatedA, n);

        rotatedA = new int[]{2, 1};
        n = 0;
        test(rotatedA, n);
    }

    private static void test(int[] rotatedA, int n) {
        System.out.println("\nRotated Array = " + Arrays.toString(rotatedA));
        System.out.println("Num of Rotations = " + numOfRotations(rotatedA));
        System.out.println("Found " + n + " at : " + find(rotatedA, n));
    }
}
