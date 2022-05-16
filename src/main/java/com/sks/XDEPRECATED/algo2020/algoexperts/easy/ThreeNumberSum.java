package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Sujit K Singh
 * Purpose : Input: Non-empty array of distinct integers and TargetSum
 * Output: List of triplets whose sum is TargetSum
 */
public class ThreeNumberSum {
    public static List<Integer[]> leftRightPointerApproach(int[] array, int targetSum) {
        Arrays.sort(array);
        int len = array.length;
        List<Integer[]> out = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < len && right > left) {
                int sum = array[i] + array[left] + array[right];
                if (sum == targetSum)
                    out.add(new Integer[]{array[i], array[left], array[right]});
                else if (sum < targetSum)
                    left++;
                else
                    right--;
            }
        }
        int[] arr = {1,2,3};
        new ArrayList<Integer>(arr[0]);
        return out;
    }

    // Time Complexity =    O(n3)
    // Space Complexity =   O(1)
    public static List<Integer[]> naive(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> out = new ArrayList<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (array[i] + array[j] + array[k] == targetSum) {
                        out.add(new Integer[]{array[i], array[j], array[k]});
                        break;
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        System.out.println("Input = " + Arrays.toString(array));
        List<Integer[]> out = naive(array, targetSum);
        System.out.print("Output = ");
        for (Integer[] a : out) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }
}
