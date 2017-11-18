package com.sks.learn.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterviewAlgorithms {

	public static void main(String[] args) {
		System.out.println("Byte min=" + Byte.MIN_VALUE + ", max=" + Byte.MAX_VALUE);
		System.out.println("Short min=" + Short.MIN_VALUE + ", max=" + Short.MAX_VALUE);
		System.out.println("Int min=" + Integer.MIN_VALUE + ", max=" + Integer.MAX_VALUE);
		System.out.println("Long min=" + Long.MIN_VALUE + ", max=" + Long.MAX_VALUE);
		System.out.println("Char min=" + Character.MIN_VALUE + ", max=" + Character.MAX_VALUE);
		System.out.println("Byte min=" + Byte.MIN_VALUE + ", max=" + Byte.MAX_VALUE);
		// String str = "1234";
		// System.out.println(permutationGenerator(str));
		// divideWithoutDivisionOrAmpersand(100, 1000);
		int[] inputArray = { 8, 10, 20, 8, 7, 5, 10, 10, 7, 18, 9, 30, 20 };
		System.out.println(findDuplicatesInArray(inputArray));
		int[] inputArray_1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(hasDuplicates(inputArray_1));
		int[] inputArray_2 = { 1, 2, 1, 4, 5, 6, 7, 8 };
		System.out.println(hasDuplicates(inputArray_2));
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

	/**
	 * Given an Array of Size N in which every number is between 1 and N,
	 * determine if there are any duplicates
	 * 
	 * @param inputArray
	 * @return
	 */
	public static boolean hasDuplicates(int[] inputArray) {
		int inputSize = inputArray.length;
		int noDuplicateSum = (inputSize * (inputSize + 1)) / 2;
		int inputSum = 0;
		for (int input : inputArray) {
			inputSum += input;
		}
		if (inputSum == noDuplicateSum) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Given an Array of Size N in which every number is between 1 and N,
	 * determine if there are any duplicates
	 * 
	 * @param inputArray
	 * @return
	 */
	public static Set<Integer> findDuplicatesInArray(int[] inputArray) {
		Set<Integer> outputSet = new HashSet<Integer>();
		Set<Integer> inputSet = new HashSet<Integer>();
		for (int input : inputArray) {
			if (inputSet.contains(input)) {
				outputSet.add(input);
			}
			inputSet.add(input);
		}
		return outputSet;

	}

	/**
	 * Microsoft First 
	 * @param root
	 * @return
	 */
	MSNode reverseCopyLinkdedList(MSNode root) {
		MSNode cNext = null;
		MSNode prev = root;
		MSNode next = root.next;
		while (next != null) {
			MSNode cPrev = copyNode(prev);
			cNext = copyNode(next);
			cNext.next = cPrev;
			prev = next;
			next = next.next;
		}
		return cNext;
	}

	MSNode copyNode(MSNode n) {
		MSNode copy = new MSNode();
		copy.data = n.data;
		return copy;
	}
}

class MSNode {
	public int data;
	public MSNode next;
}
