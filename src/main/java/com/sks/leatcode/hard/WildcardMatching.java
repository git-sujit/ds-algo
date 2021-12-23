package com.sks.leatcode.hard;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */

/**
 * Refrasing: Glob patterns are used to refer multiple file_names on computer. Glob patter has two wild characters(*, ?)
 */
public class WildcardMatching {
    /**
     * RECURSION
     * Time Complexity
     * Space Complexity
     */
    public static boolean isMatch_recursion(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch_recursion(s, p, s.length(), p.length());
    }

    public static boolean isMatch_recursion(String s, String p, int ls, int lp) {
        if (ls <= 0 || lp <= 0) return true;
        if (p.charAt(lp - 1) == '*') {
            if (lp - 2 >= 0) {
                int c = p.charAt(lp - 2);
                while (ls > 0) {
                    if (s.charAt(ls - 1) == c)
                        return isMatch_recursion(s.substring(0, ls - 2), p.substring(0, lp - 3), ls - 1, lp - 2);
                    else
                        ls--;
                }
                if (ls <= 0)
                    return false;
            }
        } else {
            if (s.charAt(ls - 1) == p.charAt(lp - 1) || p.charAt(lp - 1) == '?')
                return isMatch_recursion(s.substring(0, ls - 1), p.substring(0, lp - 1), ls - 1, lp - 1);
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String p = "a*e?g";
        System.out.println("String = " + s + ", pattern = " + p + ", isMatched = " + isMatch_recursion(s, p));
    }
}
