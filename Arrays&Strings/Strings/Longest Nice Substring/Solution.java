/*
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

Example 1:
Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.

Example 2:
Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

Example 3:
Input: s = "c"
Output: ""
Explanation: There are no nice substrings.

Constraints:
1 <= s.length <= 100
s consists of uppercase and lowercase English letters.
*/

class Solution {
    public String longestNiceSubstring(String s) {
        int l = s.length();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < l; i++) {
            set.add(s.charAt(i));
        } 

        for(int i = 0; i < l; i++){
            char ch = s.charAt(i);
            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))){
                continue;
            }
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i+1));
            
            return s1.length() >= s2.length()? s1 : s2;
        }
        return s;
    }
}