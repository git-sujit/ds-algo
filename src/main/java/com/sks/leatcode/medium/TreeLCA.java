package com.sks.leatcode.medium;

import com.sks.leatcode.common.TreeNode;
import com.sks.leatcode.common.TreePrinter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class TreeLCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        preOrder(root, parentMap);
        Set<TreeNode> pAnc = new HashSet<>();
        pAnc.add(p);
        while (p != null) {
            TreeNode parent = parentMap.get(p);
            if (parent != null)
                pAnc.add(parent);
            p = parent;
        }
        if (pAnc.contains(q)) return q;
        while (q != null) {
            TreeNode parent = parentMap.get(q);
            if (parent != null && pAnc.contains(parent)) return parent;
            q = parent;
        }
        return null;
    }

    private static void preOrder(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        if (node.left != null)
            parentMap.put(node.left, node);
        if (node.right != null)
            parentMap.put(node.right, node);
        preOrder(node.left, parentMap);
        preOrder(node.right, parentMap);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.treeData1();
        TreePrinter.printNode(root);
        lca(root, 4, 7);
        lca(root, 4, 6);
        lca(root, 5, 2);
    }

    private static void lca(TreeNode root, int v1, int v2) {
        TreeNode lca = lowestCommonAncestor(root, TreeNode.nodes.get(v1), TreeNode.nodes.get(v2));
        System.out.println("lca(" + v1 + ", " + v2 + ") : " + lca);
    }
}
