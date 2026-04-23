/*
A substring is a contiguous (non-empty) sequence of characters within a string.
A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.
Given a string word, return the number of vowel substrings in word.

Example 1:
Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"

Example 2:
Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.

Example 3:
Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
 

Constraints:
1 <= word.length <= 100
word consists of lowercase English letters only.
*/

class Solution {
    public int countVowelSubstrings(String word) {
        return countChar(word, 5) - countChar(word, 4);
    }

    private int countChar(String word, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if(!set.contains(c)) {
                map.clear();
                i = j + 1;
                continue;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k) {
                char prev = word.charAt(i);
                map.put(prev, map.get(prev) - 1);
                if(map.get(prev) == 0) {
                    map.remove(prev);
                }
                i++;
            }
            res += (j - i) + 1;
        }
        return res;
    }
}