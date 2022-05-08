package com.sks.averma.slidingwindow.variable;


import java.util.*;

/**
 * Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
 */
public class LongestSubArrayOfASum {
    /**
     * TimeComplexity: O(n), n-Size of array
     * Space Complexity: O(1)
     */
    public static int sizeOfLongestSubarray_negativeNums(int[] nums, int sum) {
        if (nums == null || nums.length == 0) return -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int lsum = 0;
        for (int i = 0; i < nums.length; i++) {
            lsum += nums[i];
            if (lsum == sum) max = Math.max(max, i + 1);
            else if (map.containsKey(lsum - sum)) {
                for (int idx : map.get(lsum - sum))
                    max = Math.max(max, i - idx + 1);
            }
            map.computeIfAbsent(sum, e -> new ArrayList<>()).add(i);
        }
        return max;
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
        test(numbers, sum);

        numbers = new int[]{-5, 8, -14, 2, 4, 12};
        sum = -5;
        test(numbers, sum);

        numbers = new int[]{1, 2, 3};
        sum = 3;
        test(numbers, sum);
    }

    private static void test(int[] numbers, int sum) {
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
