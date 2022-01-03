package com.sks.averma.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElementsBetweenK1AndK2SmallestLargest {
    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public static int sumBetweenK1K2Smallest(int[] numbers, int k1, int k2) {
        if (numbers == null || numbers.length == 0 || k1 <= 0 || k2 <= 0 || k1 == k2 || k1 > numbers.length || k2 > numbers.length)
            return -1;
        int k = k1 > k2 ? k1 : k2;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : numbers) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        int counter = Math.abs(k1 - k2);
        maxHeap.remove();
        int sum = 0;
        while (counter > 1) {
            sum += maxHeap.remove();
            counter--;
        }
        return sum;
    }

    public static int sumBetweenK1K2Smallest_alternate(int[] numbers, int k1, int k2) {
        int s1 = k1 < k2 ? kthSmallest(numbers, k1) : kthSmallest(numbers, k2);
        int s2 = k1 > k2 ? kthSmallest(numbers, k1) : kthSmallest(numbers, k2);
        int sum = 0;
        for (int num : numbers) {
            if (num > s1 && num < s2)
                sum += num;
        }
        return sum;
    }

    public static int kthSmallest(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : numbers) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        return maxHeap.peek();
    }

    public static int kthLargest(int[] numbers, int k) {
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;
        System.out.println("Numbers = " + Arrays.toString(numbers));
        System.out.println("1. Sum between (" + k1 + ", " + k2 + ") smallest elements = " + sumBetweenK1K2Smallest(numbers, k1, k2));
        System.out.println("2. Sum between (" + k1 + ", " + k2 + ") smallest elements = " + sumBetweenK1K2Smallest_alternate(numbers, k1, k2));
    }
}
