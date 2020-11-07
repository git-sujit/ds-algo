package com.sks.algo2020.udemy.graph;

import com.sks.algo2020.TestData;

import static com.sks.algo2020.TestData.GraphNode;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class DepthFirstSearch {
    /**
     * Time Complexity  : O(n) - Visiting each of n nodes
     * Space Complexity : O(n) - method stack memory for recursion
     */
    public static void dfs(GraphNode<Integer> n) {
        if (n == null) return;
        visit(n);
        n.visited = true;
        for (GraphNode<Integer> child : n.children) {
            if (!child.visited)
                dfs(child);
        }
    }

    private static void visit(GraphNode<Integer> n) {
        System.out.println("Visited : " + n.data);
    }


    public static void main(String[] args) {
        System.out.println("### GRAPH DFS");
        GraphNode<Integer> root = TestData.getGraphData();
        dfs(root);
    }
}
