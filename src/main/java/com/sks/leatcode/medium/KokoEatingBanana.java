package com.sks.leatcode.medium;

import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in "h" hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        return -1;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Piles = " + Arrays.toString(piles) + ", Hours = " + h);
        System.out.println("Minimum eating speed = " + minEatingSpeed(piles, h));
        piles = new int[]{30, 11, 23, 4, 20};
        h = 5;
        System.out.println("Piles = " + Arrays.toString(piles) + ", Hours = " + h);
        System.out.println("Minimum eating speed = " + minEatingSpeed(piles, h));
        piles = new int[]{30, 11, 23, 4, 20};
        h = 6;
        System.out.println("Piles = " + Arrays.toString(piles) + ", Hours = " + h);
        System.out.println("Minimum eating speed = " + minEatingSpeed(piles, h));
    }
}
