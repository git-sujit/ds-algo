package com.sks.averma.recursion;

import com.sks.leatcode.common.TreeNode;

public class HeightOfBinaryTree {
    /**
     * 1. Hypothesis: height(node) function returns the height of node
     */
    public static int height(TreeNode root) {
        // 2. Base Condition
        if (root == null) return 0;
        // 3. Induction
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
