package com.sks.learn.dsalgo;

import com.sks.learn.algo.SearchingAlgorithms_DEPRECATED;
import org.junit.*;

public class SearchingAlgorithmTestCases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(
				"################################ START :: SEARCHING ALGORITHMS ################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println(
				"################################ END :: SEARCHING ALGORITHMS ################################");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinarySearchSortedArray_ITERATIVE() {
		int[] sortedArray = new int[10];
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = 1 + i * (i + 1);
		}
		for (int i = 0; i < sortedArray.length; i++) {
			if (i == sortedArray.length - 1) {
				System.out.println(sortedArray[i]);
			} else {
				System.out.print(sortedArray[i] + "-");
			}
		}
		for (int i = 0; i < sortedArray.length; i++) {
			// Positive Test Case
			int input = 1 + i * (i + 1);
			System.out.println("Iterative Binary Searching: " + input);
			int output = SearchingAlgorithms_DEPRECATED.binarySearchSortedArrayIterative(sortedArray, input);
			System.out.println("Found At Index: " + output);
			// assertTrue(output > 0);
			// Negative Test Case
			input = 2 + i * (i + 1);
			System.out.println("Iterative Binary Searching:  " + input);
			output = SearchingAlgorithms_DEPRECATED.binarySearchSortedArrayIterative(sortedArray, input);
			System.out.println("Found At Index: " + output);
			// assertFalse(output > 0);
		}
	}

	@Test
	public void testBinarySearchSortedArray_RECURSIVE() {
		int[] sortedArray = new int[10];
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = 1 + i * (i + 1);
		}
		for (int i = 0; i < sortedArray.length; i++) {
			if (i == sortedArray.length - 1) {
				System.out.println(sortedArray[i]);
			} else {
				System.out.print(sortedArray[i] + "-");
			}
		}
		for (int i = 0; i < sortedArray.length; i++) {
			// Positive Test Case
			int input = 1 + i * (i + 1);
			System.out.println("Recursive Binary Searching: " + input);
			int output = SearchingAlgorithms_DEPRECATED.binarySearchSortedArrayRecursive(sortedArray, 0, sortedArray.length - 1,
					input);
			System.out.println("Found At Index: " + output);
			// assertTrue(output > 0);
			// Negative Test Case
			input = 2 + i * (i + 1);
			System.out.println("Recursive Binary Searching: " + input);
			output = SearchingAlgorithms_DEPRECATED.binarySearchSortedArrayRecursive(sortedArray, 0, sortedArray.length - 1,
					input);
			System.out.println("Found At Index: " + output);
			// assertFalse(output > 0);
		}
	}
}
