package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Cousins: Same dept, Different parents
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
 * return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 */
public class TreeCousins {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            Queue<TreeNode> childQue = new LinkedList<>();
            TreeNode px = null;
            TreeNode py = null;
            while (!que.isEmpty()) {
                TreeNode n = que.remove();
                TreeNode left = n.left;
                if (left != null) {
                    if (left.val == x) px = n;
                    if (left.val == y) py = n;
                    childQue.add(left);
                }
                TreeNode right = n.right;
                if (right != null) {
                    if (right.val == x) px = n;
                    if (right.val == y) py = n;
                    childQue.add(right);
                }
            }

            System.out.println("Child Queue = " + childQue);
            if (px != null && py != null) return px != py;
            if (px == null ^ py == null) return false;
            que = childQue;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        demo(root, 4, 5);
        demo(root, 5, 7);
        demo(root, 4, 3);
        demo(root, 6, 3);
    }

    private static void demo(TreeNode root, int x, int y) {
        System.out.println("Are cousins? (" + x + ", " + y + "): " + isCousins(root, x, y) + "\n");
    }
}
