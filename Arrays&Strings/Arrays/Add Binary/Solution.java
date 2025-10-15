/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 
Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1, bIndex = b.length() - 1, aNum = 0, bNum = 0, sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(aIndex >= 0 || bIndex >= 0) {
            sum = carry;
            if(aIndex >= 0) sum += a.charAt(aIndex) - '0';
            if(bIndex >= 0) sum += b.charAt(bIndex) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
            aIndex--;
            bIndex--;
        }
        if(carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}