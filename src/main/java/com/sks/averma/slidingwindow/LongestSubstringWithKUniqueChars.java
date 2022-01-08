package com.sks.averma.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKUniqueChars {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for map
     */
    public int lengthOfLongestSubstringAtMostKDistinct_leetcode(String str, int k) {
        if (str == null || str.length() == 0 || k <= 0 || k > str.length()) return -1;
        int maxSize = 0;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (windowEnd < str.length()) {
            char c = str.charAt(windowEnd);
            map.put(c, map.getOrDefault(c, 0) + 1);
            //if (map.size() < k) {
            //  windowEnd++;
            //} else
            if (map.size() <= k) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                //System.out.println("windowStart = " + windowStart + ", windowEnd = " + windowEnd + ", size = " + (windowEnd - windowStart + 1));
                windowEnd++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char wsc = str.charAt(windowStart);
                    int count = map.get(wsc);
                    if (count == 1) map.remove(wsc);
                    else map.put(wsc, count - 1);
                    windowStart++;
                }
                windowEnd++;
            }
        }
        return maxSize;
    }

    /**
     * Time Complexity: O(n), Three nested iterations(i, j)
     * Space Complexity: O(k), to store k-chars
     */
    public static int longestSubstring(String str, int k) {
        if (str == null || str.length() == 0 || k <= 0 || k > str.length()) return -1;
        int maxSize = 0;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (windowEnd < str.length()) {
            char c = str.charAt(windowEnd);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() < k) {
                windowEnd++;
            } else if (map.size() == k) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                //System.out.println("windowStart = " + windowStart + ", windowEnd = " + windowEnd + ", size = " + (windowEnd - windowStart + 1));
                windowEnd++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char wsc = str.charAt(windowStart);
                    int count = map.get(wsc);
                    if (count == 1) map.remove(wsc);
                    else map.put(wsc, count - 1);
                    windowStart++;
                }
                windowEnd++;
            }
        }
        return maxSize;
    }

    /**
     * Time Complexity: O(n^2), Three nested iterations(i, j)
     * Space Complexity: O(k), to store k-chars
     */
    public static int longestSubstring_bruteForce_2(String str, int k) {
        if (str == null || str.length() == 0 || k <= 0 || k > str.length()) return -1;
        int maxSize = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                charSet.add(str.charAt(j));
                if (charSet.size() == k) {
                    //System.out.println("(" + i + ", " + j + "): substring size = " + (j - i + 1));
                    maxSize = Math.max(maxSize, j - i + 1);
                } else if (charSet.size() > k) break;
            }
        }
        return maxSize;
    }

    /**
     * Time Complexity: O(n^3), Three nested iterations(i, j, k-unique chars check)
     * Space Complexity: O(1)
     */
    public static int longestSubstring_bruteForce_1(String str, int k) {
        if (str == null || str.length() == 0 || k <= 0 || k > str.length()) return -1;
        int maxSize = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int uniqueCharCount = uniqueChars(str, i, j);
                if (uniqueCharCount == k) {
                    //System.out.println("(" + i + ", " + j + "): substring size = " + (j - i + 1));
                    maxSize = Math.max(maxSize, j - i + 1);
                } else if (uniqueCharCount > k) break;
            }
        }
        return maxSize;
    }

    private static int uniqueChars(String s, int i, int j) {
        Set<Character> uniqueSet = new HashSet<>();
        char[] sa = s.toCharArray();
        for (int k = i; k <= j; k++) uniqueSet.add(sa[k]);
        return uniqueSet.size();
    }

    public static void main(String[] args) {
        String str = "aabacbebebo";
        int k = 3;
        test(str, k);

        str = "aabacebebebo";
        k = 3;
        test(str, k);
    }

    private static void test(String str, int k) {
        System.out.println("\nString = " + str + ", k = " + k);
        System.out.println("Longest Substring size = " + longestSubstring(str, k));
        System.out.println("[Brute Force-1] Longest Substring size = " + longestSubstring_bruteForce_1(str, k));
        System.out.println("[Brute Force-2] Longest Substring size = " + longestSubstring_bruteForce_2(str, k));
    }

}
