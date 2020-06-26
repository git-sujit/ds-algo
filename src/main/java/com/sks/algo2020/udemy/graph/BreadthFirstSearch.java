package com.sks.algo2020.udemy.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Sujit K Singh
 * Purpose : BFS
 */
public class BreadthFirstSearch {
    public static void bfs(Node n) {
        if (n == null) return;
        Queue<Node> q = new LinkedList<>();
        q.addAll(Arrays.asList(n.children));
        visit(n);
        n.visited = true;
        while (!q.isEmpty()) {
            System.out.println("Q = " + q.toString());
            Node qn = q.remove();
            if (!qn.visited) {
                q.addAll(Arrays.asList(qn.children));
                visit(n);
                qn.visited = true;
            }
        }
    }

    private static void visit(Node n) {
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        System.out.println("### GRAPH BFS");
        Node root = Node.getGraphData_1();
        bfs(root);
    }

}