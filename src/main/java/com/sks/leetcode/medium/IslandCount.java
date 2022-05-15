package com.sks.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
public class IslandCount {
    /**
     * Time Complexity : O(rows*cols)
     * Space Complexity: O(rows*cols)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair(i, j))) {
                    if ((i - 1 >= 0 && grid[i - 1][j] == '1') || (j - 1 >= 0 && grid[i][j - 1] == '1'))
                        continue;
                    visit(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, int i, int j, Set<Pair<Integer, Integer>> visited) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> qp = q.remove();
            // Note: In BFS, there could be duplicates
            if (!visited.contains(qp)) {
                int r = qp.getKey();
                int c = qp.getValue();
                if (r - 1 >= 0 && grid[r - 1][c] == '1' && !visited.contains(new Pair(r - 1, c)))
                    q.add(new Pair(r - 1, c));
                if (r + 1 < grid.length && grid[r + 1][c] == '1' && !visited.contains(new Pair(r + 1, c)))
                    q.add(new Pair(r + 1, c));
                if (c + 1 < grid[0].length && grid[r][c + 1] == '1' && !visited.contains(new Pair(r, c + 1)))
                    q.add(new Pair(r, c + 1));
                if (c - 1 >= 0 && grid[r][c - 1] == '1' && !visited.contains(new Pair(r, c - 1)))
                    q.add(new Pair(r, c - 1));
                visited.add(new Pair(r, c));
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'0', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'}, {'0', '1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '1', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0'}, {'0', '1', '0', '0', '1', '1', '0', '0', '1', '1', '1', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0'}};
        demo(grid);

        grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '1', '1'}};
        demo(grid);
    }

    private static void demo(char[][] grid) {
        System.out.println("\nIsland :");
        for (char[] row : grid)
            System.out.println(Arrays.toString(row));
        System.out.println("Number of islands = " + new IslandCount().numIslands(grid));
    }
}
