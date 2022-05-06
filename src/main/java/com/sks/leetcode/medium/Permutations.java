package com.sks.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static List<List<Integer>> permutations_backtracking(int[] nums) {
        return null;
    }

    /**
     * Time Complexity: O(n*n!)
     * Space Complexity: O(n!)
     */
    public static List<List<Integer>> permutations_better(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        if (nums == null || nums.length == 0) return perms;
        perms.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> subPerms = new ArrayList<>();
            for (List<Integer> l : perms) {
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> t = new ArrayList<>(l);
                    t.add(j, nums[i]);
                    subPerms.add(t);
                }
            }
            perms = subPerms;
        }
        return perms;
    }

    /**
     * Time Complexity: O(n*n!)
     * Space Complexity: O(n!)
     */
    public static List<String> permutations_string_better(String str) {
        List<String> perms = new ArrayList<>();
        if (str == null || str.isEmpty()) return perms;
        perms.add("" + str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            List<String> subPerms = new ArrayList<>();
            for (String s : perms) {
                for (int j = 0; j <= s.length(); j++) {
                    String s1 = s.substring(0, j) + c + s.substring(j);
                    subPerms.add(s1);
                }
            }
            perms = subPerms;
        }
        return perms;
    }

    /**
     * Time Complexity: O(n*n!)
     * Space Complexity: O(n!)
     * Idea: Building from permutations of all (n-1) substrings
     * Ex: p(abc) = a+p(bc), b+p(ac), c+p(ab)
     **/
    public List<String> permutations_string(String s) {
        List<String> perms = new ArrayList<>();
        if (s.length() == 1) {
            perms.add(s);
            return perms;
        }
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            List<String> subPerms = permutations_string(s.substring(0, i) + s.substring(i + 1));
            for (String p : subPerms)
                perms.add(first + p);
        }
        return perms;
    }


    // Time Complexity: O(n*n!)
    // Space Complexity: O(n!)
    // Idea: Same as String permutation above
    public List<List<Integer>> permutations_int_array(int[] a) {
        List<List<Integer>> perms = new ArrayList<>();
        if (a.length == 1) {
            List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
            perms.add(l);
            return perms;
        }
        for (int i = 0; i < a.length; i++) {
            int n = a[i];
            int[] a1 = getSubArray(a, i);
            List<List<Integer>> perms1 = permutations_int_array(a1);
            for (List<Integer> p1 : perms1) {
                p1.add(0, n);
                perms.add(p1);
            }
        }
        return perms;
    }

    private int[] getSubArray(int[] a, int remIndex) {
        List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
        l.remove(remIndex);
        Integer[] a1 = l.toArray(new Integer[0]);
        return Arrays.stream(a1).mapToInt(Integer::intValue).toArray();
    }

    private int[] getSubArray_bruteForce(int[] a, int remIndex) {
        int[] a1 = new int[a.length - 1];
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (remIndex == j)
                continue;
            a1[i] = a[j];
            i++;
        }
        return a1;
    }

    public static void main(String[] args) {
        //demo_old();
        int[] nums = {1, 2, 3};
        demo_intPerms(nums);

        String str = "abc";
        demo_stringPerms(str);
    }

    private static void demo_intPerms(int[] nums) {
        System.out.println("\nNums : " + Arrays.toString(nums));
        System.out.println("Perms: " + permutations_better(nums));
    }

    private static void demo_stringPerms(String str) {
        System.out.println("\nString: " + str);
        System.out.println("Perms : " + permutations_string_better(str));
    }

    private static void demo_old() {
        Permutations obj = new Permutations();

        int[] a = {1, 2, 3};
        System.out.println("Permutation(int[])  : " + Arrays.toString(a));
        List<List<Integer>> perms = obj.permutations_int_array(a);
        System.out.println("\tIs int[] modified  : " + Arrays.toString(a));
        System.out.println("\tcount = " + perms.size() + " : " + perms);
        perms = obj.permutations_better(a);
        System.out.println("\tIs int[] modified  : " + Arrays.toString(a));
        System.out.println("\tcount = " + perms.size() + " : " + perms);

        String s = "abcd";
        System.out.println("Permutation(String) : " + s);
        List<String> perms1 = obj.permutations_string(s);
        System.out.println("\tIs string modified : " + s);
        System.out.println("\tcount = " + perms1.size() + " : " + perms1);
    }
}
