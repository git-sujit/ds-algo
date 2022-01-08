package com.sks.averma.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Two Strings S1 & S2. Return min substring of S1 having all the letters of S2 with at least counts of S2-Chars
 */
public class MinimumWindowSubstring {
    /**
     * Time Complexity:
     * Space Complexity:
     */
    public static int minWindowSize(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return -1;
        int min = Integer.MAX_VALUE;
        int ws = 0;
        int we = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char tc : t.toCharArray())
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        Map<Character, Integer> sMap = new HashMap<>();
        System.out.println("tMap = " + tMap);
        while (we < s.length()) {
            char sc = s.charAt(we);
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);
            if (isEligible(sMap, tMap)) {
                min = Math.min(min, we - ws + 1);
            } else {
                char wsc = s.charAt(ws);
                int count = sMap.get(wsc);
                if (count == 1) sMap.remove(wsc);
                else sMap.put(wsc, count - 1);
                ws++;
            }
            we++;
        }
        return min;
    }

    private static boolean isEligible(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (tMap.size() != sMap.size()) return false;
        for (char key : tMap.keySet()) {
            if (!sMap.containsKey(key) || sMap.get(key) < tMap.get(key)) return false;
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
        System.out.println("Minimum Window Size = " + minWindowSize(s, t));
    }
    class Range{
        int left;
        int right;
        public Range(int left, int right){
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range range = (Range) o;
            return left == range.left && right == range.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
