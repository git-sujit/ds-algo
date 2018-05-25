package com.sks.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LeetCodeUtility_EASY {
	public static void main(String[] args) {
		testHashSet();
		System.out.println("is Happy = " + isHappy_RECURSIVE(19));
		String s1 = "PAYPALISHIRING";
		System.out.println("s1=" + s1 + ", converted=" + convert(s1, 3));
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 4, 7, 8 };
		for (int i : nums) {
			System.out.print(i + ",");
		}
		System.out.println("\nNon dupes = " + removeDuplicates(nums));
		for (int i : nums) {
			System.out.print(i + " ");
		}
		String str = "[";
		System.out.println("str=" + str + ", isValidBrackets=" + isValidBrackets(str));
		int i = 110;
		System.out.println("Number=" + i + ", isPalindrome=" + isPalindrome(i));
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

		String haystack = "mississippi";
		String needle = "issip";
		System.out.println("Found at : " + strStr(haystack, needle));

	}

	public int lengthOfLastWord(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		int len = s.length();
		String lastWord = "";
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				lastWord = "";
			} else {
				lastWord = lastWord + c;
			}
		}
		System.out.println("lastWord = " + lastWord);
		return lastWord.length();
	}

	public static boolean isHappy(int n) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(n);
		int squareSum = squareDigitSum(n);
		System.out.println("squareSum = " + squareSum);
		while (squareSum != 1) {
			if (!s.add(squareSum)) {
				return false;
			}
			squareSum = squareDigitSum(squareSum);
		}
		return true;
	}

	public static boolean isHappy_RECURSIVE(int n) {
		int squareSum = squareDigitSum(n);
		System.out.println("squareSum = " + squareSum);
		if (squareSum == 1) {
			return true;
		}
		return isHappy_RECURSIVE(squareSum);
	}

	private static int squareDigitSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum = sum + (int) Math.pow(n % 10, 2);
			n = n / 10;
		}
		return sum;
	}

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int add = 1;
		int[] result = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			int sum = digits[i] + add;
			if (sum >= 10) {
				add = 1;
				result[i] = sum % 10;
			} else {
				add = 0;
				result[i] = sum;
			}

		}
		if (add == 1) {
			int[] result1 = new int[len + 1];
			result1[0] = add;
			for (int i = 0; i < len; i++) {
				result1[i + 1] = result[i];
			}
			return result1;
		}
		return result;
	}

	// TODO
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (hasDuplicates(board, 0, i, 9, i)) {
				return false;
			}
			if (hasDuplicates(board, i, 0, i, 9)) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (hasDuplicates(board, i * 3, j * 3, i * 3 + 3, j * 3 + 3)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean hasDuplicates(char[][] board, int x1, int y1, int x2, int y2) {
		String existing = "";
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (board[i][j] != '.' && existing.contains("" + board[i][j])) {
					return true;
				}
			}
		}
		return false;
	}

	public static int strStr1(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	public static int strStr(String haystack, String needle) {
		if (haystack == null || "".equals(haystack) || needle == null || "".equals(needle)) {
			return -1;
		}
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return -1;
		}
		int i = 0, j = 0;
		while (i < len1) {
			char ch = haystack.charAt(i);
			char cn = needle.charAt(j);
			while (ch == cn && j < len2) {
				if (j == len2 - 1) {
					return i;
				}
				j++;
				ch = haystack.charAt(i + j);
				cn = needle.charAt(j);
			}
			j = 0;
			i++;
		}
		return -1;
	}

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int i = 0;
		for (i = 0; i < len; i++) {
			if (nums[i] == val) {
				for (int j = i + 1; j < len - 1; j++) {
				}
			}
		}
		return i + 1;
	}

	public static String convert(String s, int numRows) {
		int len = s.length();
		System.out.println("String length = " + len);
		String result = "";
		for (int i = 0; i < numRows; i++) {
			int limit = numRows + 1;
			if (i == numRows / 2) {
				limit = numRows / 2 + 1;
			}
			System.out.println("RowNum=" + i + ", limit=" + limit);
			for (int j = i; j < len; j = j + limit) {
				char c = s.charAt(j);
				System.out.print(j + ":" + c + " ");
				result += c;
			}
		}
		return result;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public ListNode mergeSortedList(ListNode n1, ListNode n2) {
		ListNode p1 = n1;
		ListNode p2 = n2;
		ListNode merged = null;
		if (p1 == null && p2 == null) {
			return null;
		} else if (p1 == null) {
			return p2;
		} else if (p2 == null) {
			return p1;
		}
		if (p1.val < p2.val) {
			merged = new ListNode(p1.val);
			p1 = p1.next;
		} else {
			merged = new ListNode(p2.val);
			p2 = p2.next;
		}
		ListNode pm = merged;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				ListNode ln = new ListNode(p1.val);
				pm.next = ln;
				pm = ln;
				p1 = p1.next;
			} else {
				ListNode ln = new ListNode(p2.val);
				pm.next = ln;
				pm = ln;
				p2 = p2.next;
			}
		}
		while (p1 != null) {
			ListNode ln = new ListNode(p1.val);
			pm.next = ln;
			pm = ln;
			p1 = p1.next;
		}
		while (p2 != null) {
			ListNode ln = new ListNode(p2.val);
			pm.next = ln;
			pm = ln;
			p2 = p2.next;
		}

		return merged;
	}

	public static boolean isValidBrackets(String s) {
		if (s == null || "".equals(s)) {
			return false;
		}
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stk.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stk.isEmpty()) {
					return false;
				}
				char c1 = stk.pop();
				if ((c == ')' && c1 != '(') || (c == '}' && c1 != '{') || (c == ']' && c1 != '[')) {
					return false;
				}
			}
		}
		return stk.isEmpty();
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

	public static boolean isPalindrome(int n) {

		if (n < 0 || (n % 10 == 0 && n != 0)) {
			return false;
		}
		int revertedNum = 0;
		int temp = n;
		while (temp != 0) {
			if (temp / 10 == 0) {
				revertedNum += temp % 10;
			} else {
				revertedNum = (revertedNum + temp % 10) * 10;
			}
			temp /= 10;
		}
		return n == revertedNum;
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

	/***
	 * Helping Classes
	 * 
	 * @author ssing69
	 *
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode(int data) {
			this.val = data;
		}
	}

	private static void testHashSet() {
		Set<Integer> s = new HashSet<Integer>();
		System.out.println(s.add(1));
		System.out.println(s.add(2));
		System.out.println(s.add(3));
		System.out.println(s.add(1));
	}

	public int longestPalindromePossible(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Set<Character> hs = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hs.contains(ch)) {
				hs.remove(ch);
				count++;
			} else {
				hs.add(ch);
			}
		}
		if (!hs.isEmpty())
			return count * 2 + 1;
		return count * 2;
	}
}
