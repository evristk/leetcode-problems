/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc_500_1000;

/**
 * Problem #701 [Medium]
 * Title: Insert into a Binary Search Tree
 * Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * Summary: You are given the root node of a binary search tree (BST)
 * and a value to insert into the tree.
 *
 * @author Evripidis
 */
public class InsertIntoBST_701
{
	protected TreeNode insertIntoBST(TreeNode root, int val)
    {
		TreeNode node = root;

		// Case 0: Root node does not exist.
        // Create one.
		if (root == null) {
			return new TreeNode(val);
		}

		// Case 1: Root node exist.
        // Find a leaf node on which the new node will be added as a child.

        TreeNode previousNode = null;
		while (node != null) {
			if (val > node.val) {
				// Go right
				previousNode = node;
				node = node.right;
			} else {
				//Go left
				previousNode = node;
				node = node.left;
			}
		}

		// previousNode is the leaf node on which we are adding a new child node.
        // Now, previousNode is no longer a leaf node, but a parent node
        // that has the node we add, as a child.

		if (val > previousNode.val) {
			previousNode.right = new TreeNode(val);
		} else {
			previousNode.left = new TreeNode(val);
		}

		return root;
	}

    /**
     * Inner class TreeNode represent a node of a binary search tree.
     */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		/**
		 * Empty constructor.
		 */
		TreeNode() {
			//Empty
		}

		/**
		 * Constructor.
		 */
		TreeNode(int val) {
			this.val = val;
		}
	}
}