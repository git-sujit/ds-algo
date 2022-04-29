package com.sks.averma.dp.mcm;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return min no of partition.
 * Note: We can have n-1 partitions to break into single char, which is palindrome
 */
public class PalindromePartition {
    /**
     * RECURSION
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int minPartitions(String s) {
        if (s == null || s.length() < 2) return 0;
        // Determine i,j
        return minPartitions(s, 0, s.length() - 1);
    }

    private static int minPartitions(String s, int i, int j) {
        // Base Condition: If s is empty, size 1 or already a palindrome
        if (i >= j || isPalindrome(s, i, j)) return 0;
        int min = Integer.MAX_VALUE;
        // K loop scheme
        for (int k = i; k <= j - 1; k++) {
            // Calculate temp ans
            int temp = 1 + minPartitions(s, i, k) + minPartitions(s, k + 1, j);
            min = Math.min(min, temp);
        }
        return min;
    }

    /**
     * RECURSION
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */
    public static int minPartitions_memoization(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length();
        int[][] mem = new int[len][len];
        for (int[] m : mem)
            Arrays.fill(m, -1);
        // Determine i,j
        return minPartitions_memoization(s, 0, s.length() - 1, mem);
    }

    private static int minPartitions_memoization(String s, int i, int j, int[][] mem) {
        if (i >= j || isPalindrome(s, i, j)) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = 1 + minPartitions_memoization(s, i, k, mem) + minPartitions_memoization(s, k + 1, j, mem);
            ans = Math.min(ans, temp);
        }
        return mem[i][j] = ans;
    }

    /**
     * RECURSION
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */
    public static int minPartitions_memoization_improved(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length();
        int[][] mem = new int[len][len];
        for (int[] m : mem) Arrays.fill(m, -1);
        return minPartitions_memoization_improved(s, 0, len - 1, mem);
    }

    private static int minPartitions_memoization_improved(String s, int i, int j, int[][] mem) {
        if (i >= j || isPalindrome(s, i, j)) return 0;
        int ans = Integer.MAX_VALUE;
        if (mem[i][j] != -1) return mem[i][j];
        for (int k = i; k <= j - 1; k++) {
            int left = mem[i][k] == -1 ? minPartitions_memoization_improved(s, i, k, mem) : mem[i][k];
            int right = mem[k + 1][j] == -1 ? minPartitions_memoization_improved(s, k + 1, j, mem) : mem[k + 1][j];
            int temp = 1 + left + right;
            ans = Math.min(ans, temp);
        }
        return mem[i][j] = ans;
    }

    private static boolean isPalindrome(String str, int s, int e) {
        for (int i = s, j = e; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                return false;
        return true;
    }

    public static void main(String[] args) {
        demo("sujit");
        demo("nitin");
        demo("aab");
        demo("aabaabcb");
        demo("abcba");
    }

    private static void demo(String s) {
        System.out.println("\n[Recursion] s = " + s + ", min no. of partition to make each as palindrome = " + minPartitions(s));
        System.out.println("[Memoization] s = " + s + ", min no. of partition to make each as palindrome = " + minPartitions_memoization(s));
        System.out.println("[Improved-Memoization] s = " + s + ", min no. of partition to make each as palindrome = " + minPartitions_memoization_improved(s));
    }
}
