package com.sks.leetcode.medium;

import java.util.Arrays;

/**
 * **UNSORTED PILES OF BANANAS**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in "h" hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBanana {
    /**
     * BINARY SEARCH
     * Time Complexity: O(nlogm), n->pile length & m->maximum number of bananas in a single pile from piles.
     * Space Complexity: O(1)
     * ALGORITHM:
     * 1. Initialize the two boundaries of the binary search as left=1, right = max(piles)
     * 2. Get the middle value from left and tright, that is, middle = (left + right) / 2, this is Koko's eating speed during this iteration.
     * 3. Iterate over the piles and check if Koko can eat all the piles within h hours given this eating speed of middle.
     * 4. If Koko can finish all the piles within h hours, set right equal to middle signifying that all speeds greater than middle are workable but less desirable by Koko.
     * Otherwise, set left equal to middle + 1 signifying that all speeds less than or equal to middle are not workable.
     * 5. Repeat the steps 2, 3, and 4 until the two boundaries overlap, i.e., left = right, which means that we have found the minimum speed by which Koko could finish
     * eating all the piles within hh hours. We can return either left or right as the answer.
     */
    public static int minEatingSpeed_binarySearch(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h <= 0) return -1;
        if (h < piles.length) return -1;
        int start = 1;
        int end = 0;
        int result = -1;
        for (int p : piles) end = Math.max(end, p);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(piles, h, mid)) {
                result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return result;
    }

    private static boolean isValid(int[] piles, int h, int mid) {
        int hrs = 0;
        for (int i = 0; i < piles.length; i++) {
            hrs += Math.ceil((double) piles[i] / mid);
            if (hrs > h) return false;
        }
        return true;
    }

    /**
     * BRUTE-FORCE
     * Time Complexity: O(nm), n-pile length & m-max value of element in piles array
     * Space Complexity: O(1)
     * ALGORITHM:
     * 1. Start at speed = 1speed=1.
     * 2. Given the current speed, calculate how many hours Koko needs to eat all of the piles.
     * - If Koko cannot finish all piles within h hours, increment speed by 1, that is speed = speed + 1 and start over step 2.
     * - If Koko can finish all piles within h hours, go to step 3.
     * 3. Return the speedspeed as the answer.
     */
    public static int minEatingSpeed_bruteForce(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h <= 0) return -1;
        if (h < piles.length) return -1;
        //int minSpeed = Integer.MAX_VALUE;
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        for (int p : piles) {
            //minSpeed = Math.min(minSpeed, p);
            maxSpeed = Math.max(maxSpeed, p);
        }
        int result = -1;
        for (int speed = minSpeed; speed <= maxSpeed; speed++) {
            int hoursSpent = 0;
            for (int pile : piles) {
                hoursSpent += Math.ceil((double) pile / speed);
                if (hoursSpent > h) break;
            }
            if (hoursSpent <= h) {
                result = speed;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        test(piles, h);

        piles = new int[]{30, 11, 23, 4, 20};
        h = 6;
        test(piles, h);

        piles = new int[]{312884470};
        h = 312884469;
        test(piles, h);
    }

    static void test(int[] piles, int h) {
        System.out.println("\nPiles = " + Arrays.toString(piles) + ", Hours = " + h);
        System.out.println("Minimum eating speed(Brute Force) = " + minEatingSpeed_bruteForce(piles, h));
        System.out.println("Minimum eating speed(Binary Search) = " + minEatingSpeed_binarySearch(piles, h));
    }
}
