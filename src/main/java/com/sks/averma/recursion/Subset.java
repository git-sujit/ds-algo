package com.sks.averma.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input-Output method
 */
public class Subset {
    /**
     * Time Complexity : O(2^n)
     * Space Complexity: O(2^n)
     */
    public static List<String> findSubsets(String s) {
        List<String> out = new ArrayList<>();
        if (s == null || s.length() == 0) return out;
        out.add("");
        for (char c : s.toCharArray()) {
            List<String> sub = new ArrayList<>();
            for (String s1 : out)
                sub.add(s1 + c);
            out.addAll(sub);
        }
        return out;
    }

    /**
     * Time Complexity : O(2^n)
     * Space Complexity: O(2^n)
     */
    public static List<List<Integer>> findSubsets(List<Integer> nums) {
        List<List<Integer>> out = new ArrayList<>();
        if (nums == null || nums.size() == 0) return out;
        out.add(new ArrayList<>());
        for (int n : nums) {
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> e : out) {
                // NOTE: Create New ArrayList
                List<Integer> e1 = new ArrayList<>(e);
                e1.add(n);
                sub.add(e1);
            }
            out.addAll(sub);
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "abc";
        demo(s);

        List<Integer> nums = Arrays.asList(1, 2, 3);
        demo(nums);
    }

    private static void demo(List<Integer> nums) {
        System.out.println("\nNumbers : " + nums);
        List<List<Integer>> subsets = findSubsets(nums);
        System.out.println("No. of Subsets = " + subsets.size() + " : " + subsets);
    }

    private static void demo(String s) {
        System.out.println("\nString : " + s);
        List<String> subsets = findSubsets(s);
        System.out.println("No. of Subsets = " + subsets.size() + " : " + subsets);
    }

}
