package com.sks.learn.dsalgo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sks.learn.algo.SortingAlgorithms;
import com.sks.learn.dsalgo.testutility.CSVReader;
import com.sks.learn.dsalgo.testutility.ValidationUtility;

public class SortingAlgorithmTestCases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(
				"################################ START :: SORTING ALGORITHMS ################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out
				.println("################################ END :: SORTING ALGORITHMS ################################");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertionSort() {
		System.out.println(
				"------------------------------------- START: INSERTION SORT -------------------------------------");
		for (ArrayList<Integer> input : CSVReader.readCSVFile()) {
			System.out.println("IP:Size=" + input.size() + "==>" + input);
			//long tStart = System.currentTimeMillis();
			SortingAlgorithms.insertionSort(input);
			//long tEnd = System.currentTimeMillis();
			//System.out.println("Time Taken(in millis) = " + (tEnd - tStart));
			assertTrue("Is Sorted: ", ValidationUtility.isSortedNonDecreasing(input));
			System.out.println("OP:Size=" + input.size() + "==>" + input);
		}
		System.out.println(
				"------------------------------------- END: INSERTION SORT -------------------------------------");
	}

	@Test
	public void testBubbleSort() {
		System.out.println(
				"------------------------------------- START: BUBBLE SORT -------------------------------------");
		for (ArrayList<Integer> input : CSVReader.readCSVFile()) {
			System.out.println("IP:Size=" + input.size() + "==>" + input);
			SortingAlgorithms.bubbleSort_Max(input);
			assertTrue("Is Sorted: ", ValidationUtility.isSortedNonDecreasing(input));
			System.out.println("OP:Size=" + input.size() + "==>" + input);
		}
		System.out.println(
				"------------------------------------- END: BUBBLE SORT -------------------------------------");
	}
}
