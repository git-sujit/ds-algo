package com.sks.algo2020.udemy.graph;

/**
 * @author : Sujit K Singh
 * Purpose : A Graph Node
 */
public class Node {
    public int data;
    public Node[] children;
    public boolean visited;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public static Node getGraphData() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.children = new Node[]{n1, n4, n5};
        n1.children = new Node[]{n3, n4};
        n2.children = new Node[]{n1};
        n3.children = new Node[]{n2, n4};
        n4.children = new Node[]{};
        n5.children = new Node[]{};

        return n0;
    }

    public static Node getGraphData_1() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.children = new Node[]{n1, n5};
        n1.children = new Node[]{n3, n4};
        n2.children = new Node[]{n1};
        n3.children = new Node[]{n2, n4};
        n4.children = new Node[]{};
        n5.children = new Node[]{};

        return n0;
    }
}
