package com.sks.averma.binarysearch;

/**
 * Find first occurrence of 1 in infinite binary sorted array
 * E.g: a[] = {0,0,0,0,0,0,0,0,0,0,0,0......1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1......}
 */
public class InfiniteBinarySortedArray {
    public static int findFirstOne(int[] a) {
        if (a == null) return -1;
        int s = 0;
        int e = 1;
        while (a[e] != 1) {
            s = e;
            e *= 2;
        }
        int result = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == 1) {
                result = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[1025];
        for (int i = 0; i < 700; i++)
            a[i] = 0;
        for (int i = 700; i < a.length; i++)
            a[i] = 1;
        System.out.println("First occurrence of 1 = " + findFirstOne(a));
    }
}
