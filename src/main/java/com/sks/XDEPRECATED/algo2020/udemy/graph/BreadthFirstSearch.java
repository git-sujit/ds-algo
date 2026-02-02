package com.sks.XDEPRECATED.algo2020.udemy.graph;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.sks.XDEPRECATED.algo2020.TestData.GraphNode_OLD;

/**
 * @author : Sujit K Singh
 * Purpose : BFS, better for Shortest path or any path - Iteration/Queue based
 */
public class BreadthFirstSearch {
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
                System.out.print(qn.data + ", ");
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
            //System.out.println("Queue = " + q.toString());
            GraphNode_OLD<Integer> qn = q.remove();
            if (!qn.visited) {
                q.addAll(Arrays.asList(qn.children));
                visit(qn);
                qn.visited = true;
            }
        }
    }


    private static void visit(GraphNode_OLD<Integer> n) {
        System.out.println("Visited : " + n.data);
    }

    public static void main(String[] args) {
        System.out.println("### GRAPH BFS");
        GraphNode_OLD<Integer> root = TestData.getGraphData_1();
        System.out.println("root = " + root);
        bfs(root);
        System.out.println("Alternate Algo: ");
        root = TestData.getGraphData_1();
        bfs_better(root);
    }

}