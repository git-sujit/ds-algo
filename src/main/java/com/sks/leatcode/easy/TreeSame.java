package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class TreeSame {
    /**
     * Time Complexity: O(n), each node is traversed once
     * Space Complexity: O(n), O(log(N) if balanced tree else O(n) to keep RECURSION-STACK
     */
    public static boolean isSameTree_recursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree_recursion(p.left, q.left) && isSameTree_recursion(p.right, q.right);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity:O(n), O(log(N) if balanced tree else O(n) to keep RECURSION-STACK
     */
    public static boolean isSameTree_iteration(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.remove();
            TreeNode n2 = q2.remove();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            q1.add(n1.left);
            q1.add(n1.right);
            q2.add(n2.left);
            q2.add(n2.right);
        }
        if (!q1.isEmpty() || !q2.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.treeData1();
        TreeNode root11 = TreeNode.treeData1();
        System.out.println("Tree - 1");
        TreePrinter.printNode(root1);
        System.out.println("Tree - 1(Same)");
        TreePrinter.printNode(root11);
        System.out.println("Tree - 2");
        TreeNode root2 = TreeNode.treeData2();
        TreePrinter.printNode(root2);

        System.out.println("[Recursion] Are tree same? : " + isSameTree_recursion(root1, root11));
        System.out.println("[Iteration] Are tree same? : " + isSameTree_iteration(root1, root11));

        System.out.println("[Recursion] Are tree same? : " + isSameTree_recursion(root1, root2));
        System.out.println("[Iteration] Are tree same? : " + isSameTree_iteration(root1, root2));
    }
}
