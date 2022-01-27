package com.sks.leatcode.common;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Binary Tree Node
 */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        /*- return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
         */
        return val + "=>(" + (left == null ? left : left.val) +
                ", " + (right == null ? right : right.val) + ")";
    }

    public static TreeNode prepareTestData() {
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

    public static TreeNode prepareTestData_1() {
        List<TreeNode> nodes = testNodes(10);
        TreeNode root = nodes.get(4);
        root.left = nodes.get(2);
        root.right = nodes.get(9);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(5);
        nodes.get(9).right = nodes.get(7);
        return root;
    }

    private static List<TreeNode> testNodes(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            nodes.add(new TreeNode(i));
        return nodes;
    }
}
