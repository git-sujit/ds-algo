package com.sks.leetcode.medium;

/**
 * Given an integer n, return a binary string representing its representation in base -2.
 * Note that the returned string should not have leading zeros unless the string is "0".
 */
public class BaseNeg2 {
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % (-2);
            n /= (-2);
            if (remainder < 0) {
                remainder -= -2;
                n += 1;
            }
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    public String base2(int n) {
        return baseX(n, 2);
    }

    public String baseX(int n, int x) {
        String out = "";
        while (n / x != 0) {
            out = n % x + out;
            n /= x;
        }
        out = n % x + out;
        return out;
    }

    public static void main(String[] args) {
        demo(12, 2);
        demo(50, 2);
        demo(134, 10);
        demo(120, -2);
    }

    private static void demo(int n, int b) {
        if (b < 0) System.out.println("Number = " + n + ", base = " + b + ", output = " + new BaseNeg2().baseNeg2(n));
        else System.out.println("Number = " + n + ", base = " + b + ", output = " + new BaseNeg2().baseX(n, b));
    }
}
