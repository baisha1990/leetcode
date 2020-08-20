/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode prev = null, s = head, f = head, l1 = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            prev = s;
            s = s.next;
        }
        prev.next = null;
        ListNode reversed = reverse(s);
       
        merge(l1, reversed);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, cnext = null;
        while(curr != null) {
            cnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = cnext;
        }
        return prev;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if(n1 == null)
                break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}