package com.sks.leatcode.medium;

import java.util.*;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 */
public class UniqueCharFrequency {
    public int minDeletions_better(String s) {
        int remCounter = 0;
        if (s == null || s.length() == 0) return remCounter;
        int[] freqList = new int[26];
        for (char c : s.toCharArray())
            freqList[c - 'a']++;
        // Max/Min Heap: Both works
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        //PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int freq : freqList)
            if (freq > 0) heap.add(freq);
        System.out.println("Heap = " + heap);
        while (!heap.isEmpty() && heap.size() > 1) {
            int fq1 = heap.remove();
            if(fq1 == heap.peek()){
                fq1--;
                remCounter++;
                if (fq1 > 0) heap.add(fq1);
            }
        }
        return remCounter;
    }

    public int minDeletions(String s) {
        int remCounter = 0;
        if (s == null || s.length() == 0) return remCounter;
        Map<Integer, List<Character>> freqCharMap = prepareFreqMap(s); // 5->[a,b,c]
        Map<Integer, List<Character>> newFreqCharMap = new HashMap<>();
        Set<Integer> freqSet = freqCharMap.keySet();
        for (Map.Entry<Integer, List<Character>> entry : freqCharMap.entrySet()) {
            List<Character> chars = entry.getValue();
            if (entry.getValue().size() > 1) {
                for (int i = 1; i < chars.size(); i++) {
                    char c = chars.get(i);
                    int freq = entry.getKey(); //5
                    int redFreq = 0;
                    while (freq > 0) {
                        freq--;
                        remCounter++;
                        if (!freqSet.contains(freq) && !newFreqCharMap.keySet().contains(freq)) {
                            redFreq = freq;
                            newFreqCharMap.put(redFreq, Arrays.asList(c));
                            break;
                        }
                    }
                }
            }
        }
        return remCounter;
    }

    Map<Integer, List<Character>> prepareFreqMap(String s) {
        Map<Integer, List<Character>> freqMap = new HashMap<>();
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        for (char key : charFreq.keySet()) {
            int freq = charFreq.get(key);
            freqMap.computeIfAbsent(freq, e -> new ArrayList<>()).add(key);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        demo("abb");
        demo("aaabbbcc");
        demo("ceabaacb");
        demo("abcabc");
    }

    private static void demo(String s) {
        System.out.println("\nString = " + s);
        System.out.println("Number of deletion to make it good = " + new UniqueCharFrequency().minDeletions(s));
        System.out.println("[Better] Number of deletion to make it good = " + new UniqueCharFrequency().minDeletions_better(s));
    }
}
