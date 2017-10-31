package com.sks.learn.ctci6.chap4;

import java.util.LinkedList;
import java.util.List;

public interface Chap4Contract {
	public abstract void stackAndQueueInJava();

	public abstract void breadthFirstSearch(Node root);

	public abstract void depthFirstSearch(Node root);

	public abstract boolean doesRouteExists_BFS(Node n1, Node n2);

	public abstract boolean doesRouteExists_DFS(Node n1, Node n2);

	public abstract BTNode getBSTFromSortedArray(int[] arr);

	public abstract List<LinkedList<BTNode>> getListOfDepths(BTNode root);

	public abstract int nthFibonacci(int n);

	public abstract void selectionSort(int[] arr);
}
