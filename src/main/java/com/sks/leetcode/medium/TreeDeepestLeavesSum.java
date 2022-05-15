package com.sks.leetcode.medium;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class TreeDeepestLeavesSum {
    /**
     * Time Complexity : O(logn)
     * Space Complexity: O(n)
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            sum = 0;
            while (!q.isEmpty()) {
                TreeNode qn = q.remove();
                sum += qn.val;
                if (qn.left != null) temp.add(qn.left);
                if (qn.right != null) temp.add(qn.right);
            }
            q = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        System.out.println("Sum of deepest leaves = " + new TreeDeepestLeavesSum().deepestLeavesSum(root));

        root = TreeNode.treeData2();
        TreePrinter.printNode(root);
        System.out.println("Sum of deepest leaves = " + new TreeDeepestLeavesSum().deepestLeavesSum(root));
    }
}