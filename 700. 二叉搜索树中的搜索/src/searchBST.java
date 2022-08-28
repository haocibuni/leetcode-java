import javax.swing.tree.TreeNode;

class Solution1 {
	// 递归，利用二叉搜索树特点，优化
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null || root.val == val) {
			return root;
		}
		if (val < root.val) {
			return searchBST(root.left, val);
		} else {
			return searchBST(root.right, val);
		}
	}
}

class Solution {
	// 迭代，利用二叉搜索树特点，优化，可以不需要栈
	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null)
			if (val < root.val)
				root = root.left;
			else if (val > root.val)
				root = root.right;
			else
				return root;
		return null;
	}
}