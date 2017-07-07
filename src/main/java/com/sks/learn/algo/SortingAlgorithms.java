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
	 */
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
		// First For loop starts with Second Element as Key
		// At any point all elements before key are sorted
		for (int outerCounter = 1; outerCounter < input.size(); outerCounter++) {
			int key = input.get(outerCounter);
			// Key divides the data-set into two parts
			// First: left-side of key is sorted
			// Second: right-side of key is not sorted
			// Now, we need to insert key in left-side
			// Go from right to left in left-side of data-set: this will be efficient for sorted sequence for Insertion sort
			for (int innerCounter = outerCounter - 1; innerCounter >= 0; innerCounter--) {
				if (key < input.get(innerCounter)) {
					input.set(innerCounter + 1, input.get(innerCounter));
					input.set(innerCounter, key);
				}
				// For efficiency, come out of loop once Left-side is sorted
				else {
					break;
				}
			}
		}
		return input;
	}
}
