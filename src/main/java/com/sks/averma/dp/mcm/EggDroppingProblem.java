package com.sks.averma.dp.mcm;

import java.util.Arrays;

/**
 * Given a certain amount of floors of a building and also given certain amount of eggs.
 * What is the least amount of egg drops one has to perform to find out the threshold floor?
 * Threshold floor is one from which the egg starts breaking and also egg breaks for all the floors above.
 */
public class EggDroppingProblem {
    public static int minEggDrops_memoization_Improved(int e, int f) {
        int[][] mem = new int[e + 1][f + 1];
        for (int[] m : mem) Arrays.fill(m, -1);
        return minEggDrops_memoization_Improved(e, f, mem);
    }

    private static int minEggDrops_memoization_Improved(int e, int f, int[][] mem) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (mem[e][f] != -1) return mem[e][f];
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int below = mem[e - 1][k - 1] == -1 ? minEggDrops_recursion(e - 1, k - 1) : mem[e - 1][k - 1];
            int above = mem[e][f - k] == -1 ? minEggDrops_recursion(e, f - k) : mem[e][f - k];
            int temp = 1 + Math.max(below, above);
            ans = Math.min(ans, temp);
        }
        return mem[e][f] = ans;
    }

    /**
     * Time Complexity : O(n^3)
     * Space Complexity: O(n^2)
     *
     * @param e: Number of eggs
     * @param f: Number of floors
     * @return: min no. of trials
     */
    public static int minEggDrops_memoization(int e, int f) {
        int[][] mem = new int[e + 1][f + 1];
        for (int[] m : mem) Arrays.fill(m, -1);
        return minEggDrops_memoization(e, f, mem);
    }

    private static int minEggDrops_memoization(int e, int f, int[][] mem) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (mem[e][f] != -1) return mem[e][f];
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(minEggDrops_recursion(e - 1, k - 1), minEggDrops_recursion(e, f - k));
            ans = Math.min(ans, temp);
        }
        return mem[e][f] = ans;
    }

    /**
     * Time Complexity : O(2^n)
     * Space Complexity: O(1)
     *
     * @param e: Number of eggs
     * @param f: Number of floors
     * @return: min no. of trials
     */
    public static int minEggDrops_recursion(int e, int f) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(minEggDrops_recursion(e - 1, k - 1), minEggDrops_recursion(e, f - k));
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        demo(10, 2);
    }

    private static void demo(int e, int f) {
        System.out.println("[Recursion] No. of Eggs = " + e + ", No. of Floors = " + f + ", Min. no. of egg-drops = " + minEggDrops_recursion(e, f));
        System.out.println("[Memoization] No. of Eggs = " + e + ", No. of Floors = " + f + ", Min. no. of egg-drops = " + minEggDrops_memoization(e, f));
        System.out.println("[Improved-Memoization] No. of Eggs = " + e + ", No. of Floors = " + f + ", Min. no. of egg-drops = " + minEggDrops_memoization_Improved(e, f));
    }

}
