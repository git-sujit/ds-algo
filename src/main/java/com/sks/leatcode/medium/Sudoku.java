package com.sks.leatcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board.length != 9 || board[0].length != 9) return false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    if (!isValidRowColumn(i, j, board))
                        return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isvalid3_3box(i, j, board))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValidRowColumn(int row, int col, char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                if (rowSet.contains(board[row][i]))
                    return false;
                rowSet.add(board[row][i]);
            }
            if (board[i][col] != '.') {
                if (colSet.contains(board[i][col]))
                    return false;
                colSet.add(board[i][col]);
            }
        }
        return true;
    }

    private static boolean isvalid3_3box(int startRow, int startCol, char[][] board) {
        Set<Character> subBoxSet = new HashSet<>();
        int endRow = startRow + 2;
        int endCol = startCol + 2;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] != '.') {
                    if (subBoxSet.contains(board[i][j]))
                        return false;
                }
                subBoxSet.add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        demo(board);

        board[0][2] = '3';
        demo(board);
    }

    private static void demo(char[][] board) {
        System.out.println("\n:: Sudoku ::");
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
        System.out.println("Is Valid? : " + isValidSudoku(board));
    }
}
