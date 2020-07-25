package com.sks.algo2020.club;

/**
 * @author : Sujit K Singh
 * Purpose : Given a string, find longest palindromic substring
 */
public class LongestPalindromicSubstring {
    public static String manachersAlgorithm(String str) {
        if (str == null || str.isEmpty()) return "";
        StringBuilder ps = new StringBuilder("#");
        for (char c : str.toCharArray())
            ps.append(c).append("#");
        str = ps.toString();
        System.out.println("Padded String = " + str);
        return "";
    }

    // Time: O(n2) Space: O(1)
    public static String lps_expandingAroundCenterAlgorithm(String str) {
        if (str == null || str.isEmpty()) return "";
        int l = str.length();
        int s = 0, e = 0;
        for (int i = 0; i < l; i++) {
            // Each character as Center of Palindrome i.e Odd length palindrome
            for (int d = 1; i - d >= 0 && i + d < l; d++) {
                if (str.charAt(i - d) == str.charAt(i + d)) {
                    if (2 * d + 1 > e - s) {
                        s = i - d;
                        e = i + d;
                    }
                } else break;
            }
            // Space between characters as Center of Palindrome i.e Even length palindrome
            for (int d = 1; i - d + 1 >= 0 && i + d < l; d++) {
                if (str.charAt(i - d + 1) == str.charAt(i + d)) {
                    if (2 * d > e - s) {
                        s = i - d + 1;
                        e = i + d;
                    }
                } else break;
            }
        }
        return str.substring(s, e + 1);
    }

    // Time: O(n2) Space: O(n2) because of 2D array
    public static String lps_dynamicProgramming(String str) {
        if (str == null || str.isEmpty()) return "";
        int l = str.length();
        boolean[][] pa = new boolean[l][l];
        for (int d = 0; d < l; d++)
            for (int i = 0; i + d < l; i++) {
                if (d == 0) pa[i][i + d] = true;
                else if (d == 1) pa[i][i + d] = isSameChar(str, i, i + d);
                else pa[i][i + d] = (isSameChar(str, i, i + d) && pa[i + 1][i + d - 1]);
            }
        //for (boolean[] b : pa)
        //System.out.println(Arrays.toString(b));
        int s = 0, e = 1;
        for (int i = 0; i < l; i++)
            for (int j = l; j > i; j--) {
                if (pa[i][j - 1] && j - i > e - s) {
                    s = i;
                    e = j;
                }
            }
        return str.substring(s, e);
    }

    private static boolean isSameChar(String str, int i, int j) {
        return str.charAt(i) == str.charAt(j);
    }

    // Time: O(n3) Space: O(1) because storing 2 indexes only
    public static String naive_improved(String str) {
        if (str == null || str.isEmpty()) return "";
        int s = 0, e = 0, l = str.length();
        for (int i = 0; i < l; i++)
            for (int j = l - 1; j >= i; j--)
                if (isPalindrome(str.substring(i, j)) && j - i > e - s) {
                    s = i;
                    e = j;
                }
        return str.substring(s, e);
    }

    // Time: O(n3) Space: O(n) to store the maxPalStr
    public static String naive(String str) {
        int l = str.length();
        String maxPalStr = "";
        for (int i = 0; i < l; i++) {
            for (int j = l; j > i; j--) {
                String sub = str.substring(i, j);
                if (isPalindrome(sub) && sub.length() > maxPalStr.length())
                    maxPalStr = sub;
            }
        }
        return maxPalStr;
    }

    // Time: O(n) Space: O(1)
    public static boolean isPalindrome(String str) {
        int l = str.length();
        boolean flag = true;
        for (int i = 0, j = l - 1; i < l / 2 && i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j)) flag = false;
        return flag;
    }

    // Time: O(n) Space: O(n) Method stack memory
    public static boolean isPalindrome_recursive(String str) {
        if (str.isEmpty() || str.length() == 1) return true;
        int l = str.length();
        return str.charAt(0) == str.charAt(l - 1) && isPalindrome_recursive(str.substring(1, l - 1));
    }

    public static void main(String[] args) {
        String s = "aaaabcda";
        printOutput(s);
        testCases();
    }

    private static void testCases() {
        String s = "abba";
        printOutput(s);

        s = "abcba";
        printOutput(s);

        s = "abaxabaxabb";
        printOutput(s);

        s = "aaaabbaa";
        printOutput(s);

        s = "abcba";
        printOutput(s);
    }

    public static void printOutput(String str) {
        System.out.println("##### Input String = " + str);
        //System.out.println("\tIs palindrome? " + isPalindrome(str));
        //System.out.println("\tIs palindrome_rec? " + isPalindrome_recursive(str));
        System.out.println("\tNaive- Max Length Palindrome = " + naive(str));
        System.out.println("\tNaive_Improved- Max Length Palindrome = " + naive_improved(str));
        System.out.println("\tDynamic_Programming- Max Length Palindrome = " + lps_dynamicProgramming(str));
        System.out.println("\tExpanding_Around_Center Algorithm- Max Length Palindrome = " + lps_expandingAroundCenterAlgorithm(str));
        System.out.println("\tManacher's Algorithm- Max Length Palindrome = " + manachersAlgorithm(str));
    }
}
