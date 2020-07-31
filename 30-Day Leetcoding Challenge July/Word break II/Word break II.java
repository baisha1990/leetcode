/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) {
            if(dp[i] == null)
                continue;
            
            for(String word : wordDict) {
                int l = word.length();
                int end = i + l;
                if(end > s.length())
                    continue;
                
                if(s.substring(i, end).equals(word)) {
                    if(dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
        List<String> res = new LinkedList<String>();
        if(dp[s.length()] == null)
            return res;
        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), res, temp);
        
        return res;
    }
    
    private void dfs(List<String> dp[], int end, List<String> res, ArrayList<String> temp) {
        if(end <= 0) {
            String path = temp.get(temp.size() - 1);
            for(int i = temp.size() - 2; i >= 0; i--)
                path += " " + temp.get(i);
            
            res.add(path);
            return;
        }
        
        for(String str : dp[end]) {
            temp.add(str);
            dfs(dp, end-str.length(), res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}