package com.sks.learn.ctci6.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class Chap4Implementation implements Chap4Contract {

	public static void main(String[] args) {
		// Node root = prepareGraph();
		Chap4Implementation obj = new Chap4Implementation();
		obj.stackAndQueueInJava();

		// Find Path
		Node root = new Node("R");
		Node one = new Node("1");
		Node two = new Node("2");
		Node three = new Node("3");
		Node four = new Node("4");
		Node five = new Node("5");
		Node six = new Node("6");
		Node seven = new Node("7");
		root.setAdjacencyList(Arrays.asList(new Node[] { one, two }));
		one.setAdjacencyList(Arrays.asList(new Node[] { three }));
		two.setAdjacencyList(Arrays.asList(new Node[] { five }));
		three.setAdjacencyList(Arrays.asList(new Node[] { six }));
		four.setAdjacencyList(Arrays.asList(new Node[] { two }));
		five.setAdjacencyList(Arrays.asList(new Node[] { six, seven }));
		six.setAdjacencyList(Arrays.asList(new Node[] { seven }));
		seven.setAdjacencyList(Arrays.asList(new Node[] { one, four }));

		System.out.println("Depth First Search :");
		obj.depthFirstSearch(root);
		System.out.println("Depth First Search(Lambda) :");
		obj.depthFirstSearch_lambda(root);
		// System.out.println("Breadth First Search :");
		// obj.breadthFirstSearch(root);
		
		System.out.println(
				"Does route exist between : " + three + ", " + seven + " = " + obj.doesRouteExists_BFS(three, seven));
		System.out.println(
				"Does route exist between : " + root + ", " + one + " = " + obj.doesRouteExists_BFS(root, one));

		System.out.println(
				"Does route exist between : " + three + ", " + root + " = " + obj.doesRouteExists_BFS(three, root));

		System.out.println(
				"Does route exist between : " + three + ", " + seven + " = " + obj.doesRouteExists_DFS(three, seven));
		System.out.println(
				"Does route exist between : " + root + ", " + one + " = " + obj.doesRouteExists_DFS(root, one));

		System.out.println(
				"Does route exist between : " + three + ", " + root + " = " + obj.doesRouteExists_DFS(three, root));
		int[] sortedArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("PrepareBST from: " + sortedArr + "\n" + obj.getBSTFromSortedArray(sortedArr));

		// System.out.println(
		// "getListOfDepths(BTNode root) = \n" +
		// obj.getListOfDepths(obj.getBSTFromSortedArray(sortedArr)));

		int n = 10;
		System.out.println("Fibonacci at position: " + n + ": " + obj.nthFibonacci(n));

		int[] arr = { 2, 5, 6, 7, 2, 3, 0, 1 };
		System.out.println("Un-sorted = ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		obj.selectionSort(arr);
		System.out.println("\nSorted = ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static Node prepareGraph() {
		Node root = new Node("R");
		Node one = new Node("1");
		Node two = new Node("2");
		Node three = new Node("3");
		Node four = new Node("4");
		Node five = new Node("5");
		Node six = new Node("6");
		Node seven = new Node("7");
		root.setAdjacencyList(Arrays.asList(new Node[] { one, two }));
		one.setAdjacencyList(Arrays.asList(new Node[] { three }));
		two.setAdjacencyList(Arrays.asList(new Node[] { five }));
		three.setAdjacencyList(Arrays.asList(new Node[] { six }));
		four.setAdjacencyList(Arrays.asList(new Node[] { two }));
		five.setAdjacencyList(Arrays.asList(new Node[] { six, seven }));
		six.setAdjacencyList(Arrays.asList(new Node[] { seven }));
		seven.setAdjacencyList(Arrays.asList(new Node[] { one, four }));
		return root;
	}

	@Override
	public void stackAndQueueInJava() {
		System.out.println("Exhibitting Queue Interface thru LinkedList :");
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		q.add("2");
		q.add("3");
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		System.out.println("Exhibitting Stack Class :");
		Stack<String> s = new Stack<String>();
		s.push("1");
		s.push("2");
		s.push("3");
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

	@Override
	// Recursive, Stack based
	public void depthFirstSearch(Node root) {
		if (root == null) {
			return;
		}
		visitNode(root);
		root.setVisited(true);
		for (Node n : root.getAdjacencyList()) {
			if (!n.isVisited()) {
				depthFirstSearch(n);
			}
		}
	}

	public void depthFirstSearch_lambda(Node root) {
		if (root == null) {
			return;
		}
		visitNode(root);
		root.setVisited(true);
		/*for (Node n : root.getAdjacencyList()) {
			if (!n.isVisited()) {
				depthFirstSearch(n);
			}
		}*/
		//root.getAdjacencyList().stream().filter((n1) -> !n1.isVisited()).forEach((n2) -> depthFirstSearch(n2));
		Stream<Node> stream = root.getAdjacencyList().stream();
		Stream<Node> filteredStream = stream.filter((n1) -> !n1.isVisited());
		filteredStream.forEach((n2) -> depthFirstSearch(n2));
	}
	
	private void visitNode(Node n) {
		System.out.println(n);
	}

	@Override
	// Iterative, Queue based
	public void breadthFirstSearch(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		root.setVisited(true);
		queue.add(root);
		while (!queue.isEmpty()) {
			// System.out.println("Queue Content: " + queue);
			Node n = queue.remove();
			visitNode(n);
			for (Node n1 : n.getAdjacencyList()) {
				if (!n1.isVisited()) {
					n1.setVisited(true);
					queue.add(n1);
				}
			}
		}
	}
	public void breadthFirstSearch_lambda(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		root.setVisited(true);
		queue.add(root);
		while (!queue.isEmpty()) {
			// System.out.println("Queue Content: " + queue);
			Node n = queue.remove();
			visitNode(n);
			for (Node n1 : n.getAdjacencyList()) {
				if (!n1.isVisited()) {
					n1.setVisited(true);
					queue.add(n1);
				}
			}
		}
	}
	@Override
	// Breadth-First-Search, Iterative + Queue Based
	public boolean doesRouteExists_BFS(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			throw new IllegalArgumentException("Either of the node is null");
		}
		Queue<Node> queue = new LinkedList<Node>();
		n1.setVisited(true);
		queue.add(n1);

		while (!queue.isEmpty()) {
			Node qNode = queue.remove();
			System.out.println("qNode = " + qNode);
			if (qNode.equals(n2)) {
				return true;
			}
			for (Node n1Adj : qNode.getAdjacencyList()) {
				if (!n1Adj.isVisited()) {
					n1Adj.setVisited(true);
					queue.add(n1Adj);
				}
			}
		}
		return false;
	}

	@Override
	// Depth-First-Search, Recursive + Stack Based
	public boolean doesRouteExists_DFS(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			throw new IllegalArgumentException("Either of the node is null");
		}
		if (n1.equals(n2)) {
			return true;
		}
		n1.setVisited(true);
		for (Node n : n1.getAdjacencyList()) {
			if (!n.isVisited()) {
				n.setVisited(true);
				doesRouteExists_DFS(n, n2);
			}
		}
		return false;
	}

	@Override
	public BTNode getBSTFromSortedArray(int[] arr) {
		return prepareBST(arr, 0, arr.length - 1);
	}

	private BTNode prepareBST(int[] arr, int start, int end) {
		if (start >= end) {
			return null;
		}
		int rootIndex = (start + end) / 2;
		BTNode n = new BTNode(arr[rootIndex]);
		n.setLeft(prepareBST(arr, start, rootIndex - 1));
		n.setRight(prepareBST(arr, rootIndex + 1, end));
		return n;
	}

	@Override
	public List<LinkedList<BTNode>> getListOfDepths(BTNode root) {
		if (root == null) {
			return null;
		}
		List<LinkedList<BTNode>> depthList = new ArrayList<LinkedList<BTNode>>();
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		int depth = 0;
		while (!q.isEmpty()) {
			BTNode qNode = q.remove();
			depthList.get(depth).add(qNode);
			q.add(qNode.getLeft());
			q.add(qNode.getRight());
		}
		return depthList;
	}

	@Override
	public int nthFibonacci(int n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		int fib = 0;
		int fib1 = 0;
		int fib2 = 1;
		for (int i = 0; i < n - 1; i++) {
			fib = fib1 + fib2;
			fib2 = fib1;
			fib1 = fib;
		}
		return fib;
	}

	@Override
	// Bubble the smallest at 0-index, second smallest at 1-index and so on
	public void selectionSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
