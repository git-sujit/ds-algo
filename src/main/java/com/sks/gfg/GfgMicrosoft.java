package com.sks.gfg;

import java.util.Scanner;

public class GfgMicrosoft {

	public static void main(String[] args) {
		// Getting input from user
		Scanner sc = new Scanner(System.in);
		int noOfInputs = sc.nextInt();
		System.out.println("noOfInputs = " + noOfInputs);
		for (int i = 0; i < noOfInputs; i++) {
			sc = new Scanner(System.in);
			String input = sc.nextLine();
			String[] arr = input.split(" ");
			if (arr.length >= 2) {
				System.out.println(arr[0] + " : " + arr[1]);
				int n = Integer.valueOf(arr[0]);
				int m = Integer.valueOf(arr[1]);
				System.out.println("closestNumber(" + n + ", " + m + ") = " + closestNumber(n, m));
			}
		}
	}

	public static int closestNumber(int n, int m) {
		int rem = n % m;
		int i = (m - rem);
		return n + i;
	}

}
