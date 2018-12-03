/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode naya = new ListNode(0);
		ListNode temp = naya;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			temp = temp.next;
		}
		
		if(l1 != null) temp.next = l1;
		if(l2 != null) temp.next = l2;
		return naya.next;
    }
}