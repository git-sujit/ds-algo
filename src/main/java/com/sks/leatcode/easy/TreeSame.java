package com.sks.leatcode.easy;

import com.sks.leatcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class TreeSame {
    /**
     * Time Complexity:
     * Space Complexity:
     */
    public boolean isSameTree_iteration(TreeNode p, TreeNode q) {
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

    /**
     * Time Complexity: O(n), each node is traversed once
     * Space Complexity: O(n), O(log(N) if balanced tree else O(n) to keep RECURSION-STACK
     */
    public boolean isSameTree_recursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree_recursion(p.left, q.left) && isSameTree_recursion(p.right, q.right);
    }
}
