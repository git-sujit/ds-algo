package com.sks.averma.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
 * we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 */
public class KthSymbolInGrammar {
    public static int kthGrammar_recursion(int n, int k) {
        if (n <= 0 || k <= 0 || k > Math.pow(2, k)) return -1;
        if (n == 1 && k == 1) return 0;
        int mid = (int) Math.pow(2, n - 1) / 2; // Math.pow(2, n-2)
        if (k <= mid) return kthGrammar_recursion(n - 1, k);
        else if (k > mid) {
            int out = kthGrammar_recursion(n - 1, k - mid);
            return out == 0 ? 1 : 0;
        }
        return -1;
    }


    private static void getNthRow(int n, List<Integer> row) {
        if (n == 1) row.add(0);
        getNthRow(n - 1, row);
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) == 0) Collections.addAll(out, 0, 1);
            else if (row.get(i) == 1) Collections.addAll(out, 1, 0);
        }
        row = out;
    }

    public static int kthGrammar_improved(int n, int k) {
        if (n <= 0 || k <= 0 || k > Math.pow(2, k)) return -1;
        if (n == 1) return 0;
        List<Integer> row = new ArrayList<>();
        row.add(0);
        for (int i = 2; i <= n; i++) {
            if (row.get(i - 2) == 0) row.add(1);
        }
        return -1;
    }

    /**
     * Will not work for large n like 30
     * Time Complexity: O(n*2^n+1) = n*(1+2+4+8+...+2^n)
     * Space Complexity: O(2^n), for n max element in row-n will be 2^n
     */
    public static int kthGrammar_bruteForce(int n, int k) {
        if (n <= 0 || k <= 0 || k > Math.pow(2, k)) return -1;
        if (n == 1) return 0;
        List<Integer> row = new ArrayList<>();
        row.add(0);
        for (int i = 2; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 0) Collections.addAll(temp, 0, 1);
                else if (row.get(j) == 1) Collections.addAll(temp, 1, 0);
            }
            row = temp;
            //System.out.println(row);
        }
        return row.get(k - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        System.out.println("n = " + n + ", k = " + k + ", Kth-Grammar = " + kthGrammar_bruteForce(n, k));
        System.out.println("[Recursion] n = " + n + ", k = " + k + ", Kth-Grammar = " + kthGrammar_recursion(n, k));
        n = 10;
        k = 511;
        System.out.println("n = " + n + ", k = " + k + ", Kth-Grammar = " + kthGrammar_bruteForce(n, k));
        System.out.println("[Recursion] n = " + n + ", k = " + k + ", Kth-Grammar = " + kthGrammar_recursion(n, k));
    }
}
