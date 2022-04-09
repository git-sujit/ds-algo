package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * index-i element can be at i-1, i or i+1
 */
public class NearlySortedArray {
    /**
     * Time: O(logn)
     * Space: O(1)
     */
    public static int binarySearch_nearlySorted_better(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = (mid - 1 + len) % len;
            int next = (mid + 1) % len;
            if (n == a[prev]) return prev;
            else if (n == a[mid]) return mid;
            else if (n == a[next]) return next;
            else if (n < a[prev]) e = prev - 1;
            else if (n > a[next]) s = next + 1;
            else return -1;
        }
        return -1;
    }

    public static int binarySearch_nearlySorted(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = mid - 1;
            int next = mid + 1;
            if (prev >= s && n == a[prev]) return prev;
            else if (n == a[mid]) return mid;
            else if (next <= e && n == a[next]) return next;
            else if (prev >= s && n < a[prev]) e = prev - 1;
            else if (next <= e && n > a[next]) s = next + 1;
            else return -1;
        }
        return -1;
    }

    /**
     * Time: O(logn)
     * Space: O(1)
     */
    public static int binarySearch(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid - 1 >= s && a[mid - 1] == n) return mid - 1;
            else if (a[mid] == n) return mid;
            else if (mid + 1 <= e && a[mid + 1] == n) return mid + 1;
            else if (mid - 1 >= 0 && n < a[mid - 1]) e = mid - 2;
            else if (mid + 1 < len && n > a[mid + 1]) s = mid + 2;
            else return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 30, 20, 40};
        int n = 30;
        System.out.println("Nearly-sorted Array = " + Arrays.toString(a) + ", n = " + n);
        System.out.println("Found at => " + binarySearch(a, n));
        System.out.println("[Better]Found at => " + binarySearch_nearlySorted(a, n));
        System.out.println("[Even-Better]Found at => " + binarySearch_nearlySorted_better(a, n));
    }
}
