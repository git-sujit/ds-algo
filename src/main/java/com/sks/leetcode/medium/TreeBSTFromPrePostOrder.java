package com.sks.leetcode.medium;

import com.sks.leetcode.common.TreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.Arrays;

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST,
 * construct the tree and return its root.
 */
public class TreeBSTFromPrePostOrder {
    /**
     * BST from preOrder
     */
    public static TreeNode bstFromPreOrder(int[] preOrder) {
        return bstFromPreOrder(preOrder, 0, preOrder.length - 1);
    }

    private static TreeNode bstFromPreOrder(int[] preOrder, int start, int end) {
        if (start > end)
            return null;
        int val = preOrder[start];
        TreeNode node = new TreeNode(val);
        int i = start + 1;
        while (i <= end) {
            if (preOrder[i] > preOrder[start]) break;
            i++;
        }
        TreeNode left = bstFromPreOrder(preOrder, start + 1, i - 1);
        TreeNode right = bstFromPreOrder(preOrder, i, end);
        node.left = left;
        node.right = right;
        return node;
    }

    /**
     * BST from preOrder
     */
    public static TreeNode bstFromPostOrder(int[] postOrder) {
        return bstFromPostOrder(postOrder, 0, postOrder.length - 1);
    }

    private static TreeNode bstFromPostOrder(int[] postOrder, int start, int end) {
        if (start > end) return null;
        int val = postOrder[end];
        TreeNode node = new TreeNode(val);
        int i = end;
        while (i >= start) {
            if (postOrder[i] < val) break;
            i--;
        }
        TreeNode left = bstFromPostOrder(postOrder, start, i);
        TreeNode right = bstFromPostOrder(postOrder, i + 1, end - 1);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Original Tree:");
        TreeNode root = TreeNode.binarySearchTreeData1();
        TreePrinter.printNode(root);
        //demoPreOrder(root);
        /*-
        int[] in = TreeNode.inOrder(root);
        System.out.println("InOrder  = " + Arrays.toString(in));
        */
        demoInOrder(root);
        //demoPostOrder(root);
    }

    private static void demoInOrder(TreeNode root) {
        int[] in = TreeNode.inOrder(root);
        System.out.println("InOrder = " + Arrays.toString(in));
        System.out.println("Tree From InOrder:");
    }

    private static void demoPreOrder(TreeNode root) {
        int[] pre = TreeNode.preOrder(root);
        System.out.println("PreOrder = " + Arrays.toString(pre));
        System.out.println("Tree From PreOrder:");
        TreeNode root1 = bstFromPreOrder(pre);
        TreePrinter.printNode(root1);
    }

    private static void demoPostOrder(TreeNode root) {
        int[] post = TreeNode.postOrder(root);
        System.out.println("PostOrder= " + Arrays.toString(post));
        System.out.println("Tree From PostOrder:");
        TreeNode root1 = bstFromPostOrder(post);
        TreePrinter.printNode(root1);
    }
}
