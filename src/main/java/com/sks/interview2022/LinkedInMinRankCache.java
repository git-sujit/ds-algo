package com.sks.interview2022;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Standard cache problem :
 * should be able to store the values in cache as per capacity.
 * If the value is present in cache, then get(key) method should return the value from cache. else use the standard cache to get the key and also store that in cache.
 * if the cache is full, then discard the value with lesser rank. getRank method will help to get the rank.
 * build the system in a thread safe way
 * <p>
 * Kind of similar to Leetcode's LRU cache problem
 */
public class LinkedInMinRankCache {
    private int capacity;
    private Map<Pair<Integer, Integer>, Integer> cache;
    private PriorityQueue<Pair<Integer, Integer>> minHeap;

    public LinkedInMinRankCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        minHeap = new PriorityQueue<>(Comparator.comparing((Pair<Integer, Integer> p) -> p.getValue()));
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }
}
