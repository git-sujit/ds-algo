package com.sks.leatcode.easy;

import java.util.Arrays;

public class OnesTogether {
    private static void onesTogether(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos = i;
                break;
            }
        }
        for (int i = pos + 1; i < nums.length; i++) {
            if (nums[i] == 1 && i > pos + 1) {
                int t = nums[i];
                nums[i] = nums[pos + 1];
                nums[pos + 1] = t;
                pos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0};
        System.out.println("nums = " + Arrays.toString(nums));
        onesTogether(nums);
        System.out.println("1's  = " + Arrays.toString(nums));
    }
}
