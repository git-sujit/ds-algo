package com.sks.interview2018;

import java.util.ArrayList;
import java.util.List;

public class Revise18 {

	public static void main(String[] args) {

	}

	/**
	 * EACH CHARACTER AS FIRST CHARACTER THEN ADD PERMUTAION OF REMAINING
	 * 
	 * P(ab) = a + P(b) , b + P(a)
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> permutations(String str) {
		if (str == null)
			return null;
		int len = str.length();
		List<String> lst = new ArrayList<String>();
		if (len == 0) {
			lst.add("");
			return lst;
		}
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0, i) + str.substring(i + 1);
			List<String> lst1 = permutations(rem);
			for (String str1 : lst1) {
				lst.add(ch + str1);
			}
		}
		return lst;
	}

}
