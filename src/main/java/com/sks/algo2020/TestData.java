package com.sks.algo2020;

/**
 * @author : Sujit K Singh
 * Purpose : Test Data Builder
 */
public class TestData {
    public static class GraphNode<T> {
        public T data;
        public GraphNode<T>[] children;
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
    }

    public static class BTNode<T> {
        public BTNode<T> left;
        public T data;
        public BTNode<T> right;
        public int depth;

        public BTNode() {
        }

        public BTNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            T leftData = null;
            T rightData = null;
            if (left != null)
                leftData = left.data;
            if (right != null)
                rightData = right.data;
            return "(" + leftData + "<--[" + data + "]-->" + rightData + ")";
        }
    }

    public static GraphNode<Integer> getGraphData() {
        GraphNode<Integer> n0 = new GraphNode(0);
        GraphNode<Integer> n1 = new GraphNode(1);
        GraphNode<Integer> n2 = new GraphNode(2);
        GraphNode<Integer> n3 = new GraphNode(3);
        GraphNode<Integer> n4 = new GraphNode(4);
        GraphNode<Integer> n5 = new GraphNode(5);

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

    public static BTNode<String> getBinaryTreeDataString() {
        BTNode<String> n0 = new BTNode("P");
        BTNode<String> n1 = new BTNode("A");
        BTNode<String> n2 = new BTNode("X");
        n0.left = n1;
        n0.right = n2;
        BTNode n3 = new BTNode("S");
        BTNode n4 = new BTNode("E");
        BTNode n5 = new BTNode("M");
        BTNode n6 = new BTNode("R");
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        BTNode n7 = new BTNode("T");
        BTNode n8 = new BTNode("Q");
        BTNode n9 = new BTNode("D");
        BTNode n10 = new BTNode("C");
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;

        return n0;
    }

    public static BTNode<String> getBinaryTreeDataString_1() {
        BTNode<String> n0 = new BTNode("P");
        BTNode<String> n1 = new BTNode("A");
        BTNode<String> n2 = new BTNode("X");
        n0.left = n1;
        n0.right = n2;
        BTNode<String> n3 = new BTNode("S");
        BTNode<String> n4 = new BTNode("E");
        BTNode<String> n5 = new BTNode("M");
        BTNode<String> n6 = new BTNode("R");
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        BTNode<String> n7 = new BTNode("T");
        BTNode<String> n8 = new BTNode("Q");
        BTNode<String> n9 = new BTNode("D");
        BTNode<String> n10 = new BTNode("C");
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;
        BTNode<String> n11 = new BTNode("S");
        BTNode<String> n12 = new BTNode("U");
        BTNode<String> n13 = new BTNode("J");
        n10.right = n11;
        n11.left = n12;
        n12.right = n13;
        return n0;
    }

    public static BTNode<Integer> getBinaryTreeDataInt() {
        BTNode<Integer> n1 = new BTNode(1);
        BTNode<Integer> n2 = new BTNode(2);
        BTNode<Integer> n3 = new BTNode(3);
        n1.left = n2;
        n1.right = n3;
        BTNode<Integer> n4 = new BTNode(4);
        BTNode<Integer> n5 = new BTNode(5);
        n2.left = n4;
        n2.right = n5;
        BTNode<Integer> n6 = new BTNode(6);
        BTNode<Integer> n7 = new BTNode(7);
        n3.left = n6;
        n3.right = n7;
        BTNode<Integer> n8 = new BTNode(8);
        BTNode<Integer> n9 = new BTNode(9);
        n4.left = n8;
        n4.right = n9;
        BTNode<Integer> n10 = new BTNode(10);
        n5.left = n10;
        return n1;
    }

    public static BTNode<Integer> getBinarySearchTreeDataInt() {
        BTNode<Integer> n0 = new BTNode(70);
        BTNode<Integer> n1 = new BTNode(40);
        BTNode<Integer> n2 = new BTNode(80);
        n0.left = n1;
        n0.right = n2;
        BTNode<Integer> n3 = new BTNode(35);
        BTNode<Integer> n4 = new BTNode(50);
        BTNode<Integer> n5 = new BTNode(75);
        BTNode<Integer> n6 = new BTNode(89);
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        BTNode<Integer> n7 = new BTNode(30);
        BTNode<Integer> n8 = new BTNode(37);
        BTNode<Integer> n9 = new BTNode(55);
        BTNode<Integer> n10 = new BTNode(82);
        BTNode<Integer> n11 = new BTNode(93);
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;
        n6.right = n11;
        BTNode<Integer> n12 = new BTNode(73);
        n5.left = n12;
        BTNode<Integer> n13 = new BTNode(71);
        BTNode<Integer> n14 = new BTNode(74);
        n12.left = n13;
        n12.right = n14;
        return n0;
    }

    static final int COUNT = 5;

    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    public static void printBinaryTree(BTNode<Integer> root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        printBinaryTree(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        printBinaryTree(root.left, space);
    }
}
