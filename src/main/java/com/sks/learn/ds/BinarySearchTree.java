package com.sks.learn.ds;

import java.util.List;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import com.sks.learn.algo.BinaryTreeAlgorithms;

public class BinarySearchTree extends BinaryTree {
	BinarySearchTree parent;

	public BinarySearchTree getParent() {
		return parent;
	}

	public void setParent(BinarySearchTree parent) {
		this.parent = parent;
	}

	public BinarySearchTree() {

	}

	public BinarySearchTree(int nodeValue) {
		this.setKey("" + nodeValue);
	}

	/**
	 * Insertion will happen always at Leaf
	 * 
	 * @param bst
	 * @param nodeValue
	 */
	public static void insert(BinarySearchTree bst, int nodeValue) {
		BinarySearchTree nodeToInsert = new BinarySearchTree(nodeValue);
		if (bst == null) {
			bst = nodeToInsert;
		} else {
			BinarySearchTree insertAtNode = bst;
			// Go till appropriate node
			boolean flag = true;
			while (flag) {
				int parentKey = Integer.valueOf(insertAtNode.getKey());
				if (nodeValue <= parentKey) {
					if (insertAtNode.getLeftChild() == null) {
						insertAtNode.setLeftChild(nodeToInsert);
						nodeToInsert.setParent(insertAtNode);
						flag = false;
					} else {
						insertAtNode = (BinarySearchTree) insertAtNode.getLeftChild();
					}
				} else {
					if (insertAtNode.getRightChild() == null) {
						insertAtNode.setRightChild(nodeToInsert);
						nodeToInsert.setParent(insertAtNode);
						flag = false;
					} else {
						insertAtNode = (BinarySearchTree) insertAtNode.getRightChild();
					}
				}
			}
		}
	}

	/**
	 * This method prepares a Binary Search Tree of given size
	 * 
	 * @return Binary Search Tree Root Node
	 */
	public static BinarySearchTree prepareRandomBinarySearchTree_1(int bstSize) {
		BinarySearchTree bst = null;
		// Generate Random Numbers
		Random random = new Random();
		System.out.print("Binary Search Random-Input: ");
		for (int i = 0; i < bstSize; i++) {
			// get the next random integer
			int randomInt = random.nextInt(100);
			System.out.print(randomInt + " ");
			if (bst == null) {
				bst = new BinarySearchTree(randomInt);
			} else {
				BinarySearchTree.insert(bst, randomInt);
			}
		}
		System.out.print("\nBinary Search Tree : ");
		printBST(bst);
		return bst;
	}

	public static String printBST(BinarySearchTree bst) {
		BinaryTreeAlgorithms.inOrderTraversal(bst);
		return null;
	}

	/**
	 * This method prepares a Binary Search Tree of given input List
	 * 
	 * @return Binary Search Tree Root Node
	 */
	public static BinarySearchTree prepareRandomBinarySearchTree_2(List<Integer> inputList) {
		BinarySearchTree bst = null;
		// Generate Random Numbers
		System.out.print("\nBinary Search List-Input: ");
		for (int i = 0; i < inputList.size(); i++) {
			// get the next random integer
			int input = inputList.get(i);
			System.out.print(input + " ");
			if (bst == null) {
				bst = new BinarySearchTree(input);
			} else {
				BinarySearchTree.insert(bst, input);
			}
		}
		System.out.print("\nBinary Search Tree : ");
		BinaryTreeAlgorithms.inOrderTraversal(bst);
		return bst;
	}

	/**
	 * Find min
	 * 
	 * @param bst
	 * @return
	 */
	public static BinarySearchTree min(BinarySearchTree bst) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree tmp = bst;
		while (tmp.getLeftChild() != null) {
			tmp = (BinarySearchTree) tmp.getLeftChild();
		}
		return tmp;
	}

	/**
	 * Find max
	 * 
	 * @param bst
	 * @return
	 */
	public static BinarySearchTree max(BinarySearchTree bst) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree tmp = bst;
		while (tmp.getRightChild() != null) {
			tmp = (BinarySearchTree) tmp.getRightChild();
		}
		return tmp;
	}

	/**
	 * Iterative Search Algorithm
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree searchIterative(BinarySearchTree bst, int nodeValue) {
		if (bst == null) {
			return null;
		}
		BinarySearchTree parentNode = bst;
		while (parentNode != null) {
			int parentNodeValue = Integer.valueOf(parentNode.getKey());
			if (nodeValue < parentNodeValue) {
				parentNode = (BinarySearchTree) parentNode.getLeftChild();
			} else if (nodeValue == parentNodeValue) {
				return parentNode;
			} else {
				parentNode = (BinarySearchTree) parentNode.getRightChild();
			}
		}
		return null;
	}

	/**
	 * Recursive Search Algorithm
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree searchRecursive(BinarySearchTree bst, int nodeValue) {
		if (bst == null) {
			return null;
		}
		int currentNodeValue = Integer.valueOf(bst.getKey());
		if (nodeValue < currentNodeValue) {
			return searchRecursive((BinarySearchTree) bst.getLeftChild(), nodeValue);
		} else if (nodeValue == currentNodeValue) {
			return bst;
		} else {
			return searchRecursive((BinarySearchTree) bst.getRightChild(), nodeValue);
		}
	}

	/**
	 * Predecessor = max value less than the node
	 * 
	 * Given node X find the node with largest key smaller than key(X)
	 * 
	 * Note: Parent, Left Child, Right Child informations are needed
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree predecessor(BinarySearchTree bst, int nodeValue) {
		if (bst != null) {
			BinarySearchTree inputNode = searchRecursive(bst, nodeValue);
			if (inputNode == null) {
				System.out.println(nodeValue + " is not found at in Given BST");
				return null;
			}

			BinarySearchTree leftChild = (BinarySearchTree) inputNode.getLeftChild();
			// If no left then get Parent, if this node is right child then return node else
			// return null
			if (leftChild == null) {
				BinarySearchTree parentNode = inputNode.getParent();
				while (parentNode != null && parentNode.getKey().compareTo(inputNode.getKey()) > 0) {
					parentNode = parentNode.getParent();
				}
				if (parentNode != null) {
					return parentNode;
				}
			}
			// If there is left child / subtree then find the max of left subtree
			else {
				return max(leftChild);
			}
		}
		return null;
	}

	/**
	 * Successor = min value greater than the node
	 * 
	 * Given node X find the node with smallest key greater than key(X)
	 * 
	 * Note: Parent, Left Child, Right Child informations are needed
	 * 
	 * @param bst
	 * @param nodeValue
	 * @return
	 */
	public static BinarySearchTree successor(BinarySearchTree bst, int nodeValue) {
		if (bst != null) {
			// Search the node in the BST
			BinarySearchTree inputNode = BinarySearchTree.searchRecursive(bst, nodeValue);

			if (inputNode != null) {
				BinarySearchTree rightChild = (BinarySearchTree) inputNode.getRightChild();
				// If Right Child is null
				if (rightChild == null) {
					BinarySearchTree parent = (BinarySearchTree) inputNode.getParent();
					while (parent != null && parent.getKey().compareTo(inputNode.getKey()) < 0) {
						parent = parent.getParent();
					}
					if (parent != null) {
						return parent;
					}
				}
				// If Right Child is not null then get the min(rightChild/SubTree)
				else {
					return min(rightChild);
				}

			}
		}
		return null;
	}

	/**
	 * Delete a given node in BST
	 * 
	 * Three Scenarios: 1. inputNode has no children 2. inputNode had only one
	 * child(left or right) 3. inputNode has both children
	 * 
	 * @param bst
	 * @param nodeValue
	 */
	public static void delete(BinarySearchTree bst, int nodeValue) {
		if (bst != null) {
			BinarySearchTree nodeToBeDeleted = BinarySearchTree.searchRecursive(bst, nodeValue);
			if (nodeToBeDeleted == null) {
				System.out.println("\nNode Not Found: " + nodeValue);
				return;
			}
			BinarySearchTree parentNode = (BinarySearchTree) nodeToBeDeleted.getParent();
			// For Root Node
			if (parentNode == null) {
				bst.setLeftChild(null);
				bst.setRightChild(null);
				bst.setParent(null);
			}
			BinarySearchTree leftChild = (BinarySearchTree) nodeToBeDeleted.getLeftChild();
			BinarySearchTree rightChild = (BinarySearchTree) nodeToBeDeleted.getRightChild();
			// For leaf node
			if (leftChild == null && rightChild == null) {
				if (isLeftChild(parentNode, nodeToBeDeleted)) {
					parentNode.setLeftChild(null);
				} else {
					parentNode.setRightChild(null);
				}
				nodeToBeDeleted.setParent(null);
			}
			// For Node having right child but no left child
			else if (leftChild == null && rightChild != null) {
				if (isLeftChild(parentNode, nodeToBeDeleted)) {
					parentNode.setLeftChild(rightChild);
				} else {
					parentNode.setRightChild(rightChild);
				}
				nodeToBeDeleted.setParent(null);
			}
			// For Node having left child but no right child
			else if (leftChild != null && rightChild == null) {
				if (isLeftChild(parentNode, nodeToBeDeleted)) {
					parentNode.setLeftChild(leftChild);
				} else {
					parentNode.setRightChild(leftChild);
				}
				nodeToBeDeleted.setParent(null);
			} else {
				BinarySearchTree successor = BinarySearchTree.successor(bst, nodeValue);
				if (isLeftChild(parentNode, nodeToBeDeleted)) {
					parentNode.setLeftChild(successor);
					successor.setLeftChild(leftChild);
					successor.setRightChild(rightChild);
				} else {
					parentNode.setRightChild(successor);
				}
			}

		}
	}

	/**
	 * @param parent
	 * @param child
	 * @return True: Left Child False: Right Child
	 */
	public static boolean isLeftChild(BinarySearchTree parent, BinarySearchTree child) {
		if (parent == null || child == null) {
			return false;
		}
		BinarySearchTree leftChild = (BinarySearchTree) parent.getLeftChild();
		if (leftChild != null) {
			if (leftChild.getKey().compareTo(child.getKey()) == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(this.getKey());
		if (this.getLeftChild() != null) {
			str.append("[Left: " + this.getLeftChild().getKey());
		} else {
			str.append("[Left: null");
		}
		if (this.getRightChild() != null) {
			str.append(", Right: " + this.getRightChild().getKey() + "]");
		} else {
			str.append(", Right: null" + "]");
		}
		return str.toString();
	}

}
