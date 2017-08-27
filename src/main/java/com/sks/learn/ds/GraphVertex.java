package com.sks.learn.ds;

import java.util.List;

public class GraphVertex {
	private String vertexId;
	// Traversal Status: 0-Undiscovered, 1-Discovered, 2-Processed
	private int traversalStatus;
	private List<GraphVertex> adjacencyList;

	public String getVertexId() {
		return vertexId;
	}

	public void setVertexId(String vertexId) {
		this.vertexId = vertexId;
	}

	public List<GraphVertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<GraphVertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public int getTraversalStatus() {
		return traversalStatus;
	}

	public void setTraversalStatus(int traversalStatus) {
		this.traversalStatus = traversalStatus;
	}

}
