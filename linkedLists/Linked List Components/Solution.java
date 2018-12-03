/*We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear 
consecutively in the linked list. */

/*Question explained : In this problem, we need to find how many connected components listed in array G exist in a LL
 * 				       Example: head: 0->1->2->3
								G = [0, 1, 3]
								Output: 2
								Explanation: 
								0 and 1 are connected, so [0, 1] and [3] are the two connected 
								components.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
		int count = 0;
		for(int i : G) 
			set.add(i);
		ListNode temp = head;
		while(temp != null) {
			if(set.contains(temp.val) && (temp.next == null || !set.contains(temp.next.val))
				count++;
			temp = temp.next;
		}
		return count;
    }
}

