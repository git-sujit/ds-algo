package com.sks.dp.lcs;

import java.util.Arrays;

public class LowestCommonSubsequence {

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

    public static int lcs_tabulation(String s1, String s2) {
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

    public static void main(String[] args) {
        String s1 = "acbd";
        String s2 = "cbdae";
        test(s1, s2);

        s1 = "pmjghexybyrgzczy";
        s2 = "hafcdqbgncrcbihkd";
        test(s1, s2);
    }

    private static void test(String s1, String s2) {
        System.out.println("\ns1 = " + s1 + ", s2 = " + s2);
        System.out.println("LCS - Recursion : " + lcs_recursion(s1, s2));
        System.out.println("LCS - DP_Memo : " + lcs_memo(s1, s2));
        System.out.println("LCS - Tabulation : " + lcs_tabulation(s1, s2));
    }
}
