package com.sks.averma2025;

import java.sql.SQLOutput;
import java.util.Arrays;

public class BinarySearchApp {
    public static void main(String[] args) {
        BinarySearchApp bsApp = new BinarySearchApp();
        int[] arr = new int[]{2, 8, 12, 13, 19, 22, 29};
        System.out.println("Sorted Array = " + Arrays.toString(arr));
        int n = 13;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 2;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 29;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 22;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 100;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 25;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
        n = 0;
        System.out.println("Binary Search of (" + n + ") : " + bsApp.binarySearch(arr, n));
    }

    private int binarySearch(int[] arr, int n) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1;
        int m = -1;
        while (s <= e) {
            m = s + (e - s) / 2; //To avoid int overflow
            if (n < arr[m]) {
                e = m - 1;
            } else if (n > arr[m]) {
                s = m + 1;
            } else return m;
        }
        //Not Found
        return -1;
    }
}
