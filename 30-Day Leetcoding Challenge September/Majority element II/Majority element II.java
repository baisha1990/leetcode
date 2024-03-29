/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int candidate1 = nums[0], candidate2 = 0, count1 = 1, count2 = 0;
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i]; 
            if(candidate1 == num) 
                count1++;
            else if(candidate2 == num)
                count2++;
            else if(count1 == 0) {
                candidate1 = num;
                count1++;
            }
            else if(count2 == 0) {
                candidate2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i : nums) {
            if(i == candidate1)
                count1++;
            else if(i == candidate2)
                count2++;
        }
        
        if(count1 > nums.length/3)
            res.add(candidate1);
        if(count2 > nums.length/3)
            res.add(candidate2);
        
        return res;
    }
}