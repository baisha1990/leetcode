/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

--------------------
Explanation:-
--------------------
There are multiple ways to solve this problem. One of the approach would be to maintain a HashMap with the array elements as keys and their occurrences as values. 
However, the problem states the run-time criteria to be linear and requires it to be implemented without extra space. Hence, below is the solution.*/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums)
            res = res ^ i;
        
        return res;
    }
}
