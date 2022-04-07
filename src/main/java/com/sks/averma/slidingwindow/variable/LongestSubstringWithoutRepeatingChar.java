package com.sks.averma.slidingwindow.variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChar {
    /**
     * Time complexity : O(n)
     * Space complexity : O(n) for map
     */
    public static int longestSubString_map(String str) {
        if (str == null || str.length() == 0) return -1;
        int max = 0;
        int ws = 0;
        int we = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (we < str.length()) {
            char c = str.charAt(we);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == we - ws + 1) {
                max = Math.max(max, we - ws + 1);
            } else if (map.size() < we - ws + 1) {
                while (map.size() < we - ws + 1) {
                    char wsc = str.charAt(ws);
                    int count = map.get(wsc);
                    if (count == 1) map.remove(wsc);
                    else map.put(wsc, count - 1);
                    ws++;
                }
                /*- Alternate Approach
                for (int k = ws; k < we; k++) {
                    if (str.charAt(k) == c) ws = k + 1;
                    break;
                }*/
            }
            we++;
        }
        return max;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n) for set
     */
    public static int longestSubString_set(String str) {
        if (str == null || str.length() == 0) return -1;
        int max = 0;
        int ws = 0;
        int we = 0;
        Set<Character> set = new HashSet<>();
        while (we < str.length()) {
            char c = str.charAt(we);
            if (set.contains(c)) {
                for (int k = ws; k < we; k++) {
                    if (str.charAt(k) == c) ws = k + 1;
                    //set.remove(str.charAt(k));
                }
            } else {
                set.add(c);
                max = Math.max(max, we - ws + 1);
                //System.out.println("Unique chars Substring(" + ws + ", " + we + ") length = " + (we - ws + 1));
            }
            we++;
        }

        return max;
    }

    /**
     * Time complexity : O(n^3) two nested loops & one uniqueness check
     * Space complexity : O(n) for HashSet
     * Brute Force- Check for all possible substrings
     */
    public static int longestSubString_bruteForce(String str) {
        if (str == null || str.length() == 0) return -1;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (hasUniqueChars(str, i, j)) {
                    max = Math.max(max, j - i + 1);
                    //System.out.println("Unique chars Substring(" + i + ", " + j + ") length = " + (j - i + 1));
                }
            }
        }
        return max;
    }

    private static boolean hasUniqueChars(String str, int i, int j) {
        Set<Character> s = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (s.contains(str.charAt(k))) return false;
            s.add(str.charAt(k));
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabacbebebo";
        test(str);

        str = "aabacebebebo";
        test(str);

        str = "pwwkew";
        test(str);
    }

    private static void test(String str) {
        System.out.println("\nString = " + str);
        System.out.println("[Map] Longest Substring size = " + longestSubString_map(str));
        System.out.println("[Set] Longest Substring size = " + longestSubString_set(str));
        System.out.println("[Brute Force] Longest Substring size = " + longestSubString_bruteForce(str));
    }
}
