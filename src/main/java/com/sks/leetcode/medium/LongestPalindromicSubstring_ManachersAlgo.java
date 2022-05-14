package com.sks.leetcode.medium;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring_ManachersAlgo {
    public String longestPalindrome_DP_LCS(String s) {
        return "";
    }

    public String longestPalindrome(String s) {
        // Boundary Condition
        if (s == null)
            return s;
        int length = s.length();
        if (length < 2)
            return s;
        // Dynamic Programming Technique
        boolean[][] isPalindrome = new boolean[length][length];
        int left = 0;
        int right = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;
                if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {
                    isPalindrome[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public String longestPalindrome_ManacharsAlgo(String text) {
        int N = text.length();
        if (N == 0)
            return "";
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++) {

            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if match then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2)))) {
                L[i]++;
            }

            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }

            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        String out = "";
        //System.out.printf("LPS of string is %s : ", text);
        for (i = start; i <= end; i++)
            out += text.charAt(i);

        return out;
    }

    public static void main(String[] args) {
        String s = "babad";
        demo(s);
    }

    private static void demo(String s) {
        System.out.println("String = " + s);
        System.out.println("Longest Palindromic Substring = " + new LongestPalindromicSubstring_ManachersAlgo().longestPalindrome(s));
        System.out.println("[Manachar's Algo] Longest Palindromic Substring = " + new LongestPalindromicSubstring_ManachersAlgo().longestPalindrome_ManacharsAlgo(s));
        System.out.println("[DP-LCS] Longest Palindromic Substring = " + new LongestPalindromicSubstring_ManachersAlgo().longestPalindrome_DP_LCS(s));
    }
}
