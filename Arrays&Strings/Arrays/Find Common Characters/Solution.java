/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

class Solution {
    public List<String> commonChars(String[] words) {
        int[] countMap = getCount(words[0]);

        for(int i = 1; i < words.length; i++) {
            countMap = commonCount(countMap, getCount(words[i]));
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(countMap[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while(countMap[i] > 0) {
                    res.add(s);
                    countMap[i]--;
                }
            }
        }
        return res;
    }

    private int[] commonCount(int[] a, int[] b) {
        int[] temp = new int[26];
        for(int i = 0; i < 26; i++) {
            temp[i] = Math.min(a[i], b[i]);
        }
        return temp;
    }

    private int[] getCount(String word) {
        int[] charCount = new int[26];
        for(int i = 0; i < word.length(); i++) {
            charCount[word.charAt(i) - 'a']++;
        }
        return charCount;
    }
}