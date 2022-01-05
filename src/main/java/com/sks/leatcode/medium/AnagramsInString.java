package com.sks.leatcode.medium;

import java.util.*;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class AnagramsInString {
    /**
     * Hashmap is quite complex structure, with known performance issues in Java. Let's implement approach 1 using 26-elements array instead of hashmap:
     * -Element number 0 contains count of letter a.
     * Element number 1 contains count of letter b.
     * ... and so on
     */
    public static List<Integer> findAnagrams_array(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) return anagrams;
        int[] masterCharCountArray = new int[26];
        for (char pc : p.toCharArray())
            masterCharCountArray[pc - 'a'] += 1;
        System.out.println("Char Count Array = " + Arrays.toString(masterCharCountArray));
        int windowStart = 0;
        int[] charCountArray = new int[26];
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char sc = s.charAt(windowEnd);
            if (masterCharCountArray[sc - 'a'] > 0) charCountArray[sc - 'a'] += 1;
            if (windowEnd - windowStart + 1 == p.length()) {
                if (sameArray(charCountArray, masterCharCountArray)) anagrams.add(windowStart);
                char wsc = s.charAt(windowStart);
                if (charCountArray[wsc - 'a'] > 0) charCountArray[wsc - 'a'] -= 1;
                windowStart++;
            }
        }
        return anagrams;
    }

    private static boolean sameArray(int[] a1, int[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++)
            if (a1[i] != a2[i]) return false;
        return true;
    }

    /**
     * Time Complexity: O(n+m), n is length of text/string & m is length of pattern
     * Space Complexity: O(1), because pCount and sCount contain not more than 26 elements(26 chars)
     */
    public static List<Integer> findAnagrams_hashMap(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) return anagrams;
        Map<Character, Integer> masterCharMap = new HashMap<>();
        for (char pc : p.toCharArray()) {
            if (masterCharMap.containsKey(pc)) masterCharMap.put(pc, masterCharMap.get(pc) + 1);
            else masterCharMap.put(pc, 1);
        }
        System.out.println("masterCharMap = " + masterCharMap);
        Map<Character, Integer> charMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char sc = s.charAt(windowEnd);
            if (masterCharMap.containsKey(sc)) {
                if (charMap.containsKey(sc)) charMap.put(sc, charMap.get(sc) + 1);
                else charMap.put(sc, 1);
            }
            if (windowEnd - windowStart + 1 == p.length()) {
                if (charMap.size() == masterCharMap.size() && charMap.equals(masterCharMap)) anagrams.add(windowStart);
                char wsc = s.charAt(windowStart);
                if (charMap.containsKey(wsc)) {
                    int count = charMap.get(wsc);
                    if (count == 1) charMap.remove(wsc);
                    else charMap.put(wsc, charMap.get(wsc) - 1);
                }
                windowStart++;
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        test(s, p);

        s = "abab";
        p = "ab";
        test(s, p);
    }

    private static void test(String s, String p) {
        System.out.println("\nString = " + s + ", Pattern = " + p);
        System.out.println("Anagrams Index List(Using List) = " + findAnagrams_array(s, p));
        System.out.println("Anagrams Index List(Using Hash) = " + findAnagrams_hashMap(s, p));
    }
}
