package com.sks.leetcode.medium;

import com.sks.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and a node p in it, return the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorTree {
    /**
     * Time Complexity: O(n) => O(logn)
     * Space Complexity: O(1)
     */
    public TreeNode findSuccessor(TreeNode tree, TreeNode node) {
        if (tree == null || node == null) return null;
        TreeNode s = null;
        if (node.right != null) {
            s = node.right;
            while (s.left != null)
                s = s.left;
        } else {
            TreeNode p = getParent();//node.parent;
            if (p != null) {
                // Left Child of parent
                if (p.left == node) {
                    return p;
                }
                // Right child of parent
                else {
                    TreeNode g = getParent();//p.parent;
                    while (g != null) {
                        if (g.left == p)
                            return g;
                        p = g;
                        g = getParent();//g.parent;
                    }
                }
            }
        }
        return s;
    }

    private TreeNode getParent() {
        return null;
    }

    /**
     * Time Complexity: O(n) => O(n) for traversing each node in tree to build list & O(n) to iterate list
     * Space Complexity: O(n) => O(n) to store nodes & o(n) to traverse inorder in worst case(For balanced tree O(logn))
     */
    public TreeNode findSuccessor_storingInorderList(TreeNode tree, TreeNode node) {
        if (tree == null || node == null) return null;
        List<TreeNode> inorderList = new ArrayList<>();
        inorderTraversal(tree, inorderList);
        for (int i = 0; i < inorderList.size(); i++) {
            TreeNode bt = inorderList.get(i);
            if (bt == node) {
                if (i + 1 < inorderList.size()) return inorderList.get(i + 1);
                else return null;
            }
        }
        return null;
    }

    private void inorderTraversal(TreeNode tree, List<TreeNode> inorderList) {
        if (tree == null) return;
        if (tree.left != null) inorderTraversal(tree.left, inorderList);
        inorderList.add(tree);
        if (tree.right != null) inorderTraversal(tree.right, inorderList);
    }
}
