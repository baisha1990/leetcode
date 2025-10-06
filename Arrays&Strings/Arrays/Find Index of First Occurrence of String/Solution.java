/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0, h = haystack.length(), n = needle.length();
        if(h < n) {
            return -1;
        }
        while(i < h) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == n) {
                    return i - j;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}