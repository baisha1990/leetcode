/*Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        return helper(nums, 0, sum/2);
    }
    
    boolean helper(int[] nums, int index, int target) {
        if(target == 0)
            return true;
        if(index == nums.length || target < 0)
            return false;
        if(helper(nums, index+1, target-nums[index]))
            return true;
        int j = index + 1;
        while(j < nums.length && nums[j] == nums[index])
            j++;
        return helper(nums, j, target);
    }
}