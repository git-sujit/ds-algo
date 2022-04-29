package com.sks.averma.dp.lcs;

import java.util.Arrays;

/**
 * Given two strings, return shortest-string common super-sequence
 * Sequence: Ordered but may not be continuous
 * Substring: Ordered & continuous
 */
public class ShortestCommonSuperSequence {
    /**
     * Get LCS and take lcs once for super-sequence => (s1-lcs)+lcs+(s2-lcs)
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public String scSuperSequence_string_better_NOT_WORKING(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] td = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    td[i][j] = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    td[i][j] = 1 + td[i - 1][j - 1];
                else
                    td[i][j] = Math.max(td[i - 1][j], td[i][j - 1]);
            }
        }
        /*-for (int[] t : td)
            System.out.println(Arrays.toString(t));
            */
        String result = "";
        int i = l1, j = l2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result += s1.charAt(i - 1);
                i--;
                j--;
            } else {
                // Move in max direction
                if (td[i][j - 1] > td[i - 1][j]) {
                    result = s2.charAt(j - 1) + result;
                    j--;
                } else {
                    result += s1.charAt(i - 1);
                    i--;
                }
            }
        }
        while (i > 0)
            result = s1.charAt(i--) + result;
        while (j > 0)
            result = s2.charAt(j--) + result;
        return result;
    }

    /**
     * Get LCS and take lcs once for super-sequence => (s1-lcs)+lcs+(s2-lcs)
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public String scSuperSequence_string(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        String result = "";
        String lcs = longestCommonSubsequence_string(s1, s2);
        int processed = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length() && processed < lcs.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            char pc = lcs.charAt(processed);
            if (c1 != pc) {
                result += c1;
                i++;
            }
            if (c2 != pc) {
                result += c2;
                j++;
            }
            if (c1 == c2 && c1 == pc) {
                result += pc;
                i++;
                j++;
                processed++;
            }
        }
        while (i < s1.length())
            result += s1.charAt(i++);
        while (j < s2.length())
            result += s2.charAt(j++);
        return result;
    }


    public String longestCommonSubsequence_string(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        int l1 = s1.length();
        int l2 = s2.length();
        String[][] td = new String[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    td[i][j] = "";
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

    /**
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public int scSuperSequence_length(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        return s1.length() + s2.length() - longestCommonSubsequence_length(s1, s2);
    }

    public int longestCommonSubsequence_length(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] td = new int[l1 + 1][l2 + 1];
        // Initialization
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0) td[i][j] = 0;
        // Induction
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    td[i][j] = 1 + td[i - 1][j - 1];
                else
                    td[i][j] = Math.max(td[i - 1][j], td[i][j - 1]);
            }
        }
        return td[l1][l2];
    }

    public static void main(String[] args) {
        demo("geek", "eke");
        demo("AGGTAB", "GXTXAYB");
        demo("abac", "cab");
        demo("bbabacaa", "cccababab");
    }

    private static void demo(String s1, String s2) {
        ShortestCommonSuperSequence obj = new ShortestCommonSuperSequence();
        System.out.println("\ns1 = " + s1 + ", s2 = " + s2);
        System.out.println("Longest Common Sub-Sequence = " + obj.longestCommonSubsequence_string(s1, s2));
        System.out.println("Shortest Common Super-Sequence String = " + obj.scSuperSequence_string(s1, s2));
        //System.out.println("[Better]Shortest Common Super-Sequence String = " + obj.scSuperSequence_string_better_NOT_WORKING(s1, s2));
        System.out.println("Shortest Common Super-Sequence Length = " + obj.scSuperSequence_length(s1, s2));
    }
}
