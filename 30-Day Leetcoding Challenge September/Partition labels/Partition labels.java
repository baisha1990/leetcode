/*A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and 
return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] range = map.getOrDefault(c, new int[]{-1,-1});
            if(range[0] == -1) {
                range[0] = i;
                range[1] = i;
            }
            else
                range[1] = i;
        map.put(c, range);
    }
    int[] temp = null;
    List<Integer> res = new ArrayList<>();
    for(Map.Entry<Character, int[]> entry : map.entrySet()) {
        int[] cur = entry.getValue();
        if(temp == null) 
            temp = cur;
        else {
            if(cur[0] < temp[1])
                temp = new int[]{temp[0], Math.max(cur[1], temp[1])};
            else {
                res.add(temp[1] - temp[0] + 1);
                temp = cur;
            }
        }
    }
    res.add(temp[1] - temp[0] + 1);
    return res;
    }
}