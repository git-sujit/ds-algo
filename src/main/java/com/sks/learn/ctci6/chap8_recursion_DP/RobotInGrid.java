package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Robot sitting in upper-left corner of a grid with r rows & c columns
 * Robot can only move right or down but certain cells are off limit
 * Desing algorithm to find a path from top-left to bottom-right
 */
public class RobotInGrid {

    /**
     * Time Complexity  : O(2^r+c), Max number of nodes in recursion tree
     * Space Complexity : O(r+c), Max depth of recursion tree
     */
    public static List<Point> determineRobotPath_recursion(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        List<Point> path = new ArrayList<Point>();
        if (hasPath(grid, grid.length - 1, grid[0].length - 1, path))
            return path;
        return null;
    }

    private static boolean hasPath(boolean[][] grid, int r, int c, List<Point> path) {
        //System.out.println("hasPath(grid, " + r + ", " + c + ", " + path + ")");
        if (r < 0 || c < 0 || !grid[r][c]) {
            return false;
        }
        boolean isAtOrigin = (r == 0 && c == 0);
        if (isAtOrigin || hasPath(grid, r - 1, c, path) || hasPath(grid, r, c - 1, path)) {
            Point p = new Point(r, c);
            path.add(p);
            //System.out.println("adding to path: " + p);
            return true;
        }
        return false;
    }

    /**
     * Time Complexity  : O(r*c)
     * Space Complexity : O(r*c)
     */
    public static List<Point> determineRobotPath_memoization(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        int r = grid.length;
        int c = grid[0].length;
        List<Point> path = new ArrayList<>();
        boolean[][] mem = new boolean[r][c];
        if (hasPath_memoization(grid, r - 1, c - 1, path, mem)) {
            for (boolean[] m : mem)
                System.out.println(Arrays.toString(m));
            return path;
        }

        return null;
    }

    private static boolean hasPath_memoization(boolean[][] grid, int r, int c, List<Point> path, boolean[][] mem) {
        if (r < 0 || c < 0 || !grid[r][c]) return false;
        if (!mem[r][c]) {
            mem[r][c] = (r == 0 && c == 0) || hasPath(grid, r - 1, c, path) || hasPath(grid, r, c - 1, path);
        }
        if (mem[r][c]) {
            Point p = new Point(r, c);
            path.add(p);
        }
        return mem[r][c];
    }

    public static void main(String[] args) {

        boolean[][] grid = new boolean[3][5];
        for (boolean[] b : grid) {
            Arrays.fill(b, true);
        }
        grid[0][4] = false;
        testRobotInGrid(grid);

        grid = new boolean[1000][5000];
        for (boolean[] b : grid) {
            Arrays.fill(b, true);
        }
        //testRobotInGrid_timeAnalysis(grid);
    }

    private static void testRobotInGrid(boolean[][] grid) {
        List<Point> robotPath = determineRobotPath_recursion(grid);
        System.out.println(robotPath);

        robotPath = determineRobotPath_memoization(grid);
        System.out.println(robotPath);
    }

    private static void testRobotInGrid_timeAnalysis(boolean[][] grid) {
        long t1 = System.currentTimeMillis();
        List<Point> robotPath = determineRobotPath_recursion(grid);
        System.out.println(robotPath);
        long t2 = System.currentTimeMillis();
        System.out.println("Recursion: Time Taken = " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        robotPath = determineRobotPath_memoization(grid);
        System.out.println(robotPath);
        t2 = System.currentTimeMillis();
        System.out.println("Memoization: Time Taken = " + (t2 - t1) + "ms");
    }
}

class Point {
    private int r;
    private int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
