package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Given a sorted array and a number, search the number in the array and return the index of number
 */
public class BinarySearch {
    /**
     * Array is sorted in ascending order
     * Time Complexity: O(logn), each iteration we are reducing the input to the half
     * Space Complexity: O(1)
     */
    public static int binarySearch(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            //int mid = (s + e) / 2;
            //To avoid int overflow use: mid = s+(e-s)/2
            int mid = s + (e - s) / 2;
            if (n > a[mid])
                s = mid + 1;
            else if (n < a[mid])
                e = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(logn)
     */
    public static int binarySearch_recursive(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        return binarySearch_recursive(a, n, s, e);
    }

    private static int binarySearch_recursive(int[] a, int n, int s, int e) {
        if (s > e) return -1;
        int m = s + (e - s) / 2;
        if (n < a[m]) return binarySearch_recursive(a, n, s, m - 1);
        else if (n == a[m]) return m;
        else return binarySearch_recursive(a, n, m + 1, e);
    }

    public static int binarySearch(int[] a, int n, int s, int e) {
        while (s <= e) {
            //int mid = (s + e) / 2;
            //To avoid int overflow use: mid = s+(e-s)/2
            int mid = s + (e - s) / 2;
            if (n > a[mid])
                s = mid + 1;
            else if (n < a[mid])
                e = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Array is sorted in descending order
     * Time Complexity: O(logn), each iteration we are reducing the input to the half
     * Space Complexity: O(1)
     */
    public static int binarySearch_reverseSorted(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n > a[mid])
                e = mid - 1;
            else if (n < a[mid])
                e = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int binarySearch_reverseSorted(int[] a, int n, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n > a[mid])
                e = mid - 1;
            else if (n < a[mid])
                e = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Sorted order is unknown
     */
    public static int binarySearch_orderAgnostic(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        if (a.length == 1) {
            if (a[0] == n) return 0;
            else return -1;
        }
        boolean isAscOrder = a[0] < a[1];
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isAscOrder) {
                if (n > a[mid])
                    s = mid + 1;
                else if (n < a[mid])
                    e = mid - 1;
                else
                    return mid;
            } else {
                if (n > a[mid])
                    e = mid - 1;
                else if (n < a[mid])
                    e = mid + 1;
                else
                    return mid;
            }
        }
        return -1;
    }

    /**
     * First occurrence of
     * Input: Array=[2,4,10,10,10,18,20], Number=10
     * Output: 2
     */
    public static int firstOccurrence(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / e;
            if (n > a[mid])
                s = mid + 1;
            else if (n < a[mid])
                e = mid - 1;
            else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Last occurrence
     * Input: Array=[2,4,10,10,10,18,20], Number=10
     * Output: 4
     */
    public static int lastOccurrence(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / e;
            if (n > a[mid])
                s = mid + 1;
            else if (n < a[mid])
                e = mid - 1;
            else {
                ans = mid;
                s = mid + 1;
            }
        }
        return ans;
    }

    public static int countOfOccurrence(int[] a, int n) {
        return lastOccurrence(a, n) - firstOccurrence(a, n) + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int n = 7;
        System.out.println("Array = " + Arrays.toString(a) + ", n = " + n);
        System.out.println("Binary Search index = " + binarySearch(a, n));
        System.out.println("[Recursive]Binary Search index = " + binarySearch_recursive(a, n));

        a = new int[]{2, 4, 10, 10, 10, 18, 20};
        n = 10;
        System.out.println("Array = " + Arrays.toString(a) + ", n = " + n);
        System.out.println("First Occurrence = " + firstOccurrence(a, n) + ", Last Occurrence = " + lastOccurrence(a, n) + ", Count of occurrence = " + countOfOccurrence(a, n));
    }
}
