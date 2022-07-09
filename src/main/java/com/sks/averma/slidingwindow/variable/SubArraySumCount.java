package com.sks.averma.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of sub-arrays whose sum equals to k.
 */
public class SubArraySumCount {
    public int subarraySum_map(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Map = " + map);
        return count;
    }

}
