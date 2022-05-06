package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

public class TreeString {
    public static String tree2str_better(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        if (root.left == null) return root.val + "(" + tree2str_better(root.right) + ")";
        if (root.right == null) return root.val + "(" + tree2str_better(root.left) + ")";
        return root.val + "(" + tree2str_better(root.left) + ")(" + tree2str_better(root.right) + ")";
    }

    public static String tree2str(TreeNode root) {
        StringBuilder out = new StringBuilder();
        tree2str(root, out);
        String outStr = out.toString();
        //outStr = outStr.replaceAll("()", "a");
        return outStr.replaceAll("\\(\\)", "");
    }

    private static void tree2str(TreeNode node, StringBuilder out) {
        if (node == null) return;
        out.append(node.val + "(");
        tree2str(node.left, out);
        out.append(")(");
        tree2str(node.right, out);
        out.append(")");
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        System.out.println(tree2str(root));
        System.out.println(tree2str_better(root) + " : Better");
    }
}
