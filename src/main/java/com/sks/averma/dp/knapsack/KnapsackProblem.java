package com.sks.averma.dp.knapsack;

import java.util.Arrays;

/**
 * @author : Sujit K Singh
 * Purpose : Knapsack problem
 * - Problem of combinatorics
 * - n Items, for item i: weight=w[i] and value=v[i] :: set of non-negative integers
 * - Max weight in Knapsack = M
 * - Which all items to pick to maximize the value of Knapsack
 */
public class KnapsackProblem {
    // Memoization Array
    private static int[][] mem;

    /**
     * Recursion
     * Approach: A simple solution is to consider all subsets of items and calculate the total weight and value of all subsets.
     * Consider the only subsets whose total weight is smaller than W. From all such subsets, pick the maximum value subset.
     * Time Complexity: O(2^n)
     * Space Complexity: O(n): method stack
     **/
    public static int knapsack_recursion(int[] wt, int[] v, int w, int n) {
        //System.out.println("knapsack(" + Arrays.toString(wt) + ", " + Arrays.toString(v) + ", " + w + ", " + n + ")");
        // 1. Base Condition
        if (w == 0 || n == 0) return 0;

        // 2. Recursion
        if (wt[n - 1] <= w)
            return Math.max(v[n - 1] + knapsack_recursion(wt, v, w - wt[n - 1], n - 1),
                    knapsack_recursion(wt, v, w, n - 1));
        else
            return knapsack_recursion(wt, v, w, n - 1);
    }

    /**
     * Recursion + Memoization = Dynamic Programming
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * (n+1)*(w+1) matrix:: n=number of items, w=max weight, mem[n][w]=Max value for n items and w max_weight
     * Concern: Method stack is used that may become full, highly unlikely
     */
    public static int knapsack_memoization(int[] wt, int[] v, int w, int n) {
        // 1. Base Condition
        if (w == 0 || n == 0) return 0;

        // 2. Check
        if (mem[n][w] != -1) return mem[n][w];

        // 3. Update
        if (wt[n - 1] <= w)
            mem[n][w] = Math.max(v[n - 1] + knapsack_memoization(wt, v, w - wt[n - 1], n - 1),
                    knapsack_memoization(wt, v, w, n - 1));
        else
            mem[n][w] = knapsack_memoization(wt, v, w, n - 1);

        return mem[n][w];
    }

    /**
     * Top-down is called real dynamic programming
     * Remove recursive call
     * Time Complexity: O(N*W)
     * Space Complexity: O(N*W)
     * Better Part: No method stack is used
     **/
    public static int knapsack_top_down(int[] wt, int[] v, int w, int n) {
        // 1. Initialization: Base condition changes to Initialization
        int[][] td = new int[n + 1][w + 1];
        
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= w; j++)
                if (i == 0 || j == 0)
                    td[i][j] = 0;

        // 2. Choice diagram
        // n ==> i
        // w ==> j
        for (int i = 1; i <= n; i++)  // i is corresponding to n(Item which has both wt[] and v[]
            for (int j = 1; j <= w; j++) { // j is corresponding to w(max-weight)
                if (wt[i - 1] <= j)
                    td[i][j] = Math.max(v[i - 1] + td[i - 1][j - wt[i - 1]], td[i - 1][j]);
                else
                    td[i][j] = td[i - 1][j];
            }

        /*-
        for (int[] arr : td)
            System.out.println(Arrays.toString(arr));
        */
        return td[n][w];
    }

    public static void main(String[] args) {
        // WEIGHTS of Items
        int wt[] = new int[]{3, 4, 5, 9, 4};
        //int wt[] = new int[]{12, 2, 1, 1, 4};

        // VALUES of Items
        int v[] = new int[]{300, 400, 400, 1000, 400};
        //int v[] = new int[]{4, 2, 1, 2, 10};

        // CAPACITY of Knapsack
        //int w = 11;
        int w = 15;
        int n = v.length;

        // Initialize 2D array for memoization
        mem = new int[n + 1][w + 1];
        for (int[] arr : mem)
            Arrays.fill(arr, -1);

        System.out.println("Weight[] = " + Arrays.toString(wt));
        System.out.println("Values[] = " + Arrays.toString(v));
        System.out.println("Knapsack Capacity/Max Weight = " + w);
        System.out.println("Max Value in knapsack_recursion = " + knapsack_recursion(wt, v, w, n));
        System.out.println("Max Value in knapsack_memoization = " + knapsack_memoization(wt, v, w, n));
        /*-
        System.out.println("######### Memoization Array after the call");
        for (int[] arr : mem)
            System.out.println(Arrays.toString(arr));
         */
        System.out.println("Max Value in knapsack_top_down = " + knapsack_top_down(wt, v, w, n));
    }
}
