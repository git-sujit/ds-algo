package com.sks.learn.ctci6.chap8_recursion_DP;

import java.util.*;

public class Chap8Implementation {
	private static long moves_toi = 0;

	public static void main(String[] args) {
		long ts1 = System.currentTimeMillis();
		towerOfHanoi(4, 'A', 'B', 'C');
		System.out.println("No of moves in Hanoi = " + moves_toi);
		long ts2 = System.currentTimeMillis();
		System.out.println("Time Taken to nmove disk = " + (ts2 - ts1));
		// Parenthesis
		int n = 4;
		System.out.println("n=" + n);
		Set<String> ps = parens(n);
		System.out.println("Possible Parens: size=" + ps.size() + " --> " + ps);
		// Coins
		int amount = 100;
		System.out.println("No. of ways to make-" + amount + " = " + makeChange(amount));
		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<List<Integer>> subSet = powerSubSet(lst);
		System.out.println("subSet size = " + subSet.size() + "\n subSet = " + subSet);
		// System.out.println("recMultiply = " + recMultiply(3, 0, 0));
		System.out.println("recMultiply_1 = "+recMultiply_1(2,5));
		List<String> l = perm_final("abc");
		for (String s : l) {
			System.out.print(s + " ");
		}
		System.out.println("\nNumber of permutatitons = " + l.size());
	}

	public static void towerOfHanoi(int n, char s, char t, char d) {
		moves_toi++;
		if (n == 1) {
			System.out.println("Move disk-" + n + " ::  " + s + "->" + d);
			return;
		}
		towerOfHanoi(n - 1, s, d, t);
		System.out.println("Move disk-" + n + " ::  " + s + "->" + d);
		towerOfHanoi(n - 1, t, s, d);
	}

	public static Set<String> parens(int n) {
		Set<String> resultSet = new HashSet<String>();
		if (n == 0) {
			resultSet.add("");
			return resultSet;
		}
		Set<String> partials = parens(n - 1);
		for (String p : partials) {
			resultSet.add("()" + p);
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == '(')
					resultSet.add(p.substring(0, i + 1) + "()" + p.substring(i + 1));
			}
		}
		return resultSet;
	}

	public static int makeChange(int n) {
		int[] denomArray = { 25, 10, 5, 1 };
		return makeChange(n, denomArray, 0);
	}

	public static int makeChange(int n, int[] denomArray, int denomIndex) {
		// System.out.println("Calling- makeChange(" + n + ", " + denomArray +
		// ", " + denomIndex + ")");
		if (denomIndex >= denomArray.length - 1)
			return 1;
		int denom = denomArray[denomIndex];
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			int rem = n - i * denom;
			ways = ways + makeChange(rem, denomArray, denomIndex + 1);
		}
		return ways;
	}

	/**
	 * Logic: subset{1,2,3} = [subset{1,2}] + [3+subset{1,2}] <br>
	 * subset{} = {} subset{1} = {} + {1} <br>
	 * subset{1,2} = {}, {1} + {2}, {1,2} <br>
	 * subset{1,2,3} = {}, {1}, {2}, {1,2} + {3}, {1,3}, {2,3}, {1,2,3} <br>
	 * 
	 * Time Complexity = O(2^n) because each element has option Yes/No to be
	 * part of Set
	 * 
	 * @param lst
	 * @return
	 */
	public static List<List<Integer>> powerSubSet(List<Integer> lst) {
		if (lst == null)
			return null;
		int size = lst.size();
		List<List<Integer>> ss = new ArrayList<List<Integer>>();
		// Base case
		if (size == 0) {
			List<Integer> ss1 = new ArrayList<Integer>();
			ss.add(ss1);
			return ss;
		}
		// Recursive case
		Integer last = lst.get(size - 1);
		List<Integer> subList;
		if ((size - 2) >= 0) {
			subList = lst.subList(0, size - 1);
		} else {
			subList = new ArrayList<Integer>();
		}
		List<List<Integer>> pss = powerSubSet(subList);
		// 1. Add the partial set to original set
		ss.addAll(pss);
		// 2. Add last int to each List<Integer> of pss
		for (List<Integer> pssEle : pss) {
			// Shallow copy of arrayList
			List<Integer> pssEleCopy = new ArrayList<Integer>(pssEle);
			pssEleCopy.add(last);
			ss.add(pssEleCopy);
		}
		return ss;
	}

	public static int recMultiply(int n1, int n2) {
		if (n1 == 0 || n2 == 0) {
			return 0;
		}
		return recMultiply(n1, n2, 0);
	}

	public static int recMultiply(int n1, int n2, int temp) {
		if (n2 == 1) {
			return temp + n1;
		}
		temp = temp + n1;
		return recMultiply(n1, n2 - 1, temp);
	}

	public static int recMultiply_1(int n1, int n2) {
		if (n2 > n1) {
			return recMultiply_1(n2, n1);
		}
		if (n2 == 0) {
			return 0;
		}
		return n1 + recMultiply_1(n1, n2 - 1);
	}

	public static List<String> perm_final(String s) {
		if (s == null)
			return null;
		int len = s.length();
		List<String> lst = new ArrayList<String>();
		if (len == 0) {
			lst.add("");
			return lst;
		}
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			String rem = s.substring(0, i) + s.substring(i + 1);
			List<String> lst1 = perm_final(rem);
			for (String s1 : lst1) {
				lst.add(ch + s1);
			}
		}
		return lst;
	}

	public static List<String> perm(String s) {
		List<String> res = new ArrayList<String>();
		perm("", s, res);
		return res;
	}

	public static void perm(String pre, String rem, List<String> res) {
		int len = rem.length();
		if (len == 0) {
			res.add(pre);
		}
		for (int i = 0; i < len; i++) {
			String before = rem.substring(0, i);
			String after = rem.substring(i + 1, len);
			char c = rem.charAt(i);
			String prefix1 = pre + c;
			String remainder1 = before + after;
			// System.out.println("perm("+prefix1+","+remainder1+", "+res+")");
			perm(prefix1, remainder1, res);
		}
	}

	public static List<String> perm_1(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		int len = s.length();
		if (len == 1) {
			List<String> res = new ArrayList<String>();
			res.add(s);
			return res;
		}
		char ic = s.charAt(len - 1);
		return insertCharAt(perm_1(s.substring(0, len - 1)), ic);
	}

	public static List<String> insertCharAt(List<String> sl, char ic) {
		if (sl == null) {
			return null;
		}
		int len = sl.size();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			String str = sl.get(i);
			int sLen = str.length();
			for (int j = 0; j < sLen; j++) {
				String before = str.substring(0, j);
				String after = str.substring(j);
				res.add(before + ic + after);
			}
		}
		return res;
	}
}
