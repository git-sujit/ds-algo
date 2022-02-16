package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

public class TreeBSSearch {
    /**
     * Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, and O(N) in the worst case.
     * Space complexity : O(H) to keep the recursion stack, i.e. O(logN) in the average case, and O(N) in the worst case.
     */
    public static TreeNode searchBST_recursion(TreeNode root, int val) {
        if (root == null || val == root.val) return root;
        return val < root.val ? searchBST_recursion(root.left, val) : searchBST_recursion(root.right, val);
    }

    /**
     * Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, and O(N) in the worst case.
     * Space complexity : O(1) since it's a constant space solution.
     */
    public static TreeNode searchBST_iteration(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.binarySearchTreeData1();
        TreePrinter.printNode(root);
        demo(root, 2);
        demo(root, 9);
    }

    private static void demo(TreeNode root, int val) {
        System.out.println("\n[Recursion] Found" + val + " at : " + searchBST_recursion(root, val));
        System.out.println("[Iteration] Found" + val + " at : " + searchBST_iteration(root, val));
    }

}
