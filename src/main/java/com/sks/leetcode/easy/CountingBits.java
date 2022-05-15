package com.sks.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {
    public int[] countBits(int n) {
        if (n < 0) return null;
        int[] out = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            out[i] = countSetBits(i);
        }
        return out;
    }

    private int countSetBits(int num) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & mask) != 0) count++;
            mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println("n = " + n);
        System.out.println("Bit Counts = " + Arrays.toString(new CountingBits().countBits(n)));
    }
}
