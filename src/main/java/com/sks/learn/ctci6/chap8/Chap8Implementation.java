package com.sks.learn.ctci6.chap8;

import java.util.ArrayList;
import java.util.List;

public class Chap8Implementation {

	public static void main(String[] args) {
		System.out.println("recMultiply = " + recMultiply(3, 0, 0));

		List<String> l = perm_final("abc");
		for (String s : l) {
			System.out.print(s + " ");
		}
		System.out.println("\nNumber of permutatitons = " + l.size());
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
