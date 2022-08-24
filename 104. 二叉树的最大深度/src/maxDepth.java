import javax.swing.tree.TreeNode;

class solution {
	/**
	 * �ݹ鷨
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}
}