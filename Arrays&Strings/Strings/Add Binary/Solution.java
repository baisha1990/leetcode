/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1, sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            int an = i >= 0 ? a.charAt(i--) - '0' : 0;
            int bn = j >= 0 ? b.charAt(j--) - '0' : 0;
            sum = (an + bn + carry); 
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        return sb.toString();
    }
}