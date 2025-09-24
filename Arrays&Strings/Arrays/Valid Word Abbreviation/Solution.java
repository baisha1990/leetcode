/*
Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
A substring is a contiguous non-empty sequence of characters within a string.

Example 1:
Input: word = "internationalization", abbr = "i12iz4n"
Output: true
Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").

Example 2:
Input: word = "apple", abbr = "a2e"
Output: false
Explanation: The word "apple" cannot be abbreviated as "a2e".
*/

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;
        while(abbrIndex < abbr.length()) {
            if(Character.isDigit(abbr.charAt(abbrIndex))) {
                if(abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;
                while(abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                wordIndex += num;
            } else {
                if(wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}