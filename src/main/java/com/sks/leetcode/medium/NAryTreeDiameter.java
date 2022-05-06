package com.sks.leetcode.medium;

import com.sks.leetcode.common.Node;

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
public class NAryTreeDiameter {
    public int diameter(Node root) {
        return -1;
    }
}
