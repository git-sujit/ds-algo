package com.sks.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class GraphRottingOranges {
    /**
     * Time Complexity : O(rows * cols)
     * Space Complexity: O(1), queue has at max 4 entries to it.
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int mins = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2)
                    q.add(new Pair(r, c));
            }
        }
        while (!q.isEmpty()) {
            Queue<Pair<Integer, Integer>> qTemp = new LinkedList<>();
            while (!q.isEmpty()) qTemp.add(q.remove());
            boolean flag = false;
            while (!qTemp.isEmpty()) {
                Pair<Integer, Integer> cord = qTemp.remove();
                int r = cord.getKey();
                int c = cord.getValue();
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    flag = true;
                    q.add(new Pair(r - 1, c));
                }
                if (r + 1 < rows && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    flag = true;
                    q.add(new Pair(r + 1, c));
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    flag = true;
                    q.add(new Pair(r, c - 1));
                }
                if (c + 1 < cols && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    flag = true;
                    q.add(new Pair(r, c + 1));
                }

            }
            if (flag) mins++;

        }
        return hasFreshOrange(grid, rows, cols) ? -1 : mins;
    }

    boolean hasFreshOrange(int[][] grid, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        demo(grid);
        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        demo(grid);
    }

    private static void demo(int[][] grid) {
        System.out.println("\nGrid:");
        for (int[] row : grid)
            System.out.println(Arrays.toString(row));
        System.out.println("Minimum minutes elapsed until no orange is fresh = " + new GraphRottingOranges().orangesRotting(grid));
    }

}
