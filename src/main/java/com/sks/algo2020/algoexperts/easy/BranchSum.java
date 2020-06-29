package com.sks.algo2020.algoexperts.easy;


import com.sks.algo2020.TestData;

import java.util.ArrayList;
import java.util.List;

import static com.sks.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose : Return list of branch sum, starting from leftmost
 */
public class BranchSum {
    public static List<Integer> branchSum(BTNode<Integer> root) {
        if (root == null) return null;
        List<Integer> sumList = new ArrayList<>();
        branchSum_recursive(root, root.data, sumList);
        return sumList;
    }

    /**
     * @param n
     * @param sum
     * @param sumList
     * @Time Complexity: O(n) - Need to traverse all nodes
     * @Space Complexity: O(logn) for stack and O(n) for List
     * Roughly n/2 leave nodes i.e n/2 branches
     * @So overall O(n) space complexity
     */
    private static void branchSum_recursive(BTNode<Integer> n, Integer sum, List<Integer> sumList) {
        if (n.left == null && n.right == null) {
            sumList.add(sum);
            return;
        }
        if (n.left != null) branchSum_recursive(n.left, sum + n.left.data, sumList);
        if (n.right != null) branchSum_recursive(n.right, sum + n.right.data, sumList);
    }

    public static void main(String[] args) {
        BTNode<Integer> root = TestData.getBinarySearchTreeDataInt();
        pritOut(root);
        root = TestData.getBinaryTreeDataInt();
        pritOut(root);
    }

    private static void pritOut(BTNode<Integer> root) {
        TestData.printBinaryTree(root, 1);
        List<Integer> sumList = branchSum(root);
        System.out.println("SumList = " + sumList);
    }
}
