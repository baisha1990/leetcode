/*Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].*/

class Solution {
    public boolean checkValidString(String s) {
        if(s.length() == 0 || s.equals("*"))
            return true;
        if(s.length() == 1)
            return false;
        
        int l = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')')
                l--;
            else
                l++;
            if(l < 0)
                return false;
        }

        if(l == 0)
            return true;
        
        int r = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '(')
                r--;
            else
                r++;
            if(r < 0)
                return false;
        }

        return true;
    }
}