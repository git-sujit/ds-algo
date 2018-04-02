package com.sks.learn.ctci6.chap6;

import java.util.ArrayList;
import java.util.List;

public class Chap6Implementation {

	public static void main(String[] args) {
		// firstNprimes(5);
		System.out.println(isPrime(53));
		System.out.println(isPrimeImproved(53));

	}

	/**
	 * Not fully implemented
	 * 
	 * @param max
	 */
	public static void sieveOfEratosthnes(int max) {
		boolean[] isPrime = new boolean[max + 1];
		for (int i = 0; i < max + 1; i++) {
			isPrime[i] = true;
		}

		isPrime[2] = false;
		for (int i = 2; i < max; i++) {
			if (isPrime[i]) {
				crossOff(isPrime, i);
			}
		}

	}

	public static void crossOff(boolean[] a, int p) {
		for (int i = p + 1; i < a.length; i++) {
			if (i % p == 0) {

			}
		}
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
