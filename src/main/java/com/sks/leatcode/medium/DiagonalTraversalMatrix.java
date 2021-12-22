package com.sks.leatcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */
public class DiagonalTraversalMatrix {
    public int[] findDiagonalOrder(int[][] mat) {
        return null;
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> out = new ArrayList<>();
        if (array == null) return out;
        int i = 0;
        int j = 0;
        int rows = array.size();
        int columns = array.get(0).size();
        while (i < rows && j < columns) {
            out.add(array.get(i).get(j));
            //Down
            if (j == 0 || j == columns - 1) {
                i++;
                out.add(array.get(i).get(j));
                //move diagonally up
                while (i > 0 && j < columns) {
                    i--;
                    j++;
                    out.add(array.get(i).get(j));
                }
            }
            //Right
            if (i == 0 || i == rows - 1) {
                j++;
                out.add(array.get(i).get(j));
                //move diagonally down
                while (i < rows && j > 0) {
                    i++;
                    j--;
                    out.add(array.get(i).get(j));
                }
            }
        }
        return out;
    }
}
