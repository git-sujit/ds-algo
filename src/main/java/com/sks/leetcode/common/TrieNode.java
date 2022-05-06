package com.sks.leetcode.common;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    public static final int MAX_LINKS = 26;

    public TrieNode() {
        children = new TrieNode[MAX_LINKS];
    }
}
