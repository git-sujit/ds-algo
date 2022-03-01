package com.sks.averma.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, print all n-bit binary numbers having more 1’s than 0’s for any prefix of the number.
 * Each prefix => no of 1s >= no of 0s
 */
public class NBitBinary {
    public static List<String> nBitBinary(int n) {
        List<String> numList = new ArrayList<>();
        nBitBinary(n, 0, 0, "", numList);
        return numList;
    }

    private static void nBitBinary(int n, int os, int zs, String num, List<String> numList) {
        if (n == 0) {
            numList.add(num);
            return;
        }
        nBitBinary(n - 1, os + 1, zs, num + "1", numList);
        if (os > zs)
            nBitBinary(n - 1, os, zs + 1, num + "0", numList);
    }

    public static void main(String[] args) {
        demo(3);
        demo(4);
        demo(5);
    }

    private static void demo(int n) {
        System.out.println("\nn = " + n);
        List<String> nums = nBitBinary(n);
        System.out.println("size = " + nums.size() + ", Num List = " + nums);
    }
}
