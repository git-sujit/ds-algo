package com.sks.interview_2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class G_Variable_SlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("----- LONGEST SUBARRAY OF A SUM -----");
        test_longestSubarrayOfASum();
        System.out.println("----- LONGEST SUBSTRING WITH K UNIQUE CHARS -----");
        test_longestSubstring_kUniqueChars();
    }

    /**
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
        return maxSize;
    }

    /**
     * TimeComplexity: O(n), n-Size of array
     * Space Complexity: O(n)
     */
    public static int sizeOfLongestSubarray_negativeArray(int[] arr, int k) {
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
     * Time Complexity: O(n), Three nested iterations(i, j)
     * Space Complexity: O(k), to store k-chars
     */
    public static int longestSubstring_kUniqueChars(String str, int k) {
        int ws = 0, we = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
            if (charFreq.size() == k)
                maxLength = Math.max(maxLength, we - ws + 1);
            if (charFreq.size() > k) {
                char sch = str.charAt(ws);
                if (charFreq.get(sch) == 1) charFreq.remove(sch);
                else charFreq.put(sch, charFreq.get(sch) - 1);
                ws++;
            }
            we++;
        }
        return maxLength;
    }

    /**
     * TEST
     */
    private static void test_longestSubarrayOfASum() {
        int[] numbers = {4, 1, 1, 1, 2, 0, 3, 5};
        int sum = 5;
        printLongestSubarray(numbers, sum);

        numbers = new int[]{-5, 8, -14, 2, 4, 12};
        sum = -5;
        printLongestSubarray(numbers, sum);
    }

    private static void printLongestSubarray(int[] numbers, int sum) {
        System.out.println("Numbers = " + Arrays.toString(numbers) + ", Sum = " + sum);
        if (Arrays.stream(numbers).anyMatch(n -> n < 0))
            System.out.println("[Negative-Array] Size of Longest SubArray = " + sizeOfLongestSubarray_negativeArray(numbers, sum));
        else
            System.out.println("[Positive-Array]Size of Longest SubArray = " + sizeOfLongestSubarray_positiveArray(numbers, sum));
    }

    private static void test_longestSubstring_kUniqueChars() {
        String str = "aabacbebebo";
        int k = 3;
        System.out.println("String = " + str + ", k = " + k);
        System.out.println("Longest Substring size = " + longestSubstring_kUniqueChars(str, k));

        str = "aabacebebebo";
        k = 3;
        System.out.println("String = " + str + ", k = " + k);
        System.out.println("Longest Substring size = " + longestSubstring_kUniqueChars(str, k));
    }

}
