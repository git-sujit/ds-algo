package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.*;

/**
 * There are two general strategies to traverse a tree:
 * 1. Breadth First Search (BFS):
 * We scan through the tree level by level, following the order of height, from top to bottom.
 * The nodes on higher level would be visited before the ones with lower levels.
 * E.g: Level Order Traversal
 * 2. Depth First Search (DFS):
 * In this strategy, we adopt the depth as the priority, so that one would start from a root
 * and reach all the way down to certain leaf, and then back to root to reach another branch.
 * Eg: preorder, inorder, and postorder depending on the relative order among the root node, left node and right node.
 */
public class TreeTraversal {
    /**
     * Time Complexity:  O(N), where N is the number of nodes, i.e. the size of tree.
     * Space Complexity:  O(N), for recursion stack, Balanced tree O(NlogN)
     */
    public static List<Integer> preorderTraversal_recursion(TreeNode root) {
        System.out.println("[Recursion] Pre-Order Traversal");
        return preorderTraversal_recursion(root, new ArrayList<Integer>());
    }

    private static List<Integer> preorderTraversal_recursion(TreeNode root, List<Integer> traverseList) {
        if (root == null) return traverseList;
        traverseList.add(root.val);
        preorderTraversal_recursion(root.left, traverseList);
        preorderTraversal_recursion(root.right, traverseList);
        return traverseList;
    }

    public static List<Integer> preorderTraversal_iteration(TreeNode root) {
        System.out.println("[Iteration] Pre-Order Traversal");
        List<Integer> traverseList = new ArrayList<>();
        if (root == null) return traverseList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traverseList.add(node.val);
            /**
             * CHECK THE ORDER OF PUSH IN THE STACK
             */
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return traverseList;
    }

    /**
     * Time Complexity:  O(N), where N is the number of nodes, i.e. the size of tree.
     * Space Complexity:  O(N), for recursion stack, Balanced tree O(NlogN)
     */
    public static List<Integer> postOrderTraversal_recursion(TreeNode root) {
        System.out.println("[Recursion] Pre-Order Traversal");
        return postOrderTraversal_recursion(root, new ArrayList<Integer>());
    }

    private static List<Integer> postOrderTraversal_recursion(TreeNode root, List<Integer> traverseList) {
        if (root == null) return traverseList;
        postOrderTraversal_recursion(root.left, traverseList);
        postOrderTraversal_recursion(root.right, traverseList);
        traverseList.add(root.val);
        return traverseList;
    }

    public static List<Integer> postOrderTraversal_iteration(TreeNode root) {
        System.out.println("[Iteration] Pre-Order Traversal");
        return null;
    }

    /**
     * Time Complexity:  O(N), where N is the number of nodes, i.e. the size of tree.
     * Space Complexity:  O(N), for recursion stack, Balanced tree O(NlogN)
     */
    public static List<Integer> inOrderTraversal_recursion(TreeNode root) {
        System.out.println("[Recursion] Pre-Order Traversal");
        return inOrderTraversal_recursion(root, new ArrayList<Integer>());
    }

    private static List<Integer> inOrderTraversal_recursion(TreeNode root, List<Integer> traverseList) {
        if (root == null) return traverseList;
        inOrderTraversal_recursion(root.left, traverseList);
        inOrderTraversal_recursion(root.right, traverseList);
        traverseList.add(root.val);
        return traverseList;
    }

    public static List<Integer> inOrderTraversal_iteration(TreeNode root) {
        System.out.println("[Iteration] In-Order Traversal");
        return null;
    }

    /**
     * Time Complexity:  O(N), where N is the number of nodes, i.e. the size of tree.
     * Space Complexity:  O(N), for recursion stack, Balanced tree O(NlogN)
     */
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        System.out.println("[Iteration] Level-Order Traversal");
        List<Integer> levList = new ArrayList<>();
        if (root == null) return levList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            levList.add(node.val);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return levList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData2();
        TreePrinter.printNode(root);
        List<Integer> traversedNodes = preorderTraversal_recursion(root);
        System.out.println(traversedNodes);

        traversedNodes = preorderTraversal_iteration(root);
        System.out.println(traversedNodes);

        traversedNodes = levelOrderTraversal(root);
        System.out.println(traversedNodes);
    }
}
