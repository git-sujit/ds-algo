package com.sks.leatcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtmostKUniqueChars {
    /**
     * Time Complexity: O(n)
     * Spcae Complexity: O(k) for map
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return -1;
        int ws = 0;
        int we = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (we < s.length()) {
            char c = s.charAt(we);
            map.put(c, map.getOrDefault(c, 0) + 1);
            //if(map.size() < k) we++;
            //else
            if (map.size() <= k) {
                max = Math.max(max, we - ws + 1);
                we++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char wsc = s.charAt(ws);
                    int count = map.get(wsc);
                    if (count == 1) map.remove(wsc);
                    else map.put(wsc, count - 1);
                    ws++;
                }
                we++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;
        test(str, k);

        str = "a";
        k = 2;
        test(str, k);

        str = "aa";
        k = 2;
        test(str, k);
    }

    private static void test(String str, int k) {
        System.out.println("String = " + str + ", k = " + k);
        System.out.println("Longest substring with at most " + k + " chars = " + lengthOfLongestSubstringKDistinct(str, k));
    }

}
