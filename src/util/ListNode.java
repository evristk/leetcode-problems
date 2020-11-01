package util;

public class ListNode
{
    /**
     * Value of node
     */
    public int val;

    /**
     * Pointer to next node.
     */
    public ListNode next;


    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}
