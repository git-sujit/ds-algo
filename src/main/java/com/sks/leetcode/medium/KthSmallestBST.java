package com.sks.leetcode.medium;

import com.sks.leetcode.common.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestBST {

    /**
     * Time Complexity : O(n), we are inorder_traversing all nodes to sort
     * Space Complexity: O(n), for sorted List + method stack
     */
    public static int kthSmallest_recursive(BST root, int k) {
        if (root == null || k <= 0)
            return -1;
        List<Integer> sortedList = new ArrayList<>();
        inOrder_sort(root, sortedList);

        return sortedList.get(k - 1);
    }

    /**
     * Time Complexity : O(n), Traversing all nodes in BST
     * Space Complexity: O(n), for Stack
     */
    public static int kthSmallest_iterative(BST root, int k) {
        if (root == null || k <= 0)
            return -1;
        List<Integer> sortedList = new ArrayList<>();
        Stack<BST> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    break;
                root = stack.pop();
                sortedList.add(root.value);
                root = root.right;
            }
        }
        return sortedList.get(k - 1);
    }

    public static int kthLargest_recursive(BST root, int k) {
        if (root == null || k <= 0)
            return -1;
        List<Integer> sortedList = new ArrayList<>();
        inOrder_sort(root, sortedList);

        return sortedList.get(sortedList.size() - k);
    }

    private static void inOrder_sort(BST root, List<Integer> sortedList) {
        if (root == null)
            return;
        if (root.left != null)
            inOrder_sort(root.left, sortedList);
        sortedList.add(root.value);
        if (root.right != null)
            inOrder_sort(root.right, sortedList);
    }
}
