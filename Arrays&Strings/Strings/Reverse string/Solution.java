/*Reverse string
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
*/

class Solution {
    public String reverseString(String s) {
        return new String(new StringBuilder(s).reverse());
    }
}