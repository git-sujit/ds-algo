package com.sks.leatcode.easy;

import java.util.*;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
public class PathInGraph {
    /**
     * Time Complexity:
     * Space Complexity:
     * Typical Candidate for BFS: We are trying to get path between two nodes
     */
    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) return true;

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> vertices = new ArrayDeque();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == source) vertices.add(edges[i][1]);
            if (edges[i][1] == source) vertices.add(edges[i][0]);
        }
        visited.add(source);

        while (!vertices.isEmpty()) {
            int vertex = vertices.poll();
            if (visited.contains(vertex)) continue;
            visited.add(vertex);
            if (vertex == destination) return true;
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][0] == vertex && !visited.contains(edges[i][1])) {
                    vertices.add(edges[i][1]);
                } else if (edges[i][1] == vertex && !visited.contains(edges[i][0])) {
                    vertices.add(edges[i][0]);
                }
            }
        }

        return false;
    }

    /**
     * Partially works
     */
    public static boolean validPath_1(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjMap = prepareAdjMap(edges);
        //System.out.println("adjMap = "+adjMap);
        Set<Integer> visited = new HashSet<>();
        return found(adjMap, source, destination, visited);
    }

    private static boolean found(Map<Integer, List<Integer>> adjMap, int source, int destination, Set<Integer> visited) {
        Queue<Integer> path = new LinkedList<>();
        path.add(source);
        visited.add(source);
        while (!path.isEmpty()) {
            int n = path.remove();
            if (n == destination) return true;
            for (int n1 : adjMap.get(n)) {
                if (!visited.contains(n1)) path.add(n1);
            }
        }
        return false;
    }

    private static Map<Integer, List<Integer>> prepareAdjMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            List<Integer> v = map.getOrDefault(e[0], new ArrayList<>());
            v.add(e[1]);
            map.put(e[0], v);
            v = map.getOrDefault(e[1], new ArrayList<>());
            v.add(e[0]);
            map.put(e[1], v);
        }
        return map;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        System.out.println("valid path exists? : " + validPath(n, edges, source, destination));
        System.out.println("[Mine]valid path exists? : " + validPath_1(n, edges, source, destination));

        destination = 3;
        System.out.println("valid path exists? : " + validPath(n, edges, source, destination));
        System.out.println("[Mine]valid path exists? : " + validPath_1(n, edges, source, destination));
    }
}
