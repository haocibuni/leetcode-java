
class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};

//中序遍历法 时间复杂度为n 空间复杂度为n
//由中序遍历来获取二叉搜索树的顺序
//然后由前驱节点pre和当前节点cur来进行连接
class Solution {
	Node pre, head;

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		dfs(root);
//		循环双向链表
		head.left = pre;
		pre.right = head;
		return head;

	}

	void dfs(Node cur) {
//		中序遍历终止条件
		if (cur == null) {
			return;
		}
//		左节点操作
		dfs(cur.left);
//		当前节点的操作
//		如果没有前驱节点，说明当前节点为表头节点
//		若由前驱pre节点，则pre节点和cur节点来连接，然后pre节点变为cur节点
//		cur节点不需要重新指向
		if (pre != null) {
			pre.right = cur;
		} else {
			head = cur;
		}
		cur.left = pre;
		pre = cur;
//		右节点操作
		dfs(cur.right);
	}
}