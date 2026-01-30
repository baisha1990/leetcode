/*
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

Example 1:
Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

Example 2:
Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.

Constraints:
2 <= arr.length <= 1000
-106 <= arr[i] <= 106
*/

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int a : arr) {
            minVal = Math.min(minVal, a);
            maxVal = Math.max(maxVal, a);
        }
        int n = arr.length;
        if((maxVal - minVal) % (n - 1) != 0) {
            return false;
        }

        int diff = (maxVal - minVal) / (n - 1);
        int i = 0;

        while(i < n) {
            if(arr[i] == minVal + i * diff) {
                i++;
            } else if((arr[i] - minVal) % diff != 0) {
                return false;
            } else {
                int j = (arr[i] - minVal) / diff;
                if(arr[i] == arr[j]) {
                    return false;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return true;
    }
}