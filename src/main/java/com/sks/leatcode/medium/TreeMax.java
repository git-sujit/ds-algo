package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

/**
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 */
public class TreeMax {
    /**
     * Time complexity : O(n^2). The function construct is called nn times. At each level of the recursive tree,
     * we traverse over all the nn elements to find the maximum element. In the average case, there will be a O(nlogn) levels leading to a complexity of
     * O(nlogn). In the worst case, the depth of the recursive tree can grow upto nn, which happens in the case of a sorted nums array,
     * giving a complexity of O(n^2)
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if (s == e) return null;
        int pos = s;
        for (int i = s; i < e; i++) {
            if (nums[i] > nums[pos]) pos = i;
        }
        TreeNode node = new TreeNode(nums[pos]);
        node.left = constructMaximumBinaryTree(nums, s, pos);
        node.right = constructMaximumBinaryTree(nums, pos + 1, e);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        TreePrinter.printNode(root);
    }
}
