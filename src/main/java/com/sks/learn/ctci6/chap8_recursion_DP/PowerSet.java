package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> getPowerSet(List<Integer> s) {
        List<List<Integer>> ps = new ArrayList<>();
        if (s != null && s.size() > 0) {
            ps.add(new ArrayList<>());
            getPowerSet(s, ps);
        }
        return ps;
    }

    private static void getPowerSet(List<Integer> s, List<List<Integer>> ps) {
        if (s == null || s.size() == 0) {
            return;
        }
        //System.out.println("getPowerSet(" + s + ", " + ps + ")");
        Integer last = s.get(s.size() - 1);
        List<Integer> s1 = s.subList(0, s.size() - 1);
        getPowerSet(s1, ps);
        //System.out.println("last = " + last);
        List<List<Integer>> ps1 = new ArrayList<>();
        for (List<Integer> l : ps) {
            if (l != null) {
                List<Integer> l1 = new ArrayList<>();
                l1.addAll(l);
                l1.add(last);
                ps1.add(l1);
            }
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
        List<List<Integer>> ps = getPowerSet(s);
        System.out.println("Power Set Size = " + ps.size() + "\nPower Set = ");
        for (List<Integer> l : ps)
            System.out.print(l+" ");
        System.out.println("\n");
    }


}
