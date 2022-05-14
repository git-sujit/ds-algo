package com.sks.sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * Time Complexity : O(nlogn)
     * Space Complexity: O(logn)
     */
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int s, int e) {
        if (e - s <= 0) return;
        int m = s + (e - s) / 2;
        mergeSort(nums, s, m);
        mergeSort(nums, m + 1, e);
        merge(nums, s, m, e);
    }

    //e.g: merge sorted list [4, 3] & [1,5]
    private void merge(int[] nums, int s, int m, int e) {
        // To store sorted elements from s to e
        int[] temp = new int[e - s + 1];
        int lp = s;
        int rp = m + 1;
        int tp = 0;
        while (lp <= m && rp <= e) {
            if (nums[lp] < nums[rp])
                temp[tp++] = nums[lp++];
            else
                temp[tp++] = nums[rp++];
        }
        while (lp <= m) temp[tp++] = nums[lp++];
        while (rp <= e) temp[tp++] = nums[rp++];
        // Copy sorted temp to original array
        for (int i = s; i <= e; i++) {
            nums[i] = temp[i - s];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 5, -1, 8, 5, 0, 4, 3, 10};
        demo(nums);
    }

    private static void demo(int[] nums) {
        System.out.println("Numbers = " + Arrays.toString(nums));
        new MergeSort().sort(nums);
        System.out.println("Sorted  = " + Arrays.toString(nums));
    }
}
