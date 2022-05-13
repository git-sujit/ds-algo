package com.sks.leetcode.medium;

import java.util.*;

/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where
 * edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 * <p>
 * Graph, G, is a tree iff(Connected & Acyclic):
 * 1. G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
 * 2. G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.
 * <p>
 * Depth-first search is a classic graph-traversal algorithm that can be used to check for both of these conditions.
 * Depth-first search requires being able to look up the adjacent (immediate neighbours) of a given node.
 * Like many graph interview problems though, the input format we're given doesn't allow us to quickly get the neighbours of a node.
 * Therefore, our first step is to convert the input into an adjacency list.
 * <p> IMPORTANT
 * Acyclic Graph: For directed graph checking [if(visited.contains(nbr) return false] works but for undirected graph there will be trivial cycle(A->B->A)
 * Two approaches:
 * 1. Delete opposite direction edge from Adjacency List(nbrMap)
 * 2. Instead of visited set, use parent map that keeps track of parent node. Then when we iterate thru neighbors of a node, we ignore parent node
 */
public class GraphValidTree {
    /**
     * Time: O(N+E), N = no. of nodes, E = no. of edges
     * Space: O(N+E)
     */
    public static boolean validTree_better(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = prepareAdjListMap(edges);
        Map<Integer, Integer> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        parentMap.put(0, -1);
        dfs(0, adjList, parentMap, visited);

        return parentMap.size() == n;
    }

    private static void dfs(int start, Map<Integer, List<Integer>> adjList, Map<Integer, Integer> parentMap, Set<Integer> visited) {
        visited.add(start);
        if (adjList.get(start) == null) return;
        for (int nbr : adjList.get(start)) {
            if (parentMap.containsKey(nbr)) return;
            parentMap.put(nbr, start);
            if (!visited.contains((nbr)))
                dfs(nbr, adjList, parentMap, visited);
        }

    }

    private static Map<Integer, List<Integer>> prepareAdjListMap(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    /**
     * Time: O(N+E), N = no. of nodes, E = no. of edges
     * Space: O(N+E)
     */
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // Step-1: Prepare Adjacency List
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // Step-2: DFS, Iterative
        // to keep track of unexplored nodes
        Stack<Integer> stack = new Stack<>();
        // Tree Check: to keep track of already visited nodes & avoid parents in the neighbors
        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(0, -1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei : adjacencyList.get(node)) {
                if (parentMap.get(node) == nei) continue;
                if (parentMap.containsKey(nei)) return false;
                stack.push(nei);
                parentMap.put(nei, node);
            }
        }
        // Tree Check: Graph fully connected, then every node must have been seen
        return parentMap.size() == n;
    }

    private static Map<Integer, List<Integer>> prepareNeighborMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neiList = map.getOrDefault(edge[0], new ArrayList<>());
            neiList.add(edge[1]);
            map.put(edge[0], neiList);
            neiList = map.getOrDefault(edge[1], new ArrayList<>());
            neiList.add(edge[0]);
            map.put(edge[1], neiList);
        }
        return map;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        demo(n, edges);

        n = 4;
        edges = new int[][]{{0, 1}, {2, 3}};
        demo(n, edges);

        n = 1;
        edges = new int[][]{};
        demo(n, edges);

        n = 2;
        demo(n, edges);
    }

    private static void demo(int n, int[][] edges) {
        System.out.println("\nValid Tree? : " + validTree(n, edges));
        System.out.println("[Better]Valid Tree? : " + validTree_better(n, edges));
    }
}
