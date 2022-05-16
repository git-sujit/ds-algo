package com.sks.leetcode.easy;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.*;

import static com.sks.XDEPRECATED.algo2020.TestData.GraphNode;

/**
 * @author : Sujit K Singh
 * Purpose : BFS, better for Shortest path or any path - Iteration/Queue based
 */
public class GraphBFS {
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
            GraphNode qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!visitedSet.contains(qn)) {
                visit(qn);
                visitedSet.add(qn);
                for (GraphNode child : qn.children) {
                    if (!visitedSet.contains(child))
                        q.add(child);
                }
            }
        }
    }

    /**
     * Time Complexity:  O(n)- Each node is traversed once thru queue
     * Space Complexity: O(n) Max queue size is n
     * Check the visited after removing from queue, queue might have duplicate data, hence need to check visited
     */
    public static void bfs_better(GraphNode<Integer> n) {
        if (n == null) return;
        Queue<GraphNode<Integer>> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            GraphNode<Integer> qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!qn.visited) {
                visit(qn);
                qn.visited = true;
                for (GraphNode<Integer> c : qn.children) {
                    if (!c.visited) q.add(c);
                }
            }
        }
    }

    /**
     * Time Complexity  : O(n) - Visiting each of n nodes
     * Space Complexity : O(n) - Queue memory
     */
    public static void bfs(GraphNode<Integer> n) {
        if (n == null) return;
        Queue<GraphNode<Integer>> q = new LinkedList<>();
        q.addAll(Arrays.asList(n.children));
        visit(n);
        n.visited = true;
        while (!q.isEmpty()) {
            GraphNode<Integer> qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!qn.visited) {
                q.addAll(Arrays.asList(qn.children));
                visit(qn);
                qn.visited = true;
            }
        }
    }


    private static void visit(GraphNode<Integer> n) {
        System.out.print(n.data + " ");
    }

    public static void main(String[] args) {
        System.out.println("### GRAPH BFS");
        GraphNode<Integer> root = TestData.getGraphData_1();
        System.out.println("\nBFS-without mutating graph");
        bfs_withoutMutatingGraph(root);

        System.out.println("\nBFS-Better");
        bfs_better(root);

        System.out.println("\nBFS");
        root = TestData.getGraphData_1();
        bfs(root);
    }

}