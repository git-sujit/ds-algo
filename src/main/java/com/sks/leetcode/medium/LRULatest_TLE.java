package com.sks.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRULatest_TLE {
    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> usageList;


    public LRULatest_TLE(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.usageList = new LinkedList<>();
    }

    public synchronized int get(int key) {
        if (cache.containsKey(key)) {
            usageList.remove((Integer) key); /** remove is O(n) so it takes lots of time & TLE, Implement your own doubly linked list for O(1) **/
            usageList.addFirst(key);
            return cache.get(key);
        } else return -1;
    }

    public synchronized void put(int key, int value) {
        if (cache.containsKey(key)) {
            usageList.remove((Integer) key); /** remove is O(n) so it takes lots of time & TLE, Implement your own doubly linked list for O(1) **/
        } else {
            if (cache.size() == capacity) {
                cache.remove(usageList.getLast());
                usageList.removeLast();
            }
        }
        usageList.addFirst(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        demo_1();
        demo_2();
    }

    private static void demo_2() {
        int capacity = 2;
        LRULatest_TLE lru = new LRULatest_TLE(capacity);
        lru.get(2);
        lru.put(2, 6);
        lru.get(1);
        lru.put(1, 5);
        lru.put(1, 2);
        System.out.println(lru.get(1) + ", " + lru.get(2));
    }

    private static void demo_1() {
        int capacity = 3;
        LRULatest_TLE lru = new LRULatest_TLE(capacity);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println("Cache = " + lru.cache + ", usage-list = " + lru.usageList);
        lru.get(1);
        System.out.println("Cache = " + lru.cache + ", usage-list = " + lru.usageList);
        lru.put(4, 4);
        System.out.println("Cache = " + lru.cache + ", usage-list = " + lru.usageList);
    }
}
