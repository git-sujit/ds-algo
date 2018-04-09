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

	/**
	 * Sorting Algorithms <br>
	 * - 1. Selection Sort: O(n^2), In-Place, Unstable sort (Natural way of
	 * sorting, Put min at first place and so on): Not data sensitive sort <br>
	 * - 2. Bubble Sort: O(n^2), In-Place, Unstable sort (Put max to the end for
	 * each pass): Improvement- If swaps zero then break because its sorted
	 * now<br>
	 * - 3. Insertion Sort: O(n^2), In-place, Stable Card Players) : There are
	 * many movements : Efficient when input is small and almost sorted<br>
	 * - 4. Shell Sort: O(n(logn)^2), In-place, Unstable : Improved Insertion
	 * Sort by making sublist and increments(5,3,1) : By shell- divide increment
	 * by 2 in each pass, should be relatively prime<br>
	 * - 5. Merge Sort: N(nlogn), Not in-place, Stable: Divide & Conquer,
	 * Recursive & Top-Down: Iterative is Bottom-Up <br>
	 * - 6. Quick Sort(Hoare-1959): Time=O(nlogn)- Space=O(n), Not in-place,
	 * Unstable Sort: Top 10 algorithm: Divide & Conquer-Pivot: Best Case: if
	 * partition is balanced(Half)- O(nlogn) : Worst Case: Reverse sorted-
	 * O(n^2) <br>
	 * 
	 * @param args
	 */
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

	/**
	 * Binary Search: Time Complexity- O(logn), In-Place
	 */
	public int binarySearch(int[] a, int s) {
		if (a == null || a.length == 0) {
			return -1;
		}
		return binarySearchRecursive(a, s, 0, a.length - 1);
	}

	public int binarySearchRecursive(int[] a, int s, int l, int h) {
		if (l > h) {
			return -1;
		}
		int m = (l + h) / 2;
		if (s < a[m]) {
			return binarySearchRecursive(a, s, l, m - 1);
		} else if (s > a[m]) {
			return binarySearchRecursive(a, s, m + 1, h);
		} else {
			return m;
		}
	}

	public int binarySearchIterative(int[] a, int s) {
		int l = 0;
		int h = a.length - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (s < a[m]) {
				h = m - 1;
			} else if (s > a[m]) {
				l = m + 1;
			} else {
				return m;
			}
		}
		return -1;
	}

	/**
	 * Sorting Algorithms
	 */
	public void mergeSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int[] res = new int[a.length];
		mergeSort(a, res, 0, a.length - 1);
	}

	private void mergeSort(int[] a, int[] res, int low, int up) {
		// Base Case of recursion
		if (low >= up)
			return;
		int med = (low + up) / 2;
		mergeSort(a, res, low, med);
		mergeSort(a, res, med + 1, up);
		merge(a, res, low, med, med + 1, up);
		copy(a, res, low, up);
	}

	private void merge(int[] a, int[] res, int l1, int u1, int l2, int u2) {
		int i = l1;
		int j = l2;
		int k = l1;
		while ((i <= u1) && (j <= u2)) {
			if (a[i] <= a[j]) {
				res[k++] = a[i++];

			} else {
				res[k++] = a[j++];
			}
		}
		while (i <= u1) {
			res[k++] = a[i++];

		}
		while (j < u2) {
			res[k++] = a[j++];
		}
	}

	private void copy(int[] a, int[] res, int low, int up) {
		for (int i = low; i <= up; i++) {
			a[i] = res[i];
		}

	}

	public void quickSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int low, int up) {
		if (low >= up)
			return;
		int pivot = partition(a, low, up);
		quickSort(a, low, pivot - 1);
		quickSort(a, pivot + 1, up);
	}

	private int partition(int[] a, int low, int up) {
		int temp, i, j, pivot;
		pivot = a[low];
		i = low + 1;
		j = up;
		while (i <= j) {
			while (a[i] < pivot && i < up) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			} else {
				break;
			}

		}
		return j;
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
	 * Binary Tree Algorithms
	 */
	class BTNode {
		public int data;
		public BTNode left;
		public BTNode right;

		@Override
		public boolean equals(Object obj) {
			return this.data == ((BTNode) obj).data;
		}
	}

	/**
	 * TIME COMPLEXITY: O(N)
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public BTNode lowestCommonAncestor(BTNode root, BTNode n1, BTNode n2) {
		if (root == null) {
			return null;
		}
		if (root == n1 || root == n2) {
			return root;
		}
		BTNode lcn = lowestCommonAncestor(root.left, n1, n2);
		BTNode rcn = lowestCommonAncestor(root.right, n1, n2);

		if (lcn != null && rcn != null) {
			return root;
		}
		if (lcn == null && rcn == null) {
			return null;
		}
		if (lcn == null && rcn != null) {
			return rcn;
		}
		if (lcn != null && rcn == null) {
			return lcn;
		}
		return null;
		// Short Form
		// return lcn != null ? lcn : rcn;

	}

	public BTNode lowestCommonAncestor_BST_Recursive(BTNode root, BTNode n1, BTNode n2) {
		if (root == null)
			return null;
		if (root.data > Math.max(n1.data, n2.data)) {
			return lowestCommonAncestor_BST_Recursive(root.left, n1, n2);
		} else if (root.data < Math.min(n1.data, n2.data)) {
			return lowestCommonAncestor_BST_Recursive(root.right, n1, n2);
		} else {
			return root;
		}
	}

	public BTNode lowestCommonAncestor_BST(BTNode root, BTNode n1, BTNode n2) {
		if (root == null)
			return null;
		BTNode curr = root;
		while (curr != null) {
			if (n1.data < root.data && n2.data < root.data) {
				curr = root.left;
				continue;
			} else if (n1.data > root.data && n2.data > root.data) {
				curr = root.right;
				continue;
			} else {
				return curr;
			}
		}
		return null;
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
	 * @param n
	 */
	public void dfs(Node n) {
		// Base Case
		if (n == null) {
			return;
		}
		// Visit the Node
		System.out.println(n.data);
		n.visited = true;

		// Visit the children (Stack behavior) because the children which is
		// last is visited first(LIFO)
		for (Node cn : n.children) {
			// Recursive Case
			if (!cn.visited) {
				dfs(cn);
			}
		}
	}

	/**
	 * Iterative BFS algorithm <br>
	 * Queue Based <br>
	 * Kind of Level Order Traversal <br>
	 * 
	 * @param n
	 */
	public void bfs(Node n) {
		if (n == null) {
			return;
		}
		Queue<Node> cq = new LinkedList<Node>();
		cq.add(n);
		bfs(n, cq);
	}

	private void bfs(Node p, Queue<Node> cq) {
		while (!cq.isEmpty()) {
			// Visit Node
			Node n = cq.remove();
			if (!n.visited) {
				System.out.println(n.data);
				n.visited = true;
			}
			Node[] children = n.children;
			cq.addAll(Arrays.asList(children));
		}
	}

}
