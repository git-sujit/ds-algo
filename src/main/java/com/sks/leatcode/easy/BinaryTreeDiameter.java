package com.sks.leatcode.easy;

import apple.laf.JRSUIUtils;
import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */

/**
 * Intuition:
 * - Longest path(Diameter) will be between two leaf nodes
 * - Tree traversal mechanism: DFS (Preorder, Inorder, Postorder)
 */
public class BinaryTreeDiameter {
    private static int diameter = 0;

    /**
     * Time Complexity: O(n), n-number of nodes in binary tree
     * Space Complexity: O(n), O(logn) if tree is balanced
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private static int longestPath(TreeNode node) {
        if (node == null) return 0;
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return 1 + Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        demo(TreeNode.treeData1());
        demo(TreeNode.treeData2());
        demo(TreeNode.binarySearchTreeData1());
    }

    private static void demo(TreeNode root) {
        System.out.println("------------------ TREE ------------------");
        TreePrinter.printNode(root);
        System.out.println("Diameter = " + diameterOfBinaryTree(root));
    }

}
