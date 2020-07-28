/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/
   
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;
        int i = inorder.length - 1, p = postorder.length - 1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[p]);
        stack.push(root);
        p--;
        
        while(p >= 0) {
            while(!stack.isEmpty() && stack.peek().val == inorder[i]) {
                prev = stack.pop();
                i--;
            }
            TreeNode newNode = new TreeNode(postorder[p]);
            if(prev != null)
                prev.left = newNode;
            else if(!stack.isEmpty()) {
                TreeNode curr = stack.peek();
                curr.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            p--;
        }
        return root;
    }
}