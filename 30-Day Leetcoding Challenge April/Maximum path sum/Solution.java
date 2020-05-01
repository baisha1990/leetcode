/*Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42*/

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
    public int maxPathSum(TreeNode root) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSum(root, res);
        return res.val;
    }
    
    public int maxPathSum(TreeNode root, Res res) {
        if(root == null)
            return 0;
        
        int l = maxPathSum(root.left, res);
        int r = maxPathSum(root.right, res);
        
        int max_one = Math.max(Math.max(l, r) + root.val, root.val);
        
        int max_all = Math.max(max_one, l + r + root.val);
        
        res.val = Math.max(res.val, max_all);
        
        return max_one;
    }
    
    public class Res {
        public int val;
    }
}