package com.sks.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    /**
     * BACKTRACKING: Power set is all possible combinations of all possible lengths, from 0 to n.
     * Time complexity: O(N×2^N), To generate all subsets(2^N) and then copy them into output list
     * Space complexity: O(N*2^N) , 2^N subsets & each subset can have upto N elements
     * IDEA: Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
     * If the solution candidate turns to be not a solution (or at least not the last one),
     * backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
     */
    public static List<List<Integer>> subsets_backtracking(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        if (nums == null || nums.length == 0) return out;
        for (int subLen = 0; subLen <= nums.length; subLen++) {
            backtrack(0, subLen, new ArrayList<>(), nums, out);
        }
        return out;
    }

    private static void backtrack(int first, int subLen, List<Integer> curr, int[] nums, List<List<Integer>> out) {
        if (curr.size() == subLen) {
            out.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, subLen, curr, nums, out);
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * CASCADING: Start with empty subset in output list, At each step one takes new integer into consideration and generates new subsets from the existing ones.
     * Time complexity: O(N×2^N) to generate all subsets and then copy them into output list.
     * Space complexity: O(N×2^N). This is exactly the number of solutions for subsets multiplied by the number N of elements to keep for each subset.
     * For a given number, it could be present or absent (i.e. binary choice) in a subset solution.
     * As as result, for N numbers, we would have in total 2^N choices (solutions).
     */
    public static List<List<Integer>> subsets_cascading(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        out.add(new ArrayList<>());
        for (int n : nums) {
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> e : out) {
                List<Integer> e1 = new ArrayList<>(e);
                e1.add(n);
                sub.add(e1);
            }
            out.addAll(sub);
        }
        return out;
    }

    /**
     * LEXICOGRAPHIC:
     * Time complexity : O(N×2^N)
     * Space complexity: O(N×2^N)
     * IDEA(By Knuth): The idea is that we map each subset to a bitmask of length n,
     * where 1 on the ith position in bitmask means the presence of nums[i] in the subset, and 0 means its absence.
     */
    public static List<List<Integer>> subsets_lexicographic(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            out.add(curr);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        test(nums);
        nums = new int[]{1};
        test(nums);
        nums = new int[]{1, 2};
        test(nums);
        nums = new int[]{1, 2, 3};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("\nNumbers = " + Arrays.toString(nums));
        List<List<Integer>> out = subsets_cascading(nums);
        System.out.println("[Cascading] Number of subsets = " + out.size() + ", subsets = " + out);
        out = subsets_backtracking(nums);
        System.out.println("[Backtracking] Number of subsets = " + out.size() + ", subsets = " + out);
        out = subsets_lexicographic(nums);
        System.out.println("[Lexicographic] No of subsets = " + out.size() + ", subsets = " + out);
    }
}
