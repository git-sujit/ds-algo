package com.sks.averma.binarysearch.bsa;

import java.util.Arrays;

/**
 * (n*m) array: Each row is sorted & each column is also sorted
 * [
 * 5   10  15  20
 * 7   12  18  25
 * 9   18  24  30
 * ]
 * Search number n and return the co-ordinates(row, column) : 0-based index
 */
public class RowColumnSortedArray {
    /**
     * Time Complexity: O(rows*cols)
     * Space Complexity: O(1)
     */
    public static Coordinate searchInRowColumnSortedArray(int[][] a, int n) {
        if (a == null || a.length == 0) return new Coordinate(-1, -1);
        int rows = a.length;
        int cols = a[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (n == a[i][j]) return new Coordinate(i, j);
            else if (n < a[i][j]) j--;
            else i++;
        }
        if (i >= rows || j < 0) {
            i = -1;
            j = -1;
        }
        return new Coordinate(i, j);
    }

    private static class Coordinate {
        int row;
        int col;

        public Coordinate(int x, int col) {
            this.row = x;
            this.col = col;
        }

        @Override
        public String toString() {
            return "{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] a = {{5, 10, 15, 20}, {7, 12, 18, 25}, {9, 18, 24, 30}};
        int n = 12;
        System.out.println("2D Array => ");
        for (int[] aa : a)
            System.out.println(Arrays.toString(aa));
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
        n = 4;
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
        n = 33;
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
        n = 24;
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
        n = 10;
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
        n = 18;
        System.out.println(n + " found at : " + searchInRowColumnSortedArray(a, n));
    }
}
