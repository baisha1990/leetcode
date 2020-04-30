/*Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

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
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int count = 0, i = S.length() - 1, j = T.length() - 1;
        while(true) {
            while(i >= 0 && (count > 0 || S.charAt(i) == '#')) {
                count += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            count = 0;
            while(j >= 0 && (count > 0 || T.charAt(j) == '#')) {
                count += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if(i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            }
            else
                break;
        }
        return i == -1 && j == -1;
    }
}