package com.sks.leatcode.easy;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery {
    private Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
    private int[] nums;

    private int[] sum;

    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
    }

    public RangeSumQuery(int[] nums, boolean bf) {
        if (bf) this.nums = nums;
        else {
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    cache.put(new Pair(i, j), sum);
                }
            }
        }
    }

    /**
     * Time complexity : O(1) time per query, O(n) time pre-computation. Since the cumulative sum is cached, each sumRange query can be calculated in O(1) time
     * Space complexity : O(n)
     */
    public int sumRange_caching_2(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    /**
     * Time complexity : O(1) time per query, O(n) time pre-computation. Since the cumulative sum is cached, each sumRange query can be calculated in O(1) time.
     * Space complexity : O(n^2)
     */
    public int sumRange_caching_1(int left, int right) {
        return cache.get(new Pair(left, right));
    }

    /**
     * Time complexity : O(n) time per query. Each sumRange query takes O(n) time.
     * Space complexity : O(1). Note that data is a reference to nums and is not a copy of it.
     */
    public int sumRange_bruteForce(int left, int right) {
        if (nums == null || nums.length == 0 || left > nums.length || left > right) return -1;
        int sum = 0;
        for (int i = left; i <= right; i++) sum += nums[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 8, 6, 10, 2, 11};
        int left = 3;
        int right = 7;
        System.out.println("Numbers = " + Arrays.toString(nums));
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println("[Caching-Efficient] Left = " + left + ", Right = " + right + " : Sum = " + rsq.sumRange_caching_2(left, right));

        rsq = new RangeSumQuery(nums, true);
        System.out.println("[Brute Force] Left = " + left + ", Right = " + right + " : Sum = " + rsq.sumRange_bruteForce(left, right));
        rsq = new RangeSumQuery(nums, false);
        System.out.println("[Caching-1] Left = " + left + ", Right = " + right + " : Sum = " + rsq.sumRange_caching_1(left, right));


    }
}
