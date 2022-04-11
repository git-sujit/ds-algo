package com.sks.leatcode.medium;

import java.util.*;

/**
 * You have a graph of n nodes. You are given an integer n and an array edges
 * where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * Return the number of connected components in the graph.
 * <p> IDEA
 * Start DFS, till all vertices are traversed in a component. Then start a new DFS for next component.
 * Number of Components = Number of DFS
 */
public class GraphConnectedComponents {
    /**
     * Time: O(E+V)
     * Space: O(E+V)
     */
    public static int countComponents_1(int n, int[][] edges) {
        int comps = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adjList = prepareAdjListMap(edges);
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, adjList, visited);
                comps++;
            }
        }
        return comps;
    }

    private static void dfs(int start, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        if (visited[start]) return;
        visited[start] = true;
        if (adjList.get(start) != null) {
            for (int nbr : adjList.get(start))
                if (!visited[nbr])
                    dfs(nbr, adjList, visited);
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


    public static int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = prepareAdjList(n, edges);
        //printAdjList(adjList);
        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                traverse_dfs(i, adjList, visited);
                components++;
            }
        }
        return components;
    }

    private static void traverse_dfs(int node, List<Integer>[] adjList, Set<Integer> visited) {
        visited.add(node);
        for (int adj : adjList[node]) {
            if (!visited.contains(adj))
                traverse_dfs(adj, adjList, visited);
        }
    }

    private static void printAdjList(List<Integer>[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.println(i + " => " + adjList[i]);
        }
    }

    private static List<Integer>[] prepareAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        return adjList;
    }

    public static int countComponents_not_good(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return 0;
        List<Set<Integer>> compList = new ArrayList<>();
        for (int[] edge : edges) {
            boolean notConn = true;
            for (Set<Integer> comp : compList) {
                if (comp.contains(edge[0]) || comp.contains(edge[1])) {
                    comp.add(edge[0]);
                    comp.add(edge[1]);
                    notConn = false;
                    break;
                }
            }
            if (notConn) {
                Set<Integer> c = new HashSet<>();
                c.add(edge[0]);
                c.add(edge[1]);
                compList.add(c);
            }
        }
        System.out.println("\nCOMPONENT LIST");
        int visitedNodes = 0;
        for (Set<Integer> comp : compList) {
            System.out.println("component = " + comp);
            visitedNodes += comp.size();
        }
        return compList.size() + (n - visitedNodes);
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        test(n, edges);

        n = 5;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        test(n, edges);

        n = 10;
        edges = new int[][]{{5, 6}, {0, 2}, {1, 7}, {5, 9}, {1, 8}, {3, 4}, {0, 6}, {0, 7}, {0, 3}, {8, 9}};
        test(n, edges);
    }

    private static void test(int n, int[][] edges) {
        //System.out.println("Number of connected components = " + countComponents_not_good(n, edges));
        System.out.println("Number of connected components = " + countComponents(n, edges));
        System.out.println("[Better]Number of connected components = " + countComponents_1(n, edges));
    }

}
