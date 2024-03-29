/*Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL*/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode start = head, end = head, newHead = head;
        int l = 1, nodesRem = 0;
        while(end.next != null) {
            l++;
            end = end.next;
        }
        k %= l;
        if(k == 0)
            return head;
        nodesRem = l - k;
        end.next = head;
        ListNode newEnd = end;
        while(nodesRem-- > 0) {
            newEnd = newEnd.next;
        }
        newHead = newEnd.next;
        newEnd.next = null;
        return newHead;
    }
}