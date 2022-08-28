import javax.swing.tree.TreeNode;

class Solution {
	// µÝ¹é
	TreeNode max;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		// ×ó
		boolean left = isValidBST(root.left);
		if (!left) {
			return false;
		}
		// ÖÐ
		if (max != null && root.val <= max.val) {
			return false;
		}
		max = root;
		// ÓÒ
		boolean right = isValidBST(root.right);
		return right;
	}
}