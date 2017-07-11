package com.sks.learn.dsalgo.testutility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public static ArrayList<ArrayList<Integer>> readCSVFile() {
		
		String csvFile = "src/test/resources/SortingData.csv";
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<ArrayList<Integer>> testDataSet = new ArrayList<ArrayList<Integer>>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				ArrayList<Integer> dataList = new ArrayList<Integer>();
				// use comma as separator
				String[] dataArray = line.split(cvsSplitBy);
				if (dataArray != null && dataArray.length != 0) {
					for (int i = 0; i < dataArray.length; i++) {
						String data = dataArray[i];
						if (data != null && !"".equals(data)) {
							dataList.add(new Integer(data));
						}
					}
				}
				testDataSet.add(dataList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testDataSet;
	}
}