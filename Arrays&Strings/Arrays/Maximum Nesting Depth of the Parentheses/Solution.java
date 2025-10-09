/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string.

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3
Explanation:
Digit 3 is inside of 3 nested parentheses in the string.

Example 3:
Input: s = "()(())((()()))"
Output: 3

Constraints:

1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS.
*/

class Solution {
    public int maxDepth(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, count = 0 ;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == ')') {
                if(c == '(') {
                    stack.push(')');
                    max = Math.max(max, stack.size());
                }
                else if(!stack.isEmpty() && c == ')') {
                    stack.pop();
                }
            }
        }
        return max;
    }
}