package com.sks.averma.slidingwindow.variable;


import java.util.*;

/**
 * Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array
 * having sum equal to the given value k.
 * Refer: htps://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class LongestSubArrayOfASum {
    /**
     * TimeComplexity: O(n), n-Size of array
     * Space Complexity: O(n)
     */
    public static int sizeOfLongestSubarray_negativeNums(int[] arr, int k) {
        int n = arr.length;
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            // accumulate sum
            sum += arr[i];
            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;
            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {
                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }
        return maxLen;
    }

    /**
     * POSITIVE ARRAYS ONLY
     * TimeComplexity: O(n), n-Size of array
     * Space Complexity: O(1)
     */
    public static int sizeOfLongestSubarray_positiveArray(int[] numbers, int sum) {
        if (numbers == null || numbers.length == 0) return -1;
        int maxSize = Integer.MIN_VALUE;
        int windowStart = 0;
        int localSum = 0;
        int windowEnd = 0;
        while (windowEnd < numbers.length) {
            localSum += numbers[windowEnd];
            if (localSum < sum) {
                windowEnd++;
            } else if (localSum == sum) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                localSum -= numbers[windowStart];
                //System.out.println("Local sum range (i,j) = (" + windowStart + ", " + windowEnd + "), Size = " + (windowEnd - windowStart + 1));
                windowStart++;
                windowEnd++;
            } else if (localSum > sum) {
                while (localSum > sum && windowStart < numbers.length) {
                    localSum -= numbers[windowStart];
                    windowStart++;
                }
                if (localSum == sum && windowStart < numbers.length) {
                    maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                    localSum -= numbers[windowStart];
                    windowStart++;
                }
                windowEnd++;
            }
        }
        /*- BETTER & more inclusive
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            localSum += numbers[windowEnd];
            if (localSum == sum) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                localSum -= numbers[windowStart];
                System.out.println("Local sum range (i,j) = (" + windowStart + ", " + windowEnd + "), Size = " + (windowEnd - windowStart + 1));
                windowStart++;
            } else if (localSum > sum) {
                while (localSum > sum) {
                    localSum -= numbers[windowStart];
                    windowStart++;
                }
                if (localSum == sum) {
                    maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
                    localSum -= numbers[windowStart];
                    System.out.println("Local sum range (i,j) = (" + windowStart + ", " + windowEnd + "), Size = " + (windowEnd - windowStart + 1));
                    windowStart++;
                }
            }
        }**/
        return maxSize;
    }

    /**
     * TimeComplexity: O(n^2), n-Size of array
     * Space Complexity: O(1)
     * Idea: Consider every possible subarray of the given numbers array
     * Concern: Repeating calculations , Can be avoided by Sliding Window
     */
    public static int sizeOfLongestSubarray_bruteForce(int[] numbers, int sum) {
        if (numbers == null || numbers.length == 0) return -1;
        int maxSize = 0;
        for (int i = 0; i < numbers.length; i++) {
            int localSum = 0;
            for (int j = i; j < numbers.length; j++) {
                localSum += numbers[j];
                if (localSum == sum) {
                    maxSize = Math.max(maxSize, j - i + 1);
                    //System.out.println("Local sum range (i,j) = (" + i + ", " + j + "), Size = " + (j - i + 1));
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;
        demo(numbers, sum);

        numbers = new int[]{-5, 8, -14, 2, 4, 12};
        sum = -5;
        demo(numbers, sum);

        numbers = new int[]{1, 2, 3};
        sum = 3;
        demo(numbers, sum);

        numbers = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        sum = 3;
        demo(numbers, sum);
    }

    private static void demo(int[] numbers, int sum) {
        boolean isPositiveArray = true;
        for (int n : numbers) {
            if (n < 0) {
                isPositiveArray = false;
                break;
            }
        }
        System.out.println("\nNumbers = " + Arrays.toString(numbers) + ", Sum = " + sum);
        System.out.println("[-ve Nums] Size of Longest SubArray = " + sizeOfLongestSubarray_negativeNums(numbers, sum));
        System.out.println("[Brute Force] Size of Longest SubArray = " + sizeOfLongestSubarray_bruteForce(numbers, sum));
        if (isPositiveArray)
            System.out.println("[Positive-Array]Size of Longest SubArray = " + sizeOfLongestSubarray_positiveArray(numbers, sum));
    }

}
