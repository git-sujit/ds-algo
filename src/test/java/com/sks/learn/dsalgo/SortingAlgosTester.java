/**
 * 
 */
package com.sks.learn.dsalgo;

import java.util.ArrayList;

import org.junit.Test;

import com.sks.learn.algo.SortingAlgorithms;
import com.sks.learn.algo.utility.CSVReader;


/**
 * @author Sujit
 *
 */
public class SortingAlgosTester {
	//@Test
	public void testInsertionSort() {
		for(ArrayList<Integer> input: CSVReader.readCSVFile()){
			System.out.println("------------------------------------- INSERTION SORT -------------------------------------");
			System.out.println("IP:Size="+input.size()+"==>"+input);
			long tStart = System.currentTimeMillis();
			SortingAlgorithms.insertionSort(input);
			long tEnd = System.currentTimeMillis();
			System.out.println("Time Taken(in millis) = "+(tEnd-tStart));
			System.out.println("OP:Size="+input.size()+"==>"+input);
		}
	}
	
	@Test
	public void testBubbleSort() {
		for(ArrayList<Integer> input: CSVReader.readCSVFile()){
			System.out.println("------------------------------------- BUBBLE SORT -------------------------------------");
			System.out.println("IP:Size="+input.size()+"==>"+input);
			long tStart = System.currentTimeMillis();
			SortingAlgorithms.bubbleSort_Max(input);
			long tEnd = System.currentTimeMillis();
			System.out.println("Time Taken(in millis) = "+(tEnd-tStart));
			System.out.println("OP:Size="+input.size()+"==>"+input);
		}
	}
}
