package com.sks.averma.heap;

import com.sks.leetcode.common.CustomPair;
import javafx.util.Pair;

import java.util.*;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class KClosestElements {
    /**
     * THINK :: Pair => int[2]
     * Time Complexity : O(nlogk)
     * Space Complexity: O(k)
     */
    public static int[] findKClosestElements_array_notPair(int[] a, int k, int x) throws Exception {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) throw new Exception("Invalid Input");
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing((int[] a1) -> a1[1]).reversed());
        for (int ele : a) {
            maxHeap.add(new int[]{ele, Math.abs(ele - x)});
            //if (maxHeap.size() > k) maxHeap.remove();
        }
        while (maxHeap.size() > k)
            maxHeap.remove();
        int[] out = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty()) out[i++] = maxHeap.remove()[0];
        return out;
    }

    /**
     * Time Complexity : O(nlogk)
     * Space Complexity: O(k)
     */
    public static int[] findKClosestElements_better(int[] a, int k, int x) throws Exception {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) throw new Exception("Invalid Input");
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((Pair<Integer, Integer> p) -> p.getValue()).reversed());
        for (int e : a) {
            maxHeap.add(new Pair(e, Math.abs(e - x)));
            //if (maxHeap.size() > k)
            //maxHeap.remove();
        }
        while (maxHeap.size() > k)
            maxHeap.remove();
        List<Integer> out = new ArrayList<>();
        while (!maxHeap.isEmpty())
            out.add(maxHeap.remove().getKey());
        Collections.sort(out);
        return out.stream().mapToInt(i -> i).toArray();
    }

    /**
     * p
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k) for PriorityQueue
     * REMEMBER:: For MaxHeap: PriorityQueue<DiffEle> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
     */
    public static List<Integer> findClosestElements(int[] a, int k, int x) {
        List<Integer> out = new ArrayList<>();
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return out;
        PriorityQueue<CustomPair<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : a) {
            //CustomPair(Key=number, Value=Diffrence)
            maxHeap.add(new CustomPair(e, Math.abs(e - x)));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        while (!maxHeap.isEmpty())
            out.add(maxHeap.remove().key);
        Collections.sort(out);
        return out;
    }

    public static int[] kClosest(int[] a, int k, int x) {
        int[] out = null;
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return out;
        out = new int[k];
        PriorityQueue<CustomPair<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int e : a) {
            maxHeap.add(new CustomPair(e, Math.abs(e - x)));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        int i = 0;
        while (!maxHeap.isEmpty())
            out[i++] = maxHeap.remove().key;

        Arrays.sort(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        int x = 3;
        test(a, k, x);

        a = new int[]{1, 2, 3, 4, 5};
        k = 4;
        x = -1;
        test(a, k, x);
    }

    static void test(int[] a, int k, int x) throws Exception {
        System.out.println("\nArray = " + Arrays.toString(a) + ", k = " + k + ", x = " + x);
        System.out.println("[Pair=int[2]] " + k + " closest elements of " + x + " = " + Arrays.toString(findKClosestElements_array_notPair(a, k, x)));
        System.out.println("[Better] " + k + " closest elements of " + x + " = " + Arrays.toString(findKClosestElements_better(a, k, x)));
        System.out.println(k + " closest elements of " + x + " = " + Arrays.toString(kClosest(a, k, x)));
        System.out.println(k + " closest elements of " + x + " = " + findClosestElements(a, k, x));

    }
}
