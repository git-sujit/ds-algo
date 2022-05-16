package com.sks.XDEPRECATED.interview2018;

public class RecursiveAlgos {

	public static void main(String[] args) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println("MIN = " + min + ", MAX = " + max);
		min = Integer.MIN_VALUE;
		for (int i = 0; i < 10; i++) {
			System.out.println(min--);
		}
	}

}
