/*
Given an integer num, return a string of its base 7 representation.

Example 1:
Input: num = 100
Output: "202"

Example 2:
Input: num = -7
Output: "-10"

Constraints:
-107 <= num <= 107
*/

class Solution {
    public String convertToBase7(int num) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
            return "0";
        }
        int n = Math.abs(num);
        while(n > 0) {
            sb.insert(0, n % 7);
            n /= 7;
        }
        System.out.println("sb is: " + sb);
        if (num < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}