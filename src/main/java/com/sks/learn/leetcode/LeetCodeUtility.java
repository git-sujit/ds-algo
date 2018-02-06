package com.sks.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LeetCodeUtility {
	public static void main(String[] args) {
		String roman = "XXXXC";
		System.out.println("Roman = " + roman + ", Decimal = " + romanToDecimal(roman));

		System.out.println("abs(int.min) = " + Math.abs(Integer.MIN_VALUE) + " : Integer.MIN_VALUE - 1= "
				+ (Integer.MIN_VALUE - 1) + ", " + Math.abs(Integer.MIN_VALUE - 1) + " : Integer.MIN_VALUE + 1= "
				+ (Integer.MIN_VALUE + 1) + ", " + Math.abs(Integer.MIN_VALUE + 1));

		int[] a = { 4, 6, 1, 9, 3, 8, 2, 4 };
		System.out.println(sumTwo(a, 11));
		String s = "abcadhjhfgjdhdskjfk";
		System.out.println("String=" + s + " :: Non reoeating Substrin = " + nonRepeatingSubString(s));
		System.out.println("String=" + s + " :: MaxLen of non-repeating substring = " + lengthOfLongestSubstring(s));
		int n = -235673;
		n = Integer.MIN_VALUE;
		n = Integer.MAX_VALUE;
		System.out.println("Reverse integer: " + n + " :: " + reverseInteger(n));

	}

	public static String sumTwo(int[] a, int t) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (m.containsKey(a[i])) {
				return m.get(a[i]) + "," + i;
			} else {
				m.put(t - a[i], i);
			}
		}
		return "";
	}

	public static String nonRepeatingSubString(String s) {
		StringBuilder sb = new StringBuilder();
		Set<Character> presentSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (presentSet.contains(c)) {
				return sb.toString();
			} else {
				presentSet.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int len = 0;
			Set<Character> existSet = new HashSet<Character>();
			for (int j = i; j < s.length(); j++) {
				char cj = s.charAt(j);
				if (existSet.contains(cj)) {
					break;
				} else {
					existSet.add(cj);
					len++;
				}
			}
			if (len > maxLen) {
				maxLen = len;
			}
		}
		return maxLen;
	}

	public static int reverseInteger(int n) {
		int result = 0;
		if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE)
			return result;
		while (n != 0) {
			result = 10 * result + (n % 10);
			n = n / 10;
		}
		return result;
	}

	public static boolean palindrome(int n) {
		String s = "" + n;
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean palindrome1(int n) {
		int temp = n;
		int d = 0;
		while (temp != 0) {
			temp = temp / 10;
			d++;
		}
		int piv = d / 2;
		temp = n;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i <= piv; i++) {
			int dig = temp % 10;
			temp = temp / 10;
			s.push(dig);
		}
		if (d % 2 != 0) {
			piv++;
		}
		return true;
	}

	public static int romanToDecimal(String roman) {
		int dec = 0;
		int len = roman.length();
		for (int i = 0; i < len; i++) {
			char c = roman.charAt(i);
			if (i == len - 2 && c == 'I') {
				char c1 = roman.charAt(i + 1);
				if (c1 != 'I') {
					dec += (romanRep(c1) - 1);
					break;
				}
				dec += romanRep(c);
			} else {
				dec += romanRep(c);
			}
		}
		return dec;
	}

	private static int romanRep(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String lcp = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String s = strs[i];
			int j = 0;
			while (j < lcp.length() && j < s.length()) {
				if (lcp.charAt(j) != s.charAt(j)) {

					break;
				}
				j++;
			}
			lcp = lcp.substring(0, j);
		}
		return lcp;
	}
}
