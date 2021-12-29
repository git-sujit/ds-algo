package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Binary Search on Answer
 */
public class BinarySearchOnAnswer {
    /**
     * Array which first increases and then decreases & no two elements are equal
     * E.g: a[] = {1,3,8,12,4,2}
     * Idea: Similar to finding the peak element
     */
    static class BitonicArray {
        public static int maxElement(int[] bitonic) {
            if (bitonic == null || bitonic.length == 0) return -1;
            if (bitonic.length == 1) return bitonic[0];
            return PeakElement.findPeakElement(bitonic);
        }

        public static void main(String[] args) {
            int[] bitonic = {1, 2, 4, 5, 6, 7, 9, 10, 13, 15, 18, 7, 6, 5, 4, 3, 0};
            System.out.println("Bitonic array = " + Arrays.toString(bitonic));
            System.out.println("Max element =" + maxElement(bitonic));
            bitonic = new int[]{4};
            System.out.println("Bitonic array = " + Arrays.toString(bitonic));
            System.out.println("Max element =" + maxElement(bitonic));
            bitonic = new int[]{4, 6};
            System.out.println("Bitonic array = " + Arrays.toString(bitonic));
            System.out.println("Max element =" + maxElement(bitonic));
            bitonic = new int[]{4, 6, 5};
            System.out.println("Bitonic array = " + Arrays.toString(bitonic));
            System.out.println("Max element =" + maxElement(bitonic));
            bitonic = new int[]{4, 6, 5, 3, 0};
            System.out.println("Bitonic array = " + Arrays.toString(bitonic));
            System.out.println("Max element =" + maxElement(bitonic));
        }
    }

    /**
     * Array is not Sorted but leverage binary search algorithm based on probability of answer in lef side vs right side
     * Idea: Take the half having higher number either at mid-1 or mid+1
     */
    static class PeakElement {
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
            System.out.println("Array = " + Arrays.toString(a));
            System.out.println("Peak Element = " + findPeakElement(a));
            a = new int[]{25, 10, 8, 15, 6};
            System.out.println("Array = " + Arrays.toString(a));
            System.out.println("Peak Element = " + findPeakElement(a));
            a = new int[]{25};
            System.out.println("Array = " + Arrays.toString(a));
            System.out.println("Peak Element = " + findPeakElement(a));
            a = new int[]{25, 10};
            System.out.println("Array = " + Arrays.toString(a));
            System.out.println("Peak Element = " + findPeakElement(a));
        }
    }
}
