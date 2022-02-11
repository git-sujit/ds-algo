package com.sks.averma.binarysearch;

import java.util.Arrays;

public class FloorCeilOfSortedArray {
    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static int findFloor(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int s = 0;
        int e = len - 1;
        int result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return mid;
            else if (n < a[mid])
                e = mid - 1;
            else {
                result = mid;
                s = mid + 1;
            }
        }
        return result;
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static int findCeil(int[] a, int n) {
        if (a == null || a.length == 0) return -1;
        int len = a.length;
        int s = 0;
        int e = len - 1;
        int result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return a[mid];
            else if (n < a[mid]) {
                e = mid - 1;
                result = mid;
            } else
                s = mid + 1;
        }
        return result;
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static char findNextAlphabet(char[] ca, char c) {
        if (ca == null || ca.length == 0) return ' ';
        int len = ca.length;
        int s = 0;
        int e = len - 1;
        char result = ' ';
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ca[mid] == c) s = mid + 1;
            else if (c < ca[mid]) {
                result = ca[mid];
                e = mid - 1;
            } else if (c > ca[mid])
                s = mid + 1;
        }
        return result;
    }

    public static int minDiffElement(int[] a, int n) {
        int len = a.length;
        int s = 0;
        int e = len - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (n == a[mid]) return a[mid];
            else if (n < a[mid]) e = mid - 1;
            else s = mid + 1;
        }
        //If n is not found then s & e will cross i.e s>e & both will be left-neighbour & right-neighbour of n
        return Math.abs(a[s] - n) < Math.abs(a[e] - n) ? a[s] : a[e];
    }

    /**
     * Time Complexity: O(logn)
     */
    public static int minDiffElement_floorCeilMethod(int[] a, int n) {
        int floor = findFloor(a, n);
        int ceil = findCeil(a, n);
        int floorDiff = Math.abs(floor - n);
        int ceilDiff = Math.abs(ceil - n);
        return floorDiff < ceilDiff ? floor : ceil;
    }

    public static void main(String[] args) {
        testFloorCeil();
        testAlphabet();
    }

    private static void testFloorCeil() {
        int[] a = {1, 2, 3, 4, 8, 10, 15, 18};
        int n = 8;
        System.out.println("Array = " + Arrays.toString(a));
        System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n) + ", Min. diff element(Floor_Ceil) = " + minDiffElement_floorCeilMethod(a, n) + ", Min Diff Ele = " + minDiffElement(a, n));
        n = 5;
        System.out.println("Number = " + n + ", Floor-Index = " + findFloor(a, n) + ", Ceil-Index = " + findCeil(a, n) + ", Min. diff element(Floor_Ceil) = " + minDiffElement_floorCeilMethod(a, n) + ", Min Diff Ele = " + minDiffElement(a, n));

    }

    private static void testAlphabet() {
        char[] ca = {'a', 'c', 'e', 'h', 'k', 'l', 't'};
        char c = 'g';
        System.out.println("Array = " + Arrays.toString(ca));
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
        c = 'k';
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
        c = 't';
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
    }
}
