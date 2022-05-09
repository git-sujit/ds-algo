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
public class RowColumnSortedArray_1 {
    /**
     * Time Complexity: O(rows+cols) ~ O(n), each iteration we are removing one row or column
     * Space Complexity: O(1)
     */
    public static int[] searchInRowColumnSortedArray(int[][] a, int n) {
        int rows = a.length;
        int cols = a[0].length;
        int r = 0;
        int c = cols - 1;
        while (r >= 0 && r < rows && c >= 0 && c < cols) {
            if (n < a[r][c]) c--;
            else if (n == a[r][c]) return new int[]{r, c};
            else r++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] a = {{5, 10, 15, 20}, {7, 12, 18, 25}, {9, 18, 24, 30}};
        int n = 12;
        System.out.println("2D Array => ");
        for (int[] aa : a)
            System.out.println(Arrays.toString(aa));

        demo(a, n);

        n = 4;
        demo(a, n);

        n = 33;
        demo(a, n);

        n = 24;
        demo(a, n);

        n = 10;
        demo(a, n);

        n = 18;
        demo(a, n);
    }

    private static void demo(int[][] a, int n) {
        System.out.println("\n" + n + " found at : " + Arrays.toString(searchInRowColumnSortedArray(a, n)));
    }
}
