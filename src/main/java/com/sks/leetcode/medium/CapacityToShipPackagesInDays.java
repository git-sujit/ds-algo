package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * A conveyor belt has packages that must be shipped from one port to another within "days" days.
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 */
public class CapacityToShipPackagesInDays {
    public static int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0 || days == 0) return -1;
        if (days > weights.length) return -1;
        int start = 0;
        int end = 0;
        int result = -1;
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(weights, days, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] weights, int days, int max) {
        int dayCount = 1;
        int weightSum = 0;
        for (int i = 0; i < weights.length; i++) {
            weightSum += weights[i];
            if (weightSum > max) {
                dayCount++;
                weightSum = weights[i];
            }
            if (dayCount > days)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println("Weights = " + Arrays.toString(weights) + ", Days = " + days);
        System.out.println("Least weight capacity = " + shipWithinDays(weights, days));
        weights = new int[]{3, 2, 2, 4, 1, 4};
        days = 3;
        System.out.println("Weights = " + Arrays.toString(weights) + ", Days = " + days);
        System.out.println("Least weight capacity = " + shipWithinDays(weights, days));
        weights = new int[]{1, 2, 3, 1, 1};
        days = 4;
        System.out.println("Weights = " + Arrays.toString(weights) + ", Days = " + days);
        System.out.println("Least weight capacity = " + shipWithinDays(weights, days));
    }
}
