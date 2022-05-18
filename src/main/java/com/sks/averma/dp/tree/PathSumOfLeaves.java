package com.sks.averma.dp.tree;

import com.sks.leetcode.common.TreeNode;

public class PathSumOfLeaves {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = {Integer.MIN_VALUE};
        maxPathSum(root, res);
        return res[0];
    }

    private int maxPathSum(TreeNode node, int[] res) {
        // Base condition
        if (node == null) return 0;
        // Hypothesis
        int ls = maxPathSum(node.left, res);
        int rs = maxPathSum(node.right, res);
        // Induction
        int temp = node.val + Math.max(ls, rs);
        int ans = Math.max(temp, 1 + ls + rs);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
}
