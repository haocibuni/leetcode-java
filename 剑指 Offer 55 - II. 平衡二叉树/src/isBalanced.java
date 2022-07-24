
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//��������Ӽ�֦�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution_DFS {
	boolean res = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		dfs(root);
		return res;
	}

	public int dfs(TreeNode root) {
		if (root == null || res == false) {
			return 0;
		}

		int left = dfs(root.left);
		int right = dfs(root.right);
		if (Math.abs(left - right) > 1) {
			res = false;
		}
		return Math.max(left, right) + 1;
	}
}

//��������Ӽ�֦�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
class Solution {
	public boolean isBalanced(TreeNode root) {
//    	������ֵ������-1���ʾ��������
		return recur(root) != -1;
	}

	private int recur(TreeNode root) {
		if (root == null)
			return 0;
		int left = recur(root.left);
//      ��ȡ������������Ⱥ����������в�ƽ��ڵ���ֱ�ӷ��أ�����Ҫ�ٵݹ�������
		if (left == -1)
			return -1;
		int right = recur(root.right);
//      ��ȡ������������Ⱥ����������в�ƽ��ڵ���ֱ�ӷ��أ�����Ҫ���ж����������Ĳ�ֵ
		if (right == -1)
			return -1;
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
}