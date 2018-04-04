/*
 *@Author: Sujit K Singh
 *Data Structure & Algorithm 
 */
package com.sks.learn.algo;

import java.util.ArrayList;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] a = { 20, 8, 17, 2, 5, 100, 1, -10, 0 };
		for (int i : a) {
			System.out.print(i + " ");
		}
		selectionSort(a);
		System.out.println("\nAfter Selection Sorting");
		for (int i : a) {
			System.out.print(i + " ");
		}
		int[] a1 = { 20, 8, 17, 2, 5, 100, 1, -10, 0 };
		System.out.println("");
		for (int i : a1) {
			System.out.print(i + " ");
		}
		bubbleSort(a1);
		System.out.println("\nAfter Bubble Sorting");
		for (int i : a) {
			System.out.print(i + " ");
		}
		int[] a2 = { 20, 8, 17, 2, 5, 100, 1, -10, 0 };
		System.out.println("");
		for (int i : a2) {
			System.out.print(i + " ");
		}
		insertionSort(a2);
		System.out.println("\nAfter Insertion Sorting");
		for (int i : a2) {
			System.out.print(i + " ");
		}
		int[] a3 = { 20, 8, 17, 2, 5, 100, 1, -10, 0, 7, 14, 500, 5, 67, 5, 3, 9, 23 };
		System.out.println("a3=");
		for (int i : a3) {
			System.out.print(i + " ");
		}
		shellSort(a3);
		System.out.println("\nAfter Shell Sorting");
		for (int i : a3) {
			System.out.print(i + " ");
		}

		System.out.println("\n***************Merge Sorted Arrays");
		int[] a4 = mergeSortedArrays(a2, a3);
		System.out.println("\nAfter Merging Sorted Arrays");
		for (int i : a4) {
			System.out.print(i + " ");
		}

	}

	/**
	 * UDEMY COURSE
	 */

	public static int[] mergeSortedArrays(int[] a1, int[] a2) {
		int len1 = a1.length;
		int len2 = a2.length;
		int[] a = new int[len1 + len2];
		int i = 0, j = 0, k = 0;
		while (i < len1 && j < len2) {
			if (a1[i] <= a2[j]) {
				a[k++] = a1[i++];
			} else {
				a[k++] = a2[j++];
			}
		}
		while (i < len1) {
			a[k++] = a1[i++];
		}
		while (j < len2) {
			a[k++] = a2[j++];
		}
		return a;
	}

	public static void mergeSortRecursive(int[] a) {
		if (a == null)
			return;
		mergeSortRecursive(a, 0, a.length);
	}

	public static void mergeSortRecursive(int[] a, int start, int end) {
		if(end == 0){
			return;
		}
		int mid = (start+end)/2;
		mergeSortRecursive(a, 0, mid);
		mergeSortRecursive(a, mid, end);
	}
	public static void shellSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		int len = a.length;
		// Take increment as half of size every time
		int increment = len / 2;
		while (increment >= 1) {
			for (int i = increment; i < len; i = i + increment) {
				for (int j = i; j > 0; j = j - increment) {
					if (a[j] < a[j - increment]) {
						int temp = a[j];
						a[j] = a[j - increment];
						a[j - increment] = temp;
					}
				}
			}
			increment = increment / 2;
		}
	}

	public static void selectionSort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}

	public static void bubbleSort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int swaps = 0;
			for (int j = 0; j < len - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swaps++;
				}
			}
			if (swaps == 0) {
				break;
			}
		}
	}

	public static void insertionSort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int len = a.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	/*
	 * INSERTION-SORT
	 * 
	 * INPUT : An array of integers, A Output: A permutation of A in
	 * non-decreasing order
	 * 
	 * Best Case Scenario: Sorted Sequence : O(n) Worst Case Scenario: Reverse
	 * Sorted Sequence : O(n^2) Average Case Scenario: Any permutation of number
	 * : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage HINT: At any point
	 * left-side of key is always sorted
	 */
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
		// First For loop starts with Second Element as Key
		// At any point all elements before key are sorted
		for (int i = 1; i < input.size(); i++) {
			int key = input.get(i);
			// Key divides the data-set into two parts
			// First: left-side of key is sorted
			// Second: right-side of key is not sorted
			// Now, we need to insert key in left-side
			// Go from right to left in left-side of data-set: this will be
			// efficient for sorted sequence for Insertion sort
			for (int j = i - 1; j >= 0; j--) {
				if (key < input.get(j)) {
					input.set(j + 1, input.get(j));
					input.set(j, key);
				}
				// For efficiency, come out of loop once Left-side is sorted
				else {
					break;
				}
			}
		}
		return input;
	}

	/*
	 * BUBBLE-SORT-MAX It will bubble up max values one-by-one to the right side
	 * 
	 * INPUT : An array of integers, A Output: A permutation of A in
	 * non-decreasing order
	 * 
	 * Simplest and most-intuitive sorting algorithm Best Case Scenario: Sorted
	 * Sequence : O(n) Worst Case Scenario: Reverse Sorted Sequence : O(n^2)
	 * Average Case Scenario: Any permutation of number : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage
	 * 
	 * HINT: With each iteration find the max and swap it in the end from right
	 * side, Sorting starts from Right
	 */
	public static ArrayList<Integer> bubbleSort_Max(ArrayList<Integer> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			// Initialize maxCounter=0 and start the loop from 1
			int indexOfMax = 0;
			for (int j = 1; j < size - i; j++) {
				if (input.get(indexOfMax) < input.get(j)) {
					indexOfMax = j;
				}
			}
			int maxValue = input.get(indexOfMax);
			input.set(indexOfMax, input.get(size - i - 1));
			input.set(size - i - 1, maxValue);
		}
		return input;
	}

	/*
	 * BUBBLE-SORT-MIN It will bubble up min values one-by-one to the right side
	 * 
	 * INPUT : An array of integers, A Output: A permutation of A in
	 * non-decreasing order
	 * 
	 * Simplest and most-intuitive sorting algorithm Best Case Scenario: Sorted
	 * Sequence : O(n) Worst Case Scenario: Reverse Sorted Sequence : O(n^2)
	 * Average Case Scenario: Any permutation of number : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage
	 * 
	 * HINT: With each iteration find the min and swap it in the end from left
	 * side, Sorting starts from Left
	 */
	public static ArrayList<Integer> bubbleSort_Min(ArrayList<Integer> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			// Initialize maxCounter=0 and start the loop from 1
			int minCounter = 0;
			for (int j = 1; j < size - i; j++) {
				if (input.get(minCounter) < input.get(j)) {
					minCounter = j;
				}
			}
			int maxValue = input.get(minCounter);
			input.set(minCounter, input.get(size - i - 1));
			input.set(size - i - 1, maxValue);
		}
		return input;
	}
}
