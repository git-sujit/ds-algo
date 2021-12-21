package com.sks.leatcode.medium;
/**
 * GOOGLE Onsite - 2018
 * Dynamic Programming Problem
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * This one is a real-world problem! Finding the longest common subsequence between two strings is useful for checking
 * the difference between two files (diffing). Applications:
 * 1. Git needs to do this when merging branches.
 * 2. Genetic Analysis: It's also used in genetic analysis (combined with other algorithms) as a measure of similarity between two genetic codes.
 */
/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */

/**
 * This one is a real-world problem! Finding the longest common subsequence between two strings is useful for checking
 * the difference between two files (diffing). Applications:
 *  1. Git needs to do this when merging branches.
 *  2. Genetic Analysis: It's also used in genetic analysis (combined with other algorithms) as a measure of similarity between two genetic codes.
 */

import java.util.Arrays;

/**
 * strings consisting of the letters a, c, g, and t. they are the symbols we use to represent genetic codes.
 */
public class LowestCommonSubsequence {
    /**
     * BRUTE FORCE:
     *  Time Complexity: O(2^L) : The number of subsequences in a string is up to O(2^L)
     *  , where L is the length of the string. This is because, for each character, we have two choices; it can either be in the subsequence or not in it
     */
    public static int lcs_recursion_brute_force(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 == 0 || l2 == 0) return 0;
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
            return 1 + lcs_recursion_brute_force(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1));
        else
            return Math.max(lcs_recursion_brute_force(s1, s2.substring(0, l2 - 1)), lcs_recursion_brute_force(s1.substring(0, l1 - 1), s2));
    }


    public static int lcs_memo(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] memo = new int[l1 + 1][l2 + 1];
        for (int[] m : memo)
            Arrays.fill(m, -1);

        return lcs_memo(s1, s2, l1, l2, memo);
    }

    private static int lcs_memo(String s1, String s2, int l1, int l2, int[][] memo) {
        if (l1 == 0 || l2 == 0) return 0;
        if (memo[l1][l2] != -1)
            return memo[l1][l2];
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
            memo[l1][l2] = 1 + lcs_memo(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1), l1 - 1, l2 - 1, memo);
        else
            memo[l1][l2] = Math.max(lcs_memo(s1, s2.substring(0, l2 - 1)), lcs_memo(s1.substring(0, l1 - 1), s2));
        return memo[l1][l2];
    }

    public static int lcs_tabulation(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tb = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                else
                    tb[i][j] = Math.max(tb[i][j - 1], tb[i - 1][j]);
            }
        }
        return tb[l1][l2];
    }
}
