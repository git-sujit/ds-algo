package com.sks.leatcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
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

    public List<List<Integer>> permutations_1(int[] a) {
        List<List<Integer>> out = new ArrayList<>();
        if (a == null || a.length == 0) return out;
        out.add(new ArrayList<>(Arrays.asList(a[0])));
        for (int i = 1; i < a.length; i++) {
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> l : out) {
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> t = new ArrayList<>(l);
                    t.add(j, a[i]);
                    sub.add(t);
                }
            }
            out = sub;
        }
        return out;
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
        Permutations obj = new Permutations();

        int[] a = {1, 2, 3};
        System.out.println("Permutation(int[])  : " + Arrays.toString(a));
        List<List<Integer>> perms = obj.permutations_int_array(a);
        System.out.println("\tIs int[] modified  : " + Arrays.toString(a));
        System.out.println("\tcount = " + perms.size() + " : " + perms);
        perms = obj.permutations_1(a);
        System.out.println("\tIs int[] modified  : " + Arrays.toString(a));
        System.out.println("\tcount = " + perms.size() + " : " + perms);

        String s = "abcd";
        System.out.println("Permutation(String) : " + s);
        List<String> perms1 = obj.permutations_string(s);
        System.out.println("\tIs string modified : " + s);
        System.out.println("\tcount = " + perms1.size() + " : " + perms1);

    }
}
