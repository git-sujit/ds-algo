package com.sks.leetcode.hard;

import java.util.*;

public class NQueensCount {
    /**
     * Time Complexity : O(N!)
     * Space Complexity: O(n^2)
     */
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        int[] solCount = {0};
        char[][] board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, solCount);
        return solCount[0];
    }

    private void backtrack(int n, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, char[][] board, int[] solCount) {
        if (row == n) solCount[0]++;
        for (int col = 0; col < n; col++) {
            int diag = row - col;
            int antiDiag = row + col;
            if (cols.contains(col) || diags.contains(diag) || antiDiags.contains(antiDiag)) continue;
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            backtrack(n, row + 1, cols, diags, antiDiags, board, solCount);

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);
        }
    }

    public static void main(String[] args) {
        demo(1);
        demo(2);
        demo(3);
        demo(4);
        demo(5);
        demo(6);
        demo(7);
        demo(8);
    }

    private static void demo(int n) {
        System.out.println("\nNo. of Queens = " + n + ", Board = (" + n + "*" + n + ")");
        System.out.println("No. of solutions = " + new NQueensCount().totalNQueens(n));
    }
}
