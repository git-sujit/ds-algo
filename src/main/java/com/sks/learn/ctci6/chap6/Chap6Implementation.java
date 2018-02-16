package com.sks.learn.ctci6.chap6;

import java.util.ArrayList;
import java.util.List;

public class Chap6Implementation {

	public static void main(String[] args) {
		// firstNprimes(5);
		System.out.println(isPrime(53));
		System.out.println(isPrimeImproved(53));

	}

	public static List<Integer> allPrimesLessThanMax_sieve_of_Eratosthenes(int max) {
		List<Integer> primeList = new ArrayList<Integer>();
		if (max < 2) {
			System.out.println("No prime numbers are less than " + max);
			return primeList;
		}

		return primeList;
	}

	public static boolean isPrimeImproved(int n) {
		if (n < 2) {
			return false;
		}
		int nsqrt = (int) Math.sqrt(n);
		for (int i = 2; i < nsqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void firstNprimes(int n) {
		int counter = 0;
		int i = 2;
		while (counter < n) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				counter++;
			}
			i++;
		}
	}
}
