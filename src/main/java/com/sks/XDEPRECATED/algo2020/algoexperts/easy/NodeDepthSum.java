package com.sks.XDEPRECATED.algo2020.algoexperts.easy;

import com.sks.XDEPRECATED.algo2020.TestData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.sks.XDEPRECATED.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose : Givent Binary Treee return Sum of Node Depths for each Node
 * @Node Depth = Distance of node from root
 */
public class NodeDepthSum {
    /**
     * @Time Complexity: O(n) - traversing through all nodes
     * @Space Complexity: O(logn) - Max height of stack on the call stack
     */
    public static int nodeDepthSum(BTNode<Integer> root) {
        if (root == null) return -1;
        return ndSum_recursive(root, 0);
    }

    private static int ndSum_recursive(BTNode<Integer> n, int depth) {
        if (n == null) return 0;
        return depth + ndSum_recursive(n.left, depth + 1) + ndSum_recursive(n.right, depth + 1);
    }

    private static int ndSum_iterative_DFS(BTNode<Integer> root) {
        if (root == null) return -1;
        Stack<BTNode> s = new Stack<>();
        int ds = 0;
        root.depth = 0;
        s.push(root);
        while (!s.empty()) {
            BTNode p = s.pop();
            BTNode l = p.left;
            BTNode r = p.right;
            if (l != null) {
                l.depth = p.depth + 1;
                ds += l.depth;
                s.push(l);
            }
            if (r != null) {
                r.depth = p.depth + 1;
                ds += r.depth;
                s.push(r);
            }
        }
        return ds;
    }

    private static int ndSum_iterative_BFS(BTNode<Integer> root) {
        if (root == null) return -1;
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        int d = 0, sum = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            Queue<BTNode> tq = new LinkedList<>();
            while (!q.isEmpty()) tq.add(q.remove());
            sum += (d * s);
            while (!tq.isEmpty()) {
                BTNode n1 = tq.remove();
                if (n1.left != null) q.add(n1.left);
                if (n1.right != null) q.add(n1.right);
            }
            d++;
        }
        return sum;
    }

    public static void main(String[] args) {
        BTNode<Integer> root = TestData.getBinarySearchTreeDataInt();
        pritOut(root);
        root = TestData.getBinaryTreeDataInt();
        pritOut(root);
    }

    private static void pritOut(BTNode<Integer> root) {
        //TestData.printBinaryTree(root, 1);
        System.out.println("Recursive : Node Depth Sum = " + nodeDepthSum(root));
        System.out.println("Iterative(BFS) : Node Depth Sum = " + ndSum_iterative_BFS(root));
        System.out.println("Iterative(DFS) : Node Depth Sum = " + ndSum_iterative_DFS(root));
    }
}
