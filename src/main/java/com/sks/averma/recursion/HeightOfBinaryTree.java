package com.sks.averma.recursion;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

public class HeightOfBinaryTree {
    /**
     * Time : O(n), we are traversing all the nodes
     * Space: O(n), best case O(logn) for balanced tree
     * 1. Hypothesis: height(node) function returns the height of node
     */
    public static int height(TreeNode root) {
        // 2. Base Condition
        if (root == null) return 0;
        // 3. Induction
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int height_better(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height_better(root.left), height_better(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        System.out.println("Height of Tree: " + height(root));
        System.out.println("[Better] Height of Tree: " + height_better(root));
    }
}
