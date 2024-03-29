/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0 || strs == null) return "";
		String pre = strs[0];
		for(String s : strs) {
			while(s.indexOf(pre) != 0) {
				pre = pre.subString(0, pre.length()-1);
			}
		}
		return pre;
	}
}