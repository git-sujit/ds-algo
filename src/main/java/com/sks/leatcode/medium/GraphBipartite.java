package com.sks.leatcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B
 * such that every edge in the graph connects a node in set A and a node in set B.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 */
public class GraphBipartite {
    /**
     * DFS
     * Time Complexity: O(N+E), where N is the number of nodes in the graph, and E is the number of edges.
     * We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.
     * Space Complexity: O(N), the space used to store the color.
     */
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        //Loop to take care of disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isBipartite_better(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        Integer[] color = new Integer[graph.length];
        color[0] = 0;
        for (int i = 0; i < graph.length; i++) {
            int[] nbr = graph[i];
            if (color[i] == 0) {
                for (int n : nbr) {
                    if (color[n] == 0) return false;
                    color[n] = 1;
                }
            } else if (color[i] == 1) {
                for (int n : nbr) {
                    if (color[n] == 1) return false;
                    color[n] = 0;
                }
            } else {
                color[i] = 0;
            }
        }
        return true;
    }

    public static boolean isBipartite_partialWorking(int[][] graph) {
        if (graph == null) return false;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int start = 0;
        for (; start < graph.length; start++) {
            if (graph[start].length > 0) {
                s1.add(start);
                for (int nbr : graph[start])
                    s2.add(nbr);
                break;
            }
        }
        for (int node = start + 1; node < graph.length; node++) {
            int[] nbrs = graph[node];
            if (s1.contains(node)) {
                if (!validate(nbrs, s2, s1)) return false;
            } else if (s2.contains(node)) {
                if (!validate(nbrs, s1, s2)) return false;
            }
            //System.out.println("s1 = " + s1);
            //System.out.println("s2 = " + s2);
        }
        return true;
    }

    private static boolean validate(int[] nbrs, Set<Integer> cs, Set<Integer> os) {
        for (int nbr : nbrs) {
            if (os.contains(nbr)) return false;
            cs.add(nbr);
        }
        return true;
    }


    public static void main(String[] args) {
        //graph[i] is an array of nodes that node-i is adjacent to
        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Is Bipartite = " + isBipartite(graph));
    }
}
