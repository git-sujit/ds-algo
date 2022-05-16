package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import com.sks.XDEPRECATED.algo2020.TestData;
import com.sks.XDEPRECATED.algo2020.udemy.tree.BinaryTreeTraversal;

import static com.sks.XDEPRECATED.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class ClosestBST {
    /**
     * Average Complexity: Time O(logn)  | Space O(1)
     * Worst Case : Time O(n)  | Space O(1) : BST has just one branch like linked-list
     */
    public static int closestValueInBST(BTNode<Integer> root, int target) {
        if (root == null) return -1;
        BTNode<Integer> closest = root;
        BTNode<Integer> n = root;
        while (n != null) {
            if (Math.abs(target - n.data) < Math.abs(target - closest.data)) closest = n;
            if (target < n.data) n = n.left;
            else if (target > n.data) n = n.right;
            else return n.data;
        }
        return closest.data;
    }

    /**
     * Average Complexity: Time O(logn)  | Space O(logn)
     * Worst Case : Time O(n)  | Space O(n) : BST has just one branch like linked-list
     */
    public static int closestValueInBST_recursive(BTNode<Integer> n, BTNode<Integer> c, int target) {
        if (n == null) return c.data;
        //System.out.println("(n" + n.data + ", n" + c.data + ", " + target + ")");
        if (Math.abs(target - n.data) < Math.abs(target - c.data)) c = n;
        if (target < n.data) return closestValueInBST_recursive(n.left, c, target);
        else if (target > n.data) return closestValueInBST_recursive(n.right, c, target);
        else return n.data;
    }

    public static void main(String[] args) {
        BTNode<Integer> root = TestData.getBinarySearchTreeDataInt();
        System.out.println("Inorder Traversal of Binary Search Tree");
        BinaryTreeTraversal.inOrder(root);
        TestData.printBinaryTree(root, 1);
        System.out.println("\n##### Iterative Algo");
        test_iterativeAlgo(root);
        System.out.println("##### Recursive Algo");
        test_recursoveAlgo(root);

    }

    private static void test_iterativeAlgo(BTNode<Integer> root) {
        helper(root, 20);
        helper(root, 44);
        helper(root, 55);
        helper(root, 76);
        helper(root, 94);
    }

    private static void helper(BTNode<Integer> root, int target) {
        System.out.println("Closest to " + target + " in BST = " + closestValueInBST(root, target));
    }

    private static void test_recursoveAlgo(BTNode<Integer> root) {
        helper_1(root, 20);
        helper_1(root, 44);
        helper_1(root, 55);
        helper_1(root, 76);
        helper_1(root, 94);
    }

    private static void helper_1(BTNode<Integer> root, int target) {
        System.out.println("Closest to " + target + " in BST = " + closestValueInBST_recursive(root, root, target));
    }


}


