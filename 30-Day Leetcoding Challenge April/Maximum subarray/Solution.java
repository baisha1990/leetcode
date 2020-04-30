/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. 

---------------
Explanation:-
---------------
For each element, we are trying to find the max element. The max element could be a single element or a sum of a subarray. Hence, we compare
each element of the array with the sum of the subarray till that point (max_l) and maintain a global maximum (max_g) till that point of the array.*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max_l = 0, max_g = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max_l = Math.max(nums[i], max_l + nums[i]);
            if(max_l > max_g)
                max_g = max_l;
        }
        return max_g;
    }
}