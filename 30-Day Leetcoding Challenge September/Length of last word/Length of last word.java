/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5*/

class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 || s.trim().length() == 0)
            return 0;
        String[] sarr = s.split("\\s+");
        if(sarr.length == 1)
            return sarr[0].length();
        else
            return sarr[sarr.length - 1].length();
    }
}