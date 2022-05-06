package com.sks.leetcode.medium;

import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    /**
     * Time : O(nlogn), for sorting
     * Space: O(n)
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println("Sorted Ivl= " + Arrays.deepToString(intervals));
        LinkedList<int[]> out = new LinkedList<>(); /** Think, LinkedList removal/Insertion is O(1) **/
        out.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= out.getLast()[1])
                out.getLast()[1] = Math.max(out.getLast()[1], intervals[i][1]);
            else out.add(intervals[i]);
        }
        return out.toArray(new int[out.size()][]);
    }

    public static int[][] merge_bruteForce(int[][] intervals) {
        List<int[]> out = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return new int[][]{};
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (isOverlapping(intervals[i], intervals[j]))
                    out.add(merge_bruteForce(intervals[i], intervals[j]));
                else
                    out.add(intervals[i]);
            }
        }
        int[][] merged = new int[out.size()][];
        for (int i = 0; i < out.size(); i++)
            merged[i] = out.get(i);
        return merged;
    }

    private static int[] merge_bruteForce(int[] interval1, int[] interval2) {
        int s = Math.min(interval1[0], interval2[0]);
        int e = Math.max(interval1[1], interval2[1]);
        return new int[]{s, e};
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] >= interval2[0] && interval1[0] < interval2[1])
                || (interval2[0] >= interval1[0] && interval2[0] < interval1[1]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{15, 18}, {1, 3}, {2, 6}, {8, 10}};
        demo(intervals);
        intervals = new int[][]{{1, 4}, {2, 3}};
        demo(intervals);
    }

    private static void demo(int[][] intervals) {
        System.out.println("\nIntervals = " + Arrays.deepToString(intervals));
        int[][] mergedIntervals = merge(intervals);
        System.out.println("Merged Ivl= " + Arrays.deepToString(mergedIntervals));
    }
}
