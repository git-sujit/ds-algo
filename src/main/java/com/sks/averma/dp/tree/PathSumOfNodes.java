package com.sks.averma.dp.tree;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

/**
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <br/>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 */
public class PathSumOfNodes {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    public int maxPathSum(TreeNode root) {
        int[] res = {Integer.MIN_VALUE};
        maxPathSum(root, res);
        return res[0];
    }

    public int maxPathSum(TreeNode node, int[] res) {
        /** Base Condition **/
        if (node == null) return 0;
        /** Hypothesis **/
        int ls = maxPathSum(node.left, res);
        int rs = maxPathSum(node.right, res);
        /** Induction **/
        int temp = Math.max(node.val + Math.max(ls, rs), node.val); // If ls & rs are -ve then return temp=node.val
        int ps = node.val + ls + rs;
        int ans = Math.max(temp, ps);
        res[0] = Math.max(res[0], ans);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        demo(root);

    }

    private static void demo(TreeNode root) {
        TreePrinter.printNode(root);
        System.out.println("Max path sum b/w leaves = " + new PathSumOfNodes().maxPathSum(root));
    }
}
