package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    /**
     * ITERATION
     * BETTER & EASIER APPROACH
     * Time Complexity  : O(n*2^n)
     * Space Complexity : O(n*2^n)
     */
    public static List<List<Integer>> powerset_iteration(List<Integer> s) {
        List<List<Integer>> ps = new ArrayList<>();
        ps.add(new ArrayList<>());
        for (int e : s) {
            List<List<Integer>> ps1 = new ArrayList<>();
            for (List<Integer> l : ps) {
                List<Integer> l1 = new ArrayList<>(l);
                l1.add(e);
                ps1.add(l1);
            }
            ps.addAll(ps1);
        }
        return ps;
    }

    /**
     * RESURSION
     * Time Complexity  : O(n*2^n)
     * Space Complexity : O(n*2^n)
     */
    public static List<List<Integer>> powerset_recursion(List<Integer> s) {
        List<List<Integer>> ps = new ArrayList<>();
        if (s != null && s.size() > 0) {
            ps.add(new ArrayList<>());
            powerset_recursion(s, ps);
        }
        return ps;
    }

    private static void powerset_recursion(List<Integer> s, List<List<Integer>> ps) {
        if (s == null || s.size() == 0) return;
        int last = s.get(s.size() - 1);
        List<Integer> s1 = s.subList(0, s.size() - 1);

        powerset_recursion(s1, ps);

        List<List<Integer>> ps1 = new ArrayList<>();
        for (List<Integer> l : ps) {
            List<Integer> l1 = new ArrayList<>(l);
            l1.add(last);
            ps1.add(l1);
        }
        ps.addAll(ps1);
    }

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{});
        testPowerSet(s);

        s = Arrays.asList(new Integer[]{1});
        testPowerSet(s);

        s = Arrays.asList(new Integer[]{1, 2});
        testPowerSet(s);

        s = Arrays.asList(new Integer[]{1, 2, 3});
        testPowerSet(s);

        s = Arrays.asList(new Integer[]{1, 2, 3, 4});
        testPowerSet(s);
    }

    private static void testPowerSet(List<Integer> s) {
        System.out.println("Set = " + s);
        List<List<Integer>> ps = powerset_recursion(s);
        System.out.println("Recursion: Power Set Size = " + ps.size());
        for (int i = 0; i < ps.size(); i++) {
            System.out.print(ps.get(i));
            if (i < ps.size() - 1)
                System.out.print(", ");
        }

        ps = powerset_iteration(s);
        System.out.println("\nIteration: Power Set Size = " + ps.size());
        for (int i = 0; i < ps.size(); i++) {
            System.out.print(ps.get(i));
            if (i < ps.size() - 1)
                System.out.print(", ");
        }

        System.out.println("\n");
    }
}
