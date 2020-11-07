package com.sks.learn.ctci6.chap4_trees_graphs;

public class BTNode {
	private int nodeId;
	private BTNode left;
	private BTNode right;

	public BTNode() {
	}

	public BTNode(int id) {
		this.nodeId = id;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + this.nodeId;
	}
}
