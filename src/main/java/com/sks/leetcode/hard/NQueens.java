package com.sks.leetcode.hard;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an [n x n] chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * Note: A queen can be attacked if another queen is on the same row, column, diagonal(row-col), or anti-diagonal(row+col).
 */
public class NQueens {
    /**
     * BRUTE-FORCE
     * A brute force solution would involve generating all possible board states with N queens.
     * There are N^2 possible squares to place the first queen, (N^2 - 1) to place the second and so on. This leads to a time complexity of O(N^2N), which is far too slow.
     * Example:  For 8 queens on a normal chessboard, let's say we place the first queen on the top left. Then, we place the second queen to its right.
     * There are 62 * 61 * ... * 57 = 44,261,653,680(44B) possible ways to place the remaining 6 queens,
     * but we already know that every single one of them is invalid, because the first 2 queens can attack each other.
     */
    /**
     * BACKTRACKING
     * This is a perfect problem for backtracking - place the queens one by one, and when all possibilities are exhausted, backtrack by removing a queen and placing it elsewhere.
     * Recall that to implement backtracking, we implement a backtrack function that
     * 1. makes some changes to the state,
     * 2. calls itself again,
     * 3. and then when that call returns it undoes those changes (this last part is why it's called "backtracking").
     */
    /**
     * Time Complexity : O(N!)
     * Space Complexity: O(n^2)
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        char[][] board = new char[n][n];
        for (char[] r : board)
            Arrays.fill(r, '.');
        backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, res);
        return res;
    }

    private void backtrack(int n, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, char[][] board, List<List<String>> res) {
        if (row == n) {
            res.add(boardToString(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int currDiag = row - col;
            int currAntiDiag = row + col;
            if (cols.contains(col) || diags.contains(currDiag) || antiDiags.contains(currAntiDiag))
                continue;
            //1. Add Queen To Board i.e change state
            cols.add(col);
            diags.add(currDiag);
            antiDiags.add(currAntiDiag);
            board[row][col] = 'Q';
            //2. Move to next row with updated board i.e call itself
            backtrack(n, row + 1, cols, diags, antiDiags, board, res);
            //3. backtrack- Remove the queen from board because we have explored all valid path
            cols.remove(col);
            diags.remove(currDiag);
            antiDiags.remove(currAntiDiag);
            board[row][col] = '.';
        }
    }

    private List<String> boardToString(char[][] board) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            out.add(new String(board[i]));
        return out;
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
        System.out.println("########################################");
        System.out.println("No. of Queens = " + n + ", Board = (" + n + "*" + n + ")");
        List<List<String>> sols = new NQueens().solveNQueens(n);
        System.out.println("No. of solutions = " + sols.size());
        for (int i = 0; i < sols.size(); i++) {
            System.out.println("## Solution-" + (i + 1) + " ##");
            for (String s : sols.get(i))
                System.out.println(s);
        }
    }
}
