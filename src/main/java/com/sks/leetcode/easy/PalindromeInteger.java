package com.sks.leetcode.easy;

public class PalindromeInteger {

    // Time Complexity: O(log10(n)), we are dividing the input by 10 every iteration
    // Space Complexity: O(1)
    private static boolean isPalindrome(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0))
            return false;
        int rev = 0;
        while (num > rev) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return num == rev || num == rev / 10;
    }

    private static boolean bruteForce(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0))
            return false;
        int rev = 0;
        int x = num;
        while (x != 0) {
            rev = (rev * 10 + x % 10);
            x /= 10;
        }
        return num == rev;
    }

    public static void main(String[] args) {
        int[] inputs = {-121, 0, 121, 10, 1234, 1234321};
        for (int n : inputs) {
            System.out.println("num = " + n + " : isPalindrome = " + isPalindrome(n) + ", bruteForce = " + bruteForce(n));
        }
    }
}
