/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc_500_1000;

/**
 * Problem #701 [Medium]
 *  Title: Insert into a Binary Search Tree
 *  Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *  Summary: You are given the root node of a binary search tree (BST)
 *           and a value to insert into the tree.
 *
 * @author Evripidis
 */
public class InsertIntoABinarySearchTree_701
{
   protected TreeNode solve(TreeNode root, int val)
   {
        TreeNode node = root;

        if (root == null)
        {
            return new TreeNode(val);
        }

        TreeNode previousNode = null;

        while (node != null)
        {
            if (val > node.val)
            {
                // Go right
                previousNode = node;
                node = node.right;
            }
            else
            {
                //Go left
                previousNode = node;
                node = node.left;
            }
        }


        if (val > previousNode.val)
        {
            previousNode.right = new TreeNode(val);
        }
        else
        {
            previousNode.left = new TreeNode(val);
        }

        return root;
    }



    public static void main(String[] args)
    {
        int[] input = {4, 2, 7, 1, 3};



    }


    protected TreeNode populateBST(int[] nodes)
    {
        TreeNode root = null;

        if (nodes.length == 1)
        {
            root = new TreeNode(nodes[0]);
        }
        else if (nodes.length > 1)
        {
            //
        }

        return root;
    }


  


    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;


        /**
         * Empty constructor.
         */
        TreeNode()
        {
        }

        /**
         * Constructor.
         */
        TreeNode(int val)
        {
            this.val = val;
        }
     }
}