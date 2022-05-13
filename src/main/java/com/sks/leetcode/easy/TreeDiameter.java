package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
     * [Memoizaion] Calculate height of each node & store in Map
     * [Iterative DFS-Stack] Traverse each node and calculate daimeter
     * Time Complexity : O(n), we are exploring all nodes
     * Space Complexity: O(n), for Map & Stack
     */
    public int diameter_by_height(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> nhMap = new HashMap<>();
        calculateHeight(root, nhMap);
        int diameter = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode sn = stack.pop();
            TreeNode left = sn.left;
            TreeNode right = sn.right;
            if (left == null && right == null) diameter = Math.max(diameter, 1);
            else if (left == null) {
                diameter = Math.max(diameter, 1 + nhMap.get(right));
                stack.push(right);
            } else if (right == null) {
                diameter = Math.max(diameter, 1 + nhMap.get(left));
                stack.push(left);
            } else {
                diameter = Math.max(diameter, 1 + nhMap.get(left) + nhMap.get(right));
                stack.push(left);
                stack.push(right);
            }
        }
        return diameter - 1; // Because no. of edges=no. of nodes - 1
    }

    private int calculateHeight(TreeNode node, Map<TreeNode, Integer> nhMap) {
        if (node == null) return 0;
        if (nhMap.containsKey(node)) return nhMap.get(node);
        int lh = calculateHeight(node.left, nhMap);
        int rh = calculateHeight(node.right, nhMap);
        int height = 1 + Math.max(lh, rh);
        nhMap.put(node, height);
        return height;
    }

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
        int[] res = new int[]{Integer.MIN_VALUE};
        diameterOfBinaryTree_BETTER(root, res);
        System.out.println("[Better] Diameter = " + (res[0] - 1));
        System.out.println("[By Height] Diameter = " + new TreeDiameter().diameter_by_height(root));
    }

}
