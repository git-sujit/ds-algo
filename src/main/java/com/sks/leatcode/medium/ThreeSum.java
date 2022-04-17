package com.sks.leatcode.medium;

import javafx.util.Pair;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    /**
     * Input Array cant be modified
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> threeSum_no_sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    int comp = -sum;
                    if (seen.containsKey(comp) && seen.get(comp) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], comp);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> threeSum_sort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, i, res);
        }
        return res;
    }

    public static void twoSum(int[] nums, int start, List<List<Integer>> res) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            if (sum < 0) left++;
            else if (sum == 0) {
                res.add(Arrays.asList(nums[start], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1])
                    left++;
            } else right--;
        }
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> threeSum_TLE(int[] nums) {
        Set<List<Integer>> out = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>(out);
        Map<Integer, List<Pair<Integer, Integer>>> sumIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sumIdxMap.computeIfAbsent(nums[i] + nums[j], e -> new ArrayList<>()).add(new Pair(i, j));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Pair<Integer, Integer>> psList = sumIdxMap.get(-num);
            if (psList != null && psList.size() > 0) {
                for (Pair<Integer, Integer> pair : psList) {
                    int idx1 = pair.getKey();
                    int idx2 = pair.getValue();
                    List<Integer> triplet = Arrays.asList(nums[i], nums[idx1], nums[idx2]);
                    Collections.sort(triplet);
                    if (i != idx1 && i != idx2) {
                        out.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(out);
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        demo(nums);
    }

    private static void demo(int[] nums) {
        System.out.println("Nums = " + Arrays.toString(nums));
        System.out.println("Unique Triplets(Values) = " + new ThreeSum().threeSum_TLE(nums));
        System.out.println("[Sort]Unique Triplets(Values) = " + new ThreeSum().threeSum_sort(nums));
        System.out.println("[No-Sort]Unique Triplets(Values) = " + new ThreeSum().threeSum_no_sort(nums));
    }
}
