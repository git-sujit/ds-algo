package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.HashMap;
import java.util.Map;

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree
 */
public class TreeSerDeser {
    private static final String NODE_DELIMITER = ",";
    private static final String NODE_CHILD_DELIMITER = "->";
    private static final String LEFT_RIGHT_DELIMITER = "_";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val + NODE_CHILD_DELIMITER);
        if (root.left == null) sb.append("null" + LEFT_RIGHT_DELIMITER);
        else sb.append(root.left.val + LEFT_RIGHT_DELIMITER);
        if (root.right == null) sb.append("null" + NODE_DELIMITER);
        else sb.append(root.right.val + NODE_DELIMITER);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        String[] nodeArr = data.split(NODE_DELIMITER);
        for (String nodeStr : nodeArr) {
            String[] nc = nodeStr.split(NODE_CHILD_DELIMITER);
            int nVal = Integer.valueOf(nc[0]);
            TreeNode node = map.computeIfAbsent(nVal, e -> new TreeNode(nVal));
            if (root == null) root = node;
            //Left Child
            String[] lr = nc[1].split(LEFT_RIGHT_DELIMITER);
            if (lr[0].equals("null")) node.left = null;
            else {
                int lVal = Integer.valueOf(lr[0]);
                TreeNode left = map.computeIfAbsent(lVal, e -> new TreeNode(lVal));
                node.left = left;
            }
            //Right Child
            if (lr[1].equals("null")) node.right = null;
            else {
                int rVal = Integer.valueOf(lr[1]);
                TreeNode right = map.computeIfAbsent(rVal, e -> new TreeNode(rVal));
                node.right = right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData2();
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
