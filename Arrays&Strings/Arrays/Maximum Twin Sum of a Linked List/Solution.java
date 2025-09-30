/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.

Example 1:
Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
*/

class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode s = head, f = head, all = head;
        int maxSum = 0, sc = 0;
        while(all != null) {
            st1.push(all.val);
            all = all.next;
        }
        while(f != null && f.next != null) {
            sc++;
            s = s.next;
            f = f.next.next;
        }
        for(int i = 0; i < sc; i++) {
            if(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        while(!st1.isEmpty() && !st2.isEmpty()) {
            maxSum = Math.max(maxSum, st1.pop() + st2.pop());
        }
        return maxSum;
    }
}