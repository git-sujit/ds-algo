package com.sks.XDEPRECATED.algo2020.club.pattern_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Sujit K Singh
 * Purpose : Knuth-Morris-Pratt Algorithm
 * KMP is string-searching algorithm
 * Searches for occurrences of a "word" W within a main "text string" S
 * First linear-time algorithm for string matching
 * Application of pattern Matching Algos: Search for a string in notepad/word file or browser or database
 */
public class KnuthMorrisPrattAlgo {
    /**
     * This method returns the index for the first match of the pattern into the index.
     * It will return -1 in case it does not match
     */
    public static int search_firstMatch(char[] txt, char[] pat) {
        int[] lps = computeLPSTable(pat);
        int j = 0;
        for (int i = 0; i < txt.length; i++) {
            while (j > 0 && txt[i] != pat[j]) j = lps[j - 1];
            if (txt[i] == pat[j]) {
                j++;
                if (j == pat.length) return i - (j - 1);
            }
        }
        return -1;
    }

    public static List<Integer> search_allMatches(char[] txt, char[] pat) {
        List<Integer> matches = new ArrayList<>();

        return matches;
    }

    private static int[] computeLPSTable(char[] pat) {
        int l = pat.length;
        int[] lps = new int[l];
        int j = 0;
        for (int i = 1; i < l; i++) {
            while (j > 0 && pat[j] != pat[i]) j = lps[j - 1];
            if (pat[j] == pat[i]) lps[i] = ++j;
            else lps[i] = 0;
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "susujsujisujitsjfikmshhmchuyribs";
        String pattern = "sujit";
        printOutput(text, pattern);

        text = "abcdsababbabbaaabaabcdabcaabcbcbbabbac";
        pattern = "abcdabca";
        printOutput(text, pattern);

        text = "sjkfhjksdhbbbaabcbcbaabaabaaadncbbdgjd";
        pattern = "aabaabaaa";
        printOutput(text, pattern);
    }

    private static void printOutput(String text, String pattern) {
        System.out.println("Longest Prefix-Suffix table for Pattern [" + pattern + "] = " + Arrays.toString(computeLPSTable(pattern.toCharArray())));
        System.out.println("Pattern [" + pattern + "] found in Text [" + text + "] at index = " + search_firstMatch(text.toCharArray(), pattern.toCharArray()));
    }
}
