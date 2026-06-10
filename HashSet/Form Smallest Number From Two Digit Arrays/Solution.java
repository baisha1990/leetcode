/*
Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.
 
Example 1:
Input: nums1 = [4,1,3], nums2 = [5,7]
Output: 15
Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.

Example 2:
Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
Output: 3
Explanation: The number 3 contains the digit 3 which exists in both arrays.
 
Constraints:
1 <= nums1.length, nums2.length <= 9
1 <= nums1[i], nums2[i] <= 9
All digits in each array are unique.
*/

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int result = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n1 : nums1) {
            min1 = Math.min(min1, n1);
            set.add(n1);
        }
        for(int n2 : nums2) {
            min2 = Math.min(min2, n2);
            if(set.contains(n2)) {
                result = Math.min(result, n2);
            }
        }
        int res = min1 < min2 ? Integer.valueOf(min1 + "" + min2 + "") : Integer.valueOf(min2 + "" + min1 + "");
        return result == Integer.MAX_VALUE ? res : result; 
    }
}