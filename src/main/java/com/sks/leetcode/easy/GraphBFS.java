package com.sks.leetcode.easy;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.*;

import static com.sks.XDEPRECATED.algo2020.TestData.GraphNode_OLD;

/**
 * @author : Sujit K Singh
 * Purpose : BFS, better for Shortest path or any path - Iteration/Queue based
 */
public class GraphBFS {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n) for Queue & VisitedSet
     */
    public static void bfs_withoutMutatingGraph(GraphNode_OLD<Integer> node) {
        if (node == null) return;
        Set<GraphNode_OLD> visitedSet = new HashSet<>();
        Queue<GraphNode_OLD> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            //System.out.println("q = " + q);
            GraphNode_OLD qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!visitedSet.contains(qn)) {
                visit(qn);
                visitedSet.add(qn);
                for (GraphNode_OLD child : qn.children) {
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
    public static void bfs_better(GraphNode_OLD<Integer> n) {
        if (n == null) return;
        Queue<GraphNode_OLD<Integer>> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            GraphNode_OLD<Integer> qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!qn.visited) {
                visit(qn);
                qn.visited = true;
                for (GraphNode_OLD<Integer> c : qn.children) {
                    if (!c.visited) q.add(c);
                }
            }
        }
    }

    /**
     * Time Complexity  : O(n) - Visiting each of n nodes
     * Space Complexity : O(n) - Queue memory
     */
    public static void bfs(GraphNode_OLD<Integer> n) {
        if (n == null) return;
        Queue<GraphNode_OLD<Integer>> q = new LinkedList<>();
        q.addAll(Arrays.asList(n.children));
        visit(n);
        n.visited = true;
        while (!q.isEmpty()) {
            GraphNode_OLD<Integer> qn = q.remove();
            // REMEMBER: Queue might have duplicate entries
            if (!qn.visited) {
                q.addAll(Arrays.asList(qn.children));
                visit(qn);
                qn.visited = true;
            }
        }
    }


    private static void visit(GraphNode_OLD<Integer> n) {
        System.out.print(n.data + " ");
    }

    public static void main(String[] args) {
        System.out.println("### GRAPH BFS");
        GraphNode_OLD<Integer> root = TestData.getGraphData_1();
        System.out.println("\n1. BFS-without mutating graph");
        bfs_withoutMutatingGraph(root);

        root = TestData.getGraphData_2();
        System.out.println("\n2. BFS-without mutating graph");
        bfs_withoutMutatingGraph(root);


        System.out.println("\nBFS-Better");
        bfs_better(root);

        System.out.println("\nBFS");
        root = TestData.getGraphData_1();
        bfs(root);
    }

}