package com.sks.averma.heap;

import com.sks.leetcode.common.CustomPair;
import javafx.util.Pair;

import java.util.*;

public class KTopFrequentNumbers {
    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static int[] topFrequentNumbers_better(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((Pair<Integer, Integer> p) -> p.getValue()));
        for (int num : freqMap.keySet()) {
            //CustomPair(key=number, value=Frequency)
            minHeap.add(new Pair(num, freqMap.get(num)));
            if (minHeap.size() > k)
                minHeap.remove();
        }
        int i = 0;
        while (!minHeap.isEmpty())
            out[i++] = minHeap.remove().getKey();
        return out;
    }

    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static int[] topFrequentNumbers(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        //System.out.println("Frequency Map = " + freqMap);
        PriorityQueue<CustomPair<Integer, Integer>> minHeap = new PriorityQueue<>();
        for (int num : freqMap.keySet()) {
            //CustomPair(key=number, value=Frequency)
            minHeap.add(new CustomPair(num, freqMap.get(num)));
            if (minHeap.size() > k)
                minHeap.remove();
        }
        int i = 0;
        while (!minHeap.isEmpty())
            out[i++] = minHeap.remove().key;
        return out;
    }

    public static void frequencySort(int[] numbers) {
        if (numbers == null || numbers.length == 0) return;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            if (freqMap.containsKey(num)) freqMap.put(num, freqMap.get(num) + 1);
            else freqMap.put(num, 1);
        }
        PriorityQueue<CustomPair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : freqMap.keySet()) {
            //CustomPair(Key=number, value=Frequency)
            maxHeap.add(new CustomPair(num, freqMap.get(num)));
        }
        int i = 0;
        while (!maxHeap.isEmpty()) {
            CustomPair<Integer, Integer> p = maxHeap.remove();
            int num = p.key;
            int freq = p.value;
            while (freq > 0) {
                numbers[i++] = num;
                freq--;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 1, 2, 1, 4};
        int k = 2;
        test(numbers, k);

        numbers = new int[]{1, 3, 3, 2, 1, 2, 1, 4};
        k = 3;
        test(numbers, k);

        numbers = new int[]{8, 9, 10, 9, 8, 5, 4, 8, 10, 9, 5, 6, 8, 9, 8, 10, 7, 6, 5, 9, 8, 4, 3, 8, 9, 10};
        k = 3;
        test(numbers, k);
    }

    private static void test(int[] numbers, int k) {
        System.out.println("\nArray = " + Arrays.toString(numbers));
        System.out.println("[Better] " + k + " most frequent numbers = " + Arrays.toString(topFrequentNumbers_better(numbers, k)));
        System.out.println(k + " most frequent numbers = " + Arrays.toString(topFrequentNumbers(numbers, k)));
        frequencySort(numbers);
        System.out.println("Frequency Sort, Array = " + Arrays.toString(numbers));
    }
}
