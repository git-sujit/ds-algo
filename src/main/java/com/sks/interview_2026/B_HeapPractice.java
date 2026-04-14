package com.sks.interview_2026;

import java.util.*;

import javafx.util.Pair;

public class B_HeapPractice {
    public static void main(String[] args) {
        System.out.println("\n----- HEAP ALGORITHMS -----");
        System.out.println("----- KTH SMALLEST/LARGEST ELEMENT -----");
        test_kthSmallestLargest();

        System.out.println("----- SORT K/NEARLY SORTED ARRAY -----");
        test_kSorted();

        System.out.println("----- TOP K FREQUENT NUMBERS -----");
        test_topKFrequentNumbers();

        System.out.println("----- MINIMUM COST IN CONNECTING ROPES -----");
        test_minCostConnectRopes();
    }

    /**
     * Time Complexity: O(nlogk), Space Complexity: O(k) for heap
     **/
    private static int[] kthSmallestLargest(int[] arr, int k) {
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

    /**
     * Time Complexity: O(nlogk), Space Complexity: O(k) for heap
     **/
    private static void sortNearlySorted_kSorted(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0) return;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;
        for (int num : a) {
            minHeap.add(num);
            if (minHeap.size() > k)
                a[j++] = minHeap.remove();
        }
        while (!minHeap.isEmpty())
            a[j++] = minHeap.remove();
    }

    /**
     * Time Complexity: O(nlogk), Space Complexity: O(k) for heap
     */
    private static List<Pair<Integer, Integer>> topKFrequentNumbers(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        List<Pair<Integer, Integer>> out = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        for (int num : freqMap.keySet()) {
            minHeap.add(new Pair<>(num, freqMap.get(num)));
            if (minHeap.size() > k)
                minHeap.remove();
        }
        while (!minHeap.isEmpty())
            out.add(minHeap.remove());
        return out.reversed();
    }

    /**
     * Time Complexity: O(nlogk), Space Complexity: O(k) for heap
     */
    private static int minCostOfConnectingRopes(int[] ropes) {
        if (ropes == null || ropes.length <= 1) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) minHeap.add(rope);
        int totalCost = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.remove() + minHeap.remove();
            minHeap.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }

    /**
     * Test Heap
     */
    private static void test_kthSmallestLargest() {
        int[] a = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Array = " + Arrays.toString(a) + ", k = " + k);
        int[] out = kthSmallestLargest(a, k);
        System.out.println(k + "th smallest Element = " + out[0]);
        System.out.println(k + "th largest Element = " + out[1]);

        int[] marks = {876, 546, 234, 985, 456, 781, 980, 456, 787, 679, 871, 345, 989, 598, 451, 234, 190, 567, 897, 919, 945, 885, 345, 909, 803, 899};
        int x = 5;
        out = kthSmallestLargest(marks, x);
        System.out.println("Marks = " + Arrays.toString(marks));
        System.out.println("\n" + k + "th smallest Element = " + out[0]);
        System.out.println(k + "th largest Element = " + out[1]);
    }

    private static void test_kSorted() {
        int[] a = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        System.out.println("\nk = " + k + ", Array = " + Arrays.toString(a));
        sortNearlySorted_kSorted(a, k);
        System.out.println("Sorted Array = " + Arrays.toString(a));
    }

    private static void test_topKFrequentNumbers() {
        int[] numbers = new int[]{1, 3, 3, 2, 1, 2, 1, 4, 3, 1};
        int k = 3;
        System.out.println("\nArray = " + Arrays.toString(numbers));
        System.out.println(k + " most frequent numbers = " + topKFrequentNumbers(numbers, k));
    }

    private static void test_minCostConnectRopes() {
        int[] ropes = {1, 2, 3, 4, 5};
        System.out.println("\nRopes = " + Arrays.toString(ropes));
        System.out.println("Minimum Cost to connect = " + minCostOfConnectingRopes(ropes));
    }
}
