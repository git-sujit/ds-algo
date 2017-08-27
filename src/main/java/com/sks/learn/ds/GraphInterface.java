/**
 * 
 */
package com.sks.learn.ds;

import java.util.List;

/**
 * @author Sujit
 *
 */
public interface GraphInterface {
	public abstract GraphVertex initializeGraph();

	public abstract void addVertex(GraphVertex v, List<GraphVertex> adjList);

	public abstract void removeVertex(GraphVertex v);

	public abstract void addEdge(GraphVertex v1, GraphVertex v2);

	public abstract void removeEdge(GraphVertex v1, GraphVertex v2);

	public void depthFirstSearch();

	public void bredthFirstSearch();
}
