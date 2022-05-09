package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Given sorted alphabetic array of characters. find next letter of a given letter.
 */
public class NextLetterProblem {
    public char nextLetter(char[] ca, char ch) {
        if (ca == null || ca.length == 0) return ' ';
        int s = 0;
        int e = ca.length - 1;
        char res = ' ';
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (ch < ca[m]) {
                res = ca[m];
                e = m - 1;
            } else if (ch == ca[m]) {
                return m < ca.length - 1 ? ca[m + 1] : ' ';
            } else s = m + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] ca = {'a', 'c', 'f', 'h'};
        char ch = 'g';
        demo(ca, ch);

        ch = 'h';
        demo(ca, ch);
    }

    private static void demo(char[] ca, char ch) {
        System.out.println("\nChar Array = " + Arrays.toString(ca) + ", Char = " + ch);
        System.out.println("Next char = " + new NextLetterProblem().nextLetter(ca, ch));
    }
}
