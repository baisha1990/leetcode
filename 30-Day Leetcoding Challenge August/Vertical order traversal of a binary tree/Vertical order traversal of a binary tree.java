/*Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom 
(decreasing Y coordinates). If two nodes have the same position, then the value of the node that is reported first is the value that is smaller. Return an list of non-empty 
reports in order of X coordinate.  Every report will have a list of values of nodes.
 
Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 
Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.*/

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
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    int minX = 0, maxX = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> v = new ArrayList<>();
        for(int i = minX; i <= maxX; i++) {
            List<Integer> l = new ArrayList<>();
            for(int key : map.get(i).keySet()) {
                while(!(map.get(i).get(key)).isEmpty()) {
                    l.add(map.get(i).get(key).poll());
                }
            }
            v.add(l);
        }
        return v;
    }
    
    private void helper(TreeNode node, int x, int y) {
        if(node == null)
            return;
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        if(map.get(x) == null) {
            map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
        }
        if(map.get(x).get(y) == null) {
            map.get(x).put(y, new PriorityQueue<Integer>());
        }
        map.get(x).get(y).add(node.val);
        helper(node.left, x-1, y+1);
        helper(node.right, x+1, y+1);
    }
}