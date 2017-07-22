package com.sks.learn.ds;

public class BinaryTree {
	private String key;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	private BinaryTree parent;
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
	public BinaryTree getParent() {
		return parent;
	}
	public void setParent(BinaryTree parent) {
		this.parent = parent;
	}
	
}
