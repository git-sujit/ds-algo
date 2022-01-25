package com.sks.leatcode.easy;

/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where
 * there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge
 * between the nodes ui and vi. Return the center of the given star graph.
 */
public class StarGraph {
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int findCenter(int[][] edges) {
        if (edges == null || edges.length == 0) return -1;
        if (edges.length == 1) return edges[0][0];
        int[] e1 = edges[0];
        int[] e2 = edges[1];
        if (e1[0] == e2[0] || e1[0] == e2[1])
            return e1[0];
        else if (e1[1] == e2[0] || e1[1] == e2[1])
            return e1[1];
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println("Center = " + findCenter(edges));

        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println("Center = " + findCenter(edges));
    }
}
