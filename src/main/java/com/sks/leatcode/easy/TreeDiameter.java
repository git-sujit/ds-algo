package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.HashMap;
import java.util.Map;

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
public class TreeDiameter {
    public static int diameterOfBinaryTree_sujit(TreeNode root, Map<TreeNode, Integer> nodePathMap) {
        if (root == null) return 0;
        int d1 = longestPath_sujit(root.left, nodePathMap) + longestPath_sujit(root.right, nodePathMap);
        int d2 = Math.max(diameterOfBinaryTree_sujit(root.left, nodePathMap), diameterOfBinaryTree_sujit(root.right, nodePathMap));
        return Math.max(d1, d2);
    }

    private static int longestPath_sujit(TreeNode node, Map<TreeNode, Integer> nodePathMap) {
        if (node == null) return 0;
        if (nodePathMap.containsKey(node)) return nodePathMap.get(node);
        int path = 1 + Math.max(longestPath_sujit(node.left, nodePathMap), longestPath_sujit(node.right, nodePathMap));
        nodePathMap.put(node, path);
        return path;
    }

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
        System.out.println("Diameter = " + diameterOfBinaryTree_sujit(root, new HashMap<>()));
        System.out.println("Diameter = " + diameterOfBinaryTree(root));
    }

}
