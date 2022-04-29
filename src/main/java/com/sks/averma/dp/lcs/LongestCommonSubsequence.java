package com.sks.averma.dp.lcs;

import java.util.Arrays;

/**
 * Give two strings, return the length of longest common subsequence
 */
public class LongestCommonSubsequence {
    /**
     * TOP-DOWN: length of sub-sequence
     * Time Complexity : O(l1*l2), We are going to each characters of String 1 & 2
     * Space Complexity: O(l1*l2), l1 & l2 are length of Strings
     */
    public static int lcs_tabulation_length(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tb = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                else
                    tb[i][j] = Math.max(tb[i][j - 1], tb[i - 1][j]);
            }
        }
        return tb[l1][l2];
    }

    /**
     * TOP-DOWN: print sub-sequence
     * Time Complexity : O(l1*l2), We are going to each characters of String 1 & 2
     * Space Complexity: O(l1*l2), l1 & l2 are length of Strings
     */
    public static String print_lcs(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "";
        String result = "";
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tb = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                tb[i][j] = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                else
                    tb[i][j] = Math.max(tb[i - 1][j], tb[i][j - 1]);
            }
        }
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result = s1.charAt(i - 1) + result;
                i--;
                j--;
            } else {
                if (tb[i - 1][j] > tb[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return result;
    }

    /**
     * RECURSION
     * Time Complexity : O(2^min(l1,l2)), When all characters mismatch
     * Space Complexity: O(l1*l2), N & M are length of Strings
     */
    public static int lcs_recursion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > 5 && l2 > 5) {
            System.out.println("***Recursion will be very time taking");
            return -1;
        }
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return 1 + lcs_recursion(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1));
        } else
            return Math.max(lcs_recursion(s1, s2.substring(0, l2 - 1)), lcs_recursion(s1.substring(0, l1 - 1), s2));
    }

    /**
     * MEMOIZATION
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*2), l1 & l1 are length of Strings
     */
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
        if (memo[l1][l2] != -1) return memo[l1][l2];
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
            memo[l1][l2] = 1 + lcs_memo(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1), l1 - 1, l2 - 1, memo);
        else
            memo[l1][l2] = Math.max(lcs_memo(s1, s2.substring(0, l2 - 1), l1, l2 - 1, memo),
                    lcs_memo(s1.substring(0, l1 - 1), s2, l1 - 1, l2, memo));
        return memo[l1][l2];
    }


    /**
     * Sub-sequence String
     * Time Complexity : O(l1*l2), We are going to each characters of String 1 & 2
     * Space Complexity: O(l1*l2), l1 & l2 are length of Strings
     */
    public static String lcs_tabulation_string_OK(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int l1 = s1.length();
        int l2 = s2.length();
        String[][] td = new String[l1 + 1][l2 + 1];
        // Initialization
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0) td[i][j] = "";
        //Induction
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    td[i][j] = td[i - 1][j - 1] + s1.charAt(i - 1);
                else
                    td[i][j] = td[i - 1][j].length() > td[i][j - 1].length() ? td[i - 1][j] : td[i][j - 1];
            }
        }
        return td[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "acbd";
        String s2 = "cbdae";
        test(s1, s2);

        s1 = "pmjghexybyrgzczy";
        s2 = "hafcdqbgncrcbihkd";
        test(s1, s2);

        s1 = "geek";
        s2 = "eke";
        test(s1, s2);
    }

    private static void test(String s1, String s2) {
        System.out.println("\ns1 = " + s1 + ", s2 = " + s2);
        System.out.println("LCS - Recursion : " + lcs_recursion(s1, s2));
        System.out.println("LCS - DP_Memo : " + lcs_memo(s1, s2));
        System.out.println("LCS - Tabulation : " + lcs_tabulation_length(s1, s2));
        System.out.println("[String] LCS - Tabulation : " + lcs_tabulation_string_OK(s1, s2));
        System.out.println("[String-BETTER] LCS - Tabulation : " + print_lcs(s1, s2));
    }
}
