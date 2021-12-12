package com.sks.leatcode.medium;

import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

    /**
     * Time Complexity : O(n), we are traversing all nodes in worst case
     * Space Complexity: O(n), Recursion stack if BST becomes linear
     */
    public static boolean isValidBST_recursive(BST root) {
        return isValidBST_recursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST_recursive(BST root, Integer min, Integer max) {
        if (root.value < min || root.value >= max)
            return false;
        if (root.left != null && !isValidBST_recursive(root.left, min, root.value))
            return false;
        if (root.right != null && !isValidBST_recursive(root.right, root.value, max))
            return false;
        return true;
    }

    public static boolean isValidBST_iterative(BST root) {
        if (root == null)
            return true;
        Stack<BST> s = new Stack<>();
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        s.push(root);
        while (!s.isEmpty()) {
            BST node = s.pop();
            if (node.left != null) {
                max = node.value;
                if (node.left.value > max) {
                    return false;
                } else {
                    s.push(node.left);
                }
            }
            if (node.right != null) {
                min = node.value;
                if (node.right.value < min) {
                    return false;
                } else {
                    s.push(node.right);
                }
            }
        }
        return true;
    }

    static Integer prev = Integer.MIN_VALUE;

    public static boolean isValidBST_inorderTraversal(BST root) {
        if (root == null)
            return true;
        if (prev > root.value)
            return false;
        if (root.left != null) {
            prev = root.left.value;
            return isValidBST_inorderTraversal(root.left);
        }
        if (root.right != null) {
            prev = root.value;
            return isValidBST_inorderTraversal(root.left);
        }
        return false;
    }

    class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }
    }
}
