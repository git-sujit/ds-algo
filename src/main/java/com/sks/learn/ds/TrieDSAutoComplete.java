package com.sks.learn.ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ssing69 <br>
 *         Refer: https://www.youtube.com/watch?v=NZ3lP33mXlY&t=886s
 */
public class TrieDSAutoComplete {
	Node root;

	class Node {
		// Prefix to store the point till which word is traversed
		String prefix;
		Map<Character, Node> children;
		boolean isWord;

		Node(String prefix) {
			this.prefix = prefix;
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
	}

	public TrieDSAutoComplete() {
		this.root = new Node("");
	}

	/**
	 * Get all words as array of Strings <br>
	 * Insert all the words in Constructor
	 * 
	 * @param dict
	 */
	public TrieDSAutoComplete(String[] dict) {
		for (String s : dict) {
			insertWord(s);
		}
	}

	private void insertWord(String word) {
		if (word == null || word.isEmpty()) {
			// TODO
		}
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node n = curr.children.get(ch);
			if (n == null) {
				// TODO check why i+1
				n = new Node(word.substring(i + 1));
				curr.children.put(ch, n);
			}
			curr = n;
		}
		curr.isWord = true;
	}

	/**
	 * All the words are in Trie so we are going to lookup <br>
	 * - Check if prefix itself is present <br>
	 * - Start iterating after end of Prefix <br>
	 * - Recursive approach to go through the results<br>
	 * 
	 * @param pre
	 * @return
	 */
	public List<String> getWordsForPrefix(String pre) {
		// LinkedList because Insertion is faster
		List<String> results = new LinkedList<String>();
		Node curr = root;
		for (char ch : pre.toCharArray()) {
			Node n = curr.children.get(ch);
			if (n == null) {
				// log.error("Invalid Prefix");
				return results;
			}
			curr = n;
		}
		findAllChildWords(curr, results);
		return results;
	}

	private void findAllChildWords(Node curr, List<String> results) {
		if (curr.isWord) {
			results.add(curr.prefix);
		}

		for (char ch : curr.children.keySet()) {
			findAllChildWords(curr.children.get(ch), results);
		}
	}

	public static void main(String[] args) {

	}
}
