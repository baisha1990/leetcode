/*Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

 

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            TreeNode h = s.pop();
            if(h != null) {
                sb.append(h.val + ",");
                s.push(h.right);
                s.push(h.left);
            }
            else 
                sb.append("#,");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        int[] t = {0};
        String[] a = data.split(",");
        return helper(a, t);
    }
    
    public TreeNode helper(String[] a, int[] t) {
        if(a[t[0]].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(a[t[0]]));
        t[0]++;
        root.left = helper(a, t);
        t[0]++;
        root.right = helper(a, t);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;