package com.sks.averma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
 */
public class MaxAreaBinaryMatrix {
    public static int maxArea(int[][] bMatrix) {
        if (bMatrix == null || bMatrix.length == 0) return -1;
        int max = 0;
        int[][] histograms = prepareHistograms(bMatrix);
        System.out.println("Histograms = ");
        for (int[] h : histograms) {
            int maxAreaH = maxArea_histogram(h);
            System.out.println(Arrays.toString(h) + ", Max Area in Histogram = " + maxAreaH);
            max = Math.max(max, maxAreaH);
        }
        return max;
    }

    private static int maxArea_histogram(int[] histogram) {
        if (histogram == null || histogram.length == 0) return -1;
        int max = 0;
        int[] nsl = nsLeftIndex(histogram);
        int[] nsr = nsRightIndex(histogram);
        //System.out.println("nsLeftIndex = " + Arrays.toString(nsl));
        //System.out.println("nsRightIndex = " + Arrays.toString(nsr));
        for (int i = 0; i < histogram.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = histogram[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }

    private static int[] nsLeftIndex(int[] histogram) {
        int[] nsl = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < histogram.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else {
                if (histogram[stack.peek()] < histogram[i]) nsl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) stack.pop();
                    nsl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsl;
    }

    private static int[] nsRightIndex(int[] histogram) {
        int[] nsr = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = histogram.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = histogram.length;
            else {
                if (histogram[stack.peek()] < histogram[i]) nsr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) stack.pop();
                    nsr[i] = stack.isEmpty() ? histogram.length : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsr;
    }

    private static int[][] prepareHistograms(int[][] bMatrix) {
        int[][] histograms = new int[bMatrix.length][bMatrix[0].length];
        for (int i = 0; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix.length; j++) {
                if (i == 0) histograms[i][j] = bMatrix[i][j];
                else {
                    if (bMatrix[i][j] == 0) histograms[i][j] = 0;
                    else histograms[i][j] = histograms[i - 1][j] + bMatrix[i][j];
                }
            }
        }
        return histograms;
    }

    public static void main(String[] args) {
        int[][] bMatrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        test(bMatrix);

        bMatrix = new int[][]{{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        test(bMatrix);
    }

    private static void test(int[][] bMatrix) {
        System.out.println("\nBinary Matrix:");
        for (int[] bm : bMatrix)
            System.out.println(Arrays.toString(bm));
        System.out.println("Maximum Area = " + maxArea(bMatrix));
    }
}
