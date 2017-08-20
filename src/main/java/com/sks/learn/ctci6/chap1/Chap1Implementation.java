package com.sks.learn.ctci6.chap1;

import java.util.HashSet;
import java.util.Set;

public class Chap1Implementation implements Chap1Contract {

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

}
