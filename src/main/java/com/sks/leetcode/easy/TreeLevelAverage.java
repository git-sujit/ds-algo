package com.sks.leetcode.easy;

import com.sks.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class TreeLevelAverage {
    public static List<Double> levelAverage(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        if (root == null)
            return avg;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            avg.add(sum / size);
        }
        return avg;
    }
}
