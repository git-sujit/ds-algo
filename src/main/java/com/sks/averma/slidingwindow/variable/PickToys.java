package com.sks.averma.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class PickToys {

    public static int maximumNumberOfToys(String toys, int k) {
        if (toys == null || toys.length() == 0 || k <= 0 || k > toys.length()) return -1;
        int max = 0;
        int ws = 0;
        int we = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (we < toys.length()) {
            char c = toys.charAt(we);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() < k) {
                we++;
            } else if (map.size() == k) {
                max = Math.max(max, we - ws + 1);
                we++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char wsc = toys.charAt(ws);
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
        String toys = "abaccab";
        int k = 2;
        test(toys, k);
    }

    private static void test(String toys, int k) {
        System.out.println("Toys = " + toys + ", k = " + k);
        System.out.println("Maximum number of toys = " + maximumNumberOfToys(toys, k));
    }
}
