package com.sks.leatcode.common;

public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
