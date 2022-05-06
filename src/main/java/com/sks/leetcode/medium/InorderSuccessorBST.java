package com.sks.leetcode.medium;

import com.sks.leetcode.common.TreeNode;

/**
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
 * The successor of a node p is the node with the smallest key greater than p.val.
 */
public class InorderSuccessorBST {
    /**
     * Time Complexity: O(n) for skewed tree, O(logn) for general BSTs
     * Space Complexity: O(1), no recursion or any other Data-structure is used
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
