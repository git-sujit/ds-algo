package com.sks.leetcode.easy;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static com.sks.XDEPRECATED.algo2020.TestData.GraphNode;

/**
 * @author : Sujit K Singh
 * Purpose : Better if we want to traverse whole graph- recusrsion/stack based
 */
public class GraphDFS {
    /**
     * Time Complexity  : O(n) - Visiting each of n nodes
     * Space Complexity : O(n) - method stack memory for recursion
     * (NuViSLoCR) :: Null Check - Visit - Set Flag - Loop - Check Flag- Recursion
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

    /**
     * Time: O(n)
     * Space: O(n) for visitedSet
     */
    public static void dfs_visited_set(GraphNode<Integer> n) {
        //Set<GraphNode> visitedSet = new HashSet<>();
        dfs_visited_set(n, new HashSet<>());
        //System.out.println("visitedSet = " + visitedSet);
    }

    private static void dfs_visited_set(GraphNode<Integer> node, Set<GraphNode> visitedSet) {
        if (node == null) return;
        visit(node);
        visitedSet.add(node);
        for (GraphNode child : node.children) {
            if (!visitedSet.contains(child)) dfs_visited_set(child, visitedSet);
        }
    }

    public static void dfs_iterative(GraphNode<Integer> n) {
        if (n == null) return;
        Stack<GraphNode<Integer>> stack = new Stack<>();
        stack.push(n);
        while (!stack.isEmpty()) {
            GraphNode<Integer> sn = stack.pop();
            visit(sn);
            sn.visited = true;
            GraphNode[] children = sn.children;
            for (int i = children.length - 1; i >= 0; i--) {
                GraphNode child = children[i];
                if (!child.visited) stack.push(child);
            }
        }
    }

    /**
     * Graph of n nodes labeled from 0 to n - 1. edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph
     */
    public static void dfs_edges(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            visit(node);
            visited.add(node);
            for (int nbr : graph[node])
                if (!visited.contains(nbr)) stack.push(nbr);
        }
    }

    private static void visit(int node) {
        System.out.println("Visited : " + node);
    }

    private static void visit(GraphNode<Integer> n) {
        System.out.println("Visited : " + n.data);
    }


    public static void main(String[] args) {
        test_dfs_vertices();
        //test_dfs_edges();
    }

    /**
     * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1
     */
    private static void test_dfs_edges() {
        System.out.println("\n[Edges in int[][]] Traversing graph - DFS");
        // Edges
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        dfs_edges(edges);
        System.out.println("\n[Neighbors/Children in int[][]] Traversing graph - DFS");
        // Where graph[u] is an array of nodes that node u is adjacent to
        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        dfs_edges(graph);
    }

    private static void test_dfs_vertices() {
        System.out.println("### GRAPH DFS");
        GraphNode<Integer> root = TestData.getGraphData();
        System.out.println("DFS Recursive- visitedSet");
        dfs_visited_set(root);
        System.out.println("DFS Recursive- mutating Graph");
        dfs(root);
        System.out.println("DFS Iterative");
        root = TestData.getGraphData();
        dfs_iterative(root);
    }
}
