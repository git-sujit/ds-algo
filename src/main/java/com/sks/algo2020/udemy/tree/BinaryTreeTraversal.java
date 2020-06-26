package com.sks.algo2020.udemy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Sujit K Singh
 * Purpose : Tree Traversal
 */
public class BinaryTreeTraversal {
    public static void preOrder(Node n) {
        if (n == null) return;
        visit(n);
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void postOrder(Node n) {
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        visit(n);
    }

    public static void inOrder(Node n) {
        if (n == null) return;
        inOrder(n.left);
        visit(n);
        inOrder(n.right);
    }

    public static void levelOrder(Node n) {
        if (n == null) return;
        Queue<Node> q = new LinkedList<>();
        if (n.left != null) q.add(n.left);
        if (n.right != null) q.add(n.right);
        visit(n);
        while (!q.isEmpty()) {
            Node n1 = q.remove();
            if (n1.left != null) q.add(n1.left);
            if (n1.right != null) q.add(n1.right);
            visit(n1);
        }
    }

    public static int height(Node n) {
        if (n == null) return 0;
        int hl = height(n.left);
        int hr = height(n.right);
        return hl > hr ? 1 + hl : 1 + hr;
    }

    private static void visit(Node n) {
        System.out.print(n.data + "  ");
    }

    public static void main(String[] args) {
        Node root = Node.getBinaryTreeData();
        System.out.println(root);
        Node root1 = Node.getBinaryTreeData_1();
        System.out.println("Height = " + height(root));
        System.out.println("Height = " + height(root1));
        System.out.println("### Pre-Order");
        preOrder(root);
        System.out.println("\n### Post-Order");
        postOrder(root);
        System.out.println("\n### In-Order");
        inOrder(root);
        System.out.println("\n### Level-Order");
        levelOrder(root);
    }
}
