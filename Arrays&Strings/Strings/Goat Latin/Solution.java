/*A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.*/

class Solution {
    public String toGoatLatin(String S) {
        String[] sarr = S.split("\\s+");
		String vowels = "AEIOUaeiou";
        StringBuilder sresult = new StringBuilder();
		for(int k = 0; k < sarr.length; k++) {
            
			StringBuilder sb = new StringBuilder();  
			if(vowels.indexOf(sarr[k].charAt(0)) != -1) {
				//First character is a vowel
				sb.append(sarr[k]);
				sb.append("ma");                
			}
            
			else {
				//First character is a constant
				for(int i = 1; i < sarr[k].length(); i++)
					sb.append(sarr[k].charAt(i));
                
				sb.append(sarr[k].charAt(0));
				sb.append("ma");	
			}
            
            for(int i = 1; i <= k+1; i++)
				sb.append('a');
            sresult.append(sb + " ");
		}
		return sresult.deleteCharAt(sresult.length()-1).toString();
    }
}