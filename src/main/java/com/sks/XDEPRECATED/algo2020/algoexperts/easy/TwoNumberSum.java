package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import java.util.*;

/**
 * @author : Sujit K Singh
 * Purpose :
 * Input: non-empty array of distinct integers and target sum
 * Output: Any two numbers in array that sums to target, return as an array
 */
public class TwoNumberSum {
    public static int[] twoNumberSum_Time_O_n2_Space_O_1(int[] array, int targetSum) {
        if (array != null && array.length > 1) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                int firstNum = array[i];
                for (int j = i + 1; j < length; j++) {
                    int secondNum = array[j];
                    if (firstNum + secondNum == targetSum)
                        return new int[]{firstNum, secondNum};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum_Time_O_nlog_Space_O1(int[] array, int targetSum) {
        if (array != null && array.length > 1) {
            Arrays.sort(array);
            int length = array.length;
            int leftPointer = 0;
            int rightPointer = length - 1;
            while (leftPointer < length && rightPointer >= 0) {
                int firstNum = array[leftPointer];
                int secNum = array[rightPointer];
                int sum = firstNum + secNum;
                if (sum == targetSum)
                    return new int[]{firstNum, secNum};
                else if (sum < targetSum)
                    leftPointer++;
                else
                    rightPointer--;
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum_Time_O_n_Space_O_n(int[] array, int targetSum) {
        if (array != null && array.length > 1) {
            Set<Integer> diffSet = new HashSet<>();
            for (int num : array) {
                diffSet.add(targetSum - num);
            }
            for (int num : array) {
                int diff = targetSum - num;
                if (diffSet.contains(num) && num != diff)
                    return new int[]{num, diff};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("### twoNumberSum_Time_O_n2_Space_O_1 ###");
        for (Input input : prepareInput()) {
            int[] array = input.getArray();
            int targetSum = input.getTargetSum();
            System.out.println("#Numbers = " + Arrays.toString(array) + ", TargetSum = " + targetSum);
            System.out.println("Output = " + Arrays.toString(twoNumberSum_Time_O_n2_Space_O_1(array, targetSum)));
        }

        System.out.println("### twoNumberSum_Time_O_nlog_Space_O1 ###");
        for (Input input : prepareInput()) {
            int[] array = input.getArray();
            int targetSum = input.getTargetSum();
            System.out.println("#Numbers = " + Arrays.toString(array) + ", TargetSum = " + targetSum);
            System.out.println("Output = " + Arrays.toString(twoNumberSum_Time_O_nlog_Space_O1(array, targetSum)));
        }

        System.out.println("### twoNumberSum_Time_O_n_Space_O_n ###");
        for (Input input : prepareInput()) {
            int[] array = input.getArray();
            int targetSum = input.getTargetSum();
            System.out.println("#Numbers = " + Arrays.toString(array) + ", TargetSum = " + targetSum);
            System.out.println("Output = " + Arrays.toString(twoNumberSum_Time_O_n_Space_O_n(array, targetSum)));
        }
    }

    private static List<Input> prepareInput() {
        List<Input> inputList = new ArrayList<>();
        inputList.add(new Input(null, 0));
        inputList.add(new Input(new int[]{1}, 3));
        inputList.add(new Input(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
        inputList.add(new Input(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, -1}, 17));
        inputList.add(new Input(new int[]{-7, -5, -3, -1, 0, 1, 3, 5, 7}, -5));
        return inputList;
    }

    private static class Input {
        private int[] array;
        private int targetSum;

        public Input(int[] array, int targetSum) {
            this.array = array;
            this.targetSum = targetSum;
        }

        public int[] getArray() {
            return array;
        }

        public int getTargetSum() {
            return targetSum;
        }
    }
}
