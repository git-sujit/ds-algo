package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class TreeHeightBalanced {
    /**
     * Top-Down recursion
     * Time Complexity: O(nlogn), for each of n node, height is calculated[Height- O(logn)]
     * Space Complexity: o(logn) for recursive stack, worst case O(n) if tree is linear
     * Concern: Multiple calls for height
     */
    public static boolean isBalanced_recursion(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced_recursion(root.left) && isBalanced_recursion(root.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Memoization
     * Time Complexity: O(n), one pass to store height of each node, second pass to check if its balanced
     * Space Complexity: o(n) for Recursion stack & HashMap
     */
    public static boolean isBalanced_memoization(TreeNode root) {
        //Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        //memoizeHeight(root, nodeHeightMap);
        return isBalanced_memoization(root, new HashMap<>());
    }

    private static boolean isBalanced_memoization(TreeNode root, Map<TreeNode, Integer> nodeHeightMap) {
        //System.out.println("nodeHeightMap = " + nodeHeightMap);
        if (root == null) return true;
        if (Math.abs(memoizeHeight(root.left, nodeHeightMap) - memoizeHeight(root.right, nodeHeightMap)) > 1)
            return false;
        return isBalanced_memoization(root.left, nodeHeightMap) && isBalanced_memoization(root.right, nodeHeightMap);
    }

    private static int memoizeHeight(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int height = 1 + Math.max(memoizeHeight(root.left, memo), memoizeHeight(root.right, memo));
        memo.put(root, height);
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        test(root);

        root = TreeNode.treeData2();
        test(root);

        root = TreeNode.treeData_leftLinear();
        test(root);
    }

    private static void test(TreeNode root) {
        TreePrinter.printNode(root);
        System.out.println("[Recursion] Is tree balanced : " + isBalanced_recursion(root));
        System.out.println("[Memoization] Is tree balanced : " + isBalanced_memoization(root));
    }

}
