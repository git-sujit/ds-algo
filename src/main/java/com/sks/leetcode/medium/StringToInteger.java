package com.sks.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringToInteger {
    public static int myAtoi(String s) {
        Set<Character> digits = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        String validNumStr = "";
        boolean isNegative = false;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '-' || c == '+' || digits.contains(c)) {
                if (c == '-') isNegative = true;
                else validNumStr += c;
                break;
            } else break;
        }
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '0' || digits.contains(c))
                validNumStr += c;
            else break;
        }
        System.out.println("validNumStr = " + validNumStr + ", isNegative = " + isNegative);
        if (validNumStr.isEmpty()) return 0;
        long out = Long.valueOf(validNumStr);
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        if (isNegative && out > Math.abs(min))
            return Integer.MIN_VALUE;
        else if (out > max)
            return Integer.MAX_VALUE;
        else return isNegative ? Integer.valueOf(validNumStr) * -1 : Integer.valueOf(validNumStr);
    }

    public static void main(String[] args) {
        String s = "1";
        test(s);

        s = "20000000000000000000";
        test(s);

        s = "words and 987";
        test(s);

        s = "42";
        test(s);

        s = "   -42";
        test(s);

        s = "4193 with words";
        test(s);

        s = "0032";
        test(s);

        s = "-    900000 is good number 1234";
        test(s);

        s = "2157234123";
        test(s);

        s = "42";
        test(s);
    }

    private static void test(String s) {
        System.out.println("\nString = " + s);
        System.out.println("Integer = " + myAtoi(s));
    }
}
