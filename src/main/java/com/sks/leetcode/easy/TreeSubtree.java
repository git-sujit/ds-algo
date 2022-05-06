package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with
 * the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 */
public class TreeSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val && isSameTree(root, subRoot)) return true;
        else return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
