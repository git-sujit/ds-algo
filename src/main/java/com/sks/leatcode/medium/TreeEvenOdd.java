package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A binary tree is named Even-Odd if it meets the following conditions:
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 * For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 */
public class TreeEvenOdd {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int prevI = Integer.MIN_VALUE;
            int prevD = Integer.MAX_VALUE;
            Queue<TreeNode> cq = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode child = q.remove();
                int cv = child.val;
                if (level % 2 == 0) {
                    if (cv % 2 == 0 || prevI >= cv) return false;
                } else {
                    if (cv % 2 == 1 || prevD <= cv) return false;
                }
                prevI = cv;
                prevD = cv;
                if (child.left != null) cq.add(child.left);
                if (child.right != null) cq.add(child.right);
            }
            level++;
            q = cq;
            System.out.print("\nQueue: ");
            for(TreeNode n: q) System.out.print(n.val+"   ");
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        System.out.println("Is Even-Odd tree : " + isEvenOddTree(root));
    }
}
