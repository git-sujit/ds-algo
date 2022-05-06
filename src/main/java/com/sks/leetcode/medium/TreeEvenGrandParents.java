package com.sks.leetcode.medium;

import com.sks.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent.
 * If there are no nodes with an even-valued grandparent, return 0.
 * A grandparent of a node is the parent of its parent if it exists.
 */
public class TreeEvenGrandParents {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, List<TreeNode>> gpMap = new HashMap<>();
        prepareEvenGrandParentMap(root, gpMap);
        System.out.println("gpMap  = " + gpMap);
        int sum = 0;
        for (TreeNode node : gpMap.keySet()) {
            for (TreeNode gk : gpMap.get(node))
                sum += gk.val;
        }
        return sum;
    }

    private void prepareEvenGrandParentMap(TreeNode node, Map<TreeNode, List<TreeNode>> gpMap) {
        if (node == null) return;
        if (node.val % 2 == 0) {
            updateGP(node, gpMap);
        }
        prepareEvenGrandParentMap(node.left, gpMap);
        prepareEvenGrandParentMap(node.right, gpMap);
    }

    private void updateGP(TreeNode node, Map<TreeNode, List<TreeNode>> gpMap) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        List<TreeNode> gkList = new ArrayList<>();
        if (left != null) {
            if (left.left != null) gkList.add(left.left);
            if (left.right != null) gkList.add(left.right);
        }
        if (right != null) {
            if (right.left != null) gkList.add(right.left);
            if (right.right != null) gkList.add(right.right);
        }
        if (!gkList.isEmpty()) gpMap.put(node, gkList);
    }
}
