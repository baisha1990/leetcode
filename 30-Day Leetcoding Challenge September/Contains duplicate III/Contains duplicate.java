/*Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 0 || t < 0) 
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            long cur = (long) nums[i];
            long left = (long) cur - t;
            long right = (long) cur + t + 1;
            SortedSet<Long> sub = set.subSet(left, right);
            if(sub.size() > 0)
                return true;
            set.add(cur);
            if(i >= k)
                set.remove((long)nums[i-k]);
        }
        return false;
    }
}