package com.sks.interview_2026;

import com.sks.interview_2026.data_structures.BinaryTreeNode;
import com.sks.leetcode.common.TreePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class I_TreeConceptsPractice {
    public static void main(String[] args) {
        System.out.println("----- PRINT BINARY TREE -----");
        test_printBinaryTree();

        System.out.println("----- BINARY TREE TRAVERSAL -----");
        test_binaryTreeTraversal();

        System.out.println("----- BINARY SEARCH TREE -----");
        test_binarySearchTree();
    }

    /**
     * BINARY TREE PRINTING
     * Time Complexity: O(n), traversing each node exactly once
     * Space Complexity: O(n), Max size of Method-stack=No. of nodes in tree
     */
    private static String printBinaryTree(BinaryTreeNode node) {
        return node.data + "=>("
                + (node.left == null ? "-" : "L:" + printBinaryTree(node.left)) + ","
                + (node.right == null ? "-" : "R:" + printBinaryTree(node.right)) + ")";
    }

    private static void printBinaryTree_byLevel(BinaryTreeNode root, int level) {
        if (root == null)
            return;
        printBinaryTree_byLevel(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.data);
        } else
            System.out.println(root.data);
        printBinaryTree_byLevel(root.left, level + 1);
    }

    /**
     * BINARY TREE TRAVERSAL
     */
    // PRE-ORDER
    private static List<Integer> preOrderTraversal(BinaryTreeNode node) {
        List<Integer> preOrderList = new ArrayList<>();
        preOrderTraversal(node, preOrderList);
        return preOrderList;
    }

    private static void preOrderTraversal(BinaryTreeNode node, List<Integer> preOrderList) {
        if (node == null) return;
        preOrderList.add(node.data);
        preOrderTraversal(node.left, preOrderList);
        preOrderTraversal(node.right, preOrderList);
    }

    // IN-ORDER
    private static List<Integer> inOrderTraversal(BinaryTreeNode node) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(node, inOrderList);
        return inOrderList;
    }

    private static void inOrderTraversal(BinaryTreeNode node, List<Integer> inOrderList) {
        if (node == null) return;
        inOrderTraversal(node.left, inOrderList);
        inOrderList.add(node.data);
        inOrderTraversal(node.right, inOrderList);
    }

    // POST-ORDER
    private static List<Integer> postOrderTraversal(BinaryTreeNode node) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderTraversal(node, postOrderList);
        return postOrderList;
    }

    private static void postOrderTraversal(BinaryTreeNode node, List<Integer> postOrderList) {
        if (node == null) return;
        postOrderTraversal(node.left, postOrderList);
        postOrderTraversal(node.right, postOrderList);
        postOrderList.add(node.data);
    }

    /**
     * SEARCH IN BINARY SEARCH TREE
     */
    // Time Complexity  : O(height=logn)
    // Space Complexity : O(logn) for method stack
    private static BinaryTreeNode searchBST_recursive(BinaryTreeNode node, int data) {
        if (node == null) return null;
        if (data == node.data) return node;
        else if (data < node.data) return searchBST_recursive(node.left, data);
        else return searchBST_recursive(node.right, data);
    }

    private static BinaryTreeNode searchBST_iterative_BETTER(BinaryTreeNode node, int data) {
        if (node == null) return null;
        while(node != null){
            if(node.data == data) return node;
            else if(data < node.data) node = node.left;
            else node = node.right;
        }
        return null;
    }
    // Time Complexity  : O(height=logn)
    // Space Complexity : O(logn) for stack
    private static BinaryTreeNode searchBST_iterative(BinaryTreeNode node, int data) {
        if (node == null) return null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode stackNode = stack.pop();
            if (data == stackNode.data) return stackNode;
            else if (data < stackNode.data && stackNode.left != null) stack.push(stackNode.left);
            else if (stackNode.right != null) stack.push(stackNode.right);
        }
        return null;
    }

    // Minimum in BST
    // Time Complexity  : O(height=logn), Space Complexity : O(1)
    private static BinaryTreeNode minInBST(BinaryTreeNode node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node;
    }

    // Maximum in BST
    // Time Complexity  : O(height=logn), Space Complexity : O(1)
    private static BinaryTreeNode maxInBST(BinaryTreeNode node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node;
    }

    // Parent in BST
    // Time Complexity  : O(height=logn), Space Complexity : O(1)
    private static BinaryTreeNode parentInBST(BinaryTreeNode node, int data) {
        if (node == null) return null;
        BinaryTreeNode parent = null;
        while (node != null) {
            if (data == node.data) return parent;
            parent = node;
            if (data < node.data) node = node.left;
            else node = node.right;
        }
        return null;
    }

    // Time Complexity  : O(height=logn), Space Complexity : O(logn)
    private static BinaryTreeNode parentInBST_stack(BinaryTreeNode node, int data) {
        if (node == null) return null;
        BinaryTreeNode parent = null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode sNode = stack.pop();
            if (data == sNode.data) return parent;
            else if (data < sNode.data && sNode.left != null) {
                parent = sNode;
                stack.push(sNode.left);
            } else if (sNode.right != null) {
                parent = sNode;
                stack.push(sNode.right);
            }
        }
        return null;
    }

    /**
     * TEST
     */
    private static void test_printBinaryTree() {
        BinaryTreeNode root = BinaryTreeNode.getBinaryTreeData1();
        System.out.println("Using Binary Tree Printer");
        BinaryTreePrinter.printNode(root);
        System.out.println(printBinaryTree(root));
        printBinaryTree_byLevel(root, 0);
    }

    private static void test_binaryTreeTraversal() {
        BinaryTreeNode root = BinaryTreeNode.getBinaryTreeData1();
        List<Integer> out = preOrderTraversal(root);
        System.out.println("Pre-Order Traversal = " + out);

        out = inOrderTraversal(root);
        System.out.println("In-Order Traversal = " + out);

        out = postOrderTraversal(root);
        System.out.println("Post-Order Traversal = " + out);
    }

    private static void test_binarySearchTree() {
        BinaryTreeNode bstRoot = BinaryTreeNode.getBinarySearchTreeData1();
        List<Integer> out = inOrderTraversal(bstRoot);
        System.out.println("SORTING: In-Order Traversal of BST = " + out);

        int data = 8;
        System.out.println("SEARCH in BST - Recursive, data=" + data + ": " + searchBST_recursive(bstRoot, data));

        System.out.println("SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative(bstRoot, data));
        System.out.println("[BETTER]SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative_BETTER(bstRoot, data));
        data = 10;
        System.out.println("SEARCH in BST - Recursive, data=" + data + ": " + searchBST_recursive(bstRoot, data));
        System.out.println("SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative(bstRoot, data));
        System.out.println("[BETTER]SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative_BETTER(bstRoot, data));
        data = 4;
        System.out.println("SEARCH in BST - Recursive, data=" + data + ": " + searchBST_recursive(bstRoot, data));
        System.out.println("SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative(bstRoot, data));
        System.out.println("[BETTER]SEARCH in BST - Iterative, data=" + data + ": " + searchBST_iterative_BETTER(bstRoot, data));

        System.out.println("Min/Max in BST: " + minInBST(bstRoot) + "/" + maxInBST(bstRoot));
        System.out.println("Does min/max changes the root-node? NO - " + bstRoot);

        data = 3;
        System.out.println("Parent in BST - Simple, data=" + data + ": " + parentInBST(bstRoot, data));
        System.out.println("Parent in BST - Stack,  data=" + data + ": " + parentInBST_stack(bstRoot, data));
        data = 11;
        System.out.println("Parent in BST - Simple, data=" + data + ": " + parentInBST(bstRoot, data));
        System.out.println("Parent in BST - Stack,  data=" + data + ": " + parentInBST_stack(bstRoot, data));
    }

}
