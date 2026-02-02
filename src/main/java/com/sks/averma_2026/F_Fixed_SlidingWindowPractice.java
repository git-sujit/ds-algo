package com.sks.averma_2026;

import java.util.*;

public class F_Fixed_SlidingWindowPractice {
    public static void main(String[] args) {
        System.out.println("----- MISSING & DUPLICATES -----");
        test_minMaxSumSubArray();

        System.out.println("----- FIRST NEGATIVE NUMBER IN SUBARRAYS -----");
        test_firstNegativeInSubArray();

        System.out.println("----- COUNT ANAGRAMS -----");
        test_countAnagrams();

        System.out.println("----- MAX OF SUBARRAYS -----");
        test_maxOfSubArrays();
    }


    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    private static int[] minMaxSumSubArray(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || numbers.length < k) return null;
        int ws = 0, we = 0, sum = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int n : numbers) {
            sum += n;
            if (we - ws + 1 == k) {
                minSum = Math.min(minSum, sum);
                maxSum = Math.max(maxSum, sum);
                sum -= numbers[ws++];
            }
            we++;
        }
        return new int[]{minSum, maxSum};
    }

    /**
     * Time Complexity: O(n): Traversing the array only once
     * Space Complexity: O(k): Size of list that stores negative numbers, which will be at max k
     */
    private static int[] firstNegativeInSubArray(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || numbers.length < k) return null;
        int[] out = new int[numbers.length - k + 1];
        List<Integer> negList = new LinkedList<>();
        int ws = 0, we = 0, i = 0;
        for (int n : numbers) {
            if (n < 0) negList.add(n);
            if (we - ws + 1 == k) {
                out[i++] = negList.isEmpty() ? 0 : negList.get(0);
                if (!negList.isEmpty() && numbers[ws] == negList.get(0)) negList.remove(0);
                ws++;
            }
            we++;
        }
        return out;
    }

    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    private static int countAnagrams(String txt, String pat) {
        if (txt == null | txt.length() == 0 || pat == null || pat.length() == 0 || pat.length() > txt.length())
            return -1;
        int[] masterCharCount = new int[26];
        for (char c : pat.toCharArray()) masterCharCount[c - 'a']++;
        int ws = 0, we = 0, count = 0;
        int[] windowCharCount = new int[26];
        for (char c : txt.toCharArray()) {
            windowCharCount[c - 'a']++;
            if (we - ws + 1 == pat.length()) {
                if (hasSameCharCount(masterCharCount, windowCharCount)) count++;
                windowCharCount[txt.charAt(ws++) - 'a']--;
            }
            we++;
        }
        return count;
    }

    private static boolean hasSameCharCount(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++)
            if (a1[i] != a2[i]) return false;
        return true;
    }

    /**
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k) for maxHeap
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int ws = 0, we = 0, i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : numbers) {
            maxHeap.add(n);
            if (we - ws + 1 == k) {
                out[ws] = maxHeap.peek();
                maxHeap.remove(numbers[ws]);
                ws++;
            }
            we++;
        }
        return out;
    }

    /**
     * TEST
     */
    private static void test_minMaxSumSubArray() {
        int[] numbers = {1, 3, -1, -3, 5, 3, 3, 6, 7};
        int k = 3;
        System.out.println("Numbers = " + Arrays.toString(numbers) + ", Window Size K = " + k);
        System.out.println("Min-Max of sum of SubArray = " + Arrays.toString(minMaxSumSubArray(numbers, k)));
    }

    private static void test_firstNegativeInSubArray() {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println("Array = " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("First -ve integer in each sub-array of size " + k + " = " + Arrays.toString(firstNegativeInSubArray(arr, k)));

        k = 3;
        System.out.println("Array = " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("First -ve integer in each sub-array of size " + k + " = " + Arrays.toString(firstNegativeInSubArray(arr, k)));

        arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        k = 3;
        System.out.println("Array = " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("First -ve integer in each sub-array of size " + k + " = " + Arrays.toString(firstNegativeInSubArray(arr, k)));
    }

    private static void test_countAnagrams() {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println("Text = " + txt + ", Pattern = " + pat);
        System.out.println("Count of Anagrams of pattern = " + countAnagrams(txt, pat));

        txt = "forrxxorfxdorfr";
        pat = "fror";
        System.out.println("Text = " + txt + ", Pattern = " + pat);
        System.out.println("Count of Anagrams of pattern = " + countAnagrams(txt, pat));
    }

    private static void test_maxOfSubArrays() {
        int[] numbers = {1, 3, -1, -3, 5, 3, 3, 6, 7};
        int k = 3;
        System.out.println("Numbers = " + Arrays.toString(numbers) + ", Window Size K = " + k);
        System.out.println("Max of SubArrays = " + Arrays.toString(maxOfSubArrays(numbers, k)));

        numbers = new int[]{1, 3, -1, -3, 5, 3, 3, 6, 7, -1, -2, -3, -4, 8};
        k = 3;
        System.out.println("Numbers = " + Arrays.toString(numbers) + ", Window Size K = " + k);
        System.out.println("Max of SubArrays = " + Arrays.toString(maxOfSubArrays(numbers, k)));
    }

}
