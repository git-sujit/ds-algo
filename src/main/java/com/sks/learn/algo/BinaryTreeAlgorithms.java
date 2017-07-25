package com.sks.learn.algo;

import java.util.Random;

import com.sks.learn.ds.BinaryTree;

public class BinaryTreeAlgorithms {

	public static void main(String[] args) {

	    // create a new Java Random object
	    Random random = new Random();
	    for ( int i=0; i<10; i++ )
	    {
	      // get the next random int
	      int randomInt = random.nextInt(100);
	      System.out.format("test %2d, randomInt = %d\n", i+1, randomInt );
	    }
		preOrderTraversal(prepareRandomBinaryTree());
		System.out.println("");
		inOrderTraversal(prepareRandomBinaryTree());
		System.out.println("");
		postOrderTraversal(prepareRandomBinaryTree());
	}

	/**
	 * Prepares random Binary Tree and returns Root
	 * 
	 * @return
	 */
	public static BinaryTree prepareRandomBinaryTree() {
		BinaryTree root = new BinaryTree("a");
		BinaryTree b = new BinaryTree("b");
		root.setLeftChild(b);
		BinaryTree e = new BinaryTree("e");
		root.setRightChild(e);
		BinaryTree c = new BinaryTree("c");
		b.setLeftChild(c);
		BinaryTree d = new BinaryTree("d");
		b.setRightChild(d);
		BinaryTree f = new BinaryTree("f");
		d.setLeftChild(f);
		BinaryTree g = new BinaryTree("g");
		d.setRightChild(g);
		return root;
	}

	/**
	 * Pre-Order Traversal of a Binary Tree
	 * 
	 * Node->Left->Right
	 * 
	 * @param node
	 */
	public static void preOrderTraversal(BinaryTree node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getKey() + " ");
		preOrderTraversal(node.getLeftChild());
		preOrderTraversal(node.getRightChild());
	}

	/**
	 * In-Order Traversal of a Binary Tree
	 * 
	 * Left->Node->Right
	 * 
	 * @param node
	 */
	public static void inOrderTraversal(BinaryTree node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeftChild());
		System.out.print(node.getKey() + " ");
		inOrderTraversal(node.getRightChild());
	}

	/**
	 * Post-Order Traversal of a Binary Tree
	 * 
	 * Left->Node->Right
	 * 
	 * @param node
	 */
	public static void postOrderTraversal(BinaryTree node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.print(node.getKey() + " ");
	}

	/**
	 * Identify BinaryTree and return root node: InOrder is must
	 * 
	 * Note: Tree can't be identified with only one Traversal or (PreOrder &
	 * PostOrder Traversal - Exception: Complete Binary Tree)
	 * 
	 * @param inOrderStr
	 * @param commaSeparatedPreOrder
	 * @return
	 */
	public static BinaryTree identifyTree_givenInOrderPreOrder(String preOrderStr, String inOrderStr) {
		BinaryTree btNode = null;
		int noOfNodes = preOrderStr.length();
		for (int i = 0; i < noOfNodes; i++) {
			char preOrderNodeValue = preOrderStr.charAt(i);
			btNode = new BinaryTree("" + preOrderNodeValue);
			// Identify left subtree
			if (i != (noOfNodes - 1)) {
				char preOrderNextNodeValue = preOrderStr.charAt(i + 1);
				if (inOrderStr.indexOf(preOrderNextNodeValue) < inOrderStr.indexOf(preOrderNodeValue)) {
					BinaryTree leftChild = new BinaryTree("" + preOrderNextNodeValue);
					btNode.setLeftChild(leftChild);
				}
			}

		}
		return btNode;
	}

	/**
	 * Identify BinaryTree and return root node: InOrder is must
	 * 
	 * Note: Tree can't be identified with only one Traversal or (PreOrder &
	 * PostOrder Traversal - Exception: Complete Binary Tree)
	 * 
	 * @param commaSeparatedInOrder
	 * @param commaSeparatedPreOrder
	 * @return
	 */
	public static BinaryTree identifyTree_givenInOrderPostOrder(String commaSeparatedInOrder,
			String commaSeparatedPreOrder) {
		BinaryTree root = new BinaryTree();

		return root;
	}
}
