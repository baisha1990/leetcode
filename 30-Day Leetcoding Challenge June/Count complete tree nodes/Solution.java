/*Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at 
the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l = new ArrayList<>();
    public int countNodes(TreeNode root) {
        countHelper(root, l); 
        return l.size();
    }
    
    void countHelper(TreeNode root, List<Integer> l) {
        if(root != null) {
            l.add(root.val);
            countHelper(root.left, l);
            countHelper(root.right, l);
        }
    }
}