/*
Given a 0-indexed integer array nums of length n and an integer target, return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.

Example 1:
Input: nums = [-1,1,2,3,1], target = 2
Output: 3
Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
- (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target 
- (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
*/

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1, count = 0;
        Collections.sort(nums);
        while(l < r) {
            if(nums.get(l) + nums.get(r) < target) {
                count += (r - l);
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}