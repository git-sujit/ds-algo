package com.sks.learn.ds;

import java.util.List;
import java.util.Set;

public class GraphDS {
	private Set<GraphVertex> vertices;
	private Set<GraphEdge> edges;
	private boolean isDirected;
	// Represent Graph using Adjacency List
	List<List<GraphVertex>> adjacencyList;

	public GraphDS() {
		vertices = null;
		edges = null;
		adjacencyList = null;
	}

	public Set<GraphVertex> getVertices() {
		return vertices;
	}

	public void setVertices(Set<GraphVertex> vertices) {
		this.vertices = vertices;
	}

	public Set<GraphEdge> getEdges() {
		return edges;
	}

	public void setEdges(Set<GraphEdge> edges) {
		this.edges = edges;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public List<List<GraphVertex>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<List<GraphVertex>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

}
