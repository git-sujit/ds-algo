package com.sks.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RandomProblems {

	public static void main(String[] args) {
		others();
	}

	public static void others() {
		List<LinkedList<String>> ht = new ArrayList<LinkedList<String>>();

		StringBuilder sb = new StringBuilder();
		sb.append("John");
		sb.append("is");
		sb.append("Boss");

		System.out.println(sb.indexOf("is"));
	}
}
