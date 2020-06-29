package com.sks.algo2020.algoexperts.easy;

import com.sks.algo2020.TestData;

import java.util.LinkedList;
import java.util.Queue;

import static com.sks.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose : Givent Binary Treee return Sum of Node Depths for each Node
 * @Node Depth = Distance of node from root
 */
public class NodeDepthSum {

    public static int nodeDepthSum(BTNode<Integer> root) {
        if (root == null) return -1;
        return ndSum_recursive(root, 0);
    }

    private static int ndSum_recursive(BTNode<Integer> n, int depth) {
        if (n == null) return 0;
        return depth + ndSum_recursive(n.left, depth + 1) + ndSum_recursive(n.right, depth + 1);
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
    }
}
