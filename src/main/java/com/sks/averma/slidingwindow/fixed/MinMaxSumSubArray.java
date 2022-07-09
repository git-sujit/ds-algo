package com.sks.averma.slidingwindow.fixed;

import java.util.Arrays;
/*- FIXED: SLIDING WINDOW CODE TEMPLATE
    int windowStart = 0;
    int windowEnd = 0;
    while (windowEnd < a.length) {
        if (windowEnd - windowStart + 1 == k) { // When we hit the window size
            windowStart++; // Slide the window
        }
        windowEnd++; // Remember- In the end
    }
 */
/*- SLIDING WINDOW CODE TEMPLATE
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
        if (windowEnd - windowStart + 1 == k) { // When we hit the window size
            windowStart++; // Slide the window
        }
    }
 */

/**
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 */
public class MinMaxSumSubArray {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSumSubArray_slidingWindow_BETTER(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return -1;
        int maxSum = Integer.MIN_VALUE;
        int ws = 0;
        int we = 0;
        int sum = 0;
        while (we < a.length) {
            sum += a[we];
            if (we - ws + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= a[ws++];
            }
            we++;
        }
        return maxSum;
    }

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
            //System.out.println("Sum = " + sum);
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
            //System.out.println("Sum = " + sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int[][] slidingWindowSubArrays(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0 || k > a.length) return null;
        int[][] subArrays = new int[a.length - k + 1][k];
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            if (windowEnd - windowStart + 1 == k) {
                int[] subArr = new int[k];
                int j = 0;
                for (int i = windowStart; i <= windowEnd; i++) subArr[j++] = a[i];
                subArrays[windowStart] = subArr;
                windowStart++;
            }
        }
        return subArrays;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;
        System.out.println("Array = " + Arrays.toString(a) + ", Size of Sub-array = " + k);
        int[][] subArrays = slidingWindowSubArrays(a, k);
        System.out.println("Total Sub-Arrays = " + subArrays.length);
        for (int[] array : subArrays)
            System.out.println(Arrays.toString(array));
        System.out.println("Max Sum of sub-array(Sliding Window) = " + maxSumSubArray_slidingWindow(a, k));
        System.out.println("[Better]Max Sum of sub-array(Sliding Window) = " + maxSumSubArray_slidingWindow_BETTER(a, k));
        System.out.println("Max Sum of sub-array = " + maxSumSubArray(a, k));
        System.out.println("Max Sum of sub-array(Brute Force) = " + maxSumSubArray_bruteForce(a, k));
    }
}
