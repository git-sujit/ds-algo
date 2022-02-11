package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Binary Search on Answer(BSA)
 * Array which first increases and then decreases & no two elements are equal
 * E.g: a[] = {1,3,8,12,4,2}
 * Idea: Similar to finding the peak element
 */
public class BitonicArray {
    public static int maxElement(int[] bitonic) {
        if (bitonic == null || bitonic.length == 0) return -1;
        if (bitonic.length == 1) return bitonic[0];
        return PeakElement.findPeakElement(bitonic);
    }

    /**
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     */
    public static int btSearch(int[] bt, int n) {
        int peak = PeakElement.findPeakElement_recursive(bt);
        if (peak > 0 && n < bt[peak]) BinarySearch.binarySearch(bt, n, 0, peak - 1);
        else if (n == bt[peak]) return peak;
        else if (peak < bt.length - 1 && n > bt[peak])
            BinarySearch.binarySearch_reverseSorted(bt, n, peak + 1, bt.length - 1);

        return -1;
    }

    public static void main(String[] args) {
        int[] bitonic = {1, 2, 4, 5, 6, 7, 9, 10, 13, 15, 18, 7, 6, 5, 4, 3, 0};
        int[] n = {10, 3, 0, 1, 4, 13};
        test(bitonic, n);

        bitonic = new int[]{4};
        test(bitonic, new int[]{0});

        bitonic = new int[]{4, 6};
        test(bitonic, new int[]{0, 6});

        bitonic = new int[]{4, 6, 5};
        test(bitonic, new int[]{5, 10});

        bitonic = new int[]{4, 6, 5, 3, 0};
        test(bitonic, new int[]{3, 13});
    }

    private static void test(int[] bitonic, int[] search) {
        System.out.println("\nBitonic array = " + Arrays.toString(bitonic));
        System.out.println("Max element =" + maxElement(bitonic));
        for (int s : search)
            System.out.println("Element " + s + " at Index\t: " + btSearch(bitonic, s));
    }
}
