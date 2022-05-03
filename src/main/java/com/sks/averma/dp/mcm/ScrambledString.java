package com.sks.averma.dp.mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 */
public class ScrambledString {
    /**
     * Time Complexity : O(n^3)
     * Space Complexity: O(n^2)
     */
    public static boolean isScrambled_memoization_map(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        Map<String, Boolean> map = new HashMap<>();
        return isScrambled_memoization_map(s1, s2, map);
    }

    private static boolean isScrambled_memoization_map(String s1, String s2, Map<String, Boolean> map) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        String key = s1 + "_" + s2;
        int len = s1.length();
        if (map.containsKey(key)) return map.get(key);
        boolean flag = false;
        for (int i = 1; i <= len - 1; i++) {
            boolean cond1 = isScrambled_memoization_map(s1.substring(0, i), s2.substring(len - i, len), map)
                    && isScrambled_memoization_map(s1.substring(i, len), s2.substring(0, len - i), map);
            boolean cond2 = isScrambled_memoization_map(s1.substring(0, i), s2.substring(0, i), map)
                    && isScrambled_memoization_map(s1.substring(i, len), s2.substring(i, len), map);
            if (cond1 || cond2) {
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }

    /**
     * Time Complexity :
     * Space Complexity:
     */
    public static boolean isScrambled_memoization(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        Boolean[][] mem = new Boolean[len + 1][len + 1];
        return isScrambled_memoization(s1, s2, mem);
    }

    private static boolean isScrambled_memoization(String s1, String s2, Boolean[][] mem) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2)) return true;
        int len = s1.length();
        if (mem[len][len] != null) return mem[len][len];
        boolean flag = false;
        for (int i = 1; i <= len - 1; i++) {
            boolean cond1 = isScrambled_recursion(s1.substring(0, i), s2.substring(len - i, len))
                    && isScrambled_recursion(s1.substring(i, len), s2.substring(0, len - i));
            boolean cond2 = isScrambled_recursion(s1.substring(0, i), s2.substring(0, i))
                    && isScrambled_recursion(s1.substring(i, len), s2.substring(i, len));
            if (cond1 || cond2) {
                flag = true;
                break;
            }
        }
        return mem[len][len] = flag;
    }

    /**
     * Time Complexity :
     * Space Complexity:
     */
    public static boolean isScrambled_recursion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length())
            return false;
        if (s1.equals(s2)) return true;
        int len = s1.length();
        boolean flag = false;
        for (int i = 1; i <= len - 1; i++) {
            boolean cond1 = isScrambled_recursion(s1.substring(0, i), s2.substring(len - i, len))
                    && isScrambled_recursion(s1.substring(i, len), s2.substring(0, len - i));
            boolean cond2 = isScrambled_recursion(s1.substring(0, i), s2.substring(0, i))
                    && isScrambled_recursion(s1.substring(i, len), s2.substring(i, len));

            if (cond1 || cond2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        demo(s1, s2);
    }

    private static void demo(String s1, String s2) {
        System.out.println("[Recursion] s1 = " + s1 + ", s2 = " + s2 + ", is scrambled? = " + isScrambled_recursion(s1, s2));
        System.out.println("[Memoization] s1 = " + s1 + ", s2 = " + s2 + ", is scrambled? = " + isScrambled_memoization(s1, s2));
        System.out.println("[Memoization-Map] s1 = " + s1 + ", s2 = " + s2 + ", is scrambled? = " + isScrambled_memoization_map(s1, s2));
    }
}