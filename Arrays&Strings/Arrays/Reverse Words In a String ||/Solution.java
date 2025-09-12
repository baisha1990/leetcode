/*
Given a character array s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
Your code must solve the problem in-place, i.e. without allocating extra space. 

Example 1:
Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
*/

class Solution {
    public void reverseWords(char[] s) {
        int i = 0, j = s.length - 1;
        reverse(s, i, j);
        reverseEachWord(s);
    }
    private void reverse(char[] a, int s, int e) {
        while(s < e) {
            char temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
    private void reverseEachWord(char[] s) {
        int start = 0, slen = s.length;
        for(int end = 0; end < s.length; end++) {
            if(s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        reverse(s, start, slen - 1);
    }
}