package com.sks.leetcode.easy;

/**
 * A bracket is any of the following characters: (, ), {, }, [, or ].
 * a sequence of brackets is said to be balanced if
 * -The sequence is empty, or
 * -The sequence is composed of two or more non-empty sequences, all of which are balanced, or
 * -The first and last brackets of the sequence are matching, and the portion of the sequence without the first and last elements is balanced.
 */
public class BalaceBrackets {
    public static boolean isBalanced(String s) {
        if (s == null || s.isEmpty()) return true;
        int len = s.length();
        return isMatching(s.charAt(0), s.charAt(len - 1)) && isBalanced(s.substring(1, len - 1));
    }

    private static boolean isMatching(char ob, char cb) {
        return (ob == '{' && cb == '}') || (ob == '(' && cb == ')') || (ob == '[' && cb == ']');
    }

    public static void main(String[] args) {
        String s = "{[(])}";
        demo(s);
        s = "{{[[(())]]}}";
        demo(s);
    }

    private static void demo(String s) {
        System.out.println("\nSequence of brackets : " + s);
        System.out.println("Is balanced? : " + isBalanced(s));
    }
}
