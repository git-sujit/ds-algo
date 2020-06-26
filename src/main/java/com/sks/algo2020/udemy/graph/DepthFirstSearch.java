package com.sks.algo2020.udemy.graph;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class DepthFirstSearch {
    public static void dfs(Node n) {
        if (n == null) return;
        visit(n);
        n.visited = true;
        for (Node child : n.children) {
            if (!child.visited)
                dfs(child);
        }
    }

    private static void visit(Node n) {
        System.out.println(n.data);
    }


    public static void main(String[] args) {
        System.out.println("### GRAPH DFS");
        Node root = Node.getGraphData();
        dfs(root);
    }
}
