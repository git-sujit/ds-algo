package com.sks.averma.binarysearch;


import java.util.Arrays;

/**
 * Find an element in infinite sorted array
 */
public class InfiniteSortedArray {
    /**
     * Time Complexity: O(logn) : O(logn) to identify the end index + O(logn) for binary search
     * Space Complexity: O(1)
     */
    public static int findElementPosition(int[] a, int n) {
        if (a == null) return -1;
        int s = 0;
        int e = 1;
        while (n > a[e]) {
            s = e;
            e *= 2;
        }
        return binarySearchForElement(a, n, s, e);
    }

    private static int binarySearchForElement(int[] a, int n, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return mid;
            else if (n < a[mid]) e = mid - 1;
            else s = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = i + 2 * i + 3;
        int n = 33;
        System.out.println("Array = " + Arrays.toString(a));
        System.out.println("Number = " + n + ", found at index = " + findElementPosition(a, n));
        n = 1203;
        System.out.println("Number = " + n + ", found at index = " + findElementPosition(a, n));
        n = 1204;
        System.out.println("Number = " + n + ", found at index = " + findElementPosition(a, n));
        n = 1;
        System.out.println("Number = " + n + ", found at index = " + findElementPosition(a, n));
    }
}
