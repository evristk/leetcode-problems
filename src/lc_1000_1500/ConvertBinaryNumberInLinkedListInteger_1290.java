package lc_1000_1500;

import lc_0_500.RotateList_61;
import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberInLinkedListInteger_1290 {
    /**
     * Problem #1290 [Easy]
     *  Title: Convert Binary Number in a Linked List to Integer
     *  Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
     *
     *  Summary: Return the decimal value of the number in the linked list.
     *
     * @author Evripidιs
     */

    public int getDecimalValue(ListNode head)
    {
        // There is no linked list
        if (head == null)
        {
            return 0;
        }

        ListNode node = head;

        // Collect values of linked list in a plain list
        List<Integer> numberList = new ArrayList<>();

        while (node != null)
        {
            numberList.add(node.val);
            node = node.next;
        }

        // Iterate list in reverse order to convert to decimal value.
        int i = numberList.size() - 1;

        int sum = 0;
        int exp = 0;

        while (i >= 0)
        {
            sum += numberList.get(i--) * Math.pow(2, exp++);
        }

        return sum;
    }
}
