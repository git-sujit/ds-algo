package com.sks.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {
    /**
     *
     */
    public static boolean checkInclusion_bruteForce(String s1, String s2) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s1.toCharArray()) charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        //System.out.println("charCountMap = " + charCountMap);

        for (int i = 0; i < s2.length(); i++) {
            if (charCountMap.containsKey(s2.charAt(i))) {
                Map<Character, Integer> retMap = new HashMap<>();
                retMap.putAll(charCountMap);
                for (int j = i; j < s2.length(); j++) {
                    char c = s2.charAt(j);
                    if (charCountMap.containsKey(c)) {
                        int count = charCountMap.get(c);
                        if (count > 1) charCountMap.put(c, count - 1);
                        else if (count == 1) charCountMap.remove(c);
                        if (charCountMap.isEmpty()) {
                            //System.out.println("Found at " + i + ", charCountMap = " + charCountMap);
                            return true;
                        } else if (j == s2.length() - 1) return false;

                    } else {
                        charCountMap = retMap;
                        //System.out.println("[Not Found] j = " + j + ", charCountMap = " + charCountMap);
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        test(s1, s2);

        s1 = "ab";
        s2 = "eidbaooo";
        test(s1, s2);

        s1 = "ba";
        s2 = "eidboaoo";
        test(s1, s2);
    }

    private static void test(String s1, String s2) {
        System.out.println("\ns1 = " + s1 + ", s2 = " + s2);
        System.out.println("Permutation Found = " + checkInclusion_bruteForce(s1, s2));
    }


}
