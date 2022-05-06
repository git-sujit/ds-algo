package com.sks.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the smallest integer which has exactly the same
 * digits existing in the integer n and is greater in value than n. If no such positive
 * integer exists, return -1.
 */
public class NextGreaterElement {
    public static int nextGreaterElement(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        System.out.println("digits : " + digits);
        int p = 0;
        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                p = i;
                break;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int n = 243985687;
        System.out.println("n : " + n);
        int nn = nextGreaterElement(n);
    }
}
