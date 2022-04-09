package com.sks.averma.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Sort a K-Sorted/Nearly sorted array
 * Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time.
 * For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 */
public class KSortedArray {
    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static void sortNearlySorted(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0) return;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        for (int e : a) {
            minHeap.add(e);
            if (minHeap.size() > k)
                a[i++] = minHeap.remove();
        }
        while (!minHeap.isEmpty())
            a[i++] = minHeap.remove();
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        test(a, k);

        a = new int[]{10, 9, 8, 7, 4, 70, 60, 50};
        k = 4;
        test(a, k);
    }

    static void test(int[] a, int k) {
        System.out.println("\nk = " + k + ", Array = " + Arrays.toString(a));
        sortNearlySorted(a, k);
        System.out.println("Sorted Array = " + Arrays.toString(a));
    }
}
