package lc_0_500;

import util.ListNode;

/**
 * Problem #147 [Easy]
 *  Title: Insertion Sort List
 *  Link: https://leetcode.com/problems/insertion-sort-list/
 *
 *  Summary: Sort a linked list using insertion sort.
 *
 * @author Evripidιs
 */
public class InsertionSortList_147
{
    public ListNode insertionSortList(ListNode head)
    {
        ListNode curr = head;
        ListNode sortedHead = null;

        // Traverse initial list and insert every node to the sorted list

        while (curr != null)
        {
            ListNode next = curr.next;

            sortedHead = sortedInsert(curr, sortedHead);

            curr = next;
        }

        return sortedHead;
    }


    public ListNode sortedInsert(ListNode newNode, ListNode sortedHead)
    {
        // Special case for new head of sorted list
        if (sortedHead == null || sortedHead.val >= newNode.val)
        {
            newNode.next = sortedHead;
            sortedHead = newNode;
        }
        else
        {
            ListNode curr = sortedHead;

            while (curr.next != null && newNode.val > curr.next.val)
            {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
        }

        return sortedHead;
    }
}
