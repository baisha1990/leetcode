/*
You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:
If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.
A cycle in the array consists of a sequence of indices seq of length k where:
Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.

Example 1:
Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).
*/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int s = i, f = i;
            boolean forward = nums[i] > 0;
            while(true) {
                s = nextStep(nums, s, n);
                if(isNotCycle(nums, s, forward)) {
                    break;
                }
                f = nextStep(nums, f, n);
                if(isNotCycle(nums, f, forward)) {
                    break;
                }
                f = nextStep(nums, f, n);
                if(isNotCycle(nums, f, forward)) {
                    break;
                }
                if(s == f) {
                    return true;
                }
            }
        }
        return false;
    }
    private int nextStep(int[] nums, int pointer, int size) {
        int res = (pointer + nums[pointer]) % size;
        if(res < 0) { 
            res += size;
        }
        return res;
    }
    private boolean isNotCycle(int[] nums, int pointer, boolean prevDirection) {
        boolean curDirection = nums[pointer] >= 0;
        if(prevDirection != curDirection || nums[pointer] % nums.length == 0) {
            return true;
        }
        return false;
    }
}