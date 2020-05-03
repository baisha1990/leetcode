/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < magazine.length(); i++)
            a[magazine.charAt(i) - 'a']++;
    
        for(int j = 0; j < ransomNote.length(); j++) 
            b[ransomNote.charAt(j) - 'a']++;
        
        for(int k = 0; k < ransomNote.length(); k++) {
            if(b[ransomNote.charAt(k) - 'a'] > a[ransomNote.charAt(k) - 'a'])
                return false;
        }
        return true;
    }
}