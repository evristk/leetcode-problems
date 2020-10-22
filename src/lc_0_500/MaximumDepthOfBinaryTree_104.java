package lc_0_500;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem #104 [Easy]
 *  Title: Maximum Depth of Binary Tree
 *  Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 *  Summary: Given a binary tree, find its maximum depth.
 *
 * @author Evripidis
 */
public class MaximumDepthOfBinaryTree_104 {

	public int maxDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();

		if (root == null) {
			return 0;
		}

		queue.add(root);
		int level = 0;

		while (!queue.isEmpty()) {
			// Number of elements that exists on current level
			int elementsSameLevel = queue.size();

			// For each element in this level,
			// add their child nodes in the queue

			while (elementsSameLevel-- > 0) {
				TreeNode node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

			// At this point, we have processed all nodes in this level,
			// so we increment it, to move to the next nodes.
			level++;
		}

		return level;

	}

	/**
	 * Inner class representing the binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		/**
		 * Constructor
		 */
		TreeNode() {}


		/**
		 * Constructor
		 * @param val Value of node.
		 */
		TreeNode(int val) { this.val = val; }

		/**
		 * Constructor.
		 * @param val Value of node.
		 * @param left Node on the left.
		 * @param right Node on the right.
		 */
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
