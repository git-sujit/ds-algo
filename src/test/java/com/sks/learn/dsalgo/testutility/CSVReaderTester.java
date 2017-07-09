package com.sks.learn.dsalgo.testutility;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CSVReaderTester {
	@Rule
	public TestRule watcher = new TestWatcher() {
		protected void starting(Description description) {
			System.out.println("************************Starting test: " + description.getDisplayName()
					+ "************************");
		}
	};

	@Test
	public void testCSVReader() {
		List<ArrayList<Integer>> csvDataList = CSVReader.readCSVFile();
		assertNotNull(csvDataList);
		assertNotEquals(csvDataList.size(), 0);
		System.out.println("csvDataList = " + csvDataList);
	}
}
