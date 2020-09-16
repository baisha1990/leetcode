/*Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.*/

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for(int n : nums)
            max = Math.max(max, n);
        int L = (Integer.toBinaryString(max)).length();
        int n = nums.length, bit = 1 << L;
        String[] str = new String[n];
        for(int i = 0; i < n; i++)
            str[i] = Integer.toBinaryString(bit | nums[i]).substring(1);
        
        TrieNode trie = new TrieNode();
        int m = 0;
        for(String num : str) {
            TrieNode node = trie, xorNode = trie;
            int cur = 0;
            for(Character b : num.toCharArray()) {
                if(node.map.containsKey(b))
                    node = node.map.get(b);
                else {
                    TrieNode newNode = new TrieNode();
                    node.map.put(b, newNode);
                    node = newNode;
                }
                
                Character t = b == '1' ? '0' : '1';
                if(xorNode.map.containsKey(t)) {
                    cur = (cur << 1) | 1;
                    xorNode = xorNode.map.get(t);
                } else {
                    cur = cur << 1;
                    xorNode = xorNode.map.get(b);
                }
            }
            m = Math.max(m, cur);
        }
        return m;
    }
}

class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    public TrieNode() {}
}