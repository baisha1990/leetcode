/*Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
		String[] st = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String space : st) {
			StringBuilder sbu = new StringBuilder(st);
			sbu.reverse();
			sb.append(sbu);
			sb.append(" ");
		}
		return new String(sb).trim();
	}
}