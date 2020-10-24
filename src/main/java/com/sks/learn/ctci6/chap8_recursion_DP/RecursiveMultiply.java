package com.sks.learn.ctci6.chap8_recursion_DP;

public class RecursiveMultiply {
    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return a + multiply(a, b - 1);
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 5;
        System.out.println(a + "*" + b + " = " + multiply(a, b));
    }
}
