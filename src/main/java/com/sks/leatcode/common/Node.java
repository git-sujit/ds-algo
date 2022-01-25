package com.sks.leatcode.common;

import java.util.*;

/**
 * N-Ary Tree Node
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
        val = 0;
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        children = _neighbors;
    }

    public static Node prepareGraphData_1() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.children = Arrays.asList(two, four);
        two.children = Arrays.asList(one, three);
        three.children = Arrays.asList(two, four);
        four.children = Arrays.asList(one, three);
        return one;
    }

    public static void visit_dfs(Node node) {
        Set<Node> visited = new HashSet<>();
        System.out.println("DFS Visit of Graph => ");
        visit_dfs(node, visited);
        System.out.println();
    }

    private static void visit_dfs(Node node, Set<Node> visited) {
        if (node == null) return;
        System.out.print(node.val + " ");
        visited.add(node);
        for (Node n : node.children)
            if (!visited.contains(n)) visit_dfs(n, visited);
    }
}
