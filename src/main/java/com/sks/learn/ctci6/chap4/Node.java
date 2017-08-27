package com.sks.learn.ctci6.chap4;

import java.util.List;

public class Node {
	private String nodeId;
	private List<Node> adjacencyList;
	private boolean isVisited;

	public Node() {
		this.nodeId = null;
		this.adjacencyList = null;
		this.isVisited = false;
	}

	public Node(String id) {
		this.nodeId = id;
		this.adjacencyList = null;
		this.isVisited = false;
	}

	@Override
	public String toString() {
		return this.nodeId;
	}
	@Override
	public boolean equals(Object obj) {
		return this.nodeId.equals(obj.toString());
	}
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public List<Node> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Node> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

}
