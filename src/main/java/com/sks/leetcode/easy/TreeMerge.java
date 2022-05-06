package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;

/**
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge the two trees into a new binary tree. T
 * he merge rule is that if two nodes overlap, then sum node values up as the new value of the
 */
public class TreeMerge {
    /**
     * Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
     * Space complexity : OO(m). The depth of the recursion tree can go upto m in the case of a skewed tree. In average case, depth will be O(logm).
     */
    public static TreeNode mergeTrees_updateFirstTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees_updateFirstTree(root1.left, root2.left);
        root1.right = mergeTrees_updateFirstTree(root1.right, root2.right);
        return root1;
    }

    /**
     * Time Complexity: O(n), n is max of no. of nodes in tree 1 & 2
     * Space Complexity: O(n) if not balanced: O(logn) for balanced tree
     */
    public static TreeNode mergeTrees_brandNewTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode merged = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        merged.left = mergeTrees_brandNewTree(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        merged.right = mergeTrees_brandNewTree(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return merged;
    }

    private static void preOrder(TreeNode node) {
        if (node == null) return;
        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void visit(TreeNode node) {
        System.out.print(node.val + "  ");
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.treeData1();
        System.out.println("\nTree One");
        preOrder(root1);
        TreeNode root2 = TreeNode.treeData2();
        System.out.println("\nTree Two");
        preOrder(root2);
        TreeNode merged = mergeTrees_brandNewTree(root1, root2);
        System.out.println("\nMerged Tree");
        preOrder(merged);

        TreeNode mergedUpdated = mergeTrees_updateFirstTree(root1, root2);
        System.out.println("\nMerged & Updated Tree");
        preOrder(mergedUpdated);
        System.out.println("\nUpdated Tree One");
        preOrder(root1);
    }

}
