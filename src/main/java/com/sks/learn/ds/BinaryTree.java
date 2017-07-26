package com.sks.learn.ds;

public class BinaryTree {
	private String key;
	private BinaryTree leftChild;
	private BinaryTree rightChild;

	public BinaryTree() {
	}

	public BinaryTree(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BinaryTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
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
