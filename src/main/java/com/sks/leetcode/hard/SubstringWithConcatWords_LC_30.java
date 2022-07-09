package com.sks.leetcode.hard;

import java.util.*;

/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 * You can return the answer in any order.
 */
public class SubstringWithConcatWords_LC_30 {
    /**
     * Time Complexity : O(n^2)
     * Space Complexity: O(n)
     */
    public List<Integer> findSubstring_TLE(String s, String[] words) {
        List<Integer> out = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return out;
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words)
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        //System.out.println("wordCountMap = " + wordCountMap);
        int wordLen = words[0].length();
        int totalWordLen = words[0].length() * words.length;
        int idx = 0;
        while (idx + totalWordLen <= s.length()) {
            String word = s.substring(idx, idx + wordLen);
            if (wordCountMap.containsKey(word)) {
                Map<String, Integer> seenWordCountMap = new HashMap<>();
                int idx1 = idx;
                while (wordCountMap.containsKey(word)) {
                    seenWordCountMap.put(word, seenWordCountMap.getOrDefault(word, 0) + 1);
                    //System.out.println("seenWordCountMap = " + seenWordCountMap);
                    if (wordCountMap.equals(seenWordCountMap)) {
                        //System.out.println("Found at : " + potential);
                        out.add(idx);
                    }
                    idx1 += wordLen;
                    if (idx1 + wordLen > s.length()) break;
                    word = s.substring(idx1, idx1 + wordLen);
                }
            }
            // Look for all combination, e.g: String=aaaaa, pattern=aaa
            idx++;
        }
        return out;
    }

    public List<Integer> findSubstring_no_Repeat_TLE(String s, String[] words) {
        List<Integer> out = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return out;
        Set<String> wordSet = new HashSet<>();
        for (String word : words) wordSet.add(word);

        int wordLen = words[0].length();
        int numWords = words.length;
        int idx = 0;
        while (idx + wordLen < s.length()) {
            String word = s.substring(idx, idx + wordLen);
            if (wordSet.contains(word)) {
                Set<String> seenWords = new HashSet<>();
                int potential = idx;
                while (wordSet.contains(word) && !seenWords.contains(word)) {
                    seenWords.add(word);
                    if (seenWords.size() == numWords) out.add(potential);
                    idx += wordLen;
                    if (idx >= s.length()) break;
                    word = s.substring(idx, idx + wordLen);
                }
                idx = potential + wordLen;
            } else idx++;
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        demo(s, words);

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word", "good", "best", "good"};
        demo(s, words);

        s = "a";
        words = new String[]{"a"};
        demo(s, words);

        s = "aaaaaaaaaaaaaa";
        words = new String[]{"aa", "aa"};
        demo(s, words);
    }

    private static void demo(String s, String[] words) {
        System.out.println("\nString = " + s + ", words = " + Arrays.toString(words));
        System.out.println("[No-Repeat]Output = " + new SubstringWithConcatWords_LC_30().findSubstring_no_Repeat_TLE(s, words));
        System.out.println("[Repeat]Output = " + new SubstringWithConcatWords_LC_30().findSubstring_TLE(s, words));
    }
}
