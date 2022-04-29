package com.sks.averma.dp.lcs;

/**
 * Given string S1 & S2, return min. no. of insertions & deletion of chars to convert S1 to S2
 */
public class MinInsertionDeletionToConvert {
    /**
     * Time Complexity : O(l1*l2)
     * Space Complexity: O(l1*l2)
     */
    public int minInsertionDeletion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l = lcs_length(s1, s2, l1, l2);
        int noOfDeletion = l1 - l;
        int noOfInsertion = l2 - l;
        return noOfDeletion + noOfInsertion;
    }

    private int lcs_length(String s1, String s2, int l1, int l2) {
        int[][] td = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                td[i][j] = 0;
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

    /**
     * LCS - String
     */
    private String lcs_string(String s1, String s2, int l1, int l2) {
        if (s1 == null || s2 == null) return "";
        String[][] td = new String[l1 + 1][l2 + 1];
        // Initialization
        for (int i = 0; i <= l1; i++)
            for (int j = 0; j <= l2; j++)
                if (i == 0 || j == 0)
                    td[i][j] = "";
        // Induction
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
        String s1 = "heap";
        String s2 = "pea";
        demo(s1, s2);
    }

    private static void demo(String s1, String s2) {
        MinInsertionDeletionToConvert obj = new MinInsertionDeletionToConvert();
        System.out.println("\ns1 = " + s1 + ", s2 = " + s2);
        System.out.println("Minimum no. of insertion/deletion to convert s1 to s2 = " + obj.minInsertionDeletion(s1, s2));
    }
}
