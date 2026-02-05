package com.sks.interview_2026;

import com.sks.interview_2026.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_RecursionPractice {
    public static void main(String[] args) {
        System.out.println("----- RECURSION: BASIC PROBLEMS -----");
        test_basicProblems();

        System.out.println("----- HEIGHT OF BINARY TREE -----");
        test_heightOfBinaryTree();

        System.out.println("----- SUBSETS -----");
        test_subsets();

        System.out.println("----- PERMUTATIONS -----");
        test_permutations();
    }

    /**
     * BASIC PROBLEMS
     */
    /**
     * 1. Design Hypothesis: Suppose that print_1_n() function prints numbers 1...n
     */
    private static void print_1_n(int n) {
        // 2. Base Condition
        if (n == 0) return;
        // 3. Induction: Call function with smaller input
        print_1_n(n - 1); // Think: --n/n-- will not work, infinite loop
        System.out.print(n + " ");
    }

    /**
     * Tail recursion: last statement is recursion call
     */
    private static void print_n_1(int n) {
        // Base Condition
        if (n == 0) return;
        System.out.print(n + " ");
        //Induction
        print_n_1(n - 1); // Think: --n works but n-- will not work, infinite loop
    }

    // Hypothesis: nthFactorial(n) return factorial of n
    private static int nthFactorial(int n) {
        // Base Condition
        if (n == 0 || n == 1) return 1;
        return n * nthFactorial(n - 1);
    }

    // Hypothesis: nthFibonacci(n) return nth Fibonacci
    public static int nthFibonacci(int n) {
        // Base Condition
        if (n == 1 || n == 2) return 1;
        // Induction
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    private static int nthFibonacci_Memoization(int n, int[] mem) {
        if (n == 1 || n == 2) mem[n] = 1;
        if (mem[n] == 0) mem[n] = nthFibonacci_Memoization(n - 1, mem) + nthFibonacci_Memoization(n - 2, mem);
        return mem[n];
    }

    // Hypothesis: height_BinaryTree(root) return height of binary tree starting at node root
    private static int height_BinaryTree(BinaryTreeNode node) {
        // Base Condition
        if (node == null) return 0;
        // Induction
        return 1 + Math.max(height_BinaryTree(node.left), height_BinaryTree((node.right)));
    }

    /**
     * Time Complexity : O(n*2^n), Space Complexity: O(n*2^n)
     */
    private static List<String> subsets(String str) {
        List<String> out = new ArrayList<>();
        if (str == null || str.isEmpty()) return out;
        // Start Point
        out.add("");
        for (char c : str.toCharArray()) {
            List<String> sub = new ArrayList<>();
            for (String s1 : out)
                sub.add(s1 + c);
            out.addAll(sub);
        }
        return out;
    }

    /**
     * Time Complexity: O(n*n!), Space Complexity: O(n!)
     */
    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        if (nums == null || nums.length == 0) return perms;
        perms.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> subPerms = new ArrayList<>();
            for (List<Integer> l : perms) {
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> t = new ArrayList<>(l);
                    t.add(j, nums[i]);
                    subPerms.add(t);
                }
            }
            perms = subPerms;
        }
        return perms;
    }

    /**
     * TEST
     */
    private static void test_basicProblems() {
        int n = 9;
        print_1_n(n);
        System.out.println();
        print_n_1(n);

        System.out.println("\nFactorial(" + n + ") = " + nthFactorial(n));
        System.out.println("Fibonacci(" + n + ") = " + nthFibonacci(n));
        int[] mem = new int[n + 1];
        System.out.println("[Memoization] Fibonacci(" + n + ") = " + nthFibonacci_Memoization(n, mem));
        System.out.println("Memoization Array, mem = " + Arrays.toString(mem));

    }

    private static void test_heightOfBinaryTree() {
        BinaryTreeNode root = BinaryTreeNode.getBinaryTreeData1();
        System.out.println("Heigh of Binary Tree = " + height_BinaryTree(root));
    }

    private static void test_subsets() {
        String s = "abc";
        System.out.println("String : " + s);
        List<String> subsets = subsets(s);
        System.out.println("No. of Subsets = " + subsets.size() + " : " + subsets);
    }

    private static void test_permutations() {
        int[] nums = {1, 2, 3};
        System.out.println("Nums : " + Arrays.toString(nums));
        System.out.println("Perms: " + permutations(nums));
    }
}
