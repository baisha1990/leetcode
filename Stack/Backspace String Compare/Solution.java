/*Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(char c : S.toCharArray()) {
            if(!st1.isEmpty() && c == '#')
                st1.pop();
            else {
                if(c == '#')
                    continue;
                 st1.push(c);
            }               
        }
        
        for(char c : T.toCharArray()) {
            if(!st2.isEmpty() && c == '#')
                st2.pop();
            else {
                if(c == '#')
                    continue;
                st2.push(c);
            }
        }
        return st1.equals(st2);
    }
}