/*
Given two positive integers a and b, return the count of numbers having unique digits in the range [a, b] (inclusive).

Example 1:
Input: a = 1, b = 20
Output: 19
Explanation: All the numbers in the range [1, 20] have unique digits except 11. Hence, the answer is 19.

Example 2:
Input: a = 9, b = 19
Output: 10
Explanation: All the numbers in the range [9, 19] have unique digits except 11. Hence, the answer is 10. 

Example 3:
Input: a = 80, b = 120
Output: 27
Explanation: There are 41 numbers in the range [80, 120], 27 of which have unique digits.
 
Constraints:
1 <= a <= b <= 1000
*/

class Solution {
    public int numberCount(int a, int b) {
        int totalUnique = 0;
        for(int i = a; i <= b; i++) {
            if(isUnique(i)) {
                totalUnique++;
            }
        }
        return totalUnique;
    }
    private boolean isUnique(int a) {
        int digit = 0;
        Set<Integer> set = new HashSet<>();
        while(a > 0) {
            digit = a % 10;
            if(!set.add(digit)) {
                return false;
            }
            a /= 10;
        }
        return true;
    }
}