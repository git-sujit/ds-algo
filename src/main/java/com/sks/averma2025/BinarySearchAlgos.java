package com.sks.averma2025;

import java.util.Arrays;

public class BinarySearchAlgos {
    private static final BinarySearchAlgos binarySearchAlgos = new BinarySearchAlgos();

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** BINARY SEARCH ***");
        binarySearchAlgos.test_binarySearch();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** SORTED ROTATED ARRAY ***");
        binarySearchAlgos.test_sortedRotatedArray();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** SORTED ROTATED ARRAY ***");
        binarySearchAlgos.test_findEle_nearlySortedArray();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** FLOOR/CEIL IN SORTED ARRAY ***");
        binarySearchAlgos.test_floorCeilSortedArray();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** INFINITE SORTED ARRAY ***");
        binarySearchAlgos.test_infiniteSortedArray();

    }

    /**
     * Binary Search - Iterative, O(logn)
     */
    private int binarySearch_iterative(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1;
        int m = -1;
        while (s <= e) {
            m = s + (e - s) / 2; //To avoid int overflow
            if (n < arr[m]) {
                e = m - 1;
            } else if (n > arr[m]) {
                s = m + 1;
            } else return m;
        }
        //Not Found
        return -1;
    }

    private int binarySearch_iterative(int[] arr, int n, int s, int e) {
        if (arr == null || arr.length == 0) return -1;
        int m = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (n == arr[m]) return m;
            else if (n < arr[m]) e = m - 1;
            else s = m + 1;
        }
        return -1;
    }

    /**
     * Binary Search - Iterative, O(logn)
     */
    private int binarySearch_recursive(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        return binarySearch_recursive(arr, n, 0, arr.length - 1);
    }

    private int binarySearch_recursive(int[] arr, int n, int s, int e) {
        // Base Condition: Where the recursion will break to avoid ArrayIndexOutOfBoundsException
        if (s > e) return -1;
        int m = s + (e - s) / 2;
        if (n == arr[m]) return m;
        else if (n < arr[m]) return binarySearch_recursive(arr, n, s, m - 1);
        else return binarySearch_recursive(arr, n, m + 1, e);
    }

    /**
     * Sorted Rotated Array: Rotated Count & Find Element
     * You can achieve min ele linearly, O(n). Using binary search improves to O(logn)
     */
    private int findEle_rotatedSortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int minIndex = rotatedCount_rotatedSortedArray(arr);
        if (n == arr[minIndex]) return minIndex;
        else if (n < arr[0]) return binarySearch_iterative(arr, n, minIndex + 1, arr.length - 1);
        else if (n > arr[arr.length - 1]) return binarySearch_iterative(arr, n, 0, minIndex - 1);
        else return -1;
    }

    private int rotatedCount_rotatedSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1;
        int m = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            int prev = m - 1;
            int next = m + 1;
            if (prev >= 0 && next < arr.length && arr[m] < arr[prev] && arr[m] < arr[next]) return m;
            if (arr[0] > arr[m])
                e = m - 1;
            if (arr[arr.length - 1] < arr[m])
                s = m + 1;
        }
        return -1;
    }

    /**
     * Nearly Sorted Array: Find Element
     * Element i in corresponding sorted array can be at: {i-1, i, i+1}
     */
    private int findEle_nearlySortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1;
        int mid = -1, prev = -1, next = -1;
        while (s <= e) {
            mid = s + (e - s) / 2;
            prev = mid - 1;
            next = mid + 1;
            if (n == arr[mid]) return mid;
            if (prev >= 0 && n == arr[prev]) return prev;
            if (next < arr.length && n == arr[next]) return next;
            if (n < arr[mid]) e = mid - 2;
            else s = mid + 2;
        }
        return -1;
    }

    /**
     * Floor, Ceil, Next Alphabetic Element
     * Floor: Greatest element Smaller than n
     * Ceil: Smallest element Greater then n
     */
    private int floorSortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1, m = -1, floor = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (n == arr[m]) return arr[m];
            if (arr[m] < n) {
                floor = arr[m];
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return floor;
    }

    private int ceilSortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1, m = -1, ceil = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (n == arr[m]) return arr[m];
            if (arr[m] > n) {
                ceil = arr[m];
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ceil;
    }

    private char nextAlphabeticElement(char[] arr, char c) {
        if (arr == null || arr.length == 0) return ' ';
        int s = 0, e = arr.length - 1, m = -1;
        char out = ' ';
        while (s <= e) {
            m = s + (e - s) / 2;
            if (arr[m] == c) {
                if (m + 1 < arr.length) return arr[m + 1];
                else return ' ';
            } else {
                if (arr[m] > c) {
                    out = arr[m];
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }
        return out;
    }

    /**
     * Infinite Sorted Array
     */
    private int findEle_infiniteSortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = 1;
        while (n > arr[e]) {
            s = e;
            e *= 2;
            //Patch: Test Input is not infinite :-)
            if (e > arr.length - 1) {
                e = arr.length - 1;
                break;
            }
        }
        return binarySearch_iterative(arr, n, s, e);
    }

    private int first1_infiniteBinarySortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = 1, m = 0;
        while (arr[e] != 1) {
            s = e;
            e *= 2;
            //Patch: Test Input is not infinite :-)
            if (e > arr.length - 1) {
                e = arr.length - 1;
                break;
            }
        }
        int res = e;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (arr[m] == 1) {
                res = m;
                e = m - 1;
            } else s = m + 1;
        }
        return res;
    }

    private int minDifferenceEle_SortedArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1, m = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (n == arr[m]) return arr[m];
            if (n < arr[m]) e = m - 1;
            else s = m + 1;
        }
        //System.out.println("s=" + s + ", e=" + e);
        // If n is smaller than nums[0] then e will be -1
        if (e == -1) return arr[0];
        // If n is greater than nums[len-1 then s will be len
        if (s == arr.length) return arr[arr.length - 1];
        return Math.abs(arr[s] - n) < Math.abs(arr[e] - n) ? arr[s] : arr[e];
    }

    /**
     * TESTING...Binary Search
     */
    private void test_infiniteSortedArray() {
        //Infinite Sorted Array
        int[] arr = new int[]{1, 5, 6, 9, 13, 15, 19, 20, 27, 34, 35, 37, 39, 41, 45, 48, 50, 53, 59, 62, 64, 68, 71, 74, 79, 83, 85, 86, 90, 100};
        System.out.println("Infinite Sorted Array = " + Arrays.toString(arr) + "...");
        int n = 19;
        System.out.println("Search Element (" + n + "): " + binarySearchAlgos.findEle_infiniteSortedArray(arr, n));
        n = 43;
        System.out.println("Search Element (" + n + "): " + binarySearchAlgos.findEle_infiniteSortedArray(arr, n));
        n = 71;
        System.out.println("Search Element (" + n + "): " + binarySearchAlgos.findEle_infiniteSortedArray(arr, n));

        //Infinite Binary Sorted Array
        int[] binaryArr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Infinite Binary Sorted Array = " + Arrays.toString(binaryArr) + "...");
        System.out.println("First 1 at index: " + binarySearchAlgos.first1_infiniteBinarySortedArray(arr));

        //Min Difference Element
        arr = new int[]{1, 5, 6, 9, 13, 15, 19, 20, 27, 34, 35, 37, 39, 41, 45, 48, 50, 53, 59, 62, 64, 68, 71, 74, 79, 83, 85, 86, 90, 100};
        System.out.println("Sorted Array = " + Arrays.toString(arr) + "...");
        n = 19;
        System.out.println("Min Difference Index for (" + n + "): " + binarySearchAlgos.minDifferenceEle_SortedArray(arr, n));
        n = 28;
        System.out.println("Min Difference Index for (" + n + "): " + binarySearchAlgos.minDifferenceEle_SortedArray(arr, n));
        n = 101;
        System.out.println("Min Difference Index for (" + n + "): " + binarySearchAlgos.minDifferenceEle_SortedArray(arr, n));
        n = 0;
        System.out.println("Min Difference Index for (" + n + "): " + binarySearchAlgos.minDifferenceEle_SortedArray(arr, n));
        n = 98;
        System.out.println("Min Difference Index for (" + n + "): " + binarySearchAlgos.minDifferenceEle_SortedArray(arr, n));
    }

    private void test_floorCeilSortedArray() {
        int[] arr = new int[]{1, 2, 4, 5, 7, 8, 10, 10, 40, 50, 73};
        System.out.println("Sorted Array = " + Arrays.toString(arr));
        int n = 8;
        System.out.println("Number=" + n + ", Floor=" + binarySearchAlgos.floorSortedArray(arr, n) + ", Ceil=" + binarySearchAlgos.ceilSortedArray(arr, n));
        n = 3;
        System.out.println("Number=" + n + ", Floor=" + binarySearchAlgos.floorSortedArray(arr, n) + ", Ceil=" + binarySearchAlgos.ceilSortedArray(arr, n));
        n = 10;
        System.out.println("Number=" + n + ", Floor=" + binarySearchAlgos.floorSortedArray(arr, n) + ", Ceil=" + binarySearchAlgos.ceilSortedArray(arr, n));
        n = 45;
        System.out.println("Number=" + n + ", Floor=" + binarySearchAlgos.floorSortedArray(arr, n) + ", Ceil=" + binarySearchAlgos.ceilSortedArray(arr, n));
        n = 100;
        System.out.println("Number=" + n + ", Floor=" + binarySearchAlgos.floorSortedArray(arr, n) + ", Ceil=" + binarySearchAlgos.ceilSortedArray(arr, n));

        //Next Alphabetic Element
        char[] cArr = new char[]{'b', 'c', 'f', 'h'};
        System.out.println("Char Array = " + Arrays.toString(cArr));
        char c = 'f';
        System.out.println("Next Alphabetic Element of '" + c + "' = " + binarySearchAlgos.nextAlphabeticElement(cArr, c));
        c = 'z';
        System.out.println("Next Alphabetic Element of '" + c + "' = " + binarySearchAlgos.nextAlphabeticElement(cArr, c));
        c = 'd';
        System.out.println("Next Alphabetic Element of '" + c + "' = " + binarySearchAlgos.nextAlphabeticElement(cArr, c));
        c = 'a';
        System.out.println("Next Alphabetic Element of '" + c + "' = " + binarySearchAlgos.nextAlphabeticElement(cArr, c));
    }

    private void test_findEle_nearlySortedArray() {
        int[] arr = new int[]{5, 10, 30, 20, 40};
        System.out.println("Nearly Sorted Array = " + Arrays.toString(arr));
        int n = 5;
        System.out.println("Binary Search of (" + n + ") : " + binarySearchAlgos.findEle_nearlySortedArray(arr, n));
        n = 2;
        System.out.println("Binary Search of (" + n + ") : " + binarySearchAlgos.findEle_nearlySortedArray(arr, n));
        n = 20;
        System.out.println("Binary Search of (" + n + ") : " + binarySearchAlgos.findEle_nearlySortedArray(arr, n));
        n = 40;
        System.out.println("Binary Search of (" + n + ") : " + binarySearchAlgos.findEle_nearlySortedArray(arr, n));
        n = 75;
        System.out.println("Binary Search of (" + n + ") : " + binarySearchAlgos.findEle_nearlySortedArray(arr, n));
    }

    private void test_sortedRotatedArray() {
        int[] arr = new int[]{18, 19, 25, 35, 5, 8, 11, 12};
        System.out.println("Rotated Sorted Array = " + Arrays.toString(arr));
        System.out.println("Rotated Count = " + binarySearchAlgos.rotatedCount_rotatedSortedArray(arr));

        int n = 19;
        System.out.println("Find (" + n + ") : " + binarySearchAlgos.findEle_rotatedSortedArray(arr, n));
        n = 8;
        System.out.println("Find (" + n + ") : " + binarySearchAlgos.findEle_rotatedSortedArray(arr, n));
        n = 100;
        System.out.println("Find (" + n + ") : " + binarySearchAlgos.findEle_rotatedSortedArray(arr, n));
        n = 3;
        System.out.println("Find (" + n + ") : " + binarySearchAlgos.findEle_rotatedSortedArray(arr, n));
        n = 5;
        System.out.println("Find (" + n + ") : " + binarySearchAlgos.findEle_rotatedSortedArray(arr, n));
    }

    private void test_binarySearch() {
        int[] arr = new int[]{2, 8, 12, 13, 19, 22, 29};
        System.out.println("Sorted Array = " + Arrays.toString(arr));
        int n = 13;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 2;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 29;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 22;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 100;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 25;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
        n = 0;
        System.out.println("[Iterative] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_iterative(arr, n));
        System.out.println("[Recursive] Binary Search of (" + n + ") : " + binarySearchAlgos.binarySearch_recursive(arr, n));
    }
}
