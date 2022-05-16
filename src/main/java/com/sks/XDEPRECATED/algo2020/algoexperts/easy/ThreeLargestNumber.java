package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Input- Array of integers, without sorting return sorted array of the three largest integers
 */
public class ThreeLargestNumber {
    public static int[] findThreeLargestNumbers(int[] array) {
        if (array != null || array.length > 2) {
            int[] result = Arrays.copyOfRange(array, 0, 3);
            Arrays.sort(result);
            for (int i = 3; i < array.length; i++) {
                int num = array[i];
                if (num > result[0]) {
                    result[0] = num;
                    Arrays.sort(result);
                }
            }
            return result;
        }
        return new int[0];
    }

    public static int[] findXLargestNumbers(int[] array, int xLargest) {
        if (array != null || array.length > xLargest) {
            int[] result = Arrays.copyOfRange(array, 0, xLargest);
            Arrays.sort(result);
            for (int i = xLargest; i < array.length; i++) {
                int num = array[i];
                if (num > result[0]) {
                    result[0] = num;
                    Arrays.sort(result);
                }
            }
            return result;
        }
        return new int[0];
    }

    public static int[] findXLargestNumbers_No_Sort(int[] array, int xLargest) {
        if (array != null || array.length > xLargest - 1) {
            int[] result = new int[xLargest];
            for (int i = 0; i < array.length; i++) {
                if (i < xLargest) {
                    result[i] = array[i];
                } else {
                    for (int j = 0; j < xLargest; j++) {
                        if (array[i] > result[j]) {
                            result[j] = array[i];
                            break;
                        }
                    }
                }
            }
            Arrays.sort(result);
            return result;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 9, 10, 12};
        System.out.println("array = " + Arrays.toString(array));
        //System.out.println("result = " + Arrays.toString(findThreeLargestNumbers(array)));
        System.out.println("result = " + Arrays.toString(findXLargestNumbers(array, 2)));
        System.out.println("result = " + Arrays.toString(findXLargestNumbers(array, 3)));
        System.out.println("result = " + Arrays.toString(findXLargestNumbers(array, 4)));
        System.out.println("result = " + Arrays.toString(findXLargestNumbers(array, 5)));

    }
}
