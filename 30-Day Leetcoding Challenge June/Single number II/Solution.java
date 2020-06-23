/*Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99*/

class Solution {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        int r = 0;
        for(int n : nums) {
            int mask = 1;
            for(int i = 31; i >= 0; i--) {
                if((n & mask) != 0) {
                    res[i]++;
                }
                mask = mask << 1;
            }
        }
        
        for(int i = 0; i < 32; i++) {
            res[i] = res[i] % 3;
            if(res[i] == 1)
                r += 1;           
            if(i == 31)
                break;
            r = r << 1;
        }
        return r;
    }
}