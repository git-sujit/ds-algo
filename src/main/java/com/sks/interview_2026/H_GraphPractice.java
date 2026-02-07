package com.sks.interview_2026;

import com.sks.interview_2026.data_structures.GraphNode;

import java.util.*;

public class H_GraphPractice {
    public static void main(String[] args) {
        System.out.println("----- GRAPH: DEPTH FIRST SEARCH -----");
        test_dfs();
        System.out.println("\n----- GRAPH: BREADTH FIRST SEARCH -----");
        test_bfs();
        System.out.println("\n----- GRAPH-PATH BETWEEN NODE n1 & n2 -----");
        test_graphPath();
        System.out.println("\n----- GRAPH-STAR -----");
        test_graphStar();
    }

    /**
     * Time Complexity  : O(n) - Visiting each of n nodes
     * Space Complexity : O(n) - method stack memory for recursion
     * (NuViSLoCR) :: Null Check - Visit - Set Flag - Loop - Check Flag- Recursion
     */
    private static void dfs_recursive(GraphNode<Integer> n) {
        if (n == null) return;
        visitNode(n);
        n.visited = true;
        for (GraphNode<Integer> child : n.children) {
            if (!child.visited)
                dfs_recursive(child);
        }
    }

    public static void dfs_iterative(GraphNode<Integer> n) {
        if (n == null) return;
        Stack<GraphNode<Integer>> stack = new Stack<>();
        stack.push(n);
        while (!stack.isEmpty()) {
            GraphNode<Integer> sn = stack.pop();
            visitNode(sn);
            sn.visited = true;
            GraphNode[] children = sn.children;
            for (int i = children.length - 1; i >= 0; i--) {
                GraphNode child = children[i];
                if (!child.visited) stack.push(child);
            }
        }
    }

    /**
     * Time Complexity:  O(n)- Each node is traversed once thru queue
     * Space Complexity: O(n) Max queue size is n
     * Check the visited after removing from queue, queue might have duplicate data, hence need to check visited
     */
    public static void bfs(GraphNode<Integer> n) {
        if (n == null) return;
        Queue<GraphNode<Integer>> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            GraphNode<Integer> qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!qn.visited) {
                visitNode(qn);
                qn.visited = true;
                for (GraphNode<Integer> c : qn.children) {
                    if (!c.visited) q.add(c);
                }
            }
        }
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n) for Queue & VisitedSet
     */
    public static void bfs_withoutMutatingGraph(GraphNode<Integer> node) {
        if (node == null) return;
        Set<GraphNode> visitedSet = new HashSet<>();
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            //System.out.println("q = " + q);
            GraphNode qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!visitedSet.contains(qn)) {
                visitNode(qn);
                visitedSet.add(qn);
                for (GraphNode child : qn.children) {
                    if (!visitedSet.contains(child))
                        q.add(child);
                }
            }
        }
    }

    private static void visitNode(GraphNode<Integer> n) {
        System.out.print(n.data + " -> ");
    }

    /**
     * * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
     * * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
     * * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
     * * You want to determine if there is a valid path that exists from vertex source to vertex destination.
     * * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
     * Using Adjacency List
     * Time Complexity : O(n), n is no. of nodes
     * Space Complexity: O(n)
     * Typical Candidate for BFS: We are trying to get path between two nodes
     */
    public static boolean validPath_adjList(int n, int[][] edges, int source, int destination) {
        if (edges == null || edges.length == 0 || source < 0 || destination < 0 || source > n || destination > n)
            return false;
        Map<Integer, Set<Integer>> adjList = prepareAdjacencyList(edges);
        return bfs_find(adjList, source, destination);
    }

    private static Map<Integer, Set<Integer>> prepareAdjacencyList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], e -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], e -> new HashSet<>()).add(edge[0]);
        }
        return adjList;
    }

    private static boolean bfs_find(Map<Integer, Set<Integer>> adjList, int source, int destination) {
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int qn = q.remove();
            if (!visitedSet.contains(qn)) {
                if (qn == destination) return true;
                visitedSet.add(qn);
                for (int child : adjList.get(qn)) {
                    if (!visitedSet.contains(child))
                        q.add(child);
                }
            }
        }
        return false;
    }

    /**
     * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where
     * there is one center node and exactly n - 1 edges that connect the center node with every other node.
     * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge
     * between the nodes ui and vi. Return the center of the given star graph.
     */
    public static int findCenter(int[][] edges) {
        if (edges == null || edges.length == 0) return -1;
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }

    /**
     * TEST
     */
    private static void test_dfs() {
        GraphNode<Integer> n0 = GraphNode.getGraphData();
        System.out.println("DFS - Recursive");
        dfs_recursive(n0);

        n0 = GraphNode.getGraphData();
        System.out.println("\nDFS - Iterative");
        dfs_iterative(n0);
    }

    private static void test_bfs() {
        GraphNode<Integer> root = GraphNode.getGraphData_1();
        System.out.println("\n1. BFS-without mutating graph");
        bfs_withoutMutatingGraph(root);

        System.out.println("\nBFS-Better");
        bfs(root);
    }

    private static void test_graphPath() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        System.out.println("[Adj-List]valid path exists? : " + validPath_adjList(n, edges, source, destination));

        destination = 3;
        System.out.println("[Adj-List]valid path exists? : " + validPath_adjList(n, edges, source, destination));
    }

    private static void test_graphStar() {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println("Center = " + findCenter(edges));
        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println("Center = " + findCenter(edges));
    }
}
