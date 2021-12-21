package com.sks.leatcode.hard;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * Note: A queen can be attacked if another queen is on the same row, column, diagonal, or anti-diagonal.
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
     * Recall that to implement backtracking, we implement a backtrack function that makes some changes to the state, calls itself again,
     * and then when that call returns it undoes those changes (this last part is why it's called "backtracking").
     */
}
