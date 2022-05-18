package com.sks.averma.dp.lcs;

public class PrintLCS {
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
        System.out.println("[String-BETTER] LCS - Tabulation : " + print_lcs(s1, s2));
    }
}
