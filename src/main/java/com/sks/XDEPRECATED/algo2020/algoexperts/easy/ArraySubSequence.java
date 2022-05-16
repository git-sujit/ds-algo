package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Sujit K Singh
 * Purpose : Given two non-empty arrays of integers, determine if second array is subsequence of first array
 * Note: subsequece is found in the order of array
 */
public class ArraySubSequence {
    public static boolean isValidSubSequence(List<Integer> array, List<Integer> sequence) {
        // Boundary condition check
        if (array == null || sequence == null || array.size() < sequence.size())
            return false;
        int seqSize = sequence.size();
        int matchCount = 0;
        int i = 0;
        for (int seqNum : sequence) {
            while (i < array.size()) {
                if (seqNum == array.get(i)) {
                    matchCount++;
                    if (matchCount == seqSize) {
                        return true;
                    }
                    i++;
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 1, 22, 25, 6, -1, 8, 10};
        Integer[] sequence = {1, 6, -1, 10, 5};
        System.out.println(isValidSubSequence(Arrays.asList(array), Arrays.asList(sequence)));
    }
}
