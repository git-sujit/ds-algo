package com.sks.interview_2026;

import java.util.Arrays;

public class G_Variable_SlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("----- LONGEST SUBARRAY OF A SUM -----");
        test_longestSubarrayOfASum();
    }

    private static int sizeOfLongestSubarray_positiveArray(int[] numbers, int sum) {
        if (numbers == null || numbers.length == 0) return -1;
        int ws = 0, we = 0, size = 0, tempSum = 0;
        for (int n : numbers) {
            tempSum += n;
            if (tempSum == sum) {
                size = Math.max(size, we - ws + 1);
                if (we + 1 < numbers.length && numbers[we + 1] != 0) tempSum -= numbers[ws++];
            }
            we++;
        }
        return size;
    }

    private static int sizeOfLongestSubarray_negativeNums(int[] numbers, int sum) {
        if (numbers == null || numbers.length == 0) return -1;
        int ws = 0, we = 0, size = 0, tempSum = 0;
        for (int n : numbers) {
            tempSum += n;
            if (tempSum == sum) {
                size = Math.max(size, we - ws + 1);
                if (we + 1 < numbers.length && numbers[we + 1] > 0) tempSum -= numbers[ws++];
            }
            we++;
        }
        return size;
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
            System.out.println("[Negative-Array] Size of Longest SubArray = " + sizeOfLongestSubarray_negativeNums(numbers, sum));
        else
            System.out.println("[Positive-Array]Size of Longest SubArray = " + sizeOfLongestSubarray_positiveArray(numbers, sum));
    }

}
