/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, 
reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int i = 0, n = s.length();
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            rev(a, i, j);
            i += 2 * k;
        }
        return String.valueOf(a);
    }
    
    public void rev(char[] a, int l, int r) {
        while(l < r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}