package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;

/**
 * A binary tree is uni-valued if every node in the tree has the same value.
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 */
public class TreeUnival {
    /**
     * Time Complexity: O(N), where N is the number of nodes in the given tree.
     * Space Complexity:O(H), where H is the height of the given tree.
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode node, int val) {
        if (node == null) return true;
        return node.val == val && isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }
}
