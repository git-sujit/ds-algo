package com.sks.averma.dp.lcs;

/**
 * Note: Min np. of insertions = Min No. of deletions
 * Given a string, return minimum no. of insertion to make it palindrome.
 */
public class MinInsertionToPalindrome {
    /**
     * Time Complexity : O(n^2), n is length of string
     * Space Complexity: O(n^2)
     */
    public static int minInsertionToPalin(String s) {
        if (s == null || s.length() == 0) return 0;
        int l = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int lps = lps(s, r, l);
        System.out.println("lps = " + lps);
        return l - lps;
    }

    private static int lps(String s, String r, int l) {
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
                    tb[i][j] = Math.max(tb[i - 1][j], tb[i][j - 1]);
            }
        }
        return tb[l][l];
    }

    public static void main(String[] args) {
        String s = "aebebda";
        System.out.println("s = " + s + ", min no. of insertion = " + minInsertionToPalin(s));
    }
}
