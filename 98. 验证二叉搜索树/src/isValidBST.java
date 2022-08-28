import javax.swing.tree.TreeNode;

class Solution {
	// �ݹ�
	TreeNode max;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		// ��
		boolean left = isValidBST(root.left);
		if (!left) {
			return false;
		}
		// ��
		if (max != null && root.val <= max.val) {
			return false;
		}
		max = root;
		// ��
		boolean right = isValidBST(root.right);
		return right;
	}
}