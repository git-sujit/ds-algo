package com.sks.learn.ds;

public class GraphEdge {
	private GraphVertex source;
	private GraphVertex destination;
	private double weight;

	public GraphVertex getSource() {
		return source;
	}

	public void setSource(GraphVertex source) {
		this.source = source;
	}

	public GraphVertex getDestination() {
		return destination;
	}

	public void setDestination(GraphVertex destination) {
		this.destination = destination;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
