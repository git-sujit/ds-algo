package com.sks.learn.dsalgo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sks.learn.algo.BinaryTreeAlgorithms;
import com.sks.learn.ds.BinarySearchTree;

public class BinaryTreeTestCases {
	static BinarySearchTree bstRandom = null;
	static BinarySearchTree bstFromList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("################################ START :: BINARY TREE ################################");
		bstRandom = BinarySearchTree.prepareRandomBinarySearchTree_1(10);
		int[] intArray = { 58, 72, 78, 45, 64, 3, 60, 90, 17, 54, 80, 24, 0, 65, 95, 50 };
		List<Integer> inputList = new ArrayList<Integer>();
		for (int input : intArray) {
			inputList.add(input);
		}
		bstFromList = BinarySearchTree.prepareRandomBinarySearchTree_2(inputList);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("\n################################ END :: BINARY TREE ################################");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinarySeartTreeInsertion() {
		System.out.println("---------- START: BST INSERT ----------");
		BinarySearchTree.insert(bstRandom, 54);
		BinaryTreeAlgorithms.inOrderTraversal(bstRandom);
		System.out.println("\n---------- END: BST INSERT ----------");
	}

	@Test
	public void testBinarySearchTreeSearch() {
		System.out.println("\n---------- START: BST ITERATIVE/RECURSIVE SEARCH ----------");
		System.out.println("\nSearch Result(Iterative)[20]: " + BinarySearchTree.searchIterative(bstRandom, 20));
		System.out.println("\nSearch Result(Iterative)[54]: " + BinarySearchTree.searchIterative(bstFromList, 54));
		System.out.println("\nSearch Result(Recursive)[20]: " + BinarySearchTree.searchRecursive(bstRandom, 20));
		System.out.println("\nSearch Result(Recursive)[54]: " + BinarySearchTree.searchRecursive(bstFromList, 54));
		System.out.println("\n---------- END: BST ITERATIVE/RECURSIVE SEARCH ----------");
	}

	@Test
	public void testBinarySearchTreeMinMax() {
		System.out.println("\n---------- START: BST MIN/MAX ----------");
		System.out.println("BST MIN = " + BinarySearchTree.min(bstRandom));
		System.out.println("BST MAX = " + BinarySearchTree.max(bstRandom));
		System.out.println("---------- END: BST MIN/MAX ----------");
	}

	@Test
	public void testBinarySearchTreePredSucc() {
		System.out.println("\n---------- START: BST PREDECESSOR/SUCCESSOR ----------");
		int input1 = 20;
		int input2 = 3;
		System.out.println("\nPredecessor of : " + input1 + "=> " + BinarySearchTree.predecessor(bstRandom, input1));
		System.out.println("\nPredecessor of : " + input2 + "=> " + BinarySearchTree.predecessor(bstFromList, input2));
		System.out.println("\nSuccessor of : " + input1 + "=> " + BinarySearchTree.successor(bstRandom, input1));
		System.out.println("\nSuccessor of : " + input2 + "=> " + BinarySearchTree.successor(bstFromList, input2));
		System.out.println("---------- END: BST PREDECESSOR/SUCCESSOR ----------");
	}

	@Test
	public void testBinarySearchTreeDelete() {
		System.out.println("\n---------- START: BST DELETE ----------");
		int input = 0;
		BinarySearchTree.printBST(bstFromList);
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 80;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 54;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 78;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 17;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 4;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 45;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 72;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		input = 58;
		BinarySearchTree.delete(bstFromList, input);
		System.out.println("\nAfter Deleting : " + input);
		BinarySearchTree.printBST(bstFromList);
		System.out.println("\n---------- END: BST DELETE ----------");
	}
}
