/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

class Solution {
    public int maxProduct(int[] nums) {
        int max_till_here = nums[0], max_so_far = nums[0], min_so_far = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = max_till_here;
            max_till_here = Math.max(Math.max(max_till_here * nums[i], min_so_far * nums[i]), nums[i]);
            min_so_far = Math.min(Math.min(temp * nums[i], min_so_far * nums[i]), nums[i]);
            
            if(max_so_far < max_till_here)
                max_so_far = max_till_here;
        }
        return max_so_far;
    }
}