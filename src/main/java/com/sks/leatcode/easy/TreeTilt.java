package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
 * If a node does not have a left/right child, then the sum of the left/right subtree node values is treated as 0
 */
public class TreeTilt {
    /**
     * Time Complexity: O(N), We traverse each node once and only once. During the traversal, we calculate the tilt value for each node.
     * Space Complexity: O(N) for recursion stack and TiltList
     */
    public static int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        sumAndTilt(root, tilts);
        System.out.println("tilts = " + tilts);
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
        TreeNode root = TreeNode.prepareTestData_1();
        System.out.println("Sum of Tilt = " + findTilt(root));
    }
}
