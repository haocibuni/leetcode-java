import javax.swing.tree.TreeNode;

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) { // �ݹ��������
			return root;
		}

		// �������
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null) { // ��δ�ҵ��ڵ� p �� q
			return null;
		} else if (left == null && right != null) { // ���ҵ�һ���ڵ�
			return right;
		} else if (left != null && right == null) { // ���ҵ�һ���ڵ�
			return left;
		} else { // ���ҵ������ڵ�
			return root;
		}
	}
}