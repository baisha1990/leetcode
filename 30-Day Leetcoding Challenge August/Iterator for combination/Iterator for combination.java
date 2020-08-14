/*Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.*/

class CombinationIterator {

    private String s;
    Queue<String> q;
    
    private void updateCombo(int start, int l, StringBuilder sb) {
        if(l == 0) {
            q.add(sb.toString());
            return;
        }
        for(int i = start; i <= s.length() - l; i++) {
            sb.append(s.charAt(i));
            updateCombo(i+1, l-1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        q = new LinkedList();
        
        updateCombo(0, combinationLength, new StringBuilder());
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */