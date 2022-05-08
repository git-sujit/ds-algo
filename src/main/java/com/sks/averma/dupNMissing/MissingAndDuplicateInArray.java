package com.sks.averma.dupNMissing;

import java.util.Arrays;

/**
 * You are given a read only array of n integers from 1 to n.
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * Return A and B.
 */
public class MissingAndDuplicateInArray {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] missingAndDuplicate_contantSpace(final int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int sum = 0;
        int squareSum = 0;
        for (int n : nums) {
            sum += n;
            squareSum += n * n;
        }
        int expSum = 0;
        int expSquareSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            expSum += i;
            expSquareSum += i * i;
        }
        int missing = ((expSquareSum - squareSum) / (expSum - sum) + (expSum - sum)) / 2;
        int duplicate = missing - (expSum - sum);
        return new int[]{missing, duplicate};
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] missingAndDuplicate(final int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] out = new int[2];
        int[] count = new int[nums.length];
        /*-for (int i = 0; i < nums.length; i++)
            count[nums[i] - 1]++;// = nums[i];*/
        //BETTER
        for (int num : nums)
            count[num - 1]++;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) out[0] = i + 1;
            if (count[i] == 2) out[1] = i + 1;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 2, 5};
        test(nums);

        nums = new int[]{3, 1, 2, 5, 3};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("\nnums = " + Arrays.toString(nums));
        int[] out = missingAndDuplicate(nums);
        System.out.println("Missing = " + out[0] + ", Duplicate = " + out[1]);
        out = missingAndDuplicate_contantSpace(nums);
        System.out.println("[Constant Space] Missing = " + out[0] + ", Duplicate = " + out[1]);
    }
}
