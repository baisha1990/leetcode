/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be 
constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for(int i = 0; i < ransomNote.length(); i++) {
            m1[ransomNote.charAt(i)]++;
        }
        
        for(int j = 0; j < magazine.length(); j++) {
            m2[magazine.charAt(j)]++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            if(m1[ransomNote.charAt(i)] > m2[ransomNote.charAt(i)]) return false;
        }
        
        return true;
    }
}