package com.sks.algo2020.udemy.graph;

import com.sks.algo2020.TestData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.sks.algo2020.TestData.GraphNode;

/**
 * @author : Sujit K Singh
 * Purpose : BFS
 */
public class BreadthFirstSearch {
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
            System.out.println("Queue = " + q.toString());
            GraphNode<Integer> qn = q.remove();
            if (!qn.visited) {
                q.addAll(Arrays.asList(qn.children));
                visit(qn);
                qn.visited = true;
            }
        }
    }

    private static void visit(GraphNode<Integer> n) {
        System.out.println("Visited : " + n.data);
    }

    public static void main(String[] args) {
        System.out.println("### GRAPH BFS");
        GraphNode<Integer> root = TestData.getGraphData_1();
        System.out.println("root = " + root);
        bfs(root);
    }

}