/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Explanation:- We know that, in a sorted list, if duplicate elements exist, they will be adjacent.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode naya = new ListNode(0);
		ListNode prev = naya;
		ListNode curr = head;
		
		while(curr != null) {
			while(curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
			}
			if(prev.next == curr)
				prev = prev.next;
			else
				prev.next = curr.next;
				
			curr = curr.next;
		}
		return naya.next;
    }
}