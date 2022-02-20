package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.*;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 */
public class TreePaths {
    /**
     * Time Complexity: O(n), we visit each node exactly once
     * Space Complexity: O(logN), recursion stack stores at max the height of binary tree
     * O(n) for unbalanced binary tree
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) binaryTreePaths(root, "", paths);
        return paths;
    }

    private static void binaryTreePaths(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) paths.add(path + node.val);
        if (node.left != null) binaryTreePaths(node.left, path + node.val + "->", paths);
        if (node.right != null) binaryTreePaths(node.right, path + node.val + "->", paths);
    }

    /**
     * Time Complexity: O(n), we visit each node exactly once
     * Space Complexity: O(logN) / O(n), For balanced vs Skew tree
     */
    public static List<String> binaryTreePaths_iterative_better(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.add(root);
        pathStack.push(String.valueOf(root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if (node.left == null && node.right == null)
                paths.add(path);
            if (node.right != null) {
                nodeStack.push(node.right);
                pathStack.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                pathStack.push(path + "->" + node.left.val);
            }
        }
        return paths;
    }


    public static List<String> binaryTreePaths_iterative(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            Map<TreeNode, String> pathMap = new HashMap<>();
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            String path = "";
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left == null && node.right == null) {
                    path += node.val;
                    paths.add(path);
                    if (!stack.isEmpty()) path = pathMap.get(parentMap.get(stack.peek()));
                } else if (node.left != null || node.right != null) {
                    path += (node.val + "->");
                    pathMap.put(node, path);
                }
                TreeNode right = node.right;
                if (right != null) {
                    parentMap.put(right, node);
                    stack.push(right);
                }
                TreeNode left = node.left;
                if (left != null) {
                    parentMap.put(left, node);
                    stack.push(left);
                }
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        demo(root);
        root = TreeNode.treeData2();
        demo(root);
    }

    private static void demo(TreeNode root) {
        TreePrinter.printNode(root);
        System.out.println("[Recursion] Paths = " + binaryTreePaths(root));
        System.out.println("[Iterative-Better] Paths = " + binaryTreePaths_iterative_better(root));
        System.out.println("[Iterative] Paths = " + binaryTreePaths_iterative(root));
    }
}
