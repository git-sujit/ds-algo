package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.*;

public class TreeDirectionBwNodes {
    static TreeNode startNode;
    static TreeNode destNode;
    static TreeNode lowestCommonAncestor;
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";
        findNodes(root, startValue, destValue);
        Queue<TreeNode> startQ = new LinkedList<>();
        Stack<TreeNode> startStack = new Stack<>();
        TreeNode sNode = startNode;
        while (sNode != null) {
            startQ.add(sNode);
            startStack.add(sNode);
            sNode = parentMap.get(sNode);
        }
        //System.out.println("startQ : " + startQ);
        Stack<TreeNode> destStack = new Stack<>();
        TreeNode dNode = destNode;
        while (dNode != null) {
            destStack.add(dNode);
            dNode = parentMap.get(dNode);
        }
        //System.out.println("destStack : " + destStack);
        while (startStack.peek() == destStack.peek()) {
            lowestCommonAncestor = startStack.peek();
            startStack.pop();
            destStack.pop();
        }
        System.out.println("lowestCommonAncestor : " + lowestCommonAncestor);
        return getDirection(startQ, destStack);
    }

    private static String getDirection(Queue<TreeNode> startQ, Stack<TreeNode> destStack) {
        String direction = "";
        while (!startQ.isEmpty()) {
            TreeNode qNode = startQ.remove();
            if (qNode == lowestCommonAncestor) break;
            direction += "u";
        }
        TreeNode parent = lowestCommonAncestor;
        while (!destStack.isEmpty()) {
            TreeNode destNode = destStack.pop();
            if (parent.left == destNode) direction += "L";
            else if (parent.right == destNode) direction += "R";
            parent = destNode;
        }
        return direction;
    }


    private static void findNodes(TreeNode node, int startValue, int destValue) {
        if (node == null) return;
        if (node.val == startValue) startNode = node;
        if (node.val == destValue) destNode = node;
        if (startNode != null && destNode != null) return;
        if (node.left != null) parentMap.put(node.left, node);
        if (node.right != null) parentMap.put(node.right, node);
        findNodes(node.left, startValue, destValue);
        findNodes(node.right, startValue, destValue);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        int src = 6;
        int dest = 7;
        demo(root, src, dest);

        src = 4;
        dest = 6;
        demo(root, src, dest);
    }

    private static void demo(TreeNode root, int src, int dest) {
        TreePrinter.printNode(root);
        System.out.println("Step-by-step direction between " + src + " and " + dest + " : " + getDirections(root, src, dest));
    }
}
