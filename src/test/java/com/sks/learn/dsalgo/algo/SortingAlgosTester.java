/**
 * 
 */
package com.sks.learn.dsalgo.algo;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.sks.learn.algo.SortingAlgorithms;
import com.sks.learn.dsalgo.testutility.CSVReader;

/**
 * @author Sujit
 *
 */
public class SortingAlgosTester {
	@Rule
	public TestRule watcher = new TestWatcher() {
		protected void starting(Description description) {
			System.out.println("************************Starting test: " + description.getDisplayName()
					+ "************************");
		}
	};

	@Test
	public void testInsertionSort() {
		for (ArrayList<Integer> input : CSVReader.readCSVFile()) {
			System.out.println(
					"------------------------------------- INSERTION SORT -------------------------------------");
			System.out.println("IP:Size=" + input.size() + "==>" + input);
			long tStart = System.currentTimeMillis();
			SortingAlgorithms.insertionSort(input);
			long tEnd = System.currentTimeMillis();
			System.out.println("Time Taken(in millis) = " + (tEnd - tStart));
			System.out.println("OP:Size=" + input.size() + "==>" + input);
		}
	}

	@Test
	public void testBubbleSort() {
		for (ArrayList<Integer> input : CSVReader.readCSVFile()) {
			System.out
					.println("------------------------------------- BUBBLE SORT -------------------------------------");
			System.out.println("IP:Size=" + input.size() + "==>" + input);
			long tStart = System.currentTimeMillis();
			SortingAlgorithms.bubbleSort_Max(input);
			long tEnd = System.currentTimeMillis();
			System.out.println("Time Taken(in millis) = " + (tEnd - tStart));
			System.out.println("OP:Size=" + input.size() + "==>" + input);
		}
	}
}
