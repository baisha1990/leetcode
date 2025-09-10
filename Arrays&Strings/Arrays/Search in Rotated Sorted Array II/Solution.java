/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
*/

class Solution {
    public boolean search(int[] nums, int target) {
         int val = search(nums, 0, nums.length - 1, target);
         return val == -1 ? false : true;
    }
    int search(int[] a, int l, int r, int x) {
        int mid = (l + r) / 2;
        if(a[mid] == x) {
            return mid;
        }
        if(l > r) {
            return -1;
        }
        if(a[l] < a[mid]) {
            if(x >= a[l] && x < a[mid]) {
                return search(a, l, mid - 1, x);
            } else {
                return search(a, mid + 1, r, x);
            }
        } else if(a[mid] < a[l]) {
            if(x > a[mid] && x <= a[r]) {
                return search(a, mid + 1, r, x);
            } else {
                return search(a, l, mid - 1, x);
            }
        } else if(a[l] == a[mid]) {
            if(a[mid] != a[r]) {
                return search(a, mid + 1, r, x);
            } else {
                int res = search(a, l, mid - 1, x);
                if(res == -1) {
                    return search(a, mid + 1, r, x);
                } else {
                    return res;
                }
            }
        }
        return -1;
    }
}