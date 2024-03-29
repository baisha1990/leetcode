/*Given an n-ary tree, return the postorder traversal of its nodes' values.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> postorder(Node root) {
		if(root == null) return l;
		for(Node child : root.children) {
			postorder(child);
		}
		l.add(root.val);
		return l;
	}
}