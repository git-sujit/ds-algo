package com.sks.leetcode.easy;

import java.util.*;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
public class GraphPath {
    /**
     * Using Adjacency List
     * Time Complexity : O(n), n is no. of nodes
     * Space Complexity: O(n)
     * Typical Candidate for BFS: We are trying to get path between two nodes
     */
    public static boolean validPath_adjList(int n, int[][] edges, int source, int destination) {
        if (edges == null || edges.length == 0 || source < 0 || destination < 0 || source > n || destination > n)
            return false;
        //Map<Integer, Set<Integer>> adjList = prepareAdjacencyList(edges);
        Map<Integer, Set<Integer>> adjList = prepareAdjacencyList_better(edges);
        //System.out.println("adjList  = " + adjList);
        //System.out.println("adjList1 = " + adjList1);
        return bfs_find(adjList, source, destination);
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
     * Without Adjacency list
     * Time Complexity : O(n), n is no. of nodes
     * Space Complexity: O(n)
     * Typical Candidate for BFS: We are trying to get path between two nodes
     */
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        HashSet<Integer> visitedSet = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        while (!que.isEmpty()) {
            int qn = que.remove();
            if (!visitedSet.contains(qn)) {
                if (qn == destination) return true;
                visitedSet.add(qn);
                for (int[] edge : edges) {
                    if (edge[0] == qn && !visitedSet.contains(edge[1]))
                        que.add(edge[1]);
                    else if (edge[1] == qn && !visitedSet.contains(edge[0]))
                        que.add(edge[0]);
                }
            }
        }
        return false;
    }


    private static Map<Integer, Set<Integer>> prepareAdjacencyList_better(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], e -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], e -> new HashSet<>()).add(edge[0]);
        }
        return adjList;
    }

    private static Map<Integer, Set<Integer>> prepareAdjacencyList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            Set<Integer> n1Children = adjList.getOrDefault(n1, new HashSet<>());
            n1Children.add(n2);
            adjList.put(n1, n1Children);
            Set<Integer> n2Children = adjList.getOrDefault(n2, new HashSet<>());
            n2Children.add(n1);
            adjList.put(n2, n2Children);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        test(n, edges, source, destination);

        destination = 3;
        test(n, edges, source, destination);
    }

    private static void test(int n, int[][] edges, int source, int destination) {
        System.out.println("\n[Better]valid path exists? : " + validPath(n, edges, source, destination));
        System.out.println("[Adj-List]valid path exists? : " + validPath_adjList(n, edges, source, destination));

    }

}
