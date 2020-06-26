package com.sks.algo2020.udemy.recursion;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class EuclidsAlgorithmGCD {
    public static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        System.out.println(gcd(32, 22));
        System.out.println(gcd(22, 32));
    }
}
