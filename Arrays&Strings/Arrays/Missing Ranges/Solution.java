/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

Example 1:
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]

Example 2:
Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
 

Constraints:
-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.
*/

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();

        int leftBound = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lower) {
                continue;
            }
            if (nums[i] > leftBound) {
                res.add(Arrays.asList(leftBound, nums[i] - 1));
            }

            leftBound = nums[i] + 1;

            if (leftBound > upper) {
                return res;
            }
        }

        if (leftBound <= upper) {
            res.add(Arrays.asList(leftBound, upper));
        }

        return res;
    }
}