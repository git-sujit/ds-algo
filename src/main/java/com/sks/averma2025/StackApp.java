package com.sks.averma2025;

import com.sks.averma.stack.MinInStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackApp {
    private static final StackApp stackApp = new StackApp();

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** NEXT GREATER/SMALLER ELEMENT LEFT/RIGHT ***");
        stackApp.test_nextGreaterElement();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** STOCK SPANNER ***");
        stackApp.test_stockSpanner();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** MAXIMUM AREA HISTOGRAM ***");
        stackApp.test_maximumAreaHistogram();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** MAXIMUM AREA RECTANGLE - IN BINARY MATRIX ***");
        stackApp.test_maximumAreaRectangle_binaryMatrix();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** RAIN WATER TRAPPING ***");
        stackApp.test_rainWaterTrapping();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** MIN STACK ***");
        stackApp.test_MinStack();
    }

    /**
     * Next Greater Element in Right => Brute Force => O(n^2)
     */
    private int[] nextGreaterElementRight_BF(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ngr[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    ngr[i] = arr[j];
                    break;
                }
            }
        }
        return ngr;
    }

    /**
     * Next Greater Element in Right => Stack => O(n)
     */
    private int[] nextGreaterElementRight_stack(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) ngr[i] = -1;
            else {
                if (stack.peek() > arr[i]) ngr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                    ngr[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ngr;
    }

    /**
     * Next Greater Element in Left => Brute Force => O(n^2)
     */
    private int[] nextGreaterElementLeft_BF(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngl = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ngl[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    ngl[i] = arr[j];
                    break;
                }
            }
        }
        return ngl;
    }

    /**
     * Next Greater Element in Left => Stack => O(n)
     */
    private int[] nextGreaterElementLeft_stack(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] ngl = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) ngl[i] = -1;
            else {
                if (stack.peek() > arr[i]) ngl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
                    ngl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ngl;
    }

    private int[] nextSmallerElementLeft_stack(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] nsl = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else {
                if (stack.peek() < arr[i]) nsl[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
                    nsl[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return nsl;
    }

    private int[] nextSmallerElementRight_stack(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] nsr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = -1;
            else {
                if (stack.peek() < arr[i]) nsr[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
                    nsr[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return nsr;
    }

    /**
     * Stock Spanner
     */
    private int[] stockSpanner_BF(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length == 0) return null;
        int[] stockSpan = new int[stockPrices.length];
        for (int i = 0; i < stockPrices.length; i++) {
            stockSpan[i] = 1;
            for (int j = i; j - 1 >= 0; j--) {
                if (stockPrices[j - 1] < stockPrices[i]) stockSpan[i]++;
                else break;
            }
        }
        return stockSpan;
    }

    private int[] stockSpanner_stack(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length == 0) return null;
        int[] stockSpan = new int[stockPrices.length];
        int[] nglIndex = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stockPrices.length; i++) {
            if (stack.isEmpty()) {
                nglIndex[i] = -1;
            } else {
                if (stockPrices[stack.peek()] > stockPrices[i]) nglIndex[i] = stack.peek();
                else {
                    while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i]) stack.pop();
                    nglIndex[i] = stack.isEmpty() ? -1 : stack.peek();
                }
            }
            stockSpan[i] = i - nglIndex[i];
            stack.push(i);
        }
        return stockSpan;
    }

    /**
     * Maximum Area Histogram
     */
    private int maximumAreaHistogram_bf(int[] buildingHeights) {
        if (buildingHeights == null || buildingHeights.length == 0) return -1;
        int[] areas = new int[buildingHeights.length];
        for (int i = 0; i < buildingHeights.length; i++) {
            int nsl = -1;
            int nsr = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (buildingHeights[j] > buildingHeights[i]) nsl = j;
                else break;
            }

            for (int j = i + 1; j < buildingHeights.length; j++) {
                if (buildingHeights[j] > buildingHeights[i]) nsr = j;
                else break;
            }

            areas[i] = buildingHeights[i] * (nsr - nsl + 1);
            //System.out.println("Building Height = " + buildingHeights[i] + ", nsl = " + nsl + ", nsr = " + nsr + " => Aras = " + areas[i]);
        }
        //System.out.println("Areas-BF = " + Arrays.toString(areas));
        return Arrays.stream(areas).max().getAsInt();
    }

    private int maximumAreaHistogram_stack(int[] buildingHeights) {
        int[] nsl_idx = nsl_index(buildingHeights);
        int[] nsr_idx = nsr_index(buildingHeights);
        //System.out.println("nsl_idx = " + Arrays.toString(nsl_idx));
        //System.out.println("nsr_idx = " + Arrays.toString(nsr_idx));
        if (buildingHeights == null || buildingHeights.length == 0) return -1;
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

    private int[] nsl_index(int[] arr) {
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

    private int[] nsr_index(int[] arr) {
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
     */
    private int maximumAreaRectangle_binaryMatrix_stack(int[][] binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.length == 0) return -1;
        List<int[]> histograms = buildHeightHistogramsFromBinaryMatrix(binaryMatrix);
        System.out.println("Histograms:");
        int maxArea = -1;
        for (int[] histogram : histograms) {
            System.out.println(Arrays.toString(histogram));
            maxArea = Math.max(maxArea, maximumAreaHistogram_stack(histogram));
        }
        return maxArea;
    }

    private List<int[]> buildHeightHistogramsFromBinaryMatrix(int[][] binaryMatrix) {
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
    private int rainWaterTrapping(int[] buildingHeights) {
        if (buildingHeights == null || buildingHeights.length == 0) return -1;
        int[] maxLeft = stackApp.maxElementLeft(buildingHeights);
        System.out.println("Max Left = " + Arrays.toString(maxLeft));
        int[] maxRight = stackApp.maxElementRight(buildingHeights);
        System.out.println("Max Right = " + Arrays.toString(maxRight));
        int waterTrapped = 0;
        for (int i = 0; i < buildingHeights.length; i++) {
            if (maxLeft[i] == -1 || maxRight[i] == -1) continue;
            waterTrapped += (Math.min(maxLeft[i], maxRight[i]) - buildingHeights[i]);
        }
        return waterTrapped;
    }

    private int[] maxElementLeft(int[] arr) {
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

    private int[] maxElementRight(int[] arr) {
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
     * Min Stack: Efficient
     */
    private static class MinStack_efficient {
        private final Stack<Integer> stack = new Stack<>();
        int min = -1;

        private void push(int ele) {
            if (stack.isEmpty()) {
                stack.push(ele);
                min = ele;
            } else {
                if (ele < min) {
                    int derivedEle = 2 * ele - min;
                    stack.push(derivedEle);
                    min = ele;
                } else {
                    stack.push(ele);
                }
            }
        }

        private int pop() {
            if (stack.isEmpty()) return -1;
            int ele = -1;
            if (stack.peek() < min) {
                ele = min;
                min = 2 * min - stack.peek();
                stack.pop();
            } else {
                ele = stack.pop();
            }
            return ele;
        }

        private int min() {
            return stack.isEmpty() ? -1 : min;
        }
    }

    /**
     * TESTING...Stack Applications
     */
    private void test_MinStack_efficient() {
        System.out.println("Min Stack - Efficient");
        MinStack_efficient mStack = new MinStack_efficient();
        demo_push_efficient(mStack, 10);
        demo_push_efficient(mStack, 20);
        demo_push_efficient(mStack, 5);
        demo_push_efficient(mStack, 50);
        demo_push_efficient(mStack, 3);
        demo_push_efficient(mStack, 43);
        demo_push_efficient(mStack, 75);
        demo_push_efficient(mStack, 1);
        while (!mStack.stack.isEmpty())
            demo_pop_efficient(mStack);
    }

    private static void demo_push_efficient(MinStack_efficient mStack, int ele) {
        mStack.push(ele);
        System.out.println("Push(" + ele + "):\tstack = " + mStack.stack + ", min = " + mStack.min());
    }

    private static void demo_pop_efficient(MinStack_efficient mStack) {
        mStack.pop();
        System.out.println("Pop:\tstack = " + mStack.stack + ", min = " + mStack.min());
    }

    private void test_MinStack() {
        test_MinStack_extraSpace();
        test_MinStack_efficient();
    }

    private void test_MinStack_extraSpace() {
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


    private void test_rainWaterTrapping() {
        int[] buildingHeights = null;
        stackApp.run_rainWaterTrapping(buildingHeights);

        buildingHeights = new int[]{};
        stackApp.run_rainWaterTrapping(buildingHeights);

        buildingHeights = new int[]{3, 0, 0, 2, 0, 4};
        stackApp.run_rainWaterTrapping(buildingHeights);

        buildingHeights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        stackApp.run_rainWaterTrapping(buildingHeights);

        buildingHeights = new int[]{5, 0, 3, 4, 2, 8};
        stackApp.run_rainWaterTrapping(buildingHeights);
    }

    private void run_rainWaterTrapping(int[] buildingHeights) {
        System.out.println("Building Heights    :" + Arrays.toString(buildingHeights));
        System.out.println("Rain Water Trapped  :" + stackApp.rainWaterTrapping(buildingHeights));
        System.out.println(" ");
    }

    private void test_maximumAreaRectangle_binaryMatrix() {
        int[][] binaryMatrix = null;
        stackApp.run_maximumAreaRectangle_binaryMatrix(binaryMatrix);

        binaryMatrix = new int[][]{};
        stackApp.run_maximumAreaRectangle_binaryMatrix(binaryMatrix);

        binaryMatrix = new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        stackApp.run_maximumAreaRectangle_binaryMatrix(binaryMatrix);
    }

    private void run_maximumAreaRectangle_binaryMatrix(int[][] binaryMatrix) {
        if (binaryMatrix == null) return;
        System.out.println("Binary Matrix");
        for (int i = 0; i < binaryMatrix.length; i++)
            System.out.println(Arrays.toString(binaryMatrix[i]));
        System.out.println("Maximum Area of Rectangle in Binary Matrix = " + stackApp.maximumAreaRectangle_binaryMatrix_stack(binaryMatrix));
    }

    private void test_maximumAreaHistogram() {
        int[] buildingHeights = null;
        stackApp.run_maximumAreaHistogram(buildingHeights);

        buildingHeights = new int[]{};
        stackApp.run_maximumAreaHistogram(buildingHeights);

        buildingHeights = new int[]{6, 2, 5, 4, 5, 1, 6};
        stackApp.run_maximumAreaHistogram(buildingHeights);
    }

    private void run_maximumAreaHistogram(int[] buildingHeights) {
        int mah_bf = stackApp.maximumAreaHistogram_bf(buildingHeights);
        int mah_stack = stackApp.maximumAreaHistogram_stack(buildingHeights);
        System.out.println("Building Heights    :" + Arrays.toString(buildingHeights));
        System.out.println("Max Area Histogram  :" + mah_stack);
        System.out.println("Passed?             :" + (mah_bf == mah_stack));
        System.out.println(" ");
    }

    /**
     * TEST: Stock Spanner
     */
    private void test_stockSpanner() {
        int[] stockPrices = null;
        stackApp.run_stockSpanner(stockPrices);

        stockPrices = new int[]{};
        stackApp.run_stockSpanner(stockPrices);

        stockPrices = new int[]{100, 80, 60, 70, 60, 75, 85};
        stackApp.run_stockSpanner(stockPrices);
    }

    private void run_stockSpanner(int[] stockPrices) {
        int[] stockSpan_bf = stackApp.stockSpanner_BF(stockPrices);
        int[] stockSpan_stack = stackApp.stockSpanner_stack(stockPrices);
        System.out.println("Stack Prices:" + Arrays.toString(stockPrices));
        System.out.println("StockSpanner:" + Arrays.toString(stockSpan_stack));
        System.out.println("Passed?     :" + Arrays.equals(stockSpan_bf, stockSpan_stack));
        System.out.println(" ");
    }

    /**
     * TEST: Next Greater Element
     */

    private void test_nextGreaterElement() {
        int[] arr = null;
        stackApp.run_nextGreaterElement(arr);

        arr = new int[]{};
        stackApp.run_nextGreaterElement(arr);

        arr = new int[]{1, 3, 0, 0, 1, 2, 4};
        stackApp.run_nextGreaterElement(arr);

        arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        stackApp.run_nextGreaterElement(arr);


        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        stackApp.run_nextGreaterElement(arr);

        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        stackApp.run_nextGreaterElement(arr);

        arr = new int[]{100, 65, 64, 63, 62, 150, 160, 170, 200};
        stackApp.run_nextGreaterElement(arr);
    }

    private void run_nextGreaterElement(int[] arr) {

        int[] ngr_bf = stackApp.nextGreaterElementRight_BF(arr);
        int[] ngr_stack = stackApp.nextGreaterElementRight_stack(arr);
        int[] ngl_bf = stackApp.nextGreaterElementLeft_BF(arr);
        int[] ngl_stack = stackApp.nextGreaterElementLeft_stack(arr);
        System.out.println("Input           :" + Arrays.toString(arr));
        System.out.println("NextGreaterRight:" + Arrays.toString(stackApp.nextGreaterElementRight_stack(arr)));
        System.out.println("Passed?         :" + Arrays.equals(ngr_bf, ngr_stack));
        System.out.println("NextGreaterLeft :" + Arrays.toString(stackApp.nextGreaterElementLeft_stack(arr)));
        System.out.println("Passed?         :" + Arrays.equals(ngl_bf, ngl_stack));
        System.out.println("NextSmallerLeft :" + Arrays.toString(stackApp.nextSmallerElementLeft_stack(arr)));
        System.out.println("NextSmallerRight:" + Arrays.toString(stackApp.nextSmallerElementRight_stack(arr)));
        System.out.println(" ");
    }
}
