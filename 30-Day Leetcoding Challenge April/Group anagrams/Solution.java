/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<List<String>> ll = new ArrayList<>();
        
        for(String st : strs) {
            int c = getArr(st);
            List<String> l = map.get(c);
            
            if(l == null) {
                l = new ArrayList<>();
                map.put(c, l);
            }
            
            l.add(st);
        }
        
        ll.addAll(map.values());
        return ll;
    }
    
    public int getArr(String s) {
        int[] ch = new int[26];
        for(char c : s.toCharArray()) {
            ch[c - 'a']++;
        }
        return Arrays.hashCode(ch);
    }
}