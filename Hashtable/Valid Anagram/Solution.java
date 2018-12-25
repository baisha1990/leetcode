/*iven two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sa = new char[256];
        char[] ta = new char[256];
        for(int i = 0; i < s.length(); i++) {
            sa[s.charAt(i)]++;
            ta[t.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(sa[s.charAt(i)] != ta[s.charAt(i)])
                return false;
        }
        return true;
    }
}