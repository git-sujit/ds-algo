package com.sks.averma.dp.tree;

import com.sks.leatcode.common.TreeNode;

/**
 * Diameter: Longest path between two leaves not necessarily passing through root
 */
public class TreeDiameter {
    public static int diameter(TreeNode root) {
        int[] res = new int[1];
        diameter(root, res);
        return res[0];
    }

    private static int diameter(TreeNode root, int[] res) {
        if (root == null) return 0;
        int leftD = diameter(root.left, res);
        int rightD = diameter(root.right, res);
        int temp = 1 + Math.max(leftD, rightD);
        int hl = height(root.left);
        int hr = height(root.right);
        res[0] = Math.max(temp, 1 + hl + hr);
        System.out.println("Result = " + res[0]);
        return temp;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = prepareTree();
        System.out.println("Diameter = " + diameter(root));
    }

    private static TreeNode prepareTree() {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        five.left = six;
        three.right = seven;
        seven.right = eight;
        eight.left = nine;
        eight.right = ten;
        return root;
    }
}
