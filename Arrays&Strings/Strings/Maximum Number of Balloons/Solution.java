/*Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] a = new int[26];
        for(char c : text.toCharArray()) {
            a[c - 'a']++;
        }
        int min = a[0];
        min = Math.min(min, a[1]);
        min = Math.min(min, a[11] / 2); //a[11] = l
        min = Math.min(min, a[13]);     //a[13] = n
        min = Math.min(min, a[14] / 2); //a[14] = o
        
        return min;
    }
}