package com.sks.averma.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*- SLIDING WINDOW CODE TEMPLATE
    int windowStart = 0;
    int windowEnd = 0;
    while (windowEnd < a.length) {
        if (windowEnd - windowStart + 1 == k) { // When we hit the window size
            windowStart++; // Slide the window
        }
    }
 */

/**
 * Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
 */
public class FirstNegativeInWindowK {
    /**
     * Time Complexity: O(n): Traversing the array only once
     * Time Complexity: O(k): Size of list that stores negative numbers, which will be at max k
     */
    public static int[] firstNegativeInteger_better(int arr[], int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return null;
        int[] out = new int[arr.length - k + 1];
        int startWindow = 0;
        int endWindow = 0;
        List<Integer> negList = new ArrayList<>();
        while (endWindow < arr.length) {
            if (arr[endWindow] < 0)
                negList.add(arr[endWindow]);
            if (endWindow - startWindow + 1 == k) {
                out[startWindow] = negList.size() > 0 ? negList.get(0) : 0;
                //if (arr[startWindow] < 0 && negList.size() > 0) negList.remove(0);
                if (negList.size() > 0 && arr[startWindow] == negList.get(0)) negList.remove(0);
                startWindow++;
            }
            endWindow++;
        }
        return out;
    }

    /**
     * Time Complexity: O(n): Traversing the array only once
     * Time Complexity: O(k): Size of list that stores negative numbers, which will be at max k
     */
    public static int[] firstNegativeInteger(int arr[], int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return null;
        int[] out = new int[arr.length - k + 1];
        int startWindow = 0;
        List<Integer> negList = new ArrayList<>();
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            if (arr[endWindow] < 0)
                negList.add(arr[endWindow]);
            if (endWindow - startWindow + 1 == k) {
                out[startWindow] = negList.size() > 0 ? negList.get(0) : 0;
                //if (arr[startWindow] < 0 && negList.size() > 0) negList.remove(0);
                if (negList.size() > 0 && arr[startWindow] == negList.get(0)) negList.remove(0);
                startWindow++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n*k)
     * Time Complexity: O(n) to store the result int[]
     */
    public static int[] firstNegativeInteger_bruteForce(int arr[], int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return null;
        int[] out = new int[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    out[i] = arr[j];
                    break;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        test(arr, k);

        k = 3;
        test(arr, k);

        arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        k = 3;
        test(arr, k);
    }

    private static void test(int[] arr, int k) {
        System.out.println("\nArray = " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("First -ve integer in each sub-array of size " + k + " = " + Arrays.toString(firstNegativeInteger(arr, k)));
        System.out.println("[Better]First -ve integer in each sub-array of size " + k + " = " + Arrays.toString(firstNegativeInteger_better(arr, k)));
        System.out.println("First -ve integer in each sub-array of size(Brute Force) " + k + " = " + Arrays.toString(firstNegativeInteger_bruteForce(arr, k)));
    }
}

