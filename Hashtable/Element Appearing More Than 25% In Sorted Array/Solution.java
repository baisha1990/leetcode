/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

Example 2:
Input: arr = [1,1]
Output: 1
 
Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 105
*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int oneFourth = n / 4;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) > oneFourth) {
                return a;
            }
        }
        return -1;
    }
}