package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class TreeSymmetry {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n), best case O(logn)
     */
    public boolean isSymmetric_recursive(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }

    /**
     * Level Order Traversal
     * Time Complexity : O(n)
     * Space Complexity: O(n), best case O(logn)
     */
    public boolean isSymmetric_iterative(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData_symmetric();
        TreePrinter.printNode(root);
        demo(root);

        root = TreeNode.treeData2();
        TreePrinter.printNode(root);
        demo(root);
    }

    private static void demo(TreeNode root) {
        TreeSymmetry obj = new TreeSymmetry();
        System.out.println("[Recursive] Is tree Symmetric? : " + obj.isSymmetric_recursive(root));
        System.out.println("[Iterative] Is tree Symmetric? : " + obj.isSymmetric_iterative(root));
    }
}
