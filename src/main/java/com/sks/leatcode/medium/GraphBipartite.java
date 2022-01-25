package com.sks.leatcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B
 * such that every edge in the graph connects a node in set A and a node in set B.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 */
public class GraphBipartite {
    /**
     * Time Complexity: O(N+E), where N is the number of nodes in the graph, and E is the number of edges.
     * We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.
     * Space Complexity: O(N), the space used to store the color.
     */
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
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

    public static void main(String[] args) {
        //graph[i] is an array of nodes that node-i is adjacent to
        int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Is Bipartite = " + isBipartite(graph));
    }
}
