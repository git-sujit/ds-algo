package com.sks.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

public class BinarySubstrings {
    /**
     * Time Complexity: O(N), where N is the length of s. Every loop is through O(N) items with O(1) work inside the for-block.
     * Space Complexity: O(1), the space used by prev, cur, and ans.
     */
    public static int countBinarySubstrings_improved(String s) {
        if (s == null || s.length() == 0) return -1;
        int count = 0;
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) curr++;
            else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        return count + Math.min(prev, curr);
    }

    /**
     * Time Complexity: O(N), where N is the length of s. Every loop is through O(N) items with O(1) work inside the for-block.
     * Space Complexity: O(N), the space used by groups.
     */
    public static int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return -1;
        int count = 0;
        int[] groups = consecutiveCount(s);
        System.out.println("groups = " + Arrays.toString(groups));
        for (int i = 1; i < s.length(); i++)
            count += Math.min(groups[i - 1], groups[i]);
        return count;
    }

    private static int[] consecutiveCount(String s) {
        int[] cc = new int[s.length()];
        int t = 0;
        cc[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) cc[t]++;
            else cc[++t] = 1;
        }
        return cc;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) for stacks
     */
    public static int countBinarySubstrings_incorrect(String s) {
        if (s == null || s.length() == 0) return -1;
        int count = 0;
        Stack<Character> zeroStack = new Stack<>();
        Stack<Character> oneStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (!oneStack.isEmpty()) {
                    oneStack.pop();
                    count++;
                }
                zeroStack.push('0');
            } else if (c == '1') {
                if (!zeroStack.isEmpty()) {
                    zeroStack.pop();
                    count++;
                }
                oneStack.push('1');
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "00110011";
        test(s);

        s = "1";
        test(s);
        s = "0";
        test(s);
        s = "01";
        test(s);

        s = "10101";
        test(s);

        s = "110001111000000";
        test(s);
    }

    private static void test(String s) {
        System.out.println("\nString = " + s);
        System.out.println("[Improved] Number of binary substrings = " + countBinarySubstrings_improved(s));
        System.out.println("Number of binary substrings = " + countBinarySubstrings(s));
        System.out.println("[Stacks]Number of binary substrings = " + countBinarySubstrings_incorrect(s));
    }
}
