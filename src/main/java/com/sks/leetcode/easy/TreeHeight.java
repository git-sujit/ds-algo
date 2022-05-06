package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {
    public static int height_recursion(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height_recursion(root.left), height_recursion(root.right));
    }

    public static int height_iterative(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> qc = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode qn = q.remove();
                if (qn.left != null) qc.add(qn.left);
                if (qn.right != null) qc.add(qn.right);
            }
            height++;
            q = qc;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        System.out.println("[Recursion] Height of Tree = " + height_recursion(root));
        System.out.println("[Iteration] Height of Tree = " + height_iterative(root));
    }
}
