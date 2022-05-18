package com.sks.leetcode.medium;

import com.sks.leetcode.common.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.
 * The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.
 * (Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)
 */

/**
 * Insights:
 * - The first insight is that the longest path in a tree can only happen between two leaves nodes or between a leaf node and the root node.
 * - Each non-leaf node acts as a bridge for the paths between its descendant leaves nodes.
 * -The height of a node is defined as the length of the longest downward path to a leaf node from that node. Leaf has height 0
 * -The depth of a node is the length of the path to the root node. Root has depth 0
 */
public class TreeDiameter_NAry {
    public int diameter(Node root) {
        return diameter_by_height(root);
    }

    public int diameter_by_height(Node root) {
        Map<Node, Integer> nhMap = new HashMap<>();
        calculateHeight(root, nhMap);
        //for(Node n: nhMap.keySet())
        //System.out.println(n.val+"->"+nhMap.get(n));
        int diameter = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int m1 = 0, m2 = 0;
            for (Node child : node.children) {
                int ch = nhMap.get(child);
                if (ch > m1) {
                    m2 = m1;
                    m1 = ch;
                } else if (ch > m2) m2 = ch;
                stack.push(child);
            }
            int temp = 1 + Math.max(m1, m2);
            int ans = Math.max(temp, 1 + m1 + m2);
            diameter = Math.max(diameter, ans);
        }
        return diameter - 1;
    }

    private int calculateHeight(Node node, Map<Node, Integer> nhMap) {
        if (node == null) return 0;
        if (nhMap.containsKey(node)) return nhMap.get(node);
        int maxChildHeight = 0;
        for (Node child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, calculateHeight(child, nhMap));
        }
        int height = maxChildHeight + 1;
        nhMap.put(node, height);
        return height;
    }
}
