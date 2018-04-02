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
	TNode root;

	public static void main(String[] args) {

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
		List<String> result = new LinkedList<String>();
		TNode curr = root;
		for (char ch : pre.toCharArray()) {
			TNode n = curr.children.get(ch);
			if (n == null) {
				// log.error("Invalid Prefix");
				return result;
			}
			curr = n;
		}
		return getWordsForPrefix(curr, result);
	}

	private List<String> getWordsForPrefix(TNode curr, List<String> result) {
		return null;
	}
}

class TNode {
	// Prefix to store the point till which word is traversed
	String prefix;
	Map<Character, TNode> children;
	boolean isWord;

	TNode(String prefix) {
		this.prefix = prefix;
		this.children = new HashMap<Character, TNode>();
		this.isWord = false;
	}
}