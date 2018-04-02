package com.sks.learn.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Insert/Delete/Search operation on Trie Data Structure <br>
 * Trie / Prefix Tree / n-ary Tree : To store collection of words<br>
 * If two strigs have common ancestors then Trie fits well <br>
 * Ideal data structure for Dictionary <br>
 * Trie Vs HashTable <br>
 * - HashTable has no prefix based search <br>
 * - HashTable takes more space <br>
 * 
 * @author ssing69
 *
 *         Refer: https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */
public class TrieDS {
	TNode root;

	public TrieDS() {
		root = new TNode();
	}

	/**
	 * Time Complexity : <br>
	 * Space Complexity : <br>
	 * 
	 * @param word
	 */
	public void insertIterative(String word) {
		// Boundary Condition
		if (word == null || "".equals(word)) {
			System.out.println("Error: Word is null/empty");
			return;
		}
		// Regular Case
		int len = word.length();
		TNode p = root;
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			TNode p1 = p.children.get(c);
			if (p1 == null) {
				p1 = new TNode();
				p.children.put(c, p1);
			}
			p = p1;
		}
		p.isWord = true;
	}

	/**
	 * @param word
	 */
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0);
	}

	private void insertRecursive(TNode p, String word, int index) {
		if (index == word.length()) {
			p.isWord = true;
			return;
		}
		char c = word.charAt(index);
		TNode p1 = p.children.get(c);
		if (p1 == null) {
			TNode node = new TNode();
			node.children.put(c, node);
		}
		insertRecursive(p1, word, index + 1);
	}

	/**
	 * Iterative Search in Trie
	 * 
	 * @param word
	 */
	public boolean searchWordIterative(String word) {
		if (word == null || word.isEmpty()) {
			return false;
		}
		TNode p = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			TNode p1 = p.children.get(c);
			if (p1 == null) {
				return false;
			}
			p = p1;
		}
		return p.isWord;
	}

	/**
	 * Iterative Search in Trie
	 * 
	 * @param word
	 * @return
	 */
	public boolean searchWordRecursive(String word) {
		return searchWordRecursive(root, word, 0);
	}

	private boolean searchWordRecursive(TNode p, String word, int index) {
		if (index == word.length()) {
			return p.isWord;
		}
		TNode p1 = p.children.get(word.charAt(index));
		if (p1 == null) {
			return false;
		} else {
			return searchWordRecursive(p1, word, index + 1);
		}
	}

	/**
	 * Delete word from Trie
	 * 
	 * @param word
	 */
	public boolean deleteWordRecursive(String word) {
		return deleteWordRecursive(root, word, 0);
	}

	private boolean deleteWordRecursive(TNode p, String word, int index) {
		if (index == word.length()) {
			// If word does not exist
			if (!p.isWord) {
				System.out.println("Word does not exist, so cant delete");
				return false;
			}
			// Id exists then remove i.e
			p.isWord = false;
			return p.children.size() == 0;

		}
		char ch = word.charAt(index);
		TNode p1 = p.children.get(ch);
		// If word does not exist
		if (p1 == null) {
			return false;
		}
		boolean deleteNodeFlag = deleteWordRecursive(p1, word, index + 1);
		if (deleteNodeFlag) {
			p.children.remove(ch);
			return p.children.size() == 0;
		}
		return false;
	}

	/**
	 * @param word
	 */
	public void deleteWord(String word) throws Exception {
		if (word == null || word.isEmpty()) {
			System.out.println("Invalid Input");
		}
		TNode p = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			TNode p1 = p.children.get(c);
			if (p1 == null) {
				System.out.println("Word not present");
			}
			p = p1;
		}
		if (p.children.size() == 0) {
			p.isWord = false;
		}
	}

	/**
	 * @param prefix
	 */
	public void searchPrefix(String prefix) {

	}

	/**
	 * @param prefix
	 */
	public void deletePrefix(String prefix) {

	}

	/**
	 * @param root
	 */
	public void traverseTrie(TNode root) {

	}

	/**
	 * LOCAL - TESTING
	 */
	public static void main(String[] args) {

	}

}

/**
 * Generic TrieNode, can be used for any character in Java (Unicode)
 */
class Node {
	Map<Character, TNode> children;
	boolean isWord;

	// Constructors
	Node() {
		this.children = new HashMap<Character, TNode>();
		this.isWord = false;
	}
}
