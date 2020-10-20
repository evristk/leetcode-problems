/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc_0_500;

/**
 Problem #61 [Medium]
 *  Title: Rotate List
 *  Link: https://leetcode.com/problems/rotate-list/
 *
 *  Summary: Given a linked list, rotate the list to the right by k places, where k is non-negative..
 * @author Evripides
 */
public class RotateList_61 {


    public static void main(String[] args)
    {
        RotateList_61 rotateList = new RotateList_61();
        rotateList.rotateRight(null, 0);
    }


    public ListNode rotateRight(ListNode head, int k)
    {
        ListNode node = head;

        if (head == null)
        {
            return null;
        }

        // Determine list length by iterating through the last node
        int i = 0;

        while (node.next != null)
        {
            node = node.next;
            i++;
        }

        // size of the list
        int length = ++i;

        //Keep track of the previous node
        ListNode prevNode = null;

        int rotationSize;
        if (length > k)
        {
            rotationSize = k;
        }
        else if (k > length)
        {
            rotationSize = k % length;
        }
        else
        {
            rotationSize = 0;
        }

        if (rotationSize == 0)
        {
            return head;
        }

        // Reset pointer to head node
        node = head;

        i = 0;
        while (i < length - rotationSize)
        {
            prevNode = node;
            node = node.next;
            i++;
        }

        ListNode lastNode = prevNode;

        ListNode newHead = node;

        while (node.next != null)
        {
            node = node.next;
        }

        node.next = head;
        head = newHead;
        lastNode.next = null;

        return head;

    }


    /**
    * Definition for singly-linked list.
    **/
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
