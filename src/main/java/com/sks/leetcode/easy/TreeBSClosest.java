package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 */
public class TreeBSClosest {
    /**
     * Binary Search
     * Time complexity : O(H)/O(logN) since here one goes from root down to a leaf.
     * Space complexity : O(1)
     */
    public static int closestValue_better(TreeNode root, double target) {
        int val;
        int closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

    public static int closestValue(TreeNode root, double target) {
        return closestValue_inOrderSort(root, target);
    }

    /**
     * Inorder + Binary Search
     * Time Complexity: O(N) = O(N) for inorder traversal + O(logN) for binary search
     * Space Complexity: O(N) / O(logN) depending on balanced/unbalanced tree
     */
    private static int closestValue_inOrderSort(TreeNode root, double target) {
        List<Integer> sortedNode = new ArrayList<>();
        inOrderSort(root, sortedNode);
        int s = 0;
        int e = sortedNode.size() - 1;
        while (s <= e) {
            int m = (e - s) / 2 + s;
            int v = sortedNode.get(m);
            if (target < v) e = m - 1;
            else if (target > v) s = m + 1;
            else return v;
            // If s crosses e means not found but exists in-between
            if (s > e) {
                if (s > sortedNode.size() - 1) return sortedNode.get(sortedNode.size() - 1);
                else if (e < 0) return sortedNode.get(0);
                else {
                    int v1 = sortedNode.get(s);
                    int v2 = sortedNode.get(e);
                    return Math.abs(v1 - target) < Math.abs(v2 - target) ? v1 : v2;
                }
            }
        }
        return -1;
    }

    private static void inOrderSort(TreeNode node, List<Integer> sortedNode) {
        if (node == null) return;
        inOrderSort(node.left, sortedNode);
        sortedNode.add(node.val);
        inOrderSort(node.right, sortedNode);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.binarySearchTreeData1();
        TreePrinter.printNode(root);

        demo(root, 3.1417);
        demo(root, 2.501);
        demo(root, 0.1987);
        demo(root, 10.546);

        root = new TreeNode(4);
        demo(root, 2.456);
        demo(root, 5.894);
    }

    private static void demo(TreeNode root, double target) {
        System.out.println("\nClosest node to " + target + " = " + closestValue(root, target));
        System.out.println("[Better] Closest node to " + target + " = " + closestValue_better(root, target));
    }
}
