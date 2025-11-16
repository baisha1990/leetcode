/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
In the American keyboard:
the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

Example 1:
Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Explanation:
Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.

Example 2:
Input: words = ["omk"]
Output: []

Example 3:
Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]

Constraints:
1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 
*/

class Solution {
    public String[] findWords(String[] words) {
        Map<Integer, String> map = new HashMap<>();
        List<String> l = new ArrayList<>();
        map.put(0, "qwertyuiop");
        map.put(1, "asdfghjkl");
        map.put(2, "zxcvbnm");
        for(String w : words) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < w.length(); i++) {
                char c = w.toLowerCase().charAt(i);
                if(map.get(0).contains(c + "")) {
                    set.add(0);
                } else if (map.get(1).contains(c + "")) {
                    set.add(1);
                } else if (map.get(2).contains(c + "")) {
                    set.add(2);
                }
            }
            if(set.size() == 1) {
                l.add(w);
            }
        }
        return l.toArray(new String[0]);
    }
}