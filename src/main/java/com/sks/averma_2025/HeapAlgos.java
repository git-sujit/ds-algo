package com.sks.averma_2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapAlgos {
    private static final HeapAlgos heapAlgos = new HeapAlgos();

    public static void main(String[] args) {
        //heapAlgos.test_kthSmallestLargest();
        //int[] arr1 = new int[]{10, 14, 20, 30, 48, 67, 200};
        //int[] arr2 = new int[]{4, 7, 15, 19, 27, 32, 40, 53, 59, 78, 85, 90, 200};
        int[] arr1 = new int[]{3, 6, 10};
        int[] arr2 = new int[]{1, 8, 15, 20};
        System.out.println("Merged Sorted: " + Arrays.toString(heapAlgos.mergeSorted(arr1, arr2)));
    }

    private int[] kthSmallestLargest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : arr) {
            minHeap.add(a);
            maxHeap.add(a);
            if (minHeap.size() > k) {
                minHeap.remove();
                maxHeap.remove();
            }
        }
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }


    private void test_kthSmallestLargest() {
        int[] a = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Array = " + Arrays.toString(a) + ", k = " + k);
        int[] out = heapAlgos.kthSmallestLargest(a, k);
        System.out.println(k + "th smallest Element = " + out[0]);
        System.out.println(k + "th largest Element = " + out[1]);

        int[] marks = {876, 546, 234, 985, 456, 781, 980, 456, 787, 679, 871, 345, 989, 598, 451, 234, 190, 567, 897, 919, 945, 885, 345, 909, 803, 899};
        int x = 5;
        out = heapAlgos.kthSmallestLargest(marks, x);
        System.out.println("\n" + k + "th smallest Element = " + out[0]);
        System.out.println(k + "th largest Element = " + out[1]);

        //System.out.println("Marks = " + Arrays.toString(marks));
        //System.out.println("Top " + x + " marks = " + Arrays.toString(topXMarks(marks, x)));
        //System.out.println("Bottom " + x + " marks = " + Arrays.toString(bottomXMarks(marks, x)));
    }

    //int[] arr1 = new int[]{10, 14, 20, 30, 48, 67, 200};
    //int[] arr2 = new int[]{4, 7, 15, 19, 27, 32, 40, 53, 59, 78, 85, 90, 200};
    //int[] arr1 = new int[]{3, 6, 10};
    //int[] arr2 = new int[]{1, 8, 15, 20};
    private int[] mergeSorted(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length) {
            while (j < arr2.length) {
                if (arr1[i] > arr2[j]) arr[k++] = arr2[j++];
                else {
                    arr[k++] = arr1[i++];
                    break;
                }
            }
        }
        while (i < arr1.length)
            arr[k++] = arr1[i++];
        while (j < arr2.length)
            arr[k++] = arr2[j++];
        return arr;
    }
}
