package com.sks.interview_2026.companies;

import java.util.*;

public class LRUCacheLinkedIn {
    private int capacity;
    private Map<Integer, Integer> lru;
    private List<Integer> recencyList;
    private Map<Integer, Integer> idxMap;

    public LRUCacheLinkedIn(int capacity) {
        this.capacity = capacity;
        this.lru = new HashMap<>();
        this.recencyList = new LinkedList<>();
        this.idxMap = new HashMap<>();
    }

    public int get(int key) {
        if (lru.containsKey(key)) {
            int idx = idxMap.get(key);

        }
        return -1;
    }

    public void put(int key, int value) {

    }
}
