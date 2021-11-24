package com.sks.algo2020.udemy.recursion;

/**
 * @author : Sujit K Singh
 * Purpose : Tower of Brahma aka Hanoi
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * <p>
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
 * No larger disk may be placed on top of a smaller disk.
 */
public class TowerOfBrahma {
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
