package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
    /**
     * Top-Down recursion
     * Time Complexity: O(nlogn), for each of n node, height is calculated[Height- O(logn)]
     * Space Complexity: o(logn) for recursive stack, worst case O(n) if tree is linear
     * Concern: Multiple calls for height
     */
    public boolean isBalanced_recursion(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced_recursion(root.left)
                && isBalanced_recursion(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Memoization
     * Time Complexity: O(n), one pass to store height of each node, second pass to check if its balanced
     * Space Complexity: o(n) for Recursion stack & HashMap
     */
    public boolean isBalanced_memoization(TreeNode root) {
        Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        memoizeHeight(root, nodeHeightMap);
        return isBalanced_memoization(root, nodeHeightMap);
    }

    private boolean isBalanced_memoization(TreeNode root, Map<TreeNode, Integer> nodeHeightMap) {
        if (root == null) return true;
        return Math.abs(nodeHeightMap.get(root.left) - nodeHeightMap.get(root.right)) <= 1
                && isBalanced_memoization(root.left, nodeHeightMap)
                && isBalanced_memoization(root.right, nodeHeightMap);
    }

    private int memoizeHeight(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return -1;
        if (memo.containsKey(root))
            return memo.get(root);
        int height = 1 + Math.max(memoizeHeight(root.left, memo), memoizeHeight(root.right, memo));
        memo.put(root, height);
        return height;
    }

    /**
     * Bottom-Up recursion
     * Time Complexity: O(n), one pass to store height of each node, second pass to check if its balanced
     * Space Complexity: o(n) for Recursion stack & HashMap
     */
    public boolean isBalanced(TreeNode root) {
        return getTreeInfo(root).isBalanced;
    }

    TreeInfo getTreeInfo(TreeNode node) {
        if (node == null)
            return new TreeInfo(true, -1);
        TreeInfo leftInfo = getTreeInfo(node.left);
        TreeInfo rightInfo = getTreeInfo(node.right);
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new TreeInfo(isBalanced, height);
    }

    class TreeInfo {
        boolean isBalanced;
        int height;

        TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
