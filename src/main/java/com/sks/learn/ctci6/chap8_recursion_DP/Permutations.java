package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    /**
     * ITERATION
     * Time Complexity  : O(n!): n is length of String
     * Space Complexity : O(n!)
     */
    public static List<String> permutationsWithoutDups(String s) {
        List<String> p = new ArrayList<>();
        if (s != null && s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0) {
                    p.add("" + c);
                    continue;
                }
                int len = p.size();
                for (int j = 0; j < len; j++) {
                    String s1 = p.get(j);
                    int len1 = s1.length();
                    for (int k = 0; k <= len1; k++) {
                        if (k == 0)
                            p.set(j, c + s1);
                        else
                            p.add(s1.substring(0, k) + c + s1.substring(k, len1));
                    }
                }
            }
        }
        return p;
    }

    /**
     * RECURSION
     * Time Complexity  : O(n!): n is length of String
     * Space Complexity : O(n!)
     */
    public static List<List<Integer>> permutationsWithoutDups_recursion(List<Integer> array) {
        if (array == null || array.size() == 0) {
            return new ArrayList<>();
        }
        if (array.size() == 1) {
            List<List<Integer>> p = new ArrayList<>();
            p.add(array);
            return p;
        }
        int size = array.size();
        int last = array.get(size - 1);
        List<List<Integer>> perms = permutationsWithoutDups_recursion(array.subList(0, size - 2));
        int pSize = perms.size();
        for (int i = 0; i < pSize; i++) {
            List<Integer> perm = perms.get(i);
            for (int loc = 0; loc <= perm.size(); loc++) {
                List<Integer> l1 = new ArrayList<>();
                l1.addAll(perm.subList(0, loc));
                l1.add(last);
                l1.addAll(perm.subList(loc, perm.size()));
                if (loc == 0)
                    perms.set(i, l1);
                else
                    perms.add(l1);
            }
        }
        return perms;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(null);

        System.out.println("RECURSION");
        testPermutationsWithoutDups_string(null);
        testPermutationsWithoutDups_string("");
        testPermutationsWithoutDups_string("a");
        testPermutationsWithoutDups_string("ab");
        testPermutationsWithoutDups_string("abc");
        testPermutationsWithoutDups_string("abcde");

        System.out.println("ITERATION");
        testPermutationsWithoutDups_list(null);
        testPermutationsWithoutDups_list(new ArrayList<>());
        testPermutationsWithoutDups_list(new ArrayList<>(Arrays.asList(1)));
        testPermutationsWithoutDups_list(new ArrayList<>(Arrays.asList(1, 2)));
        testPermutationsWithoutDups_list(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    private static void testPermutationsWithoutDups_string(String s) {
        System.out.println("\nString = " + s);
        List<String> perms = permutationsWithoutDups(s);
        System.out.println("No. of Perms = " + perms.size());
        System.out.println("Permutations = " + perms);
    }

    private static void testPermutationsWithoutDups_list(List<Integer> list) {
        System.out.println("\nList = " + list);
        List<List<Integer>> perms = permutationsWithoutDups_recursion(list);
        System.out.println("No. of Perms = " + perms.size());
        System.out.println("Permutations = " + perms);
    }
}
