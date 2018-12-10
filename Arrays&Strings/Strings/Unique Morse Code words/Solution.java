/*International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        map.put('a',".-"); map.put('b', "-..."); map.put('c',"-.-."); map.put('d', "-.."); map.put('e',".");
        map.put('f',"..-."); map.put('g',"--."); map.put('h',"...."); map.put('i',".."); map.put('j',".---");
        map.put('k',"-.-"); map.put('l',".-.."); map.put('m',"--"); map.put('n', "-."); map.put('o',"---");
        map.put('p',".--."); map.put('q',"--.-"); map.put('r',".-."); map.put('s', "..."); map.put('t', "-"); 
        map.put('u',"..-"); map.put('v',"...-"); map.put('w', ".--"); map.put('x',"-..-"); map.put('y',"-.--");
        map.put('z',"--..");

        Set<String> set = new HashSet<>();
        for(String s : words) {
            char[] c = s.toCharArray();
            String sword = "";
            for(char ch : c) {
                sword += map.get(ch);
            }
            set.add(sword);
        }
        System.out.println(set);
        return set.size();
    }
}