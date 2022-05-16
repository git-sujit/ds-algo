package com.sks.averma.recursion;

public class TowerOfHanoi {
    private static int step = 0;

    public static void brahma(int n, String source, String temp, String dest) {
        if (n == 1) {
            System.out.println((++step) + ". Move disc " + n + " from " + source + " --> " + dest);
            return;
        }
        brahma(n - 1, source, dest, temp);
        System.out.println((++step) + ". Move disc " + n + " from " + source + " --> " + dest);
        brahma(n - 1, temp, source, dest);
    }

    public static void main(String[] args) {
        brahma(2, "S", "T", "D");
    }
}
