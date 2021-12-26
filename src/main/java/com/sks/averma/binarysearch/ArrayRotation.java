package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * Sorted array is rotated n times, find n
 */
public class ArrayRotation {
    public static int numOfRotations(int[] a) {
        if (a == null || a.length == 0) return -1;
        if (a.length == 1) return 0;
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
                return mid;
            if (a[s] > a[mid])
                e = mid - 1;
            else if (a[mid] > a[e])
                s = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 8, 10, 13, 15, 18, 20};
        int[] ra = {10, 13, 15, 18, 20, 2, 5, 6, 8};
        int[] rotatedA = {15, 18, 20, 2, 5, 6, 8, 10, 13};
        System.out.println("Original Array = " + Arrays.toString(a));
        System.out.println("Rotated Array = " + Arrays.toString(rotatedA));
        System.out.println("Num of Rotations = " + numOfRotations(rotatedA));

        rotatedA = new int[]{6, 7, 1, 2, 3, 4, 5};
        System.out.println("Rotated Array = " + Arrays.toString(rotatedA));
        System.out.println("Num of Rotations = " + numOfRotations(rotatedA));

        rotatedA = new int[]{2, 1};
        System.out.println("Rotated Array = " + Arrays.toString(rotatedA));
        System.out.println("Num of Rotations = " + numOfRotations(rotatedA));
    }
}
