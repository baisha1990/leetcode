/*Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

We know that, mergeSort technique offers O(n log n) time complexity hence, we could use mergesort algorithm
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
		ListNode prev = null, fast = head, slow = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		
		return merge(l1, l2);
    }
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode p = l;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if(l1 != null) p.next = l1;
		if(l2 != null) p.next = l2;
		
		return l.next;
	}
}