package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
 * If a node does not have a left/right child, then the sum of the left/right subtree node values is treated as 0
 */
public class TreeTilt {
    public static int findTilt_recursion(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> nodeSumMap = new HashMap<>();
        return Math.abs(nodeSum_memoization(root.left, nodeSumMap) - nodeSum_memoization(root.right, nodeSumMap)) +
                findTilt_recursion(root.left) +
                findTilt_recursion(root.right);
    }

    private static int nodeSum_memoization(TreeNode node, Map<TreeNode, Integer> nodeSumMap) {
        if (node == null) return 0;
        if (nodeSumMap.containsKey(node)) return nodeSumMap.get(node);
        return node.val + nodeSum_memoization(node.left, nodeSumMap) + nodeSum_memoization(node.right, nodeSumMap);
    }

    private static int nodeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + nodeSum(node.left) + nodeSum(node.right);
    }

    /**
     * Time Complexity: O(N), We traverse each node once and only once. During the traversal, we calculate the tilt value for each node.
     * Space Complexity: O(N) for recursion stack and TiltList
     */
    public static int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        sumAndTilt(root, tilts);
        //System.out.println("tilts = " + tilts);
        int sum = 0;
        for (int tilt : tilts)
            sum += tilt;
        return sum;
    }

    private static int sumAndTilt(TreeNode node, List<Integer> tilts) {
        if (node == null) return 0;
        int leftSum = sumAndTilt(node.left, tilts);
        int rightSum = sumAndTilt(node.right, tilts);
        tilts.add(Math.abs(leftSum - rightSum));
        return node.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData2();
        demo(root);

        root = TreeNode.treeData1();
        demo(root);
    }

    private static void demo(TreeNode root) {
        TreePrinter.printNode(root);
        System.out.println("[Recursion Better]Sum of Tilt = " + findTilt_recursion(root));
        System.out.println("[Recursion] Sum of Tilt = " + findTilt(root));
    }
}
