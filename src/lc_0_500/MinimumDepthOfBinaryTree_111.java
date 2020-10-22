package lc_0_500;

/**
 * Problem #111 [Easy]
 *  Title: Minimum Depth of Binary Tree
 *  Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 *  Summary: Given a binary tree, find its minimum depth.
 *
 * @author Evripidis
 */
public class MinimumDepthOfBinaryTree_111 {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);

		if (leftDepth == 0 || rightDepth == 0) {
			return 1 + Math.max(leftDepth, rightDepth);
		}
		else {
			return 1 + Math.min(leftDepth, rightDepth);
		}


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
