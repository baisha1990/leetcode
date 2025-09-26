/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
*/

class Solution {
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while(l <= r) {
            if(sb.charAt(l) != sb.charAt(r)) {
                sb.deleteCharAt(l);
                if(isValid(sb)) {
                    return true;
                }
                sb.insert(l, s.charAt(l));
                sb.deleteCharAt(r);
                if(isValid(sb)) {
                    return true;
                }
                sb.insert(r, s.charAt(r));
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isValid(StringBuilder sb) {
        int l = 0, r = sb.length() - 1;
        while(l <= r) {
            if(sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}