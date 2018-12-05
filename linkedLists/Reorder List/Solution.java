/* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, prev = null, l1 = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		ListNode l2 = reverse(slow);
		
		merge(l1, l2);
    }
	
	public ListNode reverse(ListNode temp) {
		ListNode curr = temp, prev = null;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public void merge(ListNode l1, ListNode l2) {
			ListNode n1 = l1.next, n2 = l2.next;
		while(l1 != null) {

			n1 = l1.next;
			n2 = l2.next;
			l1.next = n2;
			
			if(n1 == null) 
				break;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}
}