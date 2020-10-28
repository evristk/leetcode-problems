package lc_0_500;

import java.util.*;

/**
 * Problem #142 [Medium]
 *  Title: Linked List Cycle II
 *  Link: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 *  Summary: Given a linked list, return the node where the cycle begins.
 *  If there is no cycle, return null.
 *
 * @author Evripidis
 */

public class LinkedListCycle_II {

	public ListNode detectCycle(ListNode head)
	{
		ListNode node = head;

		if (head == null || head.next == null)
		{
			return null;
		}

		Map<Integer, Set<ListNode>> map = new HashMap<>();

		while (node.next != null)
		{
			final ListNode curr = node;

			if (isAlreadySeen(curr.next, map))
			{
				return curr.next;
			}

			map.compute(curr.val,
				(k, v) -> {
					if (v == null) {
						v = new HashSet<>();
					}

					v.add(curr);
					return v;
				});

			// Go to next node
			node = node.next;
		}

		return null;
	}


	public boolean isAlreadySeen(ListNode next, Map<Integer, Set<ListNode>> map)
	{
		int val = next.val;

		if (map.containsKey(val))
		{
			//Node with this value already exist
			//Check if it's the same node
			Set set = map.get(val);

			if (set.contains(next))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}


//	public ListNode detectCycle2(ListNode head)
//	{
//		ListNode singleJump = head;
//		ListNode doubleJump = head;
//
//		boolean	circleIsFound = false;
//
//		while (doubleJump != null && doubleJump.next != null)
//		{
//			singleJump = singleJump.next;
//			doubleJump = doubleJump.next.next;
//
//			if (singleJump == doubleJump)
//			{
//				circleIsFound = true;
//				break;
//			}
//		}
//
//		singleJump = head;
//
//		while (singleJump != doubleJump)
//		{
//			singleJump = singleJump.next;
//		}
//
//	}


	//	Definition for singly-linked list.
	class ListNode
	{

		int val;

		ListNode next;

	    ListNode(int x)
		{
	        val = x;
	        next = null;
	    }
	}


}
