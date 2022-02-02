package com.sks.averma.slidingwindow.fixed;

import java.util.*;

public class MaxOfAllSubarryas {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for maxHeap
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_array(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int windowStart = 0;
        List<Integer> maxList = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            if (windowEnd == 0) maxList.add(numbers[windowEnd]);
            else if (numbers[windowEnd] > maxList.get(0)) maxList.add(0, numbers[windowEnd]);
            System.out.println("maxList = " + maxList);
            if (windowEnd - windowStart + 1 == k) {
                out[windowStart] = maxList.get(0);
                if (numbers[windowStart] == maxList.get(0)) maxList.remove(0);
                windowStart++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for maxHeap
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_maxHeap(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int windowStart = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            maxHeap.add(numbers[windowEnd]);
            if (windowEnd - windowStart + 1 == k) {
                out[windowStart] = maxHeap.peek();
                if (numbers[windowStart] == maxHeap.peek()) maxHeap.remove();
                windowStart++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(n-k) to store the result
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_bruteForce(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        for (int i = 0; i < numbers.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++)
                max = Math.max(max, numbers[j]);
            out[i] = max;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, -1, -3, 5, 3, 3, 6, 7};
        int k = 3;
        test(numbers, k);
    }

    private static void test(int[] numbers, int k) {
        System.out.println("\nNumbers = " + Arrays.toString(numbers) + ", Window Size K = " + k);
        System.out.println("Max of SubArrays(Using Array) = " + Arrays.toString(maxOfSubArrays_array(numbers, k)));
        System.out.println("Max of SubArrays(Using Heap) = " + Arrays.toString(maxOfSubArrays_maxHeap(numbers, k)));
        System.out.println("[Brute Force] Max of SubArrays = " + Arrays.toString(maxOfSubArrays_bruteForce(numbers, k)));
    }
}
