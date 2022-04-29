package com.sks.averma.dp.lcs;

/**
 * Given a string return the longest repeating subsequence
 */
public class LongestRepeatingSubsequence {
    /**
     * Time Complexity : O(l^2), l is length of string
     * Space Complexity: O(l^2)
     */
    public static int lrs(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int l = s.length();
        return lcs_repeating(s, s, l);
    }

    private static int lcs_repeating(String s1, String s2, int l) {
        int[][] tb = new int[l + 1][l + 1];
        for (int i = 0; i <= l; i++)
            for (int j = 0; j <= l; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (i != j && s1.charAt(i - 1) == s2.charAt(j - 1))
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                else
                    tb[i][j] = Math.max(tb[i - 1][j], tb[i][j - 1]);
            }
        }
        return tb[l][l];
    }

    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println("s = " + s + ", longest repeating subsequence = " + lrs(s));
    }
}
