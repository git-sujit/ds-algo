package com.sks.interview_2026.data_structures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.data = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return data + "=>(" + (left == null ? "-" : left.data) +
                ", " + (right == null ? "-" : right.data) + ")";
    }

    public static BinaryTreeNode getBinaryTreeData1() {
        List<BinaryTreeNode> nodes = testNodes(10);
        BinaryTreeNode root = nodes.get(1);
        root.left = nodes.get(2);
        root.right = nodes.get(3);
        nodes.get(2).left = nodes.get(4);
        nodes.get(2).right = nodes.get(5);
        nodes.get(5).left = nodes.get(6);
        nodes.get(3).right = nodes.get(7);
        return root;
    }

    public static BinaryTreeNode getBinaryTreeData2() {
        List<BinaryTreeNode> nodes = testNodes(10);
        BinaryTreeNode root = nodes.get(4);
        root.left = nodes.get(2);
        root.right = nodes.get(9);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(5);
        nodes.get(9).right = nodes.get(7);
        return root;
    }

    public static BinaryTreeNode getBinarySearchTreeData1() {
        List<BinaryTreeNode> nodes = testNodes(10);
        BinaryTreeNode root = nodes.get(5);
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

    private static List<BinaryTreeNode> testNodes(int n) {
        List<BinaryTreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            nodes.add(new BinaryTreeNode(i));
        return nodes;
    }
}
