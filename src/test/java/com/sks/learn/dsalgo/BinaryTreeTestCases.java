package com.sks.learn.dsalgo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sks.learn.algo.BinaryTreeAlgorithms;
import com.sks.learn.ds.BinarySearchTree;

public class BinaryTreeTestCases {
	static BinarySearchTree bst = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("################################ START :: BINARY TREE ################################");
		bst = BinarySearchTree.prepareRandomBinarySearchTree(10);
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
		BinarySearchTree.insert(bst, 54);
		BinaryTreeAlgorithms.inOrderTraversal(bst);
		System.out.println("\n---------- END: BST INSERT ----------");
	}

	@Test
	public void testBinarySearchTreeSearch() {
		System.out.println("\n---------- START: BST ITERATIVE/RECURSIVE SEARCH ----------");
		System.out.println("\nSearch Result(Iterative): " + BinarySearchTree.searchIterative(bst, 20));
		System.out.println(
				"\nSearch Result(Iterative): " + BinarySearchTree.searchIterative(bst, Integer.valueOf(bst.getKey())));
		System.out.println("\nSearch Result(Recursive): " + BinarySearchTree.searchRecursive(bst, 20));
		System.out.println(
				"\nSearch Result(Recursive): " + BinarySearchTree.searchRecursive(bst, Integer.valueOf(bst.getKey())));
		System.out.println("\n---------- END: BST ITERATIVE/RECURSIVE SEARCH ----------");
	}

	@Test
	public void testBinarySearchTreeMinMax() {
		System.out.println("\n---------- START: BST MIN/MAX ----------");
		System.out.println("BST MIN = " + BinarySearchTree.min(bst));
		System.out.println("BST MAX = " + BinarySearchTree.max(bst));
		System.out.println("---------- END: BST MIN/MAX ----------");
	}
}
