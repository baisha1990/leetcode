/*Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for(int i = 0,j = S.length()-1; i < j; ++i,--j) {
            while(i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while(i < j && !Character.isLetter(sb.charAt(j))) --j;
            sb.setCharAt(i, S.charAt(j));
            sb.setCharAt(j, S.charAt(i));
        }
        return sb.toString();
    }
}