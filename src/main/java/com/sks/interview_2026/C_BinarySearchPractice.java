package com.sks.interview_2026;

import java.util.Arrays;

public class C_BinarySearchPractice {
    public static void main(String[] args) {
        System.out.println("----- BINARY SEARCH -----");
        test_binarySearch();

        System.out.println("\n----- SORTED-ROTATED ARRAY -----");
        test_sortedRotatedArray();

        System.out.println("\n----- NEARLY SORTED ARRAY -----");
        test_nearlySortedArray();

        System.out.println("\n----- FLOOR-CEIL OF A NUMBER -----");
        test_floorCeil();

        System.out.println("\n----- INFINITE SORTED ARRAY -----");
        test_infiniteSortedArray();

        System.out.println("\n----- INFINITE BINARY SORTED ARRAY -----");
        test_infiniteBinarySortedArray();
    }


    /**
     * ITERATIVE
     * Time Complexity: O(logn), Space Complexity: O(1)
     **/
    public static int binarySearch_iterative(int[] nums, int n) {
        if (nums == null || nums.length == 0) return -1;
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == nums[mid]) return mid;
            else if (n > nums[mid]) s = mid + 1;
            else e = mid - 1;
        }
        return -1; //Not Found
    }

    /**
     * ITERATIVE
     * Time Complexity: O(logn), Space Complexity: O(logn) for method stack
     **/
    public static int binarySearch_recursive(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0, e = a.length - 1;
        return binarySearch_recursive(a, n, s, e);
    }

    private static int binarySearch_recursive(int[] a, int n, int s, int e) {
        // Base Condition: Where the recursion will break to avoid ArrayIndexOutOfBoundsException
        if (s > e) return -1;
        int m = s + (e - s) / 2;
        if (n == a[m]) return m;
        else if (n < a[m]) return binarySearch_recursive(a, n, s, m - 1);
        else return binarySearch_recursive(a, n, m + 1, e);
    }

    /**
     * numOfRotations = index of minimum element
     * Time Complexity: O(logn), Space Complexity: O(1)
     */
    private static int numOfRotations_sortedRotatedArray(int[] nums) {
        if (nums == null || nums.length < 2 || nums[0] < nums[nums.length - 1]) return -1;
        int len = nums.length;
        int s = 0, e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = mid - 1;
            int next = mid + 1;
            // Condition: smaller than both neighbors
            if (prev >= 0 && nums[mid] < nums[prev] && next < len && nums[mid] < nums[next]) return mid;
            if (nums[0] > nums[mid]) e = mid - 1;
            else if (nums[mid] > nums[len - 1]) s = mid + 1;
        }
        return -1;
    }

    /**
     * Time: O(logn), Space: O(1)
     */
    public static int binarySearch_nearlySorted(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int s = 0, e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = mid - 1;
            int next = mid + 1;
            if (n == a[prev]) return prev;
            else if (n == a[mid]) return mid;
            else if (n == a[next]) return next;
            else if (n < a[prev]) e = prev - 1;
            else if (n > a[next]) s = next + 1;
            else return -1;
        }
        return -1;
    }

    /**
     * Time Complexity: O(logn), Space Complexity: O(1)
     * REMEMBER(Opposite): Floor(greater), Set value when n>a[mid]
     * Ceil(smaller)- set value when n<a[mid]
     */
    public static int findFloor(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0, e = a.length - 1, result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return mid;
            else if (n < a[mid]) e = mid - 1;
            else {
                result = mid;
                s = mid + 1;
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(logn), Space Complexity: O(1)
     */
    public static int findCeil(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int s = 0, e = a.length - 1, result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return a[mid];
            else if (n < a[mid]) {
                e = mid - 1;
                result = mid;
            } else s = mid + 1;
        }
        return result;
    }

    /**
     * Time Complexity: O(logn), Space Complexity: O(1)
     */
    public static int findInfiniteSortedArray(int[] nums, int n) {
        if (nums == null || nums.length == 0 || n < nums[0]) return -1;
        int s = 0, e = 1;
        while (n > nums[e]) {
            s = e + 1;
            e *= 2;
        }
        return binarySearch_recursive(nums, n, s, e);
    }

    private static int findFirstOne_infiniteBinarySortedArray(int[] nums) {
        int s = 0, e = 1;
        while (nums[e] == 0) {
            s = e + 1;
            e *= 2;
        }
        int firstOne = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == 1) {
                firstOne = m;
                e = m - 1;
            } else s = m + 1;

        }
        return firstOne;
    }

    /**
     * TEST
     */
    private static void test_binarySearch() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int n = 7;
        System.out.println("Array = " + Arrays.toString(a) + ", n = " + n);
        System.out.println("[Iterative] Binary Search index = " + binarySearch_iterative(a, n));
        System.out.println("[Recursive] Binary Search index = " + binarySearch_recursive(a, n));
    }

    private static void test_sortedRotatedArray() {
        int[] a = {2, 5, 6, 8, 10, 13, 15, 18, 20};
        int[] rotatedA = {15, 18, 20, 2, 5, 6, 8, 10, 13};
        int n = 18;

        System.out.println("Original Array= " + Arrays.toString(a));
        System.out.println("Rotated Array = " + Arrays.toString(rotatedA));
        System.out.println("Num of Rotations = " + numOfRotations_sortedRotatedArray(rotatedA));
    }

    private static void test_nearlySortedArray() {
        int[] a = {5, 10, 30, 20, 40};
        int n = 30;
        System.out.println("Nearly-sorted Array = " + Arrays.toString(a) + ", n = " + n);
        System.out.println("Found at => " + binarySearch_nearlySorted(a, n));
    }

    private static void test_floorCeil() {
        int[] a = {1, 2, 3, 4, 8, 10, 15, 18};
        int n = 8;
        System.out.println("Array = " + Arrays.toString(a));
        //System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n) + ", Min. diff element(Floor_Ceil) = " + minDiffElement_floorCeilMethod(a, n) + ", Min Diff Ele = " + minDiffElement(a, n));
        System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n));
        n = 5;
        System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n));
        //System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n) + ", Min. diff element(Floor_Ceil) = " + minDiffElement_floorCeilMethod(a, n) + ", Min Diff Ele = " + minDiffElement(a, n));
    }

    private static void test_infiniteSortedArray() {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = i + 2 * i + 3;
        int n = 33;
        System.out.println("Array = " + Arrays.toString(a));
        System.out.println("Number = " + n + ", found at index = " + findInfiniteSortedArray(a, n));
        n = 1203;
        System.out.println("Number = " + n + ", found at index = " + findInfiniteSortedArray(a, n));
        n = 1204;
        System.out.println("Number = " + n + ", found at index = " + findInfiniteSortedArray(a, n));
        n = 1;
        System.out.println("Number = " + n + ", found at index = " + findInfiniteSortedArray(a, n));
    }

    private static void test_infiniteBinarySortedArray() {
        int[] a = new int[1025];
        for (int i = 0; i < 700; i++)
            a[i] = 0;
        for (int i = 700; i < a.length; i++)
            a[i] = 1;
        System.out.println("First occurrence of 1 = " + findFirstOne_infiniteBinarySortedArray(a));
    }
}
