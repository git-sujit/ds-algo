package com.sks.learn.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	Node root;
	Logger log = Logger.getLogger(TrieDS.class.getName());

	/**
	 * Generic TrieNode, can be used for any character in Java (Unicode)
	 */
	class Node {
		Map<Character, Node> children;
		boolean isWord;

		// Constructors
		Node() {
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
	}

	public TrieDS() {
		root = new Node();
	}

	/**
	 * Time Complexity : <br>
	 * Space Complexity : <br>
	 * 
	 * @param word
	 */
	public void insertIterative(String word) {
		// Boundary Condition
		if (word == null || word.isEmpty()) {
			log.log(Level.SEVERE, "Error: Word is null/empty");
			return;
		}
		// Regular Case
		Node curr = root;
		for (char ch : word.toCharArray()) {
			Node n = curr.children.get(ch);
			if (n == null) {
				n = new Node();
				curr.children.put(ch, n);
			}
			curr = n;
		}
		curr.isWord = true;
	}

	/**
	 * @param word
	 */
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0);
	}

	private void insertRecursive(Node curr, String word, int index) {
		if (index == word.length()) {
			curr.isWord = true;
			return;
		}
		char ch = word.charAt(index);
		Node n = curr.children.get(ch);
		if (n == null) {
			Node node = new Node();
			node.children.put(ch, node);
		}
		insertRecursive(n, word, index + 1);
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
		Node curr = root;
		for (char ch : word.toCharArray()) {
			Node n = curr.children.get(ch);
			if (n == null) {
				return false;
			}
			curr = n;
		}
		return curr.isWord;
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

	private boolean searchWordRecursive(Node curr, String word, int index) {
		if (index == word.length()) {
			return curr.isWord;
		}
		Node n = curr.children.get(word.charAt(index));
		if (n == null) {
			return false;
		} else {
			return searchWordRecursive(n, word, index + 1);
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

	private boolean deleteWordRecursive(Node p, String word, int index) {
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
		Node p1 = p.children.get(ch);
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
		Node p = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			Node p1 = p.children.get(c);
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
	public void traverseTrie(Node root) {

	}

	/**
	 * LOCAL - TESTING
	 */
	public static void main(String[] args) {

	}

}
