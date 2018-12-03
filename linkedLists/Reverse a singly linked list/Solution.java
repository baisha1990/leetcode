/*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*/
 
/*------Iterative Solution-----*/

class Solution {
    public ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		ListNode curr = head;
		ListNode prev = null;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
    }
}

/*------Recursive Solution-----*/

class Solution {
    public ListNode reverseList(ListNode head) {

		return reverseList(head, null);
		
	}
	
	public ListNode reverseList(ListNode head, ListNode prev) {
		if(head == null) return head;
		
		ListNode curr = head;
		ListNode next = curr.next;
		curr.next = prev;
		
		return reverseList(next, head);
	}
}

