/*
Given an array of strings words, return true if it forms a valid word square.
A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).

Input: words = ["abcd","bnrt","crmy","dtye"]
Output: true
Explanation:
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crmy".
The 4th row and 4th column both read "dtye".
Therefore, it is a valid word square.
*/

class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++) {
            String curr = words.get(i);
            if(!curr.equals(helper(i, words))) {
                return false;
            }
        }
        return true;
    }
    private String helper(int j, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if(j < word.length()) {
                sb.append(word.charAt(j));
            }
        }
        return sb.toString();
    }
}