package com.sks.averma.slidingwindow.variable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array consisting of the cost of toys. Given an integer K depicting the amount of money
 * available to purchase toys. Write a program to find the maximum number of toys one can buy with the amount K.
 * Note: One can buy only 1 quantity of a particular toy.
 */
public class PickToys {

    public static int maximum_toys(int cost[], int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (cost[n - 1] <= k)
            return Math.max(1 + maximum_toys(cost, n - 1, k - cost[n - 1]), maximum_toys(cost, n - 1, k));
        else
            return maximum_toys(cost, n - 1, k);
    }

    /**
     * @param toys
     * @param k
     * @return
     */
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
        int[] cost = new int[]{1, 12, 5, 111, 200, 1000, 10, 9, 12, 15};
        k = 50;
        System.out.println("Toys cost = " + Arrays.toString(cost) + ", k = " + k);
        System.out.println("Maximum no. of toys = " + maximum_toys(cost, cost.length, k));
    }

    private static void test(String toys, int k) {
        System.out.println("Toys = " + toys + ", k = " + k);
        System.out.println("Maximum number of toys = " + maximumNumberOfToys(toys, k));
        System.out.println("Maximum number of toys = " + maximumNumberOfToys(toys, k));
    }
}
