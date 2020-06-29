package com.sks.algo2020.udemy.tree;

import com.sks.algo2020.TestData;

import static com.sks.algo2020.TestData.BTNode;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class BinarySearchTree {

    public static BTNode<Integer> search(BTNode<Integer> n, int data) {
        if (n == null) return null;
        int nData = n.data;
        if (data < nData)
            return search(n.left, data);
        else if (data > nData)
            return search(n.right, data);
        else
            return n;
    }

    public static BTNode<Integer> min(BTNode n) {
        if (n == null) return null;
        while (n.left != null)
            n = n.left;
        return n;
    }

    public static BTNode<Integer> max(BTNode n) {
        if (n == null) return null;
        while (n.right != null)
            n = n.right;
        return n;
    }

    public static BTNode<Integer> insert(BTNode<Integer> n, int d) {
        BTNode<Integer> in = new BTNode(d);
        BTNode<Integer> parent = null;
        while (n != null) {
            parent = n;
            if (d < n.data) {
                n = n.left;
                if (n == null) {
                    parent.left = in;
                }
            } else if (d > n.data) {
                n = n.right;
                if (n == null) {
                    parent.right = n;
                }
            } else {
                return n;
            }
        }
        return parent;
    }

    public static BTNode<Integer> insert_recursive(BTNode<Integer> n, int d) {
        if (n == null) return new BTNode(d);
        if (d < n.data)
            n.left = insert_recursive(n.left, d);
        else if (d > n.data)
            n.right = insert_recursive(n.right, d);
        return n;
    }

    public static void delete(BTNode<Integer> n, int d) {
        if (n == null) return;
        BTNode<Integer> p = null;
        while (n != null) {
            if (d == n.data) break;
            p = n;
            if (d < n.data) n = n.left;
            else if (d > n.data) n = n.right;
        }
        if (n == null) {
            System.out.println("Data to be deleted not found in BST");
            return;
        }
        System.out.println("Data to be Deleted=" + n + ", parent=" + p);
        BTNode<Integer> l = n.left;
        BTNode<Integer> r = n.right;
        if (l == null && r == null) {
            if (d < p.data) p.left = null;
            else p.right = null;
        } else if (l == null) {
            if (d == p.left.data)
                p.left = r;
            else
                p.right = r;
            r = null;
        } else if (r == null) {
            if (d == p.left.data)
                p.left = l;
            else
                p.right = l;
            l = null;
        } else {
            BTNode<Integer> in = n;
            BTNode<Integer> inp = null;
            while (in.left != null) {
                inp = in;
                in = in.left;
            }
            inp.left = null;
            in.left = l;
            in.right = r;
            l = null;
            r = null;
            if (d == p.left.data)
                p.left = in;
            else if (d == p.right.data)
                p.right = in;
        }
    }

    public static BTNode<Integer> parent(BTNode<Integer> n, int d) {
        if (n == null) return null;
        BTNode parent = null;
        while (n != null) {
            if (d == n.data) break;
            parent = n;
            if (d < n.data) n = n.left;
            else if (d > n.data) n = n.right;
        }
        return parent;
    }

    public static void main(String[] args) {
        BTNode<Integer> root = TestData.getBinarySearchTreeDataInt();
        testGeneral(root);
        //testTraversal(root);
        //testSearching(root);
        //testInsertion(root);
        testDeletion(root);
    }


    private static void testGeneral(BTNode<Integer> root) {
        System.out.println("Parent = " + parent(root, 35));
        System.out.println("Height = " + BinaryTreeTraversal.height(root));
        System.out.println("Min Data BTNode = " + min(root) + ", root=" + root);
        System.out.println("Min Data BTNode = " + max(root) + ", root=" + root);
    }

    private static void testTraversal(BTNode<Integer> root) {
        System.out.println("### Pre-Order");
        BinaryTreeTraversal.preOrder(root);
        System.out.println("\n### Post-Order");
        BinaryTreeTraversal.postOrder(root);
        System.out.println("\n### In-Order");
        BinaryTreeTraversal.inOrder(root);
        System.out.println("\n### Level-Order");
        BinaryTreeTraversal.levelOrder(root);
    }

    private static void testSearching(BTNode<Integer> root) {
        int searchData = 10;
        System.out.println("Searching " + searchData + " :: " + search(root, searchData));
        searchData = 80;
        System.out.println("Searching " + searchData + " :: " + search(root, searchData));
        searchData = 93;
        System.out.println("Searching " + searchData + " :: " + search(root, searchData));
        searchData = 50;
        System.out.println("Searching " + searchData + " :: " + search(root, searchData));
        searchData = 40;
        System.out.println("Searching " + searchData + " :: " + search(root, searchData));
    }

    private static void testInsertion(BTNode<Integer> root) {
        System.out.println("### Insert in BST");
        int in = 20;
        System.out.println("Inserting " + in + " :: " + insert(root, in));
        BinaryTreeTraversal.levelOrder(root);
        in = 54;
        System.out.println("Inserting " + in + " :: " + insert(root, in));
        BinaryTreeTraversal.levelOrder(root);
        in = 98;
        System.out.println("Inserting " + in + " :: " + insert(root, in));
        BinaryTreeTraversal.levelOrder(root);
    }

    private static void testDeletion(BTNode<Integer> root) {
        int del = 4500;
        delete(root, del);
        del = 70;
        delete(root, del);
        del = 50;
        delete(root, del);
        del = 75;
        delete(root, del);
    }
}
