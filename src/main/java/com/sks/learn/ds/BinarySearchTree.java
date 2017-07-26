package com.sks.learn.ds;

import java.util.Random;

import com.sks.learn.algo.BinaryTreeAlgorithms;

public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree() {

	}

	public BinarySearchTree(int nodeValue) {
		this.setKey("" + nodeValue);
	}

	/**
	 * Insertion will happen always at Leaf
	 * 
	 * @param bst
	 * @param nodeValue
	 */
	public static void insert(BinarySearchTree bst, int nodeValue) {
		BinarySearchTree nodeToInsert = new BinarySearchTree(nodeValue);
		if (bst == null) {
			bst = nodeToInsert;
		} else {
			BinarySearchTree insertAtNode = bst;
			// Go till appropriate leaf node

			boolean flag = true;
			while (flag) {
				int parentKey = Integer.valueOf(insertAtNode.getKey());
				if (nodeValue <= parentKey) {
					if (insertAtNode.getLeftChild() == null) {
						insertAtNode.setLeftChild(nodeToInsert);
						flag = false;
					} else {
						insertAtNode = (BinarySearchTree) insertAtNode.getLeftChild();
					}
				} else {
					if (insertAtNode.getRightChild() == null) {
						insertAtNode.setRightChild(nodeToInsert);
						flag = false;
					} else {
						insertAtNode = (BinarySearchTree) insertAtNode.getRightChild();
					}
				}
			}
		}
	}

	/**
	 * This method prepares a Binary Search Tree of given size
	 * 
	 * @return Binary Search Tree Root Node
	 */
	public static BinarySearchTree prepareRandomBinarySearchTree(int bstSize) {
		BinarySearchTree bst = null;
		// Generate Random Numbers
		Random random = new Random();
		System.out.print("Binary Search Input: ");
		for (int i = 0; i < bstSize; i++) {
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
		return bst;
	}

	public static void delete(BinarySearchTree bst, int nodeValue) {

	}

	/**
	 * Find min
	 * 
	 * @param bst
	 * @return
	 */
	public static BinarySearchTree min(BinarySearchTree bst) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree tmp = bst;
		while (tmp.getLeftChild() != null) {
			tmp = (BinarySearchTree) tmp.getLeftChild();
		}
		return tmp;
	}

	/**
	 * Find max
	 * 
	 * @param bst
	 * @return
	 */
	public static BinarySearchTree max(BinarySearchTree bst) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree tmp = bst;
		while (tmp.getRightChild() != null) {
			tmp = (BinarySearchTree) tmp.getRightChild();
		}
		return tmp;
	}

	/**
	 * Iterative Search Algorithm
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree searchIterative(BinarySearchTree bst, int nodeValue) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree parentNode = bst;
		while (parentNode != null) {
			int parentNodeValue = Integer.valueOf(parentNode.getKey());
			if (nodeValue < parentNodeValue) {
				parentNode = (BinarySearchTree) parentNode.getLeftChild();
			} else if (nodeValue == parentNodeValue) {
				return parentNode;
			} else {
				parentNode = (BinarySearchTree) parentNode.getRightChild();
			}
		}
		return null;
	}

	/**
	 * Recursive Search Algorithm
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree searchRecursive(BinarySearchTree bst, int nodeValue) {
		if (bst == null) {
			return null;
		}
		int currentNodeValue = Integer.valueOf(bst.getKey());
		if (nodeValue < currentNodeValue) {
			searchRecursive((BinarySearchTree) bst.getLeftChild(), nodeValue);
		} else if (nodeValue == currentNodeValue) {
			return bst;
		} else {
			searchRecursive((BinarySearchTree) bst.getRightChild(), nodeValue);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(this.getKey());
		if (this.getLeftChild() != null) {
			str.append(", Left: " + this.getLeftChild().getKey());
		}
		if (this.getRightChild() != null) {
			str.append(", Right: " + this.getRightChild().getKey());
		}
		return str.toString();
	}
}
