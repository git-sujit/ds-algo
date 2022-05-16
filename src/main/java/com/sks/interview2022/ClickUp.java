package com.sks.interview2022;

import java.util.*;

/**
 * Given an array and a targetSum, return all possible pairs adding to targetSum.
 * Constraint: If a number is used in a pair it cant be re-used
 */
public class ClickUp {
    /**
     * Time: O(n^2)
     * Space:O(n^2)
     */
    public static int[][] findPairs(int target, int[] potentialPairs) {
        if (potentialPairs == null || potentialPairs.length == 0) return null;
        List<List<Integer>> out = new ArrayList<>();
        Set<Integer> idxSet = new HashSet<>();
        for (int i = 0; i < potentialPairs.length; i++) {
            for (int j = i + 1; j < potentialPairs.length; j++) {
                if (!idxSet.contains(i) && !idxSet.contains(j) && potentialPairs[i] + potentialPairs[j] == target) {
                    out.add(Arrays.asList(potentialPairs[i], potentialPairs[j]));
                    idxSet.add(i);
                    idxSet.add(j);
                }
            }
        }
        int[][] outArr = new int[out.size()][2];
        int i = 0;
        for (List<Integer> l : out) {
            outArr[i][0] = l.get(0);
            outArr[i][1] = l.get(1);
            i++;
        }
        return outArr;
    }

    public static void main(String[] args) {
        int[] potentialPairs = {5, 5, 5, 5};
        int target = 10;
        demo(target, potentialPairs);

        potentialPairs = new int[]{1, 2, 3, 5, 2, 7, 8, 3, 8, 6, 1, 3};
        target = 4;
        demo(target, potentialPairs);
    }

    private static void demo(int target, int[] potentialPairs) {
        System.out.println("\nTarget= " + target + ", Array = " + Arrays.toString(potentialPairs));
        int[][] out = findPairs(target, potentialPairs);
        System.out.print("Output: ");
        for (int[] o : out)
            System.out.print(" " + Arrays.toString(o));
    }
}
