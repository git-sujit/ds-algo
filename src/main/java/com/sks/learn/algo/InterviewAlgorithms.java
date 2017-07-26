package com.sks.learn.algo;

import java.util.ArrayList;
import java.util.List;

public class InterviewAlgorithms {

	public static void main(String[] args) {
		String str = "1234";
		// System.out.println(permutationGenerator(str));
		divideWithoutDivisionOrAmpersand(100, 1000);
	}

	/**
	 * @param input
	 * @return
	 */
	public static List<String> permutationGenerator(String input) {
		List<String> permutationList = new ArrayList<String>();
		int inputLength = input.length();
		for (int i = 0; i < inputLength; i++) {
			String permutation = input.substring(i, i + 1) + input.substring(0, i)
					+ input.substring(i + 1, inputLength);
			permutationList.add(permutation);
			for (int j = 1; j < inputLength; j++) {
				if (j + 1 < inputLength) {
					permutation = input.substring(0, j) + input.charAt(inputLength - 1)
							+ input.substring(j + 1, inputLength - 1) + input.charAt(j + 1);
					permutationList.add(permutation);
				}
			}
		}
		return permutationList;
	}

	/**
	 * In division, the dividend is divided by the divisor to get a quotient and
	 * remainder
	 * 
	 * dividend/divisor = quotient & remainder
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static void divideWithoutDivisionOrAmpersand(int dividend, int divisor) {
		if (divisor == 0) {
			System.out.println("Error: Division by Zero is not possible");
			return;
		}
		int quotient = 0;
		int remainder = 0;
		while (dividend >= 0) {
			dividend -= divisor;
			if (dividend < 0) {
				remainder = dividend + divisor;
			} else {
				quotient++;
			}
		}
		System.out.println("quotient = " + quotient + ", remainder = " + remainder);
	}

}
