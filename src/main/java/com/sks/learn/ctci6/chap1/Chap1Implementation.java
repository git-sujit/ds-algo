package com.sks.learn.ctci6.chap1;

import java.util.HashSet;
import java.util.Set;

public class Chap1Implementation implements Chap1Contract {

	/**
	 * Time Complexity = O(length of String): Linear
	 * 
	 * Space Complexity = O(length of String), Extra Set
	 */
	@Override
	public boolean isUniqueExtraSpace(String s) {
		Set<Character> existingCharSet = new HashSet<Character>();
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			if (existingCharSet.contains(c)) {
				return false;
			}
			existingCharSet.add(c);
		}
		System.out.println("existingCharSet=" + existingCharSet);
		return true;
	}

	/**
	 * Time Complexity = O(n^2): Quadratic
	 * 
	 * Space Complexity = O(1) [In-Memory]
	 */
	@Override
	public boolean isUniqueInMemory(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Time Complexity = O(length of String): Linear
	 * 
	 * Space Complexity = O(length of String), Extra Char[]
	 */
	@Override
	public boolean isUniqueCtci(String s) {
		int sLen = s.length();
		// Assumption: Character set is ASCI only
		// Char is 16 bit: First 128 Unicode Code points are ASCII
		// Extended ASCII: 256
		if (sLen > 128) {
			return false;
		}
		boolean[] bArr = new boolean[128];
		for (int i = 0; i < sLen; i++) {
			char currC = s.charAt(i);
			if (bArr[currC]) {
				return false;
			}
			bArr[currC] = true;
		}
		return true;
	}

	/**
	 * Time Complexity = O(s1Len*s2Len): Quadratic
	 * 
	 * Space Complexity = O(1), In Memory
	 */
	@Override
	public boolean isPermutationInMemory(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		if (s1Len != s2Len) {
			return false;
		}
		for (int i = 0; i < s1Len; i++) {
			char c1 = s1.charAt(i);
			boolean found = false;
			for (int j = 0; j < s2Len; j++) {
				char c2 = s2.charAt(j);
				if (c1 == c2) {
					found = true;
				}
			}
			if (!found) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int i = 0;
		while (i < len) {
			System.out.println(" i = " + i);
			char c = s.charAt(i);
			int count = 1;
			// TO STOP INFINITE LOOP
			if (i == (len - 1)) {
				break;
			}
			for (int j = i + 1; j < len; j++) {
				i = j;
				char c1 = s.charAt(j);
				if (c == c1) {
					count++;
				} else {
					break;
				}
			}
			sb.append(""+c + count);
		}
		return sb.toString();
	}

}
