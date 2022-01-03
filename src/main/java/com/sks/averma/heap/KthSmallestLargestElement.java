package com.sks.averma.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue for Heap
 * Heap is complete binary tree & each node is greater(maxHeap) or smaller(minHeap) than children
 */
public class KthSmallestLargestElement {
    /**
     * SORT and iterate: O(nlogn)
     * Using Heap: O(nlogk)
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static int kthSmallest(int[] a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : a) {
            maxHeap.add(e);
            if (maxHeap.size() > k) maxHeap.remove();
        }
        return maxHeap.peek();
    }

    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static int kthLarglest(int[] a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int e : a) {
            maxHeap.add(e);
            if (maxHeap.size() > k) maxHeap.remove();
        }
        return maxHeap.peek();
    }

    public static int[] topXMarks(int[] marks, int x) {
        if (marks == null || marks.length == 0 || x <= 0) return null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int m : marks) {
            minHeap.add(m);
            if (minHeap.size() > x)
                minHeap.remove();
        }
        int[] topMarks = new int[x];
        int i = 0;
        while (!minHeap.isEmpty()) {
            topMarks[i++] = minHeap.remove();
        }
        return topMarks;
    }

    public static int[] bottomXMarks(int[] marks, int x) {
        if (marks == null || marks.length == 0 || x <= 0) return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int m : marks) {
            maxHeap.add(m);
            if (maxHeap.size() > x)
                maxHeap.remove();
        }
        int[] bottomMarks = new int[x];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            bottomMarks[i++] = maxHeap.remove();
        }
        return bottomMarks;
    }

    public static void main(String[] args) {
        int[] a = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Array = " + Arrays.toString(a) + ", k = " + k);
        System.out.println(k + "th smallest Element = " + kthSmallest(a, k));
        System.out.println(k + "th largest Element = " + kthLarglest(a, k));

        int[] marks = {876, 546, 234, 985, 456, 781, 980, 456, 787, 679, 871, 345, 989, 598, 451, 234, 190, 567, 897, 919, 945, 885, 345, 909, 803, 899};
        int x = 5;
        System.out.println("Marks = " + Arrays.toString(marks));
        System.out.println("Top " + x + " marks = " + Arrays.toString(topXMarks(marks, x)));
        System.out.println("Bottom " + x + " marks = " + Arrays.toString(bottomXMarks(marks, x)));
    }
}
