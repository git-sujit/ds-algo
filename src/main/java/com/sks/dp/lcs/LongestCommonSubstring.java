package com.sks.dp.lcs;

import java.util.Arrays;

public class LongestCommonSubstring {
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
        for (int[] t : tb)
            System.out.println(Arrays.toString(t));
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("Longest common string length = " + lcString(s1, s2));
    }
}
