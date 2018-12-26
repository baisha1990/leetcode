/*Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/

/*
// Definition for a Node.
class Node {
    public int val;max = 
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int max = 0;
    public int maxDepth(Node root) {
		if(root == null) return 0;
		dfs(root, 1);
		return max;
	}
	
	public void dfs(Node root, int depth) {
		max = Math.max(max, depth);
		for(Node node : root.children)
			dfs(node, depth+1);
	}
}