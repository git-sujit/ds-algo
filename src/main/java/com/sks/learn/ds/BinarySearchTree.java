package com.sks.learn.ds;

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

	public static void delete(BinarySearchTree bst, int nodeValue) {

	}

	public static BinarySearchTree min(BinarySearchTree bst) {
		return null;
	}

	public static BinarySearchTree max(BinarySearchTree bst) {
		return null;
	}

	public static BinarySearchTree search(BinarySearchTree bst, int nodeValue) {
		return null;
	}
}
