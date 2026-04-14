package com.sks.leetcode.easy;

import com.sks.interview_2026.BinaryTreePrinter;
import com.sks.interview_2026.data_structures.BinaryTreeNode;

/** LeetCode-1022
 * You are given the root of a binary tree where each node has a value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 */
public class BinaryTreeLeafSum {
    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeNode.getBinaryTreeData_binary();
        BinaryTreePrinter.printNode(root);
        System.out.println("sumRootToLeaf = "+sumRootToLeaf(root));
    }
    public static int sumRootToLeaf(BinaryTreeNode root) {
        if(root == null) return 0;
        return sumRootToLeaf(root, 0);
    }

    private static int sumRootToLeaf(BinaryTreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum * 2 + node.data;
        if (node.left == null && node.right == null) return sum;
        return sumRootToLeaf(node.left, sum) + sumRootToLeaf(node.right, sum);
    }
}
