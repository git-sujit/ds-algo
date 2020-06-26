package com.sks.algo2020.udemy.tree;

/**
 * @author : Sujit K Singh
 * Purpose : Tree Node
 */
public class Node {
    public Node left;
    public Object data;
    public Node right;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String leftData = "";
        String rightData = "";
        if (left != null)
            leftData = "" + left.data;
        if (right != null)
            rightData = "" + right.data;
        return "(" + leftData + "<--[" + data + "]-->" + rightData + ")";
    }

    public static Node getBinaryTreeData() {
        Node n0 = new Node("P");
        Node n1 = new Node("A");
        Node n2 = new Node("X");
        n0.left = n1;
        n0.right = n2;
        Node n3 = new Node("S");
        Node n4 = new Node("E");
        Node n5 = new Node("M");
        Node n6 = new Node("R");
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        Node n7 = new Node("T");
        Node n8 = new Node("Q");
        Node n9 = new Node("D");
        Node n10 = new Node("C");
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;

        return n0;
    }

    public static Node getBinaryTreeData_1() {
        Node n0 = new Node("P");
        Node n1 = new Node("A");
        Node n2 = new Node("X");
        n0.left = n1;
        n0.right = n2;
        Node n3 = new Node("S");
        Node n4 = new Node("E");
        Node n5 = new Node("M");
        Node n6 = new Node("R");
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        Node n7 = new Node("T");
        Node n8 = new Node("Q");
        Node n9 = new Node("D");
        Node n10 = new Node("C");
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;
        Node n11 = new Node("S");
        Node n12 = new Node("U");
        Node n13 = new Node("J");
        n10.right = n11;
        n11.left = n12;
        n12.right = n13;
        return n0;
    }

    public static Node getBinarySearchTreeData() {
        Node n0 = new Node(70);
        Node n1 = new Node(40);
        Node n2 = new Node(80);
        n0.left = n1;
        n0.right = n2;
        Node n3 = new Node(35);
        Node n4 = new Node(50);
        Node n5 = new Node(75);
        Node n6 = new Node(89);
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        Node n7 = new Node(30);
        Node n8 = new Node(37);
        Node n9 = new Node(55);
        Node n10 = new Node(82);
        Node n11 = new Node(93);
        n3.left = n7;
        n3.right = n8;
        n4.right = n9;
        n6.left = n10;
        n6.right = n11;
        Node n12 = new Node(73);
        n5.left = n12;
        Node n13 = new Node(71);
        Node n14 = new Node(74);
        n12.left = n13;
        n12.right = n14;
        return n0;
    }

}
