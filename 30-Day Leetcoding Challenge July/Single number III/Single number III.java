/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/

class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[0];
        int xor = 0;
        for(int i : nums)
            xor = xor ^ i;
        int mask = 1;
        while((mask & xor) == 0)
            mask = mask << 1;
        int x1 = 0, x2 = 0;
        for(int i : nums) {
            if((i & mask) == 0)
                x1 = x1 ^ i;
            else
                x2 = x2 ^ i;
        }
        int[] res = new int[]{x1, x2};
        return res;
    }
}