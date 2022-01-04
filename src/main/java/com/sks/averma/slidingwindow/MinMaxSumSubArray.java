package com.sks.averma.slidingwindow;

import java.util.Arrays;

/**
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 */
public class MinMaxSumSubArray {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSumSubArray_slidingWindow(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return -1;
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            windowSum += a[windowEnd];
            if (windowEnd - windowStart + 1 == k) { // When we hit the window size
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= a[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window
            }
        }
        return maxSum;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSumSubArray(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return -1;
        int maxSum = 0;
        for (int i = 0; i < k; i++) maxSum += a[i];
        for (int i = 1; i <= a.length - k; i++) {
            int sum = maxSum - a[i - 1] + a[i + k - 1];
            System.out.println("Sum = " + sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /**
     * Time Complexity: O(n*k)
     * Space Complexity: O(1)
     */
    public static int maxSumSubArray_bruteForce(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= a.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += a[j];
            }
            System.out.println("Sum = " + sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;
        System.out.println("Array = " + Arrays.toString(a) + ", Size of Sub-array = " + k);
        System.out.println("Max Sum of sub-array(Sliding Window) = " + maxSumSubArray_slidingWindow(a, k));
        //System.out.println("Max Sum of sub-array = " + maxSumSubArray(a, k));
        //System.out.println("Max Sum of sub-array(Brute Force) = " + maxSumSubArray_bruteForce(a, k));
    }
}
