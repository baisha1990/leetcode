/*Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7*/
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val < key)
            root.right = deleteNode(root.right, key);
        else if(root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private int minVal(TreeNode root) {
        int min = root.val;
        while(root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}