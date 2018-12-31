/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pl = p.length();
        List<Integer> l = new ArrayList<>();
        if(p.length() > s.length()) return l;
        for(int i = 0; i <= s.length() - pl; i++){
            if(isAnagram(s.substring(i,i+pl), p))
        			l.add(i);
        }
        return l;
    }
    
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[] s1a = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            s1a[s1.charAt(i)]++;
            s1a[s2.charAt(i)]--;
        }
        for(int i = 0; i < s1a.length; i++) {
            if(s1a[i] != 0)
                return false;
        }
        return true;
    }
}