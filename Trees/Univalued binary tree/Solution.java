/*A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.
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
    public boolean isUnivalTree(TreeNode root) {
		return dfs(root, root.val);
	}
	
	public boolean dfs(TreeNode root, int r) {
		if(root == null) return true;
		if(root.val != r) return false;
		return dfs(root.left, r) && dfs(root.right, r);
	}
}