package com.sks.algo2020.algoexperts.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Sujit K Singh
 * Purpose : Product Sum of an Array that contains
 * - Integer or
 * - Another Array of Integer
 */
public class ProductSumOfArray {
    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List array, int depth) {
        System.out.println("array = " + array + ", Depth = " + depth);
        int ps = 0;
        for (Object obj : array) {
            if (obj instanceof Integer)
                ps += depth * (Integer) obj;
            else if (obj instanceof ArrayList)
                ps += depth * productSum((ArrayList) obj, depth + 1);
            else
                System.out.println("Invalid Array");
        }
        return ps;
    }

    public static void main(String[] args) {
        List<Object> array = Arrays.asList(5, 2, Arrays.asList(7, -1), 3, Arrays.asList(6, Arrays.asList(-13, 8), 4));
        System.out.println("Array = " + array + " :: Product Sum = " + productSum(array));
    }
}
