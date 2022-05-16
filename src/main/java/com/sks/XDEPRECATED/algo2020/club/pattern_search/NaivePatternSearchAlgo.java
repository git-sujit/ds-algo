package com.sks.XDEPRECATED.algo2020.club.pattern_search;

/**
 * @author : Sujit K Singh
 * @ Purpose : Given a text txt[0..n-1] and a pattern pat[0..m-1],
 * write a function search(String pattern, String text) that
 * prints all occurrences of pattern in text. You may assume that n > m.
 * n = length of text
 * m = length of pattern
 * @ Time Complexity: Best Case - O(n), When first character of Patter is not in Text
 * - Worst Case -  O(m*(n-m+1) , When all characters of text and patterns are same or only last character is different
 * - KMPimproves the worst case to O(n)
 * @ Space Complexity: O(1), no additional memory dependent on n or m
 */
public class NaivePatternSearchAlgo {
    public static void naivePS(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++)
                if (text.charAt(i + j) != pattern.charAt(j)) break;
            if (j == m)
                System.out.println("Pattern (" + pattern + ") found in Text (" + text + ") at index: " + i);
        }
    }

    public static void main(String[] args) {
        String text = "susujsujisujitsjfikmshhmchuyribs";
        String pattern = "sujit";
        naivePS(text, pattern);

        //WORST CASE: O(n(n-m+1))
        text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        pattern = "AAA";
        naivePS(text, pattern);

        //BEST CASE: O(n)
        text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        pattern = "BAA";
        naivePS(text, pattern);

        text = "abcdsababbabbaaabaabcdabcaabcbcbbabbac";
        pattern = "abcdabca";
        naivePS(text, pattern);

        text = "sjkfhjksdhbbbaabcbcbaabaabaaadncbbdgjdaabaabaaaiwyiurgaabaabaaa";
        pattern = "aabaabaaa";
        naivePS(text, pattern);
    }
}
