package com.sks.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class IslandMaxArea {
    /**
     * Time Complexity : O(rows*cols)
     * Space Complexity: O(rows*cols)
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(new Pair(i, j))) {
                    if ((i - 1 >= 0 && grid[i - 1][j] == 1) || (j - 1 >= 0 && grid[i][j - 1] == 1))
                        continue;
                    maxArea = Math.max(maxArea, visit(grid, i, j, visited));
                }
            }
        }
        return maxArea;
    }

    private int visit(int[][] grid, int i, int j, Set<Pair<Integer, Integer>> visited) {
        int area = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> qp = q.remove();
            // Note: In BFS, there could be duplicates
            if (!visited.contains(qp)) {
                int r = qp.getKey();
                int c = qp.getValue();
                if (r - 1 >= 0 && grid[r - 1][c] == 1 && !visited.contains(new Pair(r - 1, c)))
                    q.add(new Pair(r - 1, c));
                if (r + 1 < grid.length && grid[r + 1][c] == 1 && !visited.contains(new Pair(r + 1, c)))
                    q.add(new Pair(r + 1, c));
                if (c + 1 < grid[0].length && grid[r][c + 1] == 1 && !visited.contains(new Pair(r, c + 1)))
                    q.add(new Pair(r, c + 1));
                if (c - 1 >= 0 && grid[r][c - 1] == 1 && !visited.contains(new Pair(r, c - 1)))
                    q.add(new Pair(r, c - 1));
                visited.add(new Pair(r, c));
                area++;
            }
        }
        //System.out.println("Area = " + area);
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        demo(grid);

        grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        demo(grid);
    }

    private static void demo(int[][] grid) {
        System.out.println("\nIsland :");
        for (int[] row : grid)
            System.out.println(Arrays.toString(row));
        System.out.println("Max Area = " + new IslandMaxArea().maxAreaOfIsland(grid));
    }
}
