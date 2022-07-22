public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//��������ĵ��� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//��ȫ�ֱ���res��k
class Solution {
	int res, k;

	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	void dfs(TreeNode root) {
//		����k��ڵ�Ϊ�ҽڵ�,�򷵻�res��,��ڵ���Ȼ������ݹ�,������k<=0�������ڵ�Ҳ����ֹ
		if (root == null || k <= 0) {
			return;
		}
		dfs(root.right);
//		����ǰ�ڵ�Ϊ��k��ڵ���
		if (--k == 0) {
			res = root.val;
			return;

		}
		dfs(root.left);
	}
}