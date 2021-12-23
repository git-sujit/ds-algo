package com.sks.leatcode.medium;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
 * without changing the order of the remaining elements.
 */
public class LongestPalindromicSubsequence {
    /**
     * RECURSION
     * Time Complexity: O(2^n): n is length of string
     * Space Complexity: O(n) for Recursion stack
     */
    public static int longestPalindromeSubseq_recursion(String s) {
        if (s == null || s.length() == 0) return 0;
        String r = new StringBuilder(s).reverse().toString();
        return longestPalindromeSubseq_recursion(s, r, s.length(), r.length());
    }

    private static int longestPalindromeSubseq_recursion(String s, String r, int ls, int lr) {
        if (ls == 0 || lr == 0) return 0;
        if (s.charAt(ls - 1) == r.charAt(lr - 1))
            return 1 + longestPalindromeSubseq_recursion(s.substring(0, ls - 1), r.substring(0, lr - 1), ls - 1, lr - 1);
        else
            return Math.max(longestPalindromeSubseq_recursion(s, r.substring(0, lr - 1), ls, lr - 1),
                    longestPalindromeSubseq_recursion(s.substring(0, ls - 1), r, ls - 1, lr));
    }

    /**
     * MEMOIZATION
     * Time Complexity: O(n^2): n is length of string
     * Space Complexity: O(n^2) for memoization array
     */
    public static int longestPalindromeSubseq_memoization(String s) {
        if (s == null || s.length() == 0) return 0;
        String r = new StringBuilder(s).reverse().toString();
        int l = s.length();
        int[][] memo = new int[l + 1][l + 1];
        for (int[] m : memo)
            Arrays.fill(m, -1);
        return longestPalindromeSubseq_memoization(s, r, l, l, memo);
    }

    private static int longestPalindromeSubseq_memoization(String s, String r, int ls, int lr, int[][] memo) {
        if (ls == 0 || lr == 0) return 0;
        if (memo[ls][lr] != -1)
            return memo[ls][lr];
        if (s.charAt(ls - 1) == r.charAt(lr - 1))
            memo[ls][lr] = 1 + longestPalindromeSubseq_memoization(s.substring(0, ls - 1), r.substring(0, lr - 1), ls - 1, lr - 1, memo);
        else
            memo[ls][lr] = Math.max(longestPalindromeSubseq_memoization(s, r.substring(0, lr - 1), ls, lr - 1, memo),
                    longestPalindromeSubseq_memoization(s.substring(0, ls - 1), r, ls - 1, lr, memo));
        return memo[ls][lr];
    }

    /**
     * TABULATION
     * Time Complexity: O(n^2): n is length of string
     * Space Complexity: O(n^2) for Tabulation array
     */
    public static int longestPalindromeSubseq_tabulation(String s) {
        if (s == null || s.length() == 0) return 0;
        int l = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] tb = new int[l + 1][l + 1];
        for (int i = 0; i <= l; i++)
            for (int j = 0; j <= l; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1))
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                else
                    tb[i][j] = Math.max(tb[i][j - 1], tb[i - 1][j]);
            }
        }
        return tb[l][l];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Recursion: s = " + s + ", longest palindromic subsequence = " + longestPalindromeSubseq_recursion(s));
        System.out.println("Memoization: s = " + s + ", longest palindromic subsequence = " + longestPalindromeSubseq_memoization(s));
        System.out.println("Tabulation: s = " + s + ", longest palindromic subsequence = " + longestPalindromeSubseq_tabulation(s));

    }
}