package com.sks.interview_2026.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val + "=>(" + (left == null ? left : left.val) +
                ", " + (right == null ? right : right.val) + ")";
    }

    public static TreeNode treeData1() {
        List<TreeNode> nodes = testNodes(10);
        TreeNode root = nodes.get(1);
        root.left = nodes.get(2);
        root.right = nodes.get(3);
        nodes.get(2).left = nodes.get(4);
        nodes.get(2).right = nodes.get(5);
        nodes.get(5).left = nodes.get(6);
        nodes.get(3).right = nodes.get(7);
        return root;
    }

    public static TreeNode treeData2() {
        List<TreeNode> nodes = testNodes(10);
        TreeNode root = nodes.get(4);
        root.left = nodes.get(2);
        root.right = nodes.get(9);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(5);
        nodes.get(9).right = nodes.get(7);
        return root;
    }

    public static TreeNode binarySearchTreeData1() {
        List<TreeNode> nodes = testNodes(10);
        TreeNode root = nodes.get(5);
        root.left = nodes.get(3);
        root.right = nodes.get(6);
        nodes.get(3).left = nodes.get(2);
        nodes.get(3).right = nodes.get(4);
        nodes.get(2).left = nodes.get(1);
        nodes.get(6).right = nodes.get(8);
        nodes.get(8).left = nodes.get(7);
        nodes.get(8).right = nodes.get(9);
        return root;
    }

    private static List<TreeNode> testNodes(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            nodes.add(new TreeNode(i));
        return nodes;
    }
}
