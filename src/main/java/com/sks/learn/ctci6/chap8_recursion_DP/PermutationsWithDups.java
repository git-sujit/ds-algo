package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithDups {
    /**
     * ITERATION
     * Time Complexity  : O(n!): n is length of String
     * Space Complexity : O(n!)
     */
    public static List<String> pemutationsWithDuplicates(String s) {
        List<String> perms = new ArrayList<>();
        if (s != null && s.length() > 0) {
            perms.add("");
            for (char c : s.toCharArray()) {
                List<String> perms1 = new ArrayList<>();
                for (String s1 : perms) {
                    for (int j = 0; j <= s1.length(); j++) {
                        StringBuilder sb = new StringBuilder(s1.substring(0, j));
                        sb.append(c);
                        sb.append(s1.substring(j));
                        if (j == 0)
                            perms.set(j, sb.toString());
                        else
                            perms1.add(sb.toString());
                    }
                }
                perms.addAll(perms1);
            }
        }
        return perms;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(null);

        System.out.println("ITERATION");
        testPermutationsWithoutDups(null);
        testPermutationsWithoutDups("");
        testPermutationsWithoutDups("a");
        testPermutationsWithoutDups("ab");
        testPermutationsWithoutDups("abc");
        testPermutationsWithoutDups("abcd");
    }

    private static void testPermutationsWithoutDups(String s) {
        System.out.println("\nString = " + s);
        List<String> perms = pemutationsWithDuplicates(s);
        System.out.println("No. of Perms = " + perms.size());
        System.out.println("Permutations = " + perms);
    }

}
