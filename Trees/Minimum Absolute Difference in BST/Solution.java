/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
*/

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
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return -1;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < l.size(); i++) {
            min = Math.min(min, l.get(i) - l.get(i - 1));
        }
        return min;
    }
    public void dfs(TreeNode root, List<Integer> l) {
        if(root != null) {
            dfs(root.left, l);
            l.add(root.val);
            dfs(root.right, l);
        }
    }
}