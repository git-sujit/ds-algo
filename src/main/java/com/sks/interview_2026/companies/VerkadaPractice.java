package com.sks.interview_2026.companies;

import javafx.util.Pair;

import java.util.*;

public class VerkadaPractice {
    public static void main(String[] args) {
        System.out.println("----- Time-Series Patterns -----");
        test_timeSeriesPatterns();
        System.out.println("----- Non-Overlapping Intervals -----");
        test_nonOverlappingIntervals();
        System.out.println("----- Time-Based Key-Value Store -----");
        test_timeBasedKeyValueStore();
        System.out.println("----- Interval List Intersection -----");
        test_intervalListInterSection();
        System.out.println("----- Maximum Profit in Job Scheduling -----");
        test_maximumProfitInJobScheduling();
        System.out.println("----- LRU Cache -----");
        test_LRUCacheVerkada();

    }


    /**
     * Given sorted timestamps, count events between start and end.
     */
    private static int countEventsInTimeRange(int[] timestamps, int start, int end) {
        return -1;
    }

    /**
     * Time Complexity: O(nlogn), Space Complexity: O(1)
     * Sort intervals by their end time and iterate greedily, removing an interval
     * whenever its start is less than the previous interval’s end; otherwise, update the end.
     */
    private static int removeOverlapIntervals_leetCode(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // Sort by End time
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));
        System.out.println("Sorted by End time = " + Arrays.deepToString(intervals));
        int count = 0;
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last) count++;
            else last = intervals[i][1];
        }
        return count;
    }

    /**
     * Time Complexity: O(nlogn), Space Complexity: O(1)
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
     */
    private static int removeOverlapIntervals_fails(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // Sort by (endi - starti)
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1] - e[0]));
        System.out.println("Sorted by (End-Start) = " + Arrays.deepToString(intervals));
        int left = 0, right = intervals.length - 1, removalCounter = 0;
        while (left < right) {
            int[] leftInterval = intervals[left];
            int[] rightInterval = intervals[right];
            //System.out.println("leftInterval = " + Arrays.toString(leftInterval) + ", rightInterval = " + Arrays.toString(rightInterval));
            if ((leftInterval[0] == rightInterval[0] && leftInterval[1] == rightInterval[1])
                    || (leftInterval[0] > rightInterval[0] && leftInterval[0] < rightInterval[1])
                    || (leftInterval[1] > rightInterval[0] && leftInterval[1] < rightInterval[1])) {
                //System.out.println("Removing...");
                removalCounter++;
                right--;
            } else {
                left++;
            }
        }
        return removalCounter;
    }

    /**
     * Interval List Intersection
     */
    private static int[][] intervalListIntersection_leetcode(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    private static int[][] intervalListIntersection_fails(int[][] firstList, int[][] secondList) {
        List<int[]> ivlList = new ArrayList<>();
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
            return ivlList.toArray(new int[0][]);
        int fi = 0, si = 0;
        while (fi < firstList.length && si < secondList.length) {
            int fs = firstList[fi][0];
            int fe = firstList[fi][1];
            int ss = secondList[si][0];
            int se = secondList[si][1];
            System.out.println("First = [" + fs + ", " + fe + "], Second = [" + ss + ", " + se + "]");
            if ((fs >= ss && fs <= se) || (fe >= ss && fe <= se) || (fs <= ss && fe >= ss) || (fs >= ss && fe >= se)) {
                int is = Math.max(fs, ss);
                int ie = Math.min(fe, se);
                ivlList.add(new int[]{is, ie});
            }
            System.out.println("fe = " + fe + ", se = " + se);
            if (fe == se) {
                fi++;
                si++;
            } else if (fe < se) fi++;
            else si++;
        }
        return ivlList.toArray(new int[0][]);
    }

    /**
     * Maximum Profit in Job Scheduling
     */
    private static int maximumProfitInJobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || startTime.length == 0
                || endTime == null || endTime.length == 0
                || profit == null || profit.length == 0 ||
                startTime.length != endTime.length || startTime.length != profit.length)
            return -1;
        int maxProfit = 0;
        int i = 0;
        do {
            maxProfit += profit[i];
            i = ceilStartTime(startTime, endTime[i]);
            System.out.println("maxProfit = " + maxProfit + ", next index in start = " + i);
        } while (i >= 0 && i < startTime.length);
        return maxProfit;
    }

    private static int ceilStartTime(int[] startTime, int time) {
        if (startTime == null || startTime.length == 0) return -1;
        int s = 0, e = startTime.length - 1, ceil = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (time == startTime[m]) ceil = m;
            if (time < startTime[m]) {
                ceil = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ceil;
    }

    private static void LRUCacheVerkada() {

    }

    /**
     * TEST
     */
    private static void test_timeSeriesPatterns() {
        System.out.println("Sliding Window Problem: Fixed & Variable: Done");
        System.out.println("Count Events in Time Range");
    }

    private static void test_nonOverlappingIntervals() {
        int[][] intervals = {{1, 2}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println("Intervals = " + Arrays.deepToString(intervals));
        System.out.println("Minimum no. of removals = " + removeOverlapIntervals_fails(intervals));
        System.out.println("[LeetCode]Minimum no. of removals = " + removeOverlapIntervals_leetCode(intervals));

        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println("\nIntervals = " + Arrays.deepToString(intervals));
        System.out.println("Minimum no. of removals = " + removeOverlapIntervals_fails(intervals));
        System.out.println("[LeetCode]Minimum no. of removals = " + removeOverlapIntervals_leetCode(intervals));

        intervals = new int[][]{{1, 2}, {1, 3}};
        System.out.println("\nIntervals = " + Arrays.deepToString(intervals));
        System.out.println("Minimum no. of removals = " + removeOverlapIntervals_fails(intervals));
        System.out.println("[LeetCode]Minimum no. of removals = " + removeOverlapIntervals_leetCode(intervals));

        intervals = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println("\nIntervals = " + Arrays.deepToString(intervals));
        System.out.println("Minimum no. of removals = " + removeOverlapIntervals_fails(intervals));
        System.out.println("[LeetCode]Minimum no. of removals = " + removeOverlapIntervals_leetCode(intervals));
    }

    private static void test_timeBasedKeyValueStore() {
        TimeMap kvStore = new TimeMap();
        kvStore.set("foo", "bar", 1);
        System.out.println(kvStore.get("foo", 1));
        System.out.println(kvStore.get("foo", 3));
        kvStore.set("foo", "bar2", 4);
        System.out.println(kvStore.get("foo", 4));
        System.out.println(kvStore.get("foo", 5));
        System.out.println("KV Store = " + kvStore);


        kvStore.set("love", "high", 10);
        kvStore.set("love", "low", 20);
        System.out.println("KV Store = " + kvStore);
        System.out.println("GET: love-5 = " + kvStore.get("love", 5));
        System.out.println("GET: love-10 = " + kvStore.get("love", 10));
        System.out.println("GET: love-15 = " + kvStore.get("love", 15));
        System.out.println("GET: love-20 = " + kvStore.get("love", 20));
        System.out.println("GET: love-25 = " + kvStore.get("love", 25));
    }

    private static void test_intervalListInterSection() {
        int[][] firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println("First List  = " + Arrays.deepToString(firstList));
        System.out.println("Second List = " + Arrays.deepToString(secondList));
        System.out.println("Intersection-Fails = " + Arrays.deepToString(intervalListIntersection_fails(firstList, secondList)));
        System.out.println("Intersection-LeetCode = " + Arrays.deepToString(intervalListIntersection_leetcode(firstList, secondList)));

        firstList = new int[][]{{3, 5}, {9, 20}};
        secondList = new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};
        System.out.println("First List  = " + Arrays.deepToString(firstList));
        System.out.println("Second List = " + Arrays.deepToString(secondList));
        System.out.println("Intersection= " + Arrays.deepToString(intervalListIntersection_fails(firstList, secondList)));
        System.out.println("Intersection-LeetCode = " + Arrays.deepToString(intervalListIntersection_leetcode(firstList, secondList)));
    }

    private static void test_maximumProfitInJobScheduling() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println("startTime= " + Arrays.toString(startTime));
        System.out.println("endTime  = " + Arrays.toString(endTime));
        System.out.println("profit   = " + Arrays.toString(profit));
        System.out.println("Maximum Profit in scheduling the Job = " + maximumProfitInJobScheduling(startTime, endTime, profit));
    }

    private static void test_LRUCacheVerkada() {
    }
}

class TimeMap {
    private final Map<String, SortedMap<Integer, String>> kvStore = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        SortedMap<Integer, String> sortedValue = kvStore.get(key) == null ? new TreeMap<>() : kvStore.get(key);
        sortedValue.put(timestamp, value);
        kvStore.put(key, sortedValue);
    }

    public String get(String key, int timestamp) {
        if (kvStore.get(key).isEmpty()) return "";
        SortedMap<Integer, String> sortedValue = kvStore.get(key);
        int floorTimestamp = getFloorTimestamp(new ArrayList<>(sortedValue.keySet()), timestamp);
        //System.out.println("floorTimestamp = " + floorTimestamp);
        String out = kvStore.get(key).get(floorTimestamp);
        return out == null ? "" : out;
    }

    private int getFloorTimestamp(List<Integer> sortedKeyList, int timestamp) {
        //System.out.println("Inside floorTimestamp, sortedKeyList = " + sortedKeyList + ", timestamp = " + timestamp);
        if (sortedKeyList.isEmpty()) return Integer.MIN_VALUE;
        int s = 0, e = sortedKeyList.size() - 1;
        int floorTimestamp = Integer.MIN_VALUE;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (timestamp == sortedKeyList.get(m)) {
                return timestamp;
            } else if (timestamp < sortedKeyList.get(m)) {
                e = m - 1;
            } else {
                floorTimestamp = sortedKeyList.get(m);
                s = m + 1;
            }
        }
        return floorTimestamp;
    }

    @Override
    public String toString() {
        return kvStore.toString();
    }
}
class LRUCacheVerkada {
    private int capacity;
    private Map<Integer, Integer> cache;
    //private Map<Integer, Pair<Integer, Integer>> cache;
    //private Deque<Pair<Integer, Integer>> dq;
    private Deque<Integer> dq;

    public LRUCacheVerkada(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        dq = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //Pair<Integer, Integer> p = cache.get(key);
            Integer p = cache.get(key);
            dq.remove(p);
            dq.addFirst(p);
            return p;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() == capacity) {
            if (cache.containsKey(key)) {
                Integer rem = cache.get(key);
                //Pair<Integer, Integer> rem = cache.get(key);
                dq.remove(rem);
            } else {
               Integer rem = dq.removeLast();
                //Pair<Integer, Integer> rem = dq.removeLast();
                cache.remove(rem);
            }
        }
        //Integer p = new Pair(key, value);
        //Pair<Integer, Integer> p = new Pair(key, value);
        cache.put(key, value);
        dq.addFirst(value);
    }

    public static void main(String[] args) {
        //demo_1();
        demo_2();
    }

    private static void demo_2() {
        com.sks.leetcode.medium.LRUCache lru = new com.sks.leetcode.medium.LRUCache(2);
        lru.put(2, 1);
        lru.put(1, 1);
        lru.put(2, 3);
        lru.put(4, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    private static void demo_1() {
        com.sks.leetcode.medium.LRUCache lru = new com.sks.leetcode.medium.LRUCache(5);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        lru.put(4, 40);
        lru.put(5, 50);
        System.out.println("Getting: " + lru.get(1));
        lru.put(12, 100);
        lru.put(14, 100);
        System.out.println("Getting: " + lru.get(3));
        lru.put(15, 100);
        lru.put(15, 150);
    }
}
