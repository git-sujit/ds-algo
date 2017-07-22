package com.sks.learn.algo;

public class SearchingAlgorithms {

	public static void main(String[] args) {
		int[] sortedArray = { 1, 3, 7, 13, 21, 31, 43, 57, 73, 91 };
		System.out.println("Found At : " + binarySearchSortedArray(sortedArray, 5));

	}

	/**
	 * USE WHILE LOOP :With for loop its not correct as i++ will execute first .
	 *  BREAK THE INFINITE LOOP
	 * Time Complexity of Search = O(log n), n = size of sorted array and base of
	 * log is 2
	 * 
	 * @param sortedArray
	 *            : Array must be in increasing order
	 * @param input
	 * @return: If found => Index of Array Else return negative number(-1)
	 */
	public static int binarySearchSortedArray(int[] sortedArray, int input) {
		// Boundary Condition
		if (sortedArray == null || sortedArray.length == 0) {
			return -1;
		}
		int start = 0;
		int end = sortedArray.length - 1;
		int mid = (start + end) / 2;
		while (start <= mid) {
			mid = (start + end) / 2;
			// System.out.println("start = " + start + ", end = " + end + ", mid = " + mid);
			if (input < sortedArray[mid]) {
				end = mid;
			} else if (input == sortedArray[mid]) {
				return mid;
			} else {
				start = mid;
			}
			// To avoid infinite loop
			if (start == mid && end == (mid + 1)) {
				break;
			}
		}

		return -1;
	}

	/**
	 * USE WHILE LOOP :With for loop its not correct as i++ will execute first '
	 * 
	 * Time Complexity of Search = O(log n), n = size of sorted array and base of
	 * log is 2
	 * 
	 * @param sortedArray
	 *            : Array must be in increasing order
	 * @param input
	 * @return: If found => Index of Array Else return negative number(-1)
	 */
	public static int WRONG_binarySearchSortedArray(int[] sortedArray, int input) {
		// Boundary Condition
		if (sortedArray == null || sortedArray.length == 0) {
			return -1;
		}
		int start = 0;
		int end = sortedArray.length - 1;
		for (int i = start; i <= end; i++) {
			int mid = (start + end) / 2;
			System.out.println("start = " + start + ", end = " + end + ", mid = " + mid);
			if (start == end) {
				break;
			}
			if (input < sortedArray[mid]) {
				end = mid;
			} else if (input == sortedArray[mid]) {
				return mid;
			} else {
				start = mid;
			}
			System.out.println("AFTER:: start = " + start + ", end = " + end + ", i = " + i);

		}
		return -1;
	}
}
