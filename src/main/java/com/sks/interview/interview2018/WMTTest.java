package com.sks.interview.interview2018;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WMTTest {
	public boolean isMatching(Node r1, Node r2) {
		// Boundary Condition
		if (r1 == null && r2 == null) {
			return true;
		}
		if (r1 == null || r2 == null) {
			return false;
		}
		// Queue for Level-Order Traversal
		Map<Integer, String> levelChildrenMap1 = new HashMap<Integer, String>();
		traverseAndPrepareMap(r1, levelChildrenMap1);
		Map<Integer, String> levelChildrenMap2 = new HashMap<Integer, String>();
		traverseAndPrepareMap(r2, levelChildrenMap2);

		if (levelChildrenMap1.size() != levelChildrenMap2.size())
			return false;
		for (int level : levelChildrenMap1.keySet()) {
			String seq1 = levelChildrenMap1.get(level);
			String seq2 = levelChildrenMap2.get(level);
			if (!isPermutation(seq1, seq2)) {
				return false;
			}
		}
		return true;
	}

	public void traverseAndPrepareMap(Node n, Map<Integer, String> m) {
		if (n == null)
			return;
		int l = n.level;
		// String that maintains the count sequence
		String childrenCountSequence = m.get(l);
		if (childrenCountSequence == null || "".equals(childrenCountSequence)) {
			if (n.children == null) {
				m.put(l, "0");
			} else {
				m.put(l, "" + n.children.size());
			}
		} else {
			if (n.children == null) {
				m.put(l, childrenCountSequence + "0");
			} else {
				m.put(l, childrenCountSequence + n.children.size());
			}
		}
		for (Node cn : n.children) {
			traverseAndPrepareMap(cn, m);
		}
	}

	/**
	 * TODO: Not implemented
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private Boolean isPermutation(String s1, String s2) {
		// TODO Implement the permutation logic
		return null;
	}

}

class Node {
	// Maintains level of the node
	int level;

	// Maintains list of all the children
	List<Node> children;
}
