package com.sks.averma.heap;

import java.util.*;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class KClosestElements {

    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k) for PriorityQueue
     * REMEMBER:: For MaxHeap: PriorityQueue<DiffEle> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
     */
    public static List<Integer> findClosestElements(int[] a, int k, int x) {
        List<Integer> out = new ArrayList<>();
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return out;
        PriorityQueue<DiffEle> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : a) {
            maxHeap.add(new DiffEle(Math.abs(e - x), e));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        while (!maxHeap.isEmpty())
            out.add(maxHeap.remove().ele);
        Collections.sort(out);
        return out;
    }

    public static int[] kClosest(int[] a, int k, int x) {
        int[] out = null;
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return out;
        out = new int[k];
        PriorityQueue<DiffEle> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : a) {
            maxHeap.add(new DiffEle(Math.abs(e - x), e));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        int i = 0;
        while (!maxHeap.isEmpty())
            out[i++] = maxHeap.remove().ele;

        Arrays.sort(out);
        return out;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        test(a, k, x);

        a = new int[]{1, 2, 3, 4, 5};
        k = 4;
        x = -1;
        test(a, k, x);
    }

    static void test(int[] a, int k, int x) {
        System.out.println("\nArray = " + Arrays.toString(a) + ", k = " + k + ", x = " + x);
        System.out.println(k + " closest elements of " + x + " = " + Arrays.toString(kClosest(a, k, x)));
        System.out.println(k + " closest elements of " + x + " = " + findClosestElements(a, k, x));

    }

    static class DiffEle implements Comparable<DiffEle> {
        public int diff;
        public int ele;


        public DiffEle(int diff, int ele) {
            this.diff = diff;
            this.ele = ele;
        }

        @Override
        public int compareTo(DiffEle obj) {
            return this.diff == obj.diff ? Integer.compare(this.ele, obj.ele) : Integer.compare(this.diff, obj.diff);
        }

        @Override
        public String toString() {
            return "EleDiff{" +
                    "ele=" + ele +
                    ", diff=" + diff +
                    '}';
        }
    }
}
