package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in
 * the tree is now the root of the tree, and every node has no left child and only one right child.
 */
public class TreeBSInOrder {
    /**
     * Time Complexity: O(N), where NN is the number of nodes in the given tree
     * Space Complexity: O(N)
     */
    public static TreeNode increasingBST(TreeNode root) {
        List<TreeNode> inList = new ArrayList<>();
        inOrder(root, inList);
        if (inList.isEmpty()) return null;
        for (int i = 0; i < inList.size(); i++) {
            TreeNode n = inList.get(i);
            n.left = null;
            n.right = (i == inList.size() - 1) ? null : inList.get(i + 1);
        }
        return inList.get(0);
    }

    private static void inOrder(TreeNode node, List<TreeNode> lst) {
        if (node == null) return;
        inOrder(node.left, lst);
        lst.add(node);
        inOrder(node.right, lst);
    }

    public static void main(String[] args) {
        TreeNode bstRoot = TreeNode.binarySearchTreeData1();
        TreePrinter.printNode(bstRoot);
        TreeNode changedBstRoot = increasingBST(bstRoot);
        TreePrinter.printNode(changedBstRoot);
    }
}
