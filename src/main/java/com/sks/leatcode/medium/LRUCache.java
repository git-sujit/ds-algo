package com.sks.leatcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

/**
 * Time complexity : O(1) both for put and get.
 * Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.
 */
public class LRUCache {
    private int capacity;
    private final Map<Integer, Integer> cache = new HashMap<>();
    private final LinkedList<Integer> usabilityList = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (usabilityList.getLast() == key) {
            usabilityList.removeLast();
            usabilityList.addFirst(key);
        }
        return cache.get(key) != null ? cache.get(key) : -1;
    }

    public void put(int key, int value) {
        if (cache.size() == this.capacity)
            evictLeastRecentUsed();
        usabilityList.addFirst(key);
        cache.put(key, value);
        System.out.println("Cache = " + cache);
        System.out.println("usabilityList = " + usabilityList);
    }

    private void evictLeastRecentUsed() {
        int lastKey = usabilityList.removeLast();
        cache.remove(lastKey);
        System.out.println("Evicting least used: " + lastKey);
    }

    public static void main(String[] args) {
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
