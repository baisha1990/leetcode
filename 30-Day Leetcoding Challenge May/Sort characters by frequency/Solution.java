/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuffer[] buckets = new StringBuffer[s.length() + 1];
        for(char c : map.keySet()) {
            int count = map.get(c);
            if(buckets[count] == null)
                buckets[count] = new StringBuffer();
            for(int i = 0; i < count; i++) {
                buckets[count].append(c);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = s.length(); i > 0; i--) {
            if(buckets[i] == null)
                continue;
            
            sb.append(buckets[i]);
        }
        return sb.toString();
    }
}