/*Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.*/

class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int index = (int)(c - 'a');
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    public boolean find(String word, TrieNode cur, int index) {
        if(index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(cur.children[i] != null && find(word, cur.children[i], index+1))
                    return true;
            }
            return false;
        } else {
            return cur.children[c - 'a'] != null && find(word, cur.children[c-'a'], index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */