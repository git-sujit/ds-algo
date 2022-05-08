package com.sks.averma.heap;

import com.sks.leetcode.common.CustomPair;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    /**
     * Time complexity: O(N⋅logk)
     * Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size of the heap is capped at k elements.
     * Space complexity: O(k)
     * The heap (or priority queue) will contain at most k elements.
     */
    public static int[][] kClosetPoints_better(int[][] points, int[] targetPoint, int k) {
        if (points == null || points.length == 0 || targetPoint == null || targetPoint.length == 0 || k <= 0 || k > points.length)
            return null;
        int[][] out = new int[k][2];
        PriorityQueue<Pair<int[], Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((Pair<int[], Integer> p) -> p.getValue()).reversed());
        for (int[] pt : points) {
            minHeap.add(new Pair(pt, calculateDistance(pt, targetPoint)));
            if (minHeap.size() > k)
                minHeap.remove();
        }
        int i = 0;
        while (!minHeap.isEmpty())
            out[i++] = minHeap.remove().getKey();
        return out;
    }

    /**
     * Time complexity: O(N⋅logk)
     * Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size of the heap is capped at k elements.
     * Space complexity: O(k)
     * The heap (or priority queue) will contain at most k elements.
     */
    public static int[][] kClosetPoints(int[][] points, int[] targetPoint, int k) {
        if (points == null || points.length == 0 || targetPoint == null || targetPoint.length == 0 || k <= 0 || k > points.length)
            return null;
        int[][] out = new int[k][2];
        PriorityQueue<CustomPair<Point, Integer>> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] point : points) {
            maxHeap.add(new CustomPair(new Point(point[0], point[1]), calculateDistance(point, targetPoint)));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        System.out.println("maxHeap = " + maxHeap);
        int p = 0;
        while (!maxHeap.isEmpty()) {
            CustomPair pair = maxHeap.remove();
            out[p][0] = ((Point) pair.key).x;
            out[p][1] = ((Point) pair.key).y;
            p++;
        }
        return out;
    }

    private static int calculateDistance(int[] p1, int[] p2) {
        int xDiff = p1[0] - p2[0];
        int yDiff = p1[1] - p2[1];
        return xDiff * xDiff + yDiff * yDiff;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int[] targetPoint = {0, 0};
        int k = 2;
        test(points, targetPoint, k);

        points = new int[][]{{1, 3}, {-2, 2}};
        k = 1;
        test(points, targetPoint, k);
    }

    static void test(int[][] points, int[] targetPoint, int k) {
        System.out.println("\nPoints = " + Arrays.deepToString(points));
        System.out.println("Target Point = " + Arrays.toString(targetPoint));
        System.out.println("[Better] " + k + " closest points = " + Arrays.deepToString(kClosetPoints_better(points, targetPoint, k)));
        System.out.println(k + " closest points = " + Arrays.deepToString(kClosetPoints(points, targetPoint, k)));
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
