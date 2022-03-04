package com.sks.leatcode.medium;

import javafx.util.Pair;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

/**
 * Time complexity : O(1) both for put and get.
 * Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Pair<Integer, Integer>> cache;
    private Deque<Pair<Integer, Integer>> dq;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        dq = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Pair<Integer, Integer> p = cache.get(key);
            dq.remove(p);
            dq.addFirst(p);
            return p.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() == capacity) {
            if (cache.containsKey(key)) {
                Pair<Integer, Integer> rem = cache.get(key);
                dq.remove(rem);
            } else {
                Pair<Integer, Integer> rem = dq.removeLast();
                cache.remove(rem.getKey());
            }
        }
        Pair<Integer, Integer> p = new Pair(key, value);
        cache.put(key, p);
        dq.addFirst(p);
    }

    public static void main(String[] args) {
        //demo_1();
        demo_2();
    }

    private static void demo_2() {
        LRUCache lru = new LRUCache(2);
        lru.put(2, 1);
        lru.put(1, 1);
        lru.put(2, 3);
        lru.put(4, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    private static void demo_1() {
        LRUCache lru = new LRUCache(5);
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
