package com.sks.learn.dsalgo.testutility;

public class TestData {
	public static Integer[] unionFindData() {
		Integer[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < 10; i++) {
			data[i] = 10 + i;
		}
		return data;
	}
}
