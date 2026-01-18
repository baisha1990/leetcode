/*
Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.

Example 1:
Input: nums = [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.

Example 2:
Input: nums = [9,9,8,8]
Output: -1
Explanation: There is no number that occurs only once.

Constraints:
1 <= nums.length <= 2000
0 <= nums[i] <= 1000
*/

class Solution {
    public int largestUniqueNumber(int[] nums) {
        int maxResult = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if(val == 1) {
                maxResult = Math.max(maxResult, key);
            }
        }
        return maxResult == Integer.MIN_VALUE ? -1 : maxResult;
    }
}