package com.sks.averma.dp.lcs;

import java.util.Arrays;

/**
 * Given two strings, return the longest length of substring
 */
public class LongestCommonSubstring {
    /**
     * TOP-DOWN: Length
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public static int lcString(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int result = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tb = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    tb[i][j] = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tb[i][j] = 1 + tb[i - 1][j - 1];
                    result = Math.max(result, tb[i][j]);
                } else
                    tb[i][j] = 0;
            }
        }
        return result;
    }

    /**
     * TOP-DOWN: String
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public static String print_lcString(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "";
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
        String resStr = "";
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                resStr = s1.charAt(i - 1) + resStr;
                i--;
                j--;
            } else {
                if (tb[i - 1][j] > tb[i][j - 1])
                    i--;
                else
                    j--;
            }

        }
        return resStr;
    }

    /**
     * RECURSION
     * Time Complexity : O(2^min(l1,l2))
     * Space Complexity: O(2^min(l1,l2))
     */
    static int lMax = 0;

    public static int lcString_recursion(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        lcString_recursion(s1, s2, s1.length(), s2.length(), 0);
        return lMax;
    }

    private static void lcString_recursion(String s1, String s2, int l1, int l2, int l) {
        if (l1 == 0 || l2 == 0) return;
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            lMax = Math.max(l + 1, lMax);
            lcString_recursion(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1), l1 - 1, l2 - 1, l + 1);
        } else {
            lcString_recursion(s1.substring(0, l1 - 1), s2, l1 - 1, l2, 0);
            lcString_recursion(s1, s2.substring(0, l2 - 1), l1, l2 - 1, 0);
        }
    }

    /**
     * MEMOIZATION
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    static int lMax_memo = 0;

    public static int lcString_memoization(String s1, String s2) {
        if (s1.length() == s2.length()) return 0;
        int l1 = s1.length(), l2 = s2.length();
        int[][] memo = new int[l1 + 1][l2 + 1];
        for (int[] m : memo)
            Arrays.fill(m, -1);
        lcString_memoization(s1, s2, l1, l2, 0, memo);
        return lMax_memo;
    }

    private static int lcString_memoization(String s1, String s2, int l1, int l2, int l, int[][] memo) {
        if (l1 == 0 || l2 == 0) return 0;
        if (memo[l1][l2] != -1) return memo[l1][l2];
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            lMax_memo = Math.max(lMax_memo, l + 1);
            memo[l1][l2] = 1 + lcString_memoization(s1.substring(0, l1 - 1), s2.substring(0, l2 - 1), l1 - 1, l2 - 1, l + 1, memo);

        } else {
            memo[l1][l2] = Math.max(lcString_memoization(s1.substring(0, l1 - 1), s2, l1 - 1, l2, 0, memo),
                    lcString_memoization(s1, s2.substring(0, l2 - 1), l1, l2 - 1, 0, memo));
        }
        return memo[l1][l2];
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("Longest common string length = " + lcString(s1, s2));
        System.out.println("[Recursion] Longest common string length = " + lcString_recursion(s1, s2));
        System.out.println("[Memoization] Longest common string length = " + lcString_memoization(s1, s2));
        System.out.println("[Length-Tabulation] Longest common string length = " + lcString(s1, s2));
        System.out.println("[String-Tabulation] Longest common string length = " + print_lcString(s1, s2));
    }
}
