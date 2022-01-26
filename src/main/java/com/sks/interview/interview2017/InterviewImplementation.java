package com.sks.interview.interview2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewImplementation implements InterviewContract {
	public static void main(String[] args) {
		InterviewContract obj = new InterviewImplementation();
		
		  List<String> outList = obj.getAllPossiblePermutations_FB_AUG_2017("118");
		  System.out.println("Permutation Output List: "); for (String s : outList) {
		  System.out.println(s); }
		 
		/*
		for (int i = 0; i < 30; i++) {
			System.out.println(("fib(" + i + ") = " + obj.fibonacci(i)));
		}
		*/
	}

	@Override
	public List<String> getAllPossiblePermutations_FB_AUG_2017(String input) {
		Map<Character, Character[]> masterMap = getMasterMap();
		char[] inArray = input.toCharArray();
		List<String> permInputList = new ArrayList<String>();
		for (char c : inArray) {
			StringBuilder sb = new StringBuilder();
			Character[] cArr = masterMap.get(c);
			for (Character c1 : cArr) {
				sb.append(c1);
			}
			permInputList.add(sb.toString());
		}
		System.out.println("Permutation Input List: ");
		for (String s : permInputList) {
			System.out.println(s.toString());
		}
		List<String> permOutputList = new ArrayList<String>();

		return getPermutations(permInputList, permOutputList, permInputList.size() - 1);
	}

	private List<String> getPermutations(List<String> permInputList, List<String> permOutputList, int index) {
		if (index == permInputList.size())
			return permOutputList;
		for (int i = 0; i < permOutputList.size(); i++) {
			StringBuilder sb = new StringBuilder();
			String permInput = permInputList.get(index);
			for (int j = 0; j < permInputList.get(index).length(); j++) {
				sb.append(permInput.charAt(j));
			}
			permOutputList.add(sb.toString());
		}
		for (int i = 0; i < permInputList.size(); i++) {
			getPermutations(permInputList, permOutputList, i);
		}
		return permOutputList;
	}

	private Map<Character, Character[]> getMasterMap() {
		Map<Character, Character[]> masterMap = new HashMap<Character, Character[]>();
		masterMap.put('1', new Character[] { 'a', 'b', 'c' });
		masterMap.put('2', new Character[] { 'd', 'e', 'f' });
		masterMap.put('3', new Character[] { 'g', 'h', 'i' });
		masterMap.put('4', new Character[] { 'j', 'k', 'l' });
		masterMap.put('5', new Character[] { 'm', 'n', 'o' });
		masterMap.put('6', new Character[] { 'p', 'q', 'r' });
		masterMap.put('7', new Character[] { 's', 't', 'u' });
		masterMap.put('8', new Character[] { 'v', 'w', 'x' });
		masterMap.put('9', new Character[] { 'y', 'z' });
		return masterMap;
	}

	@Override
	public int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}

}
