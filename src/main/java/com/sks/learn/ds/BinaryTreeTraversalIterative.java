package com.sks.learn.ds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversalIterative {
    class Node {
        Node left;
        int data;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    BinaryTreeTraversalIterative() {
        initialize();
    }

    Node root;

    public void initialize() {
        root = new Node(200);
        root.left = new Node(100);
        root.right = new Node(300);

        root.left.left = new Node(50);
        root.left.right = new Node(150);

        root.right.right = new Node(350);
    }

    // PRE-ORDER: Root -> Left -> Right
    public void preOrder_recursive(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder_recursive(root.left);
        preOrder_recursive(root.right);
    }

    public void preOrder_iterative(Node root) {
        if (root == null)
            return;
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.data + " ");
            Node right = n.right;
            if (right != null)
                stack.push(right);
            Node left = n.left;
            if (left != null)
                stack.push(left);
        }
    }

    // IN-ORDER: Left -> Root -> Right
    public void inOrder_recursive(Node root) {
        if (root == null)
            return;
        inOrder_recursive(root.left);
        System.out.print(root.data + " ");
        inOrder_recursive(root.right);

    }

    public void inOrder_iterative(Node root) {
        if (root == null)
            return;
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            Node left = n.left;
            if (left != null)
                stack.push(left);
            Node right = n.right;
            if (right != null)
                stack.push(right);

        }
    }

    // POST-ORDER: Left -> Right -> Root
    public void postOrder_recursive(Node root) {
        if (root == null)
            return;
        postOrder_recursive(root.left);
        postOrder_recursive(root.right);
        System.out.print(root.data + " ");
    }

    // Use of two stacks
    public void postOrder_iterative(Node root) {
        if (root == null)
            return;
        // s1: to maintain left/right of a node
        Deque<Node> s1 = new ArrayDeque<Node>();
        // S2- To maintan node for which left/right is in s1
        Deque<Node> s2 = new ArrayDeque<Node>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node n = s1.pop();
            // Because node will be processed last
            s2.push(n);
            Node left = n.left;
            if (left != null)
                s1.push(left);
            Node right = n.right;
            if (right != null)
                s1.push(right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.data + " ");
            Node left = n.left;
            Node right = n.right;
            if (left != null)
                q.add(left);
            if (right != null)
                q.add(right);
        }
    }

    public int heightOfBT(Node root) {
        if (root == null)
            return 0;
        int lh = heightOfBT(root.left);
        int rh = heightOfBT(root.right);
        return 1 + (lh > rh ? lh : rh);
    }

    public static void main(String[] args) {
        BinaryTreeTraversalIterative obj = new BinaryTreeTraversalIterative();
        System.out.println("PRE-ORDER : RECURSIVE");
        obj.preOrder_recursive(obj.root);
        System.out.println("\nIN-ORDER : RECURSIVE");
        obj.inOrder_recursive(obj.root);
        System.out.println("\nPOST-ORDER : RECURSIVE");
        obj.postOrder_recursive(obj.root);
        System.out.println("\n======================");
        System.out.println("PRE-ORDER : ITERATIVE");
        obj.preOrder_iterative(obj.root);
        System.out.println("\nIN-ORDER : ITERATIVE");
        // obj.inOrder_iterative(obj.root);
        System.out.println("\nPOST-ORDER : ITERATIVE");
        obj.postOrder_iterative(obj.root);
        System.out.println("\nLEVEL-ORDER : ITERATIVE");
        obj.levelOrderTraversal(obj.root);

        System.out.println("\nHeight of Tree = " + obj.heightOfBT(obj.root));
    }

}
