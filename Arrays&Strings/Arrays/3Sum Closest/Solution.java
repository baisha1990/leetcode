/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0, prevDiff = Integer.MAX_VALUE, l = 0, r = 0, n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            l = i + 1;
            r = n - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(target - sum);
                if(diff < prevDiff) {
                    res = sum;
                }
                prevDiff = Math.min(prevDiff, diff);
                if(sum == target) {
                    return res;
                } else if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}