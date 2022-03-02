package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree
 */

/**
 * Idea: BST could be constructed from preorder or postorder traversal only.
 * Time / Space: O(n)
 */
public class TreeBSTSerDeserBetter {
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private static void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val).append(DELIMITER);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] postOrder = data.split(DELIMITER);
        return bstFromPostOrder(postOrder, 0, postOrder.length - 1);
    }

    private static TreeNode bstFromPostOrder(String[] postOrder, int start, int end) {
        if (start > end) return null;
        int val = Integer.valueOf(postOrder[end]);
        TreeNode node = new TreeNode(val);
        int i = end;
        while (i >= start) {
            if (Integer.valueOf(postOrder[i]) < val) break;
            i--;
        }
        TreeNode left = bstFromPostOrder(postOrder, start, i);
        TreeNode right = bstFromPostOrder(postOrder, i + 1, end - 1);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.binarySearchTreeData1();
        demo(root);
        //demo(null);
    }

    private static void demo(TreeNode root) {
        TreePrinter.printNode(root);
        String ser = serialize(root);
        System.out.println("Serialized Tree : " + ser);
        System.out.println("\nAfter Deserialization:");
        TreeNode deserNode = deserialize(ser);
        TreePrinter.printNode(deserNode);
    }
}
