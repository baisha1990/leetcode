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
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        int[] c = new int[256];
        boolean hasOdd = false;
        int odd = 0, even = 0;
        for(int i = 0; i < s.length(); i++) {
            c[s.charAt(i)]++;
        }
        for(int i = 0; i < c.length; i++) {
            if(c[i] % 2 == 1) {
                odd += c[i] - 1;
                hasOdd = true;
            }
            else
                even += c[i];
        }
        return (even + odd + (hasOdd == true ? 1 : 0));
    }
}