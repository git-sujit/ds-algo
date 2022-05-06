package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * (Get the mirror image of binary tree)
 */
public class TreeInversion {
    /**
     * Time Complexity  : O(n), we are going through each node once
     * Space Complexity : O(logn)/Height, for Balance tree , O(n) if Recursion stack can grow upto n size if Tree is skewed/linear
     */
    public static TreeNode invertTree_recursive_2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree_recursive_2(left);
        invertTree_recursive_2(right);
        return root;
    }

    /**
     * Time Complexity  : O(n), we are going through each node once
     * Space Complexity : O(logn)/Height, for Balance tree , O(n) if Recursion stack can grow upto n size if Tree is skewed/linear
     */
    public static TreeNode invertTree_recursive(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree_recursive(root.left);
        TreeNode right = invertTree_recursive(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static TreeNode invertTree_recursive_1(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree_recursive_1(root.left);
        invertTree_recursive_1(root.right);

        return root;
    }

    /**
     * /**
     * Time Complexity  : O(n), we are going through each node once
     * Space Complexity : O(n), Queue storage
     */
    public static TreeNode invertTree_iterative(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return root;
    }

    public static TreeNode invertTreeReturningRoot(TreeNode root) {
        invertTreeWithoutReturningRoot(root);
        return root;
    }

    public static void invertTreeWithoutReturningRoot(TreeNode root) {
        if (root == null)
            return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTreeWithoutReturningRoot(root.left);
        invertTreeWithoutReturningRoot(root.right);
    }


    public static void main(String[] args) {
        //deprecated();
        TreeNode root = TreeNode.treeData2();
        demo(root);
    }

    private static void demo(TreeNode root) {
        System.out.println("Original Tree");
        TreePrinter.printNode(root);
        System.out.println("Inverted Tree");
        TreePrinter.printNode(invertTree_recursive(root));
        System.out.println("Inverted Tree-1");
        root = TreeNode.treeData2();
        TreePrinter.printNode(invertTree_recursive_1(root));
    }

    private static void deprecated() {
        int[] a = {Integer.MAX_VALUE, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Array = " + Arrays.toString(a));
        TreeNode root = prepareCompleteBinaryTree_queueBased(a);
        traverseTree_levelOrder_BFS(root);
        TreeNode invertedRoot = invertTreeReturningRoot(root);
        System.out.println("\nInverted Tree: ");
        traverseTree_levelOrder_BFS(invertedRoot);

        root = prepareCompleteBinaryTree_queueBased(a);
        traverseTree_levelOrder_BFS(root);
        invertedRoot = invertTree_recursive(root);
        System.out.println("\nInverted Tree: ");
        traverseTree_levelOrder_BFS(invertedRoot);

        root = prepareCompleteBinaryTree_queueBased(a);
        traverseTree_levelOrder_BFS(root);
        invertedRoot = invertTree_iterative(root);
        System.out.println("\nInverted Tree: ");
        traverseTree_levelOrder_BFS(invertedRoot);
        //testBasics();
    }

    private static void testBasics() {
        int[] a = {Integer.MAX_VALUE, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Binary tree in Array : " + Arrays.toString(a));
        TreeNode root = prepareCompleteBinaryTree_arrayBased(a);
        System.out.println("Tree traversal(Level Order) : ");
        traverseTree_levelOrder_BFS(root);
        System.out.println("\nTree =>  " + root);

        root = prepareCompleteBinaryTree_queueBased(a);
        System.out.println("Tree traversal(Level Order) : ");
        traverseTree_levelOrder_BFS(root);
        System.out.println("\nTree =>  " + root);
    }

    private static TreeNode prepareCompleteBinaryTree_queueBased(int[] a) {
        System.out.println("\nPreparing complete-binary-tree : Queue Based");
        if (a == null || a.length < 2) return null;
        TreeNode root = new TreeNode(a[1]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < a.length / 2 + 1; i++) {
            int l = 2 * i;
            int r = 2 * i + 1;
            TreeNode n = q.remove();
            n.left = new TreeNode(a[l]);
            q.add(n.left);
            if (r < a.length) {
                n.right = new TreeNode(a[r]);
                q.add(n.right);
            }

        }
        return root;
    }

    private static TreeNode prepareCompleteBinaryTree_arrayBased(int[] a) {
        System.out.println("Preparing complete-binary-tree : Array Based");
        if (a == null || a.length < 2) return null;
        TreeNode[] na = new TreeNode[a.length];
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            na[i] = new TreeNode(val);
        }
        for (int i = 1; i < na.length; i++) {
            int l = 2 * i;
            int r = 2 * i + 1;
            if (l < na.length)
                na[i].left = na[l];
            if (r < na.length)
                na[i].right = na[r];
        }
        return na[1];
    }

    private static void traverseTree_levelOrder_BFS(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            System.out.print(node.val + "\t");
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }
}


