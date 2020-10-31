/*Given an integer array nums, return the number of longest increasing subsequences.

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

 

Constraints:

0 <= nums.length <= 2000
-106 <= nums[i] <= 106*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int n = nums.length;
        int[] l = new int[n], count = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(count, 1);
        
        int seq = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(l[j] + 1 > l[i]) {
                        l[i] = l[j] + 1;
                        count[i] = count[j];
                    }
                    else if(l[j] + 1 == l[i])
                        count[i] += count[j];
                }
            }
            seq = Math.max(seq, l[i]);
        }
        int nl = 0;
        for(int i = 0; i < n; i++)
            if(l[i] == seq)
                nl += count[i];
        
        return nl;
    }
}