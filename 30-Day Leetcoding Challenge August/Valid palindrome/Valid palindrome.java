/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.*/

class Solution {
    public boolean isPalindrome(String s) {
        String stemp = s.replaceAll("[^A-Za-z0-9]+", "");
        stemp = stemp.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = stemp.length()-1; i >= 0; i--) {
            sb.append(stemp.charAt(i));
        }
        return sb.toString().equals(stemp);
    }
}