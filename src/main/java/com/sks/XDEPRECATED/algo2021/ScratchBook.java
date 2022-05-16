package com.sks.XDEPRECATED.algo2021;

import java.util.Arrays;

public class ScratchBook {
    public static void main(String[] args) {
        testRecursions();

        //testMergeSortedArray();

        //testOthers();
    }

    private static void testRecursions() {
        int[] a = new int[]{10, 14, 2, 9, 1, 0, 100};
        System.out.println(Arrays.toString(a));
        sortRecursive(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        //printRecursive(3);
    }

    private static void testOthers() {
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.SIZE);

        printFibs(10);
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " : " + fact(i));
        }
        String s = "abc";
        System.out.println(s + " : " + permCount(s));
    }


    private static int fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }


    private static int permCount(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        return s.length() * permCount(s.substring(1));
    }

    private static void printFibs(int n) {
        int[] a = new int[n + 1];
        if (n <= 0) a[0] = 0;
        else if (n == 1) a[1] = 1;
        else {
            for (int i = 2; i <= n; i++) {
                if (a[i] == 0) a[i] = a[i - 1] + a[i - 2];
            }

        }
        for (int f : a)
            System.out.print(" " + f);
    }

    private static void testMergeSortedArray() {
        int[] a1 = new int[]{2, 5, 9, 12};
        int[] a2 = new int[]{3, 7, 11, 15, 18, 30, 35};
        int[] a = mergeSortedArray(a1, a2);
        System.out.println(Arrays.toString(a));
        a = mergeSortedArray(a2, a1);
        System.out.println(Arrays.toString(a));

    }

    private static void printRecursive(int n) {
        if (n < 1) return;
        printRecursive(n - 1);
        System.out.println(n);
    }

    private static void sortRecursive(int[] a, int s, int e) {
        if (s > e) return;
        int minIndex = s;
        for (int i = s + 1; i <= e; i++) {
            if (a[i] < a[minIndex])
                minIndex = i;
        }
        int temp = a[s];
        a[s] = a[minIndex];
        a[minIndex] = temp;

        sortRecursive(a, s + 1, e);
    }

    private static int[] mergeSortedArray(int[] a1, int[] a2) {
        if (a1 == null) return a2;
        if (a2 == null) return a1;
        int l1 = a1.length;
        int l2 = a2.length;
        int[] a = new int[l1 + l2];

        int i = 0, i1 = 0, i2 = 0;
        while (i < l1 + l2 && i1 < l1 && i2 < l2) {
            if (a1[i1] < a2[i2])
                a[i++] = a1[i1++];
            else
                a[i++] = a2[i2++];
        }
        while (i1 < l1)
            a[i++] = a1[i1++];
        while (i2 < l2)
            a[i++] = a2[i2++];

        return a;
    }
}
