/*Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the 
smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters. */

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        
        int i = 0, j = 0;
        for(String s : queries) {
            q[i++] = freqCount(s);
        }
        
        for(String wo : words) {
            w[j++] = freqCount(wo);
        }
        
        int[] res = new int[queries.length];
        int r = 0;
        for(int x = 0; x < q.length; x++) {
            int count = 0;
            for(int y = 0; y < w.length; y++) {
                if(w[y] > q[x])
                    count++;
            }
            res[r++] = count;
        }
        
        return res;
    }
    
    public int freqCount(String s) {
        int[] a = new int[26];
        for(char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for(int i : a) {
            if(i > 0)
            return i;
        }
        return -1;
    }
}