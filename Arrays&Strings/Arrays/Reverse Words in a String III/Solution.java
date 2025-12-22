/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "Mr Ding"
Output: "rM gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

class Solution {
    public String reverseWords(String s) {
        int lastSpaceIndex = -1, n = s.length();
        char[] sarr = s.toCharArray();
        for(int start = 0; start <= n; start++) {
            if(start == n || sarr[start] == ' ') {
                int l = lastSpaceIndex + 1;
                int r = start - 1;
                while(l < r) {
                    char temp = sarr[l];
                    sarr[l] = sarr[r];
                    sarr[r] = temp;
                    l++;
                    r--;
                }
                lastSpaceIndex = start;
            }
        }
        return new String(sarr);
    }
}