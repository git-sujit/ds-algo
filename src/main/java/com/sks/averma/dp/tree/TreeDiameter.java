package com.sks.averma.dp.tree;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

/**
 * Diameter: Longest path between two leaves not necessarily passing through root
 */
public class TreeDiameter {
    /**
     * Time Complexity : O(n), we are exploring all nodes
     * Space Complexity: O(n), for worst case linear-tree
     */
    public static int diameterOfBinaryTree_BETTER(TreeNode root, int[] res) {
        /** Base Condition **/
        if (root == null) return 0;
        /** Hypothesis **/
        int ld = diameterOfBinaryTree_BETTER(root.left, res);
        int rd = diameterOfBinaryTree_BETTER(root.right, res);
        /** Induction **/
        // What could be passed to parent i.e return statement
        int temp = 1 + Math.max(ld, rd);
        // Potential diameter
        int pd = 1 + ld + rd;
        // Potential answer
        int ans = Math.max(temp, pd);
        // Store the max diameter till this point
        res[0] = Math.max(res[0], ans);
        return temp;
    }

    /**
     * Time Complexity :
     * Space Complexity:
     */
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
        //System.out.println("Result = " + res[0]);
        return temp;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = prepareTree();
        TreePrinter.printNode(root);
        System.out.println("Diameter = " + diameter(root));
        int[] res = new int[]{Integer.MIN_VALUE};
        diameterOfBinaryTree_BETTER(root, res);
        System.out.println("[Better] Diameter = " + res[0]);
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
