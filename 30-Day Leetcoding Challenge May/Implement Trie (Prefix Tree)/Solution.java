/*Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/

class TrieNode {
    TrieNode[] arr;
    boolean isEnd;
        
    public TrieNode() {
        arr = new TrieNode[26];
    }
}

class Trie {

    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.arr[index] == null) {
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }
            else
                p = p.arr[index];
        }
        p.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p == null) 
            return false;
        if(p.isEnd)
            return true;
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p == null)
            return false;
        else
            return true;
    }
    
    public TrieNode searchNode(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(p.arr[index] != null)
                p = p.arr[index];
            else
                return null;
        }
        if(p == root)
            return null;
        return p;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */