package com.sks.algo2020.algoexperts.easy;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class Palindrome {
    public static boolean isPalindrome_Time_O_n_Space_O_1(String str) {
        if (str == null)
            return false;
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome_reverse(String str) {
        if (str == null)
            return false;

        String rev = "";
        char[] charArr = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += charArr[i];
        }
        return rev.equals(str);
    }

    public static boolean isPalindrome_recursion(String str, int index) {
        if (str == null)
            return false;
        int len = str.length();
        if (index >= (len - 1 - index))
            return true;
        if (str.charAt(index) != str.charAt(len - 1 - index))
            return false;
        return isPalindrome_recursion(str, ++index);
    }

    public static void main(String[] args) {
        int i = 98;
        int j = 20;
        System.out.println("Batches = " + Math.round((float)i / j));
       // testPlan();
        String str = "aba";
        System.out.println(str + " : " + isPalindrome_recursion(str, 0));
    }

    private static void testPlan() {

        String[] palList = {null, "a", "ab", "aba", "abba", "abcdef", "abcba", "malyalam"};
        for (String str : palList) {
            System.out.println(str + " : " + isPalindrome_Time_O_n_Space_O_1(str));
        }
        System.out.println("### Reverse Approach");

        for (String str : palList) {
            System.out.println(str + " : " + isPalindrome_reverse(str));
        }
        System.out.println("### Recursion Approach");
        for (String str : palList) {
            System.out.println(str + " : " + isPalindrome_recursion(str, 0));
        }
    }
}
