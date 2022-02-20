package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class TreeSymmetry {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    private static boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData_symmetric();
        TreePrinter.printNode(root);
        System.out.println("Is tree Symmetric? : " + isSymmetric(root));
        root = TreeNode.treeData2();
        TreePrinter.printNode(root);
        System.out.println("Is tree Symmetric? : " + isSymmetric(root));
    }
}
