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

    /**
     * PreOrder traversal
     */
    public static int[] preOrder(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        return pre.stream().mapToInt(i -> i).toArray();
    }

    private static void preOrder(TreeNode node, List<Integer> pre) {
        if (node == null) return;
        pre.add(node.val);
        preOrder(node.left, pre);
        preOrder(node.right, pre);
    }

    /**
     * InOrder traversal
     */
    public static int[] inOrder(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);
        return in.stream().mapToInt(i -> i).toArray();
    }

    private static void inOrder(TreeNode node, List<Integer> in) {
        if (node == null) return;
        inOrder(node.left, in);
        in.add(node.val);
        inOrder(node.right, in);
    }

    /**
     * PostOrder traversal
     */
    public static int[] postOrder(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        postOrder(root, post);
        return post.stream().mapToInt(i -> i).toArray();
    }

    private static void postOrder(TreeNode node, List<Integer> post) {
        if (node == null) return;
        postOrder(node.left, post);
        postOrder(node.right, post);
        post.add(node.val);
    }

    public static List<TreeNode> nodes;

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

    public String printTree() {
        return val + "=>(L: "
                + (left == null ? left : left.printTree()) + ", R: "
                + (right == null ? right : right.printTree()) + ")";
    }

    public static void printBinaryTree(TreeNode root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.val);
        } else
            System.out.println(root.val);
        printBinaryTree(root.left, level + 1);
    }

    public static TreeNode treeData1() {
        nodes = testNodes(10);
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
        nodes = testNodes(10);
        TreeNode root = nodes.get(4);
        root.left = nodes.get(2);
        root.right = nodes.get(9);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(5);
        nodes.get(9).right = nodes.get(7);
        return root;
    }

    public static TreeNode binarySearchTreeData1() {
        nodes = testNodes(10);
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

    public static TreeNode treeData_leftLinear() {
        nodes = testNodes(10);
        TreeNode root = nodes.get(1);
        root.left = nodes.get(2);
        nodes.get(2).left = nodes.get(3);
        nodes.get(3).left = nodes.get(4);
        nodes.get(4).left = nodes.get(5);
        nodes.get(5).left = nodes.get(6);
        nodes.get(6).left = nodes.get(7);
        return root;
    }

    public static TreeNode treeData_symmetric() {
        List<TreeNode> pool1 = testNodes(10);
        List<TreeNode> pool2 = testNodes(10);
        TreeNode root = new TreeNode(1);
        root.left = pool1.get(2);
        root.right = pool2.get(2);
        pool1.get(2).left = pool1.get(3);
        pool1.get(2).right = pool1.get(4);
        pool2.get(2).left = pool2.get(4);
        pool2.get(2).right = pool2.get(3);
        return root;
    }

    public static TreeNode treeData_unival() {
        nodes = testNodes_unival(10);
        TreeNode root = nodes.get(4);
        root.left = nodes.get(2);
        root.right = nodes.get(9);
        nodes.get(2).left = nodes.get(3);
        nodes.get(2).right = nodes.get(5);
        nodes.get(9).right = nodes.get(7);
        return root;
    }

    public static TreeNode treeData_rightLinear() {
        nodes = testNodes(10);
        TreeNode root = nodes.get(1);
        root.right = nodes.get(2);
        nodes.get(2).right = nodes.get(3);
        nodes.get(3).right = nodes.get(4);
        nodes.get(4).right = nodes.get(5);
        nodes.get(5).right = nodes.get(6);
        nodes.get(6).right = nodes.get(7);
        return root;
    }

    private static List<TreeNode> testNodes(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            nodes.add(new TreeNode(i));
        return nodes;
    }

    private static List<TreeNode> testNodes_unival(int n) {
        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            nodes.add(new TreeNode(5));
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = treeData_leftLinear();
        TreePrinter.printNode(root);
    }
}
