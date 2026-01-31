package com.sks.averma_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class A_StackPractice {
    public static void main(String[] args) {
        // Next Greater Element Right
        test_ngr();
        // Stock Spanner
        test_stockSpanner();
        // Maximum Area Histogram
        test_maximumAreaHistogram();
        // Maximum Area rectangle - In Binary Matrix
        test_maximumAreaRectangle_binaryMatrix();
        // Rain Water Trapping
        test_rainWaterTrapping();
        // Min Stack
        test_MinStack();
    }

    /**
     * Given an array, print the Next Greater Element in Left/right for every element.
     * Time Complexity: O(n), Space Complexity: O(n)
     **/
    private static int[] nextGreaterElementRight(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //Loop from Right->Left because you traverse to find next-greater-element in right(Stack-LIFO)
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) ngr[i] = -1;
            else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                ngr[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i]);
        }
        return ngr;
    }

    /**
     * For Day-i => How many stock-prices are equal/smaller
     * Time Complexity: O(n), Space Complexity: O(n)
     **/
    private static int[] stockSpanner(int[] stocks) {
        if (stocks == null || stocks.length == 0) return null;
        int[] ngl_idx = nextGreaterLeft_index(stocks);
        int[] span = new int[stocks.length];
        for (int i = 0; i < stocks.length; i++)
            span[i] = i - ngl_idx[i];
        return span;
    }

    private static int[] nextGreaterLeft_index(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngl_idx = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) ngl_idx[i] = -1;
            else {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
                ngl_idx[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        return ngl_idx;
    }

    /**
     * Maximum Area Histogram
     * Time Complexity: O(n), Space Complexity: O(n)
     **/
    private static int maximumAreaHistogram(int[] buildingHeights) {
        if (buildingHeights == null || buildingHeights.length == 0) return -1;
        int[] nsl_idx = nsl_index(buildingHeights);
        int[] nsr_idx = nsr_index(buildingHeights);
        //System.out.println("nsl_idx = " + Arrays.toString(nsl_idx));
        //System.out.println("nsr_idx = " + Arrays.toString(nsr_idx));
        int[] areas = new int[buildingHeights.length];
        int max = -1;
        for (int i = 0; i < buildingHeights.length; i++) {
            int left_span = (i - nsl_idx[i] - 1);
            int right_span = nsr_idx[i] == -1 ? (buildingHeights.length - 1 - i) : (nsr_idx[i] - i - 1);
            areas[i] = buildingHeights[i] * (left_span + right_span + 1);
            max = Math.max(max, areas[i]);
        }
        //System.out.println("Areas = " + Arrays.toString(areas));
        //return Arrays.stream(areas).max().getAsInt();
        return max;
    }

    private static int[] nsl_index(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] nsl_idx = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) nsl_idx[i] = -1;
            else {
                if (arr[stack.peek()] < arr[i]) nsl_idx[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                    nsl_idx[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsl_idx;
    }

    private static int[] nsr_index(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] nsr_idx = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr_idx[i] = -1;
            else {
                if (arr[stack.peek()] < arr[i]) nsr_idx[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                    nsr_idx[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(i);
        }
        return nsr_idx;
    }

    /**
     * Maximum Area Rectangle - Binary Matrix
     * Time Complexity: O(n), Space Complexity: O(n)
     **/
    private static int maximumAreaRectangle_binaryMatrix(int[][] binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.length == 0) return -1;
        List<int[]> histograms = buildHeightHistogramsFromBinaryMatrix(binaryMatrix);
        System.out.println("Histograms:");
        int maxArea = -1;
        for (int[] histogram : histograms) {
            System.out.println(Arrays.toString(histogram));
            maxArea = Math.max(maxArea, maximumAreaHistogram(histogram));
        }
        return maxArea;
    }

    private static List<int[]> buildHeightHistogramsFromBinaryMatrix(int[][] binaryMatrix) {
        List<int[]> histograms = new ArrayList<>();
        for (int i = 0; i < binaryMatrix.length; i++) {
            List<Integer> heights = new ArrayList<>();
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                if (binaryMatrix[i][j] == 1) {
                    int height = 1;
                    for (int k = i + 1; k < binaryMatrix.length; k++) {
                        if (binaryMatrix[k][j] == 1) height++;
                        else break;
                    }
                    heights.add(height);
                }
            }
            int[] histogram = new int[heights.size()];
            for (int l = 0; l < heights.size(); l++) histogram[l] = heights.get(l);
            histograms.add(histogram);
        }
        return histograms;
    }

    /**
     * Rain Water Trapping
     */
    private static int rainWaterTrapping(int[] buildingHeights) {
        if (buildingHeights == null || buildingHeights.length == 0) return -1;
        int[] maxLeft = maxElementLeft(buildingHeights);
        System.out.println("Max Left = " + Arrays.toString(maxLeft));
        int[] maxRight = maxElementRight(buildingHeights);
        System.out.println("Max Right = " + Arrays.toString(maxRight));
        int waterTrapped = 0;
        for (int i = 0; i < buildingHeights.length; i++) {
            if (maxLeft[i] == -1 || maxRight[i] == -1) continue;
            waterTrapped += (Math.min(maxLeft[i], maxRight[i]) - buildingHeights[i]);
        }
        return waterTrapped;
    }

    private static int[] maxElementLeft(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] maxLeft = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) maxLeft[i] = -1;
            else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                maxLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            if (stack.isEmpty() || stack.peek() < arr[i])
                stack.push(arr[i]);
        }
        return maxLeft;
    }

    private static int[] maxElementRight(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] maxRight = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) maxRight[i] = -1;
            else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                maxRight[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            if (stack.isEmpty() || stack.peek() < arr[i]) stack.push(arr[i]);
        }
        return maxRight;
    }

    /**
     * Min Stack: Extra Space
     */
    private static class MinStack_extraSpace {
        private final Stack<Integer> stack = new Stack<>();
        private final Stack<Integer> minStack = new Stack<>();

        private void push(int ele) {
            stack.push(ele);
            if (minStack.isEmpty() || minStack.peek() > ele) minStack.push(ele);
        }

        private int pop() {
            int ele = stack.pop();
            if (minStack.peek() == ele) minStack.pop();
            return ele;
        }

        private int min() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }

    /**
     * TEST
     */
    private static void test_ngr() {
        int[] arr = new int[]{1, 3, 0, 0, 1, 2, 4};
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("NGR   = " + Arrays.toString(nextGreaterElementRight(arr)));
    }

    private static void test_stockSpanner() {
        int[] stockPrices = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Prices:" + Arrays.toString(stockPrices));
        System.out.println("StockSpanner:" + Arrays.toString(stockSpanner(stockPrices)));
    }

    private static void test_maximumAreaHistogram() {
        int[] buildingHeights = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println("Building Heights    :" + Arrays.toString(buildingHeights));
        System.out.println("Max Area Histogram  :" + maximumAreaHistogram(buildingHeights));
    }

    private static void test_maximumAreaRectangle_binaryMatrix() {
        int[][] binaryMatrix = new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        if (binaryMatrix == null) return;
        System.out.println("Binary Matrix");
        for (int i = 0; i < binaryMatrix.length; i++)
            System.out.println(Arrays.toString(binaryMatrix[i]));
        System.out.println("Maximum Area of Rectangle in Binary Matrix = " + maximumAreaRectangle_binaryMatrix(binaryMatrix));

    }

    private static void test_rainWaterTrapping() {
        int[] buildingHeights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Building Heights    :" + Arrays.toString(buildingHeights));
        System.out.println("Rain Water Trapped  :" + rainWaterTrapping(buildingHeights));
    }

    private static void test_MinStack() {
        test_MinStack_extraSpace();
        //test_MinStack_efficient();
    }

    private static void test_MinStack_extraSpace() {
        System.out.println("Min Stack - Extra Space");
        MinStack_extraSpace mStack = new MinStack_extraSpace();
        demo_push(mStack, 10);
        demo_push(mStack, 20);
        demo_push(mStack, 5);
        demo_push(mStack, 50);
        demo_push(mStack, 3);
        demo_push(mStack, 43);
        demo_push(mStack, 75);
        demo_push(mStack, 1);

        while (!mStack.stack.isEmpty())
            demo_pop(mStack);
    }

    private static void demo_push(MinStack_extraSpace mStack, int ele) {
        mStack.push(ele);
        System.out.println("Push(" + ele + "):\tstack = " + mStack.stack + ", min = " + mStack.min());
    }

    private static void demo_pop(MinStack_extraSpace mStack) {
        mStack.pop();
        System.out.println("Pop:\tstack = " + mStack.stack + ", min = " + mStack.min());
    }
}
