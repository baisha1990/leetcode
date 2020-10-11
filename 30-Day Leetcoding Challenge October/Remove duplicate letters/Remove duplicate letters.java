/*Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.*/

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastSeen = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(seen[c] == true)
                continue;
            while(!st.isEmpty() && st.peek() > c && lastSeen[st.peek()] > i) 
                seen[st.pop()] = false;
            st.push(c);
            seen[c] = true;
        }
        while(!st.isEmpty()) {
            sb.append((char)(st.pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}