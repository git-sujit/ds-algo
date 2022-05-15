package com.sks.leetcode.easy;

import java.util.Arrays;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes",
 */
public class IslandPerimeter {
    /**
     * Time Complexity : O(rows * cols)
     * Time Complexity : O(rows * cols) for storing grid
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int land = 0;
        int common = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i + 1 < rows && grid[i + 1][j] == 1) common++;
                    if (j + 1 < cols && grid[i][j + 1] == 1) common++;
                }
            }
        }
        return land * 4 - common * 2;
    }

    public static void main(String[] args) {
        int[][] island = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        demo(island);

        island = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        demo(island);

        island = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        demo(island);
    }

    private static void demo(int[][] island) {
        System.out.println("Island :");
        for (int[] row : island)
            System.out.println(Arrays.toString(row));
        System.out.println("Island Perimeter = " + new IslandPerimeter().islandPerimeter(island));
    }
}
