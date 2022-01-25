package com.sks.leatcode.medium;

import com.sks.leatcode.common.Node;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 */
public class GraphCloner {
    // The key is original node and value being the clone node.
    private static Map<Node, Node> visited_better = new HashMap<>();

    /**
     * Time Complexity: O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
     * Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
     * space would also be occupied by the recursion stack since we are adopting a recursive approach here.
     * The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
     * Overall, the space complexity would be O(N)
     */
    public static Node cloneGraph_better(Node node) {
        if (node == null) return null;
        if (visited_better.containsKey(node)) return visited_better.get(node);
        Node clonedNode = new Node(node.val, new ArrayList<>());
        // The key is original node and value being the clone node.
        visited_better.put(node, clonedNode);
        for (Node n : node.children)
            clonedNode.children.add(cloneGraph_better(n));
        return clonedNode;
    }

    /**
     * Time complexity: O(n) Visiting each node in DFS fashion
     * Space complexity: O(n) to maintain Map & set
     */
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> clonedNodes = new HashMap<>();
        cloneNodes_dfs(node, clonedNodes);
        setNeighnbors_dfs(node, clonedNodes, new HashSet<>());
        return clonedNodes.get(node.val);
    }

    private static void setNeighnbors_dfs(Node node, Map<Integer, Node> clonedNodes, Set<Integer> visited) {
        if (node == null) return;
        visited.add(node.val);
        Node clone = clonedNodes.get(node.val);
        List<Node> nbr = new ArrayList<>();
        for (Node n : node.children) nbr.add(clonedNodes.get(n.val));
        clone.children = nbr;
        for (Node n : node.children) {
            if (!visited.contains(n.val)) setNeighnbors_dfs(n, clonedNodes, visited);
        }
    }

    private static void cloneNodes_dfs(Node node, Map<Integer, Node> clonedNodes) {
        if (node == null) return;
        clonedNodes.put(node.val, new Node(node.val));
        for (Node n : node.children) {
            if (!clonedNodes.containsKey(n.val)) cloneNodes_dfs(n, clonedNodes);
        }
    }

    public static void main(String[] args) {
        System.out.println("Original Graph");
        Node node = Node.prepareGraphData_1();
        Node.visit_dfs(node);
        System.out.println("\nCloned Graph");
        Node clonedNode = cloneGraph(node);
        Node.visit_dfs(clonedNode);
        System.out.println("\n[Better]Cloned Graph");
        clonedNode = cloneGraph_better(node);
        Node.visit_dfs(clonedNode);
    }
}
