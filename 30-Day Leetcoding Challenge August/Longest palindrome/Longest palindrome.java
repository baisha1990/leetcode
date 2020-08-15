/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.*/

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int odd = 0, even = 0;
        boolean hasOdd = false;
        for(char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 1) {
                odd += count[i] - 1;
                hasOdd = true;
            }
            else 
                even += count[i];
        }
        return (even + odd + (hasOdd == true ? 1 : 0));
    }
}