
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

class Solution {
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
//		左右节点相连
		if (root.left != null) {
			root.left.next = root.right;
		}
//		跨节点相连，先序遍历父节点肯定连接
		if (root.right != null) {
			if (root.next != null) {
				root.right.next = root.next.left;
			} else {
				root.next = null;
			}
		}
//		重连左右
		root.left = connect(root.left);
		root.right = connect(root.right);
//		返回root
		return root;

	}
}