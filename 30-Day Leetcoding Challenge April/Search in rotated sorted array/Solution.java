/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1*/

class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);
        if(pivot == -1)
            return binsearch(nums, 0, nums.length-1, target);
        if(nums[pivot] == target)
            return pivot;
        if(nums[0] <= target)
            return binsearch(nums, 0, pivot-1, target);
        
        return binsearch(nums, pivot+1, nums.length-1, target);
    }
    
    public int binsearch(int[] nums, int l, int r, int target) {
        if(r < l)
            return -1;
        int mid = l + (r-l)/2;
        if(target == nums[mid])
            return mid;
        if(target < nums[mid])
            return binsearch(nums, l, mid-1, target);
        
        return binsearch(nums, mid+1, r, target);
    }
    
    public int findPivot(int[] nums, int low, int high) {
        if(high < low)
            return -1;
        if(high == low)
            return low;
        int mid = low + (high - low)/2;
        if(mid < high && nums[mid] > nums[mid+1])
            return mid;        
        if(low < mid && nums[mid] < nums[mid-1])
            return mid-1;
        
        if(nums[low] >= nums[mid])
            return findPivot(nums, low, mid-1);
        
        return findPivot(nums,mid+1, high);
        
    }
}