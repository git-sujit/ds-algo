package com.sks.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string text and an array of strings words,
 * return an array of all index pairs [i, j] so that the substring text[i...j] is in words.
 * Return the pairs [i, j] in sorted order
 */
public class TrieIndexOfPairs {
    /**
     * Time Complexity :
     * Space Complexity:
     */
    public int[][] indexPairs(String text, String[] words) {
        if (text == null || text.length() == 0 || words == null || words.length == 0) return null;
        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            insertToTrie(root, word);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (searchTrie(text.substring(i, j), root)) {
                    list.add(new int[]{i, j - 1});
                }
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private boolean searchTrie(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] != null)
                node = node.children[c - 'a'];
            if (i == word.length() - 1 && word.equals(node.word))
                return true;
        }
        return false;
    }

    private void insertToTrie(TrieNode root, String word) {
        if (word == null || word.length() == 0) return;
        char[] arr = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode(c);
            if (i == arr.length - 1) node.children[c - 'a'].word = word;
            node = node.children[c - 'a'];
        }
    }

    public static void main(String[] args) {
        String text = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode"};
        demo(text, words);

        text = "ababa";
        words = new String[]{"aba", "ab"};
        demo(text, words);
    }

    private static void demo(String text, String[] words) {
        TrieIndexOfPairs obj = new TrieIndexOfPairs();
        System.out.println("\nText = " + text + ", Words = " + Arrays.toString(words));
        System.out.println("Index of pairs = " + Arrays.deepToString(obj.indexPairs(text, words)));
    }
}

class TrieNode {
    char c;
    TrieNode[] children;
    String word;

    public TrieNode(char c) {
        this.c = c;
        children = new TrieNode[26];
        word = "";
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "c=" + c +
                ", children=" + (children == null ? "" : Arrays.toString(children)) +
                ", word='" + word + '\'' +
                '}';
    }

    private String printChildren(TrieNode[] children) {
        if (children == null || children.length == 0) return "";
        String out = "[";
        for (TrieNode node : children)
            if (node != null)
                out += node.c + ", ";
        return out + "]";
    }
}


