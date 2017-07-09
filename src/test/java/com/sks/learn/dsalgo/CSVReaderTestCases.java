package com.sks.learn.dsalgo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sks.learn.dsalgo.testutility.CSVReader;

public class CSVReaderTestCases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("################################ START :: CSV READER ################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("################################ END :: CSV READER ################################");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCSVReader() {
		List<ArrayList<Integer>> csvDataList = CSVReader.readCSVFile();
		assertNotNull(csvDataList);
		assertNotEquals(csvDataList.size(), 0);
		System.out.println("csvDataList = " + csvDataList);
	}

}
