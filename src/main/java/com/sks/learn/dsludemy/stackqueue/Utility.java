package com.sks.learn.dsludemy.stackqueue;

import java.util.Stack;

public class Utility {

	public static void main(String[] args) {
		String exp = "[3+(3-4)]}";
		System.out.println("exp=" + exp + " :: valid=" + isValidExpression(exp));
		int decNum = 4563;
		toBinary(decNum);
		System.out.println();
		toOctal(decNum);
		System.out.println();
		toAnyBase(decNum, 2);
		System.out.println();
		toAnyBase(decNum, 8);
		System.out.println();
		long t1 = System.currentTimeMillis();
		System.out.println(nthPower(2, 10));
		long t2 = System.currentTimeMillis();
		System.out.println(nthPowerRecursive(2, 10));
		long t3 = System.currentTimeMillis();
		System.out.println("nthPower: Time Taken = " + (t2 - t1));
		System.out.println("nthPowerRecursive: Time Taken = " + (t3 - t2));
		System.out.println("greatestCommonDivisor = " + greatestCommonDivisor(4, 8));

		for (int i = 40; i <= 50; i++) {
			t1 = System.currentTimeMillis();
			System.out.println("fibExponential(" + i + ") = " + fibExponential(i));
			t2 = System.currentTimeMillis();
			System.out.println("Time Taken: " + (t2 - t1));
		}

	}

	public static boolean isValidExpression(String exp) {
		if (exp == null || "".equals(exp)) {
			throw new IllegalArgumentException();
		}
		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				s.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (s.isEmpty()) {
					return false;
				} else {
					char c1 = s.pop();
					if ((c1 == '(' && c != ')') || (c1 == '{' && c != '}') || (c1 == '[' && c != ']')) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void toBinary(int n) {
		if (n == 0)
			return;
		toBinary(n / 2);
		System.out.print(n % 2 + " ");
	}

	public static void toOctal(int n) {
		if (n == 0)
			return;
		toOctal(n / 8);
		System.out.print(n % 8 + " ");
	}

	public static void toAnyBase(int n, int base) {
		if (n == 0) {
			return;
		}
		toAnyBase(n / base, base);
		System.out.print(n % base + " ");
	}

	public static long nthPower(int n, int p) {
		long prod = 1;
		for (int i = 0; i < p; i++) {
			prod *= n;
		}
		return prod;
	}

	public static long nthPowerRecursive(int n, int p) {
		if (p == 1)
			return n;
		return n * nthPowerRecursive(n, p - 1);
	}

	public static int greatestCommonDivisor(int a, int b) {
		if (b == 0) {
			return a;
		}
		return greatestCommonDivisor(b, a % b);
	}

	public static int fibExponential(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibExponential(n - 1) + fibExponential(n - 2);
	}

	public static int fibEfficient(int n, int prev) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		prev = fibEfficient(n - 2, prev);
		return fibEfficient(n - 1, prev) + prev;
	}
}
