/*
Given an integer array nums, return 0 if the sum of the digits of the minimum integer in nums is odd, or 1 otherwise.

Example 1:
Input: nums = [34,23,1,24,75,33,54,8]
Output: 0
Explanation: The minimal element is 1, and the sum of those digits is 1 which is odd, so the answer is 0.

Example 2:
Input: nums = [99,77,33,66,55]
Output: 1
Explanation: The minimal element is 33, and the sum of those digits is 3 + 3 = 6 which is even, so the answer is 1.
 
Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

class Solution {
    public int sumOfDigits(int[] nums) {
        int result = 0, min = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num < min) {
                min = num;
            }
        }
        if(min > 9) {
            if(isSumOfDigitsOdd(min)) {
                System.out.println("Is odd");
                return 0;
            } else {
                return 1;
            }
        }
        return min % 2 != 0 ? 0 : 1;
    }
    private boolean isSumOfDigitsOdd(int num) {
        int sum = 0;
        int digit = 0;
        while(num >= 1) {
            digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum % 2 != 0 ? true : false;
    }
}