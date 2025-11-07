/*
Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Example 3:
Input: s = "carerac"
Output: true

Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] hash = new int[26];
        int counto = 0;
        for(int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(hash[i] % 2 == 1) {
                counto++;
            }
        }
        return counto <= 1;
    }
}