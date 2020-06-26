package com.sks.algo2020.udemy.tree;

/**
 * @author : Sujit K Singh
 * Purpose :
 */
public class BinarySearchTree {

    public static Node search(Node n, int data) {
        if (n == null) return null;
        int nData = (Integer) n.data;
        if (data < nData)
            return search(n.left, data);
        else if (data > nData)
            return search(n.right, data);
        else
            return n;
    }

    public static Node min(Node n) {
        if (n == null) return null;
        while (n.left != null)
            n = n.left;
        return n;
    }

    public static Node max(Node n) {
        if (n == null) return null;
        while (n.right != null)
            n = n.right;
        return n;
    }

    public static Node insert(Node n, int d) {
        Node in = new Node(d);
        Node parent = null;
        while (n != null) {
            parent = n;
            if (d < (Integer) n.data) {
                n = n.left;
                if (n == null) {
                    parent.left = in;
                }
            } else if (d > (Integer) n.data) {
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

    public static Node insert_recursive(Node n, int d) {
        if (n == null) return new Node(d);
        if (d < (Integer) n.data)
            n.left = insert_recursive(n.left, d);
        else if (d > (Integer) n.data)
            n.right = insert_recursive(n.right, d);
        return n;
    }

    public static void delete(Node n, int d) {
        if (n == null) return;
        Node p = null;
        while (n != null) {
            if (d == (Integer) n.data) break;
            p = n;
            if (d < (Integer) n.data) n = n.left;
            else if (d > (Integer) n.data) n = n.right;
        }
        if (n == null) {
            System.out.println("Data to be deleted not found in BST");
            return;
        }
        System.out.println("Data to be Deleted=" + n + ", parent=" + p);
        Node l = n.left;
        Node r = n.right;
        if (l == null && r == null) {
            if (d < (Integer) p.data) p.left = null;
            else p.right = null;
        } else if (l == null) {
            if (d == (Integer) p.left.data)
                p.left = r;
            else
                p.right = r;
            r = null;
        } else if (r == null) {
            if (d == (Integer) p.left.data)
                p.left = l;
            else
                p.right = l;
            l = null;
        } else {
            Node in = n;
            Node inp = null;
            while (in.left != null) {
                inp = in;
                in = in.left;
            }
            inp.left = null;
            in.left = l;
            in.right = r;
            l = null;
            r = null;
            if (d == (Integer) p.left.data)
                p.left = in;
            else if (d == (Integer) p.right.data)
                p.right = in;
        }
    }

    public static Node parent(Node n, int d) {
        if (n == null) return null;
        Node parent = null;
        while (n != null) {
            if (d == (Integer) n.data) break;
            parent = n;
            if (d < (Integer) n.data) n = n.left;
            else if (d > (Integer) n.data) n = n.right;
        }
        return parent;
    }

    public static void main(String[] args) {
        Node root = Node.getBinarySearchTreeData();
        testGeneral(root);
        //testTraversal(root);
        //testSearching(root);
        //testInsertion(root);
        testDeletion(root);
    }


    private static void testGeneral(Node root) {
        System.out.println("Parent = " + parent(root, 35));
        System.out.println("Height = " + BinaryTreeTraversal.height(root));
        System.out.println("Min Data Node = " + min(root) + ", root=" + root);
        System.out.println("Min Data Node = " + max(root) + ", root=" + root);
    }

    private static void testTraversal(Node root) {
        System.out.println("### Pre-Order");
        BinaryTreeTraversal.preOrder(root);
        System.out.println("\n### Post-Order");
        BinaryTreeTraversal.postOrder(root);
        System.out.println("\n### In-Order");
        BinaryTreeTraversal.inOrder(root);
        System.out.println("\n### Level-Order");
        BinaryTreeTraversal.levelOrder(root);
    }

    private static void testSearching(Node root) {
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

    private static void testInsertion(Node root) {
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

    private static void testDeletion(Node root) {
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
