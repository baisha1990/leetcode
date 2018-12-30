/*Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            if(temp.val == val) 
                prev.next = temp.next; 
            else                      
                prev = temp;
            temp = temp.next;
        }
        return head;
    }
}