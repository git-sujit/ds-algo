package com.sks.algo2020.udemy.recursion;

/**
 * 1. Big problem can be broken into smaller problems
 * 2. Base can for which we know the output
 * 3. Winding & Unwinding phase
 * E.g- Factorial, SumOfDigits of an Integer, Base Conversion, nthPower of a number
 * Euclids Algorithms for Greatest Common Divisor, Fibonacci Series, Tower of Hanoi etc
 *
 * @author : Sujit K Singh
 * Purpose : Any Base conversion From Decimal
 */
public class BaseConversion {
    public static String baseConversionFromDecimal(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map(num % base));
            num /= base;
        }
        return sb.reverse().toString();
    }

    public static String baseConversionFromDecimal_RECURSIVE(int num, int base, StringBuilder sb) {
        if (num == 0)
            return sb.reverse().toString();
        return baseConversionFromDecimal_RECURSIVE(num / base, base, sb.append(map(num % base)));
    }

    private static String map(int n) {
        if (n < 10)
            return "" + n;
        switch (n) {
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
        }
        return "NOT_VALID";
    }

    public static void main(String[] args) {
        System.out.println("### ITERATIVE APPROACH ###");
        System.out.println(baseConversionFromDecimal(75, 2));
        System.out.println(baseConversionFromDecimal(75, 8));
        System.out.println(baseConversionFromDecimal(1009, 16));
        System.out.println("### RECURSIVE APPROACH ###");
        System.out.println(baseConversionFromDecimal_RECURSIVE(75, 2, new StringBuilder()));
        System.out.println(baseConversionFromDecimal_RECURSIVE(75, 8, new StringBuilder()));
        System.out.println(baseConversionFromDecimal_RECURSIVE(1009, 16, new StringBuilder()));
    }
}
