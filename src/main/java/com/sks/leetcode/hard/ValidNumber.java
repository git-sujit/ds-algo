package com.sks.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidNumber {
    /**
     * Time Complexity : O(n), n = length of string
     * Space Complexity: O(1)
     */
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                seenDigit = true;
            } else if (curr == '+' || curr == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (curr == 'e' || curr == 'E') {
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (curr == '.') {
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }

    public boolean isNumber_partial(String s) {
        if (s == null || s.length() == 0) return false;
        Set<Character> signs = new HashSet<>(Arrays.asList('+', '-'));
        Set<Character> digits = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        Set<Character> exps = new HashSet<>(Arrays.asList('e', 'E'));
        boolean hasSign = false;
        boolean hasDec = false;
        boolean hasExp = false;
        boolean hasDigit = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (signs.contains(ch)) {
                if (hasSign || i != 0) return false;
                else hasSign = true;
            } else if (ch == '.') {
                if (hasDec) return false;
                else hasDec = true;
            } else if (digits.contains(ch)) {
                if (!hasDigit) hasDigit = true;
            } else if (exps.contains(ch)) {
                if (hasExp || i == 0) return false;
                else hasExp = true;
            } else return false;
        }
        return hasDigit;
    }

    public static void main(String[] args) {
        ValidNumber obj = new ValidNumber();
        String[] nums = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String num : nums) {
            System.out.println("Number: " + num + ", is valid? : " + obj.isNumber(num));
        }
    }
}
