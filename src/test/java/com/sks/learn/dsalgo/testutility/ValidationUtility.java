package com.sks.learn.dsalgo.testutility;

import java.util.ArrayList;

public class ValidationUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param input
	 * @return
	 */
	public static boolean isSortedNonDecreasing(ArrayList<Integer> input) {
		for (int i = 1; i < input.size(); i++) {
			if (input.get(i - 1) > input.get(i)) {
				return false;
			}
		}
		return true;
	}
}
