package com.sks.leatcode.medium;

import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 */
public class MaxLengthRepeatedSubArray {
    public static int findLength_memo(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * O(N*M)
     */
    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return 0;
        int maxLen = 0;
        for (int i = 0; i < nums1.length; i++) {
            int locMax = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    locMax = 1;
                    for (int k = 1; i + k < nums1.length && j + k < nums2.length; k++) {
                        if (nums1[i + k] == nums2[j + k]) locMax++;
                        else break;
                    }
                    maxLen = Math.max(maxLen, locMax);
                }
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0};
        test(nums1, nums2);

        nums1 = new int[]{1, 2, 1, 1, 1};
        nums2 = new int[]{1, 1, 1, 1, 1};
        test(nums1, nums2);
    }

    private static void test(int[] nums1, int[] nums2) {
        System.out.println("\nNums1 : " + Arrays.toString(nums1));
        System.out.println("Nums2 : " + Arrays.toString(nums2));
        System.out.println("Max length = " + findLength(nums1, nums2));
        System.out.println("[DP]Max length = " + findLength_memo(nums1, nums2));
    }
}
