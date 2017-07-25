package com.sks.learn.dsalgo;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sks.learn.algo.BinaryTreeAlgorithms;
import com.sks.learn.ds.BinarySearchTree;

public class BinaryTreeTestCases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("################################ START :: BINARY TREE ################################");
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
		BinarySearchTree bst = null;
		// Generate Random Numbers
		Random random = new Random();
		System.out.print("Binary Search Input: ");
		for (int i = 0; i < 10; i++) {
			// get the next random integer
			int randomInt = random.nextInt(100);
			System.out.print(randomInt + " ");
			if (bst == null) {
				bst = new BinarySearchTree(randomInt);
			} else {
				BinarySearchTree.insert(bst, randomInt);
			}
		}
		System.out.print("\nBinary Search Tree : ");
		BinaryTreeAlgorithms.inOrderTraversal(bst);
	}

}
