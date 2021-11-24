package com.sks.algo2021;

import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int M = 6, N = 6;
        int[][] m = new int[M][N];
        int c = 1;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                m[i][j] = c++;
        for (int[] r : m)
            System.out.println(Arrays.toString(r));
        //System.out.println(Arrays.deepToString(m));
        System.out.println("Array length = " + m.length);
        System.out.println("Array length = " + m[0].length);
        rotateMatrixBy90(m);
        for (int[] r : m)
            System.out.println(Arrays.toString(r));
    }

    private static void rotateMatrixBy90(int[][] m) {
        if (m == null || m.length == 0) return;
        int l = m.length;

        int[][] mc = new int[l][l];
        for (int i = 0; i < l; i++)
            for (int j = 0; j < l; j++)
                mc[i][j] = m[i][j];

        for (int i = 0; i < l; i++) {
            int[] r = mc[i];
            for (int j = 0; j < l; j++)
                m[j][l - i - 1] = r[j];
        }
    }
}
