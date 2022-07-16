
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

//��������� ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//�������������ȡ������������˳��
//Ȼ����ǰ���ڵ�pre�͵�ǰ�ڵ�cur����������
class Solution {
	Node pre, head;

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		dfs(root);
//		ѭ��˫������
		head.left = pre;
		pre.right = head;
		return head;

	}

	void dfs(Node cur) {
//		���������ֹ����
		if (cur == null) {
			return;
		}
//		��ڵ����
		dfs(cur.left);
//		��ǰ�ڵ�Ĳ���
//		���û��ǰ���ڵ㣬˵����ǰ�ڵ�Ϊ��ͷ�ڵ�
//		����ǰ��pre�ڵ㣬��pre�ڵ��cur�ڵ������ӣ�Ȼ��pre�ڵ��Ϊcur�ڵ�
//		cur�ڵ㲻��Ҫ����ָ��
		if (pre != null) {
			pre.right = cur;
		} else {
			head = cur;
		}
		cur.left = pre;
		pre = cur;
//		�ҽڵ����
		dfs(cur.right);
	}
}