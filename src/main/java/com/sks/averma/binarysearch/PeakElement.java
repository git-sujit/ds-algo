package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Array is not Sorted but leverage binary search algorithm based on probability of answer in lef side vs right side
 * Idea: Take the half having higher number either at mid-1 or mid+1
 */
public class PeakElement {

    public static int findPeakElement_recursive(int[] a) {
        if (a == null || a.length == 0) return -1;
        return findPeakElement_recursive(a, 0, a.length - 1);
    }

    private static int findPeakElement_recursive(int[] a, int s, int e) {
        if (s == e) return s;
        int mid = s + (e - s) / 2;
        if (a[mid] > a[mid + 1])
            return findPeakElement_recursive(a, s, mid);
        return findPeakElement_recursive(a, mid + 1, e);
    }

    /**
     * Time Complexity:  O(logn)
     * Space Complexity: O(1)
     */
    public static int findPeakElement_better_not_working(int[] a) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = mid - 1;
            int next = mid + 1;
            if (mid == 0) {
                if (next < e && a[mid] > a[next]) return a[mid];
                else s = next;
            } else if (mid == a.length - 1) {
                if (prev >= s && a[mid] > a[prev]) return a[mid];
                else e = prev;
            } else {
                if (a[mid] > a[prev] && a[mid] > a[next]) return a[mid];
                else if (a[mid] < a[prev]) e = prev;
                else if (a[mid] < a[next]) s = next;
            }
        }
        return -1;
    }

    public static int findPeakElement(int[] a) {
        if (a == null || a.length == 0) return -1;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid > 0 && mid < a.length - 1) {
                if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                    return a[mid];
                else if (a[mid] < a[mid - 1])
                    e = mid - 1;
                else if (a[mid] < a[mid + 1])
                    s = mid + 1;
            } else if (mid == 0) {
                if (mid + 1 < a.length && a[mid] > a[mid + 1]) return a[mid];
                else s = mid + 1;
            } else if (mid == a.length - 1) {
                if (mid - 1 >= 0 && a[mid] > a[mid - 1]) return a[mid];
                else e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 20, 15};
        test(a);

        a = new int[]{25, 10, 8, 15, 6};
        test(a);

        a = new int[]{25};
        test(a);

        a = new int[]{25, 10};
        test(a);
    }

    private static void test(int[] a) {
        System.out.println("\nArray = " + Arrays.toString(a));
        System.out.println("Peak Element = " + findPeakElement(a));
        System.out.println("[Better]Peak Element = " + findPeakElement_better_not_working(a));
        System.out.println("[Recursion]Peak Element = " + findPeakElement_recursive(a));
    }

}
