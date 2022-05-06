package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * Ideas: 2d Grid Traversal Problem, Similar to Robot Room Cleaner
 * Backtracking more thoroughly solves the problem than DFS
 */
/*- Code Pattern/Skeleton for Backtracking
    Loop that iterates through each cell in the grid
        For each cell, invoke backtracking function to check if we would obtain a solution starting at this cell
        backtrack() function as DFS recursive algorithm
 */
public class WordSearch {
    /**
     * Time Complexity : O(N*3^L), N is number of cells in board. 3-arry tree
     * Space Complexity: O(L), L is length of word, Max length of call stack will be length of word
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        // Call backtrack function for each cell of the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, rows, cols, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int rows, int cols, int idx) {
        // Base Case: word is found
        if (idx == word.length()) return true;
        // Is cell out of boundary i.e invalid input (i,j)
        if (i < 0 || i == rows || j < 0 || j == cols) return false;
        // Valid input but not matching the word
        if (board[i][j] != word.charAt(idx)) return false;
        // Mark cell as visited, setting cell to non-alphabetic char
        board[i][j] = '#';
        //board[i][j] ^= 256;
        // Iterate through four possible directions: Backtracking with strategy of DFS
        boolean ex = backtrack(board, word, i - 1, j, rows, cols, idx + 1)
                || backtrack(board, word, i + 1, j, rows, cols, idx + 1)
                || backtrack(board, word, i, j - 1, rows, cols, idx + 1)
                || backtrack(board, word, i, j + 1, rows, cols, idx + 1);
        //board[i][j] ^= 256;
        // Revert back the cell to its original value/state
        board[i][j] = word.charAt(idx);
        return ex;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        demo(board, word);
        char c = board[0][0];
        System.out.println(board[0][1]);
        board[0][1] ^= 256;
        System.out.println(board[0][1]);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCCED";
        demo(board, word);
    }

    private static void demo(char[][] board, String word) {
        System.out.println("\nword = " + word);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println("Exists? :" + exist(board, word));
    }
}
