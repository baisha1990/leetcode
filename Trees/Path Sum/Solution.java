/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null && sum-root.val == 0) return true;
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}
}