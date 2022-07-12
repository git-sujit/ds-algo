package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Given sorted alphabatic array of characters. Find next letter of a given letter in the array
 */
public class NextAlphabet {
    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static char findNextAlphabet(char[] ca, char c) {
        if (ca == null || ca.length == 0) return ' ';
        int len = ca.length;
        int s = 0;
        int e = len - 1;
        char result = ' ';
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ca[mid] == c) s = mid + 1;
            else if (c < ca[mid]) {
                result = ca[mid];
                e = mid - 1;
            } else if (c > ca[mid])
                s = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        testAlphabet();
    }

    private static void testAlphabet() {
        char[] ca = {'a', 'c', 'e', 'h', 'k', 'l', 't'};
        char c = 'g';
        System.out.println("Array = " + Arrays.toString(ca));
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
        c = 'k';
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
        c = 't';
        System.out.println("Character = " + c + ", Next Alphabet = " + findNextAlphabet(ca, c));
    }
}
