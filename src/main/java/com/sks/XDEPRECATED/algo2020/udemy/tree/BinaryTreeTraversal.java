package com.sks.XDEPRECATED.algo2020.udemy.tree;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.LinkedList;
import java.util.Queue;

import static com.sks.XDEPRECATED.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose : Tree Traversal
 */
public class BinaryTreeTraversal {
    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static void preOrder(BTNode n) {
        // Base Case
        if (n == null) return;
        visit(n);
        preOrder(n.left);
        preOrder(n.right);
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static void postOrder(BTNode n) {
        // Base Case
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        visit(n);
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static void inOrder(BTNode n) {
        // Base Case
        if (n == null) return;
        inOrder(n.left);
        visit(n);
        inOrder(n.right);
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static void levelOrder(BTNode n) {
        // Base Case
        if (n == null) return;
        Queue<BTNode> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            BTNode n1 = q.remove();
            visit(n1);
            if (n1.left != null) q.add(n1.left);
            if (n1.right != null) q.add(n1.right);
        }
    }

    /**
     * Time Complexity  : O(logn)
     * Space Complexity : O(1)
     */
    public static int height(BTNode n) {
        // Base Case
        if (n == null) return 0;
        int hl = height(n.left);
        int hr = height(n.right);
        return hl > hr ? 1 + hl : 1 + hr;
    }

    private static void visit(BTNode n) {
        System.out.print(n.data + " ");
    }

    public static void main(String[] args) {
        BTNode<String> root = TestData.getBinaryTreeDataString();
        System.out.println(root);
        BTNode<String> root1 = TestData.getBinaryTreeDataString_1();
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
