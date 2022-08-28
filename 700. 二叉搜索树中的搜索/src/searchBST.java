import javax.swing.tree.TreeNode;

class Solution1 {
	// �ݹ飬���ö����������ص㣬�Ż�
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
	// ���������ö����������ص㣬�Ż������Բ���Ҫջ
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