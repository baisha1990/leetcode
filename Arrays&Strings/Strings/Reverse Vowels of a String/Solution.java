/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".*/

Reverse Vowels of a string

class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
        set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
        char[] sc = s.toCharArray();
		for(int i=0, j=sc.length-1; i<j; ) {
            if (!set.contains(sc[i])) {
                i++;
                continue;
            }
            if (!set.contains(sc[j])) {
                j--;
                continue;
            }
            char temp=sc[i];
            sc[i]=sc[j];
            sc[j]=temp;
            i++;
            j--;
        }
		return String.valueOf(sc);
    }
}