/*Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.*/

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] table;
    int buckets = 1000;
    int itemsperbucket = 1000;
    
    public MyHashSet() {
        table = new boolean[buckets][];
    }
    
    private int hash(int key) {
        return key % buckets;
    }
    
    private int pos(int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int hashKey = hash(key);
        
        if(table[hashKey] == null)
            table[hashKey] = new boolean[itemsperbucket];
        
        table[hashKey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        
        if(table[hashKey] != null)
            table[hashKey][pos(key)] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = hash(key);
        
        return table[hashKey] != null && table[hashKey][pos(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */