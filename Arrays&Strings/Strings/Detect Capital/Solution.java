/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        char[] wordch = word.toCharArray();
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if('Z' - wordch[i] >= 0)
                count++;
        }
        return count == 0 || count == word.length() || count == 1 && 'Z' - word.charAt(0) >= 0;
    }
}