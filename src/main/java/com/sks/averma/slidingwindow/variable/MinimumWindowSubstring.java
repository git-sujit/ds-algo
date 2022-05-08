package com.sks.averma.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Strings S1 & S2. Return min substring of S1 having all the letters of S2 with at least counts of S2-Chars
 */
public class MinimumWindowSubstring {
    /**
     * Time Complexity: O(n)
     * Space Complexity:
     */
    public static int minWindowSize_array(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return -1;
        int min = Integer.MAX_VALUE;
        int ws = 0;
        int we = 0;
        int[] tCount = new int[52];
        for (char ch : t.toCharArray()) {
            updateCount(ch, tCount, true);
        }
        //System.out.println("tCount " + Arrays.toString(tCount));
        int[] sCount = new int[52];
        while (we < s.length()) {
            char ech = s.charAt(we);
            updateCount(ech, sCount, true);
            while (isEligible_arr(sCount, tCount)) {
                min = Math.min(min, we - ws + 1);
                char wch = s.charAt(ws++);
                updateCount(wch, sCount, false);
            }
            we++;
        }
        return min;
    }

    private static void updateCount(char ch, int[] tCount, boolean increment) {
        if (ch >= 'A' && ch <= 'Z') {
            if (increment) tCount[ch - 'A']++;
            else tCount[ch - 'A']--;
        } else {
            if (increment) tCount[ch - 'a' + 26]++;
            else tCount[ch - 'a' + 26]--;
        }
    }

    private static boolean isEligible_arr(int[] sCount, int[] tCount) {
        for (int i = 0; i < 52; i++)
            if (sCount[i] < tCount[i]) return false;
        return true;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity:
     */
    public static int minWindowSize_map(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return -1;
        int min = Integer.MAX_VALUE;
        int ws = 0;
        int we = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char tc : t.toCharArray())
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        Map<Character, Integer> sMap = new HashMap<>();
        //System.out.println("tMap = " + tMap);
        while (we < s.length()) {
            char sc = s.charAt(we);
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);
            while (isEligible(sMap, tMap)) {
                min = Math.min(min, we - ws + 1);
                char wch = s.charAt(ws++);
                int count = sMap.get(wch);
                if (count == 1) sMap.remove(wch);
                else sMap.put(wch, count - 1);
            }
            we++;
        }
        return min;
    }

    private static boolean isEligible(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (char key : tMap.keySet()) {
            if (!sMap.containsKey(key) || sMap.get(key) < tMap.get(key)) return false;
        }
        return true;
    }

    public static int minWindowSize_bruteForce(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return -1;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        //System.out.println("tMap = " + tMap);
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                sub += s.charAt(j);
                if (sub.length() >= t.length() && isValid(sub, tMap)) {
                    min = Math.min(min, sub.length());
                    //System.out.println("(i, j) = (" + i + ", " + j + ")");
                }
            }
        }
        return min;
    }

    private static boolean isValid(String sub, Map<Character, Integer> tMap) {
        Map<Character, Integer> subMap = new HashMap<>();
        for (char c : sub.toCharArray())
            subMap.put(c, subMap.getOrDefault(c, 0) + 1);
        //System.out.println("subMap = " + subMap);
        if (subMap.size() < tMap.size()) return false;
        for (char key : tMap.keySet()) {
            if (!subMap.containsKey(key) || subMap.get(key) < tMap.get(key)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String t = "toc";
        test(s, t);

        s = "TOTMTAPTAT";
        t = "TTA";
        test(s, t);
    }

    private static void test(String s, String t) {
        System.out.println("\ns = " + s + ", t = " + t);
        System.out.println("[Better-Array] Minimum Window Size = " + minWindowSize_array(s, t));
        System.out.println("[Map] Minimum Window Size = " + minWindowSize_map(s, t));
        System.out.println("[Brute Force] Minimum Window Size = " + minWindowSize_bruteForce(s, t));
    }
}
