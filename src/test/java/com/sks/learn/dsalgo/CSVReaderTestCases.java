package com.sks.learn.dsalgo;

import com.sks.learn.dsalgo.testutility.CSVReader;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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

	// Timeout to avoid infinite loops
	@Test(timeout = 1000)
	public void testCSVReader() {
		List<ArrayList<Integer>> csvDataList = CSVReader.readCSVFile();
		assertNotNull(csvDataList);
		assertNotEquals(csvDataList.size(), 0);
		System.out.println("csvDataList = " + csvDataList);
	}

}
