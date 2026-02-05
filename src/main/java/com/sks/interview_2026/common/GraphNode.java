package com.sks.interview_2026.common;

public class GraphNode<T> {
    public T data;
    public GraphNode[] children;
    public boolean visited;

    public GraphNode() {
    }

    public GraphNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                '}';
    }

    public static GraphNode<Integer> getGraphData() {
        GraphNode<Integer> n0 = new GraphNode<>(0);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n5 = new GraphNode<>(5);

        n0.children = new GraphNode[]{n1, n4, n5};
        n1.children = new GraphNode[]{n3, n4};
        n2.children = new GraphNode[]{n1};
        n3.children = new GraphNode[]{n2, n4};
        n4.children = new GraphNode[]{};
        n5.children = new GraphNode[]{};

        return n0;
    }


    public static GraphNode<Integer> getGraphData_1() {
        GraphNode<Integer> n0 = new GraphNode(0);
        GraphNode<Integer> n1 = new GraphNode(1);
        GraphNode<Integer> n2 = new GraphNode(2);
        GraphNode<Integer> n3 = new GraphNode(3);
        GraphNode<Integer> n4 = new GraphNode(4);
        GraphNode<Integer> n5 = new GraphNode(5);

        n0.children = new GraphNode[]{n1, n5};
        n1.children = new GraphNode[]{n3, n4};
        n2.children = new GraphNode[]{n1};
        n3.children = new GraphNode[]{n2, n4};
        n4.children = new GraphNode[]{};
        n5.children = new GraphNode[]{};

        return n0;
    }
}
