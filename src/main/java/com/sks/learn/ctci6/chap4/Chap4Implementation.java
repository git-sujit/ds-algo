package com.sks.learn.ctci6.chap4;

import java.util.Arrays;
import java.util.LinkedList;

public class Chap4Implementation implements Chap4Contract {

	public static void main(String[] args) {
		// Node root = prepareGraph();
		Chap4Implementation obj = new Chap4Implementation();
		// System.out.println("Depth First Search :");
		// obj.depthFirstSearch(root);
		// System.out.println("Breadth First Search :");
		// obj.breadthFirstSearch(root);

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
		System.out.println("Does route exist = " + obj.doesRouteExists(three, seven));

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

	private void visitNode(Node n) {
		System.out.println(n);
	}

	@Override
	// Iterative, Queue based
	public void breadthFirstSearch(Node root) {
		if (root == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		root.setVisited(true);
		queue.push(root);
		while (!queue.isEmpty()) {
			// System.out.println("Queue Content: " + queue);
			Node n = queue.pop();
			visitNode(n);
			for (Node n1 : n.getAdjacencyList()) {
				if (!n1.isVisited()) {
					n1.setVisited(true);
					queue.push(n1);
				}
			}
		}
	}

	@Override
	// Breadth-First-Search, Iterative + Queueu Based
	public boolean doesRouteExists(Node n1, Node n2) {
		if (n1 == null || n2 == null) {
			throw new IllegalArgumentException("Either of the node is null");
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		n1.setVisited(true);
		queue.push(n1);

		while (!queue.isEmpty()) {
			Node qNode = queue.pop();
			if (qNode.equals(n2)) {
				return true;
			}
			for (Node n1Adj : n1.getAdjacencyList()) {
				if (!n1Adj.isVisited()) {
					n1Adj.setVisited(true);
					queue.push(n1Adj);
				}
			}
		}
		return false;
	}

}
