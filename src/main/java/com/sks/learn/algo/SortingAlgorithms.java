/*
 *@Author: Sujit K Singh
 *Data Structure & Algorithm 
 */
package com.sks.learn.algo;

import java.util.ArrayList;

public class SortingAlgorithms {
	/*
	 * INSERTION-SORT
	 * 
	 * INPUT : An array of integers, A
	 * Output: A permutation of A in non-decreasing order 
	 * 
	 * Best Case Scenario: Sorted Sequence : O(n) 
	 * Worst Case Scenario: Reverse Sorted Sequence : O(n^2)
	 * Average Case Scenario: Any permutation of number : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage
	 * HINT: At any point left-side of key is always sorted
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
			// Go from right to left in left-side of data-set: this will be efficient for sorted sequence for Insertion sort
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
	 * BUBBLE-SORT-MAX
	 * It will bubble up max values one-by-one to the right side
	 * 
	 * INPUT : An array of integers, A
	 * Output: A permutation of A in non-decreasing order 
	 * 
	 * Simplest and most-intuitive sorting algorithm
	 * Best Case Scenario: Sorted Sequence : O(n) 
	 * Worst Case Scenario: Reverse Sorted Sequence : O(n^2)
	 * Average Case Scenario: Any permutation of number : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage
	 * 
	 * HINT: With each iteration find the max and swap it in the end from right side, Sorting starts from Right
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
	 * BUBBLE-SORT-MIN
	 * It will bubble up min values one-by-one to the right side
	 * 
	 * INPUT : An array of integers, A
	 * Output: A permutation of A in non-decreasing order 
	 * 
	 * Simplest and most-intuitive sorting algorithm
	 * Best Case Scenario: Sorted Sequence : O(n) 
	 * Worst Case Scenario: Reverse Sorted Sequence : O(n^2)
	 * Average Case Scenario: Any permutation of number : O(n^2)
	 * 
	 * IN-PLACE sorting: No need of additional memory/storage
	 * 
	 * HINT: With each iteration find the min and swap it in the end from left side, Sorting starts from Left
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
