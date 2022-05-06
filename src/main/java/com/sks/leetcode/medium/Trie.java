package com.sks.leetcode.medium;

/**
 * Implement Trie or Prefix Tree
 */

import com.sks.leetcode.common.TrieNode;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * -Trie() Initializes the trie object.
 * -void insert(String word) Inserts the string word into the trie.
 * -boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * -boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Time Complexity : O(n), n is word/key length
     * Space Complexity: O(n), for very first word when Trie is fresh
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Time Complexity : O(n), n is word/key length
     * Space Complexity: O(1)
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
            if (i == word.length() - 1 && node.isEnd) return true;
        }
        return false;
    }

    /**
     * Time Complexity : O(n), n is word/key length
     * Space Complexity: O(1)
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return true;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
            if (i == prefix.length() - 1) return true;
        }
        return false;
    }
}
