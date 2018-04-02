package com.sks.interview2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Revise18 {
	private static Map<Integer, List<Character>> itocMap = null;
	static {
		itocMap = new HashMap<Integer, List<Character>>();
		itocMap.put(1, Arrays.asList());
		itocMap.put(0, Arrays.asList());
		itocMap.put(2, Arrays.asList('a', 'b', 'c'));
		itocMap.put(3, Arrays.asList('d', 'e', 'f'));
		itocMap.put(4, Arrays.asList('g', 'h', 'i'));
		itocMap.put(5, Arrays.asList('j', 'k', 'l'));
		itocMap.put(6, Arrays.asList('m', 'n', 'o'));
		itocMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
		itocMap.put(8, Arrays.asList('t', 'u', 'v'));
		itocMap.put(9, Arrays.asList('w', 'x', 'y'));
	}

	public static void main(String[] args) {
		// Fibonnaci: Not efficient --> Time: O(2^n) Memory: In-Memory
		int n = 5;
		System.out.println("fibonacci_NOTefficient(" + n + ") = " + fibonacci_NOTefficient(10));
		// Fibonnaci: Efficient --> Time: O(2^n) Memory: O(n) memory of array
		System.out.println("fibonacci_efficient(" + n + ") = " + fibonacci_efficient(10));
		// (Memorization)
		// Combinations / Subsets
		System.out.println("################# Combinations / Subsets #################");
		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("Input:: List<Integer> = " + lst);
		List<List<Integer>> subSet = powerSubSet(lst);
		System.out.println("subSet size = " + subSet.size() + "\nsubSets = " + subSet);
		// Permutations
		System.out.println("################# Permutations / Different ordering of String  #################");
		String str = "abcde";
		System.out.println("Input:: String = " + str);
		List<String> l = permutations(str);
		System.out.println("Number of permutatitons = " + l.size() + "\nPermutations = " + l);
		// Letter combination on rotary phone
		System.out.println("################# Letter combination on rotary phone  #################");
		str = "23";
		System.out.println("Input:: String = " + str);
		List<String> lComs = letterCombinations(str);
		System.out.println("Number of permutatitons = " + lComs.size() + "\nPermutations = " + lComs);
	}

	public static int fibonacci_NOTefficient(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci_NOTefficient(n - 1) + fibonacci_NOTefficient(n - 2);
	}

	public static int fibonacci_efficient(int n) {
		int[] ma = new int[n + 1];
		return fibonacci(n, ma);
	}

	public static int fibonacci(int n, int[] ma) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (ma[n] == 0) {
			ma[n] = fibonacci(n - 1, ma) + fibonacci(n - 2, ma);
		}
		return ma[n];
	}

	public static void towerOfHanoi(int n, char s, char t, char d) {
		if (n == 1) {
			System.out.println("Move disk-" + n + " ::  " + s + "->" + d);
			return;
		}
		towerOfHanoi(n - 1, s, d, t);
		System.out.println("Move disk-" + n + " ::  " + s + "->" + d);
		towerOfHanoi(n - 1, t, s, d);
	}

	/**
	 * Chapter-8 of CTCI <br>
	 * Logic: subset{1,2,3} = [subset{1,2}] + [3+subset{1,2}] <br>
	 * subset{} = {} subset{1} = {} + {1} <br>
	 * subset{1,2} = {}, {1} + {2}, {1,2} <br>
	 * subset{1,2,3} = {}, {1}, {2}, {1,2} + {3}, {1,3}, {2,3}, {1,2,3} <br>
	 * 
	 * Size of subset = 2^n <br>
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

	/**
	 * EACH CHARACTER AS FIRST CHARACTER THEN ADD PERMUTAION OF REMAINING <br>
	 * P(ab) = a + P(b) , b + P(a)
	 * 
	 * Number of Permutations = NcN = n! <br>
	 * 
	 * Time Complexity: O(!n)
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> permutations(String str) {
		if (str == null)
			return null;
		int len = str.length();
		List<String> lst = new ArrayList<String>();
		if (len == 0) {
			lst.add("");
			return lst;
		}
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0, i) + str.substring(i + 1);
			List<String> lst1 = permutations(rem);
			for (String str1 : lst1) {
				lst.add(ch + str1);
			}
		}
		return lst;
	}

	/**
	 * Facebook Interview
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		if (digits == null)
			return null;
		int len = digits.length();
		List<String> lst = new ArrayList<String>();
		if (len == 0) {
			lst.add("");
			return lst;
		}
		try {
			Long l = new Long(digits);
		} catch (NumberFormatException ex) {
			System.out.println("Not valid number");
			ex.printStackTrace();
		}
		char ch = digits.charAt(0);
		List<Character> letters = itocMap.get(new Integer("" + ch));
		// System.out.println("ch=" + ch + ", letters=" + letters);
		String rem = digits.substring(1);
		List<String> partial = letterCombinations(rem);
		for (int i = 0; i < letters.size(); i++) {
			for (int j = 0; j < partial.size(); j++) {
				lst.add(letters.get(i) + partial.get(j));
			}
		}
		return lst;
	}

	/**
	 * Graph Algorithms
	 */
	class Node {
		public int data;
		public Node[] children;
		public boolean visited;
	}

	/**
	 * Recursive DFS algorithm <br>
	 * Stack Based
	 * 
	 * @param root
	 */
	public void dfs(Node root) {
		// Base Case
		if (root == null) {
			return;
		}
		// Visit the Node
		System.out.println(root.data);
		root.visited = true;
		// Visit the children (Stack behavior)
		for (Node n : root.children) {
			// Recursive Case
			if (!n.visited) {
				dfs(n);
			}
		}
	}

	/**
	 * Iterative NFS algorithm <br>
	 * Queue Based <br>
	 * Kind of Level Order Traversal <br>
	 * 
	 * @param root
	 */
	public void bfs(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> cq = new LinkedList<Node>();
		cq.add(root);
		bfs(root, cq);
	}

	private void bfs(Node p, Queue<Node> cq) {
		while (!cq.isEmpty()) {
			// Visit Node
			Node n = cq.remove();
			if (!n.visited) {
				System.out.println(n.data);
			}
			Node[] children = n.children;
			cq.addAll(Arrays.asList(children));
		}
	}

}
