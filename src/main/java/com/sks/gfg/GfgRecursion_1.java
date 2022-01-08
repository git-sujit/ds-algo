package com.sks.gfg;

import java.util.*;

public class GfgRecursion_1 {

	public static void main(String[] args) {
		GfgRecursion_1 obj = new GfgRecursion_1();
		int n = 7;
		System.out.println("recursiveSequece(" + n + ") = " + recursiveSequece(n));
		// obj.gfSeriesTest();
		printBinaryHavingMore1s(3);
		int num = 10;
		System.out.println("\n*****isHappyNum, " + num + " : " + isHappyNumber(num, new ArrayList<Integer>()));
		n = 10;
		System.out.println("\nIterative: " + n + " no. element = " + obj.gfSeriesInterative(n));
		System.out.println("n = " + n + " ==> nextSmallestHappyNumber = " + nextSmallestHappyNumber(n));
	}

	/**
	 * Description:: Siddhant made a special series and named it as G.F
	 * Series.The series follows this trend Tn=(Tn-2)2-(Tn-1) in which the first
	 * and the second term are 0 and 1 respectively.Help Siddhant to find upto N
	 * terms of the series .
	 * 
	 * @param n
	 * @return
	 */
	public void gfSeriesTest() {
		Scanner scanner = new Scanner(System.in);
		int M = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < M; i++) {
			int N = Integer.parseInt(scanner.nextLine());

			for (int j = 1; j <= N; j++) {
				System.out.print(gfs(j));
				if (j == N) {
					System.out.println();
				} else {
					System.out.print(" ");
				}
			}
		}
	}

	private Map<Integer, Long> cache = new HashMap<Integer, Long>();

	public long gfs(int n) {
		if (n == 1) {
			cache.put(1, 0l);
			return 0;
		}
		if (n == 2) {
			cache.put(2, 1l);
			return 1;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		long nth = gfs(n - 2) * gfs(n - 2) - gfs(n - 1);
		cache.put(n, nth);
		return nth;
	}

	public long[] gfSeries(int n) {
		if (n < 1) {
			System.out.println("Invalid input");
		}
		long[] mem = new long[n + 1];
		gfSeries(n, mem);
		return mem;
	}

	private long gfSeries(int n, long[] m) {
		// Base Case
		if (n < 1) {
			System.out.println("Invalid Input");
			return -99999;
		} else if (n <= 2) {
			m[n] = n - 1;
		}
		// Recursive case
		else {
			if (m[n] == 0) {
				m[n] = gfSeries(n - 2, m) * gfSeries(n - 2, m) - gfSeries(n - 1, m);
			}
		}
		return m[n];
	}

	/**
	 * @param n
	 * @return
	 */
	public int gfSeriesInterative(int n) {
		if (n < 1) {
			System.out.println("Invalid input");
			return -1;
		}
		if (n <= 2) {
			return n - 1;
		}
		int prePrev = 0;
		int prev = 1;
		int pn = 0;
		for (int i = 3; i <= n; i++) {
			pn = prePrev * prePrev - prev;
			prePrev = prev;
			prev = pn;
		}
		return pn;
	}

	/**
	 * For a given non-negative integer N, find the next smallest Happy Number.
	 * A number is called happy if it leads to 1 after a sequence of steps where
	 * in each step number is replaced by sum of squares of its digit that is if
	 * we start with Happy Number and keep replacing it with digits square sum,
	 * we reach 1.
	 * 
	 * @param n
	 * @return
	 */
	public static int nextSmallestHappyNumber(int n) {
		while (true) {
			boolean isH = isHappyNumber(n + 1, new ArrayList<Integer>());
			System.out.println("Checking for " + (n + 1) + " :: " + isH);
			if (isH) {
				return n + 1;
			}
			return nextSmallestHappyNumber(n + 1);
		}
	}

	public static boolean isHappyNumber(int n, List<Integer> l) {
		if (n == 0)
			return false;
		// Base Case: Finally sum=1
		if (n == 1)
			return true;
		int sum = 0;
		while (n != 0) {
			int lastDigit = (n % 10);
			sum += (lastDigit) * (lastDigit);
			n = n / 10;
		}
		// List to stop infinite recursion
		if (l.contains(sum))
			return false;
		l.add(sum);
		return isHappyNumber(sum, l);
	}

	/**
	 * Given a positive integer n, print all n-bit binary numbers having more
	 * 1’s than 0’s for any prefix of the number.
	 */
	public static void printBinaryHavingMore1s(int n) {
		// printBinaryHavingMore1s("", 0, n);
		for (String s : getBinaryHavingMore1s("", 0, n)) {
			System.out.print(s + " ");
		}
	}

	public static void printBinaryHavingMore1s(String bNum, int extraOnes, int remainingPlaces) {
		System.out.println("printBinaryHavingMore1s(" + bNum + ", " + extraOnes + ", " + remainingPlaces + ")");
		// BASE CASE: Number Generated
		if (remainingPlaces == 0) {
			System.out.print(bNum + " ");
			return;
		}
		// RECURSION CASE
		// Append 1 at current number and reduce remaining places by 1
		printBinaryHavingMore1s(bNum + "1", extraOnes + 1, remainingPlaces - 1);
		// If more 1s than 0 then append 0 and reduce remaining by 1
		if (extraOnes > 0)
			printBinaryHavingMore1s(bNum + "0", extraOnes - 1, remainingPlaces - 1);
	}

	public static List<String> getBinaryHavingMore1s(int bNum) {
		if (bNum > 0)
			return getBinaryHavingMore1s("", 0, bNum);
		return null;
	}

	public static List<String> getBinaryHavingMore1s(String bNum, int extraOnes, int remainingPlaces) {
		System.out.println("getBinaryHavingMore1s(" + bNum + ", " + extraOnes + ", " + remainingPlaces + ")");
		List<String> res = new ArrayList<String>();
		// BASE CASE: Number Generated
		if (remainingPlaces == 0) {
			res.add(bNum + " ");
			return res;
		}
		// RECURSION CASE
		// Append 1 at current number and reduce remaining places by 1
		res.addAll(getBinaryHavingMore1s(bNum + "1", extraOnes + 1, remainingPlaces - 1));
		// If more 1s than 0 then append 0 and reduce remaining by 1
		if (extraOnes > 0)
			res.addAll(getBinaryHavingMore1s(bNum + "0", extraOnes - 1, remainingPlaces - 1));
		return res;
	}

	/**
	 * Given a string of digits, the task is to check if it is a ‘sum-string’. A
	 * string S is called a sum-string if a rightmost substring can be written
	 * as sum of two substrings before it and same is recursively true for
	 * substrings before it.
	 * 
	 * @param s
	 * @return
	 */
	public static int isSumString(String s) {
		// Boundary condition
		if (s == null)
			return 0;
		int len = s.length();
		if (len == 0)
			return 0;
		// The max lens
		int maxRightMostLen = len / 3;
		for (int i = 1; i <= maxRightMostLen; i++) {
			String rms = s.substring(len - i);
			int rmi = Integer.valueOf(rms);
			Set<Integer> rem = new HashSet<Integer>();
			for (int j = 0; j < len - i; j++) {
				int val1 = Integer.valueOf(s.substring(j, j + i));
				if (rem.contains(val1)) {
					return 1;
				}
				int diff = rmi - val1;
				if (diff >= 0) {
					rem.add(diff);
				}
			}
		}
		return 0;
	}

	/**
	 * A function f is defined as follows F(n)= (1) +(2*3) + (4*5*6) ... n.
	 * Given an integer n the task is to print the F(n)th term. <br>
	 * Input : 2 Output: 7 Series: (1) + (2*3)
	 * 
	 * Input : 4 Output: 5167 Series: (1) + (2*3) + (4*5*6) + (7*8*9*10)
	 * 
	 * @param n
	 * @return
	 */
	public static long recursiveSequece(int n) {
		System.out.println("recursiveSequece(" + n + ")");
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		long nth = n * (n - 1) / 2;
		long sum = 1;
		System.out.println("nth = " + nth);
		for (int i = 1; i <= n; i++) {
			sum *= (nth + i);
		}
		System.out.println("sum = " + sum);
		return recursiveSequece(n - 1) + sum;
	}

	public static int sumOfPowerOfNaturalMNumber(int x, int n) {
		int w = 0;
		for (int i = 1; Math.pow(i, n) < x; i++) {
			w += recSOPON(x, n, i);
		}
		return w;
	}

	public static int recSOPON(int x, int n, int k) {
		int w = 0;
		if (x == Math.pow(k, n))
			return 1;
		if (x < Math.pow(k, n))
			return 0;
		for (int i = k + 1; Math.pow(i, n) <= x; i++) {
			w += recSOPON((int) (x - Math.pow(k, n)), n, i);
		}
		return w;
	}
}
