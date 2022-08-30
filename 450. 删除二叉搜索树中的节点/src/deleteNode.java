import javax.swing.tree.TreeNode;

class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
		root = delete(root, key);
		return root;
	}

	private TreeNode delete(TreeNode root, int key) {
		if (root == null)
			return null;

		if (root.val > key) {
			root.left = delete(root.left, key);
		} else if (root.val < key) {
			root.right = delete(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
			TreeNode tmp = root.right;
			while (tmp.left != null) {
				tmp = tmp.left;
			}
			root.val = tmp.val;
			root.right = delete(root.right, tmp.val);
		}
		return root;
	}
}

class Solution1 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val == key) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				TreeNode cur = root.right;
				while (cur.left != null) {
					cur = cur.left;
				}
				cur.left = root.left;
				root = root.right;
				return root;
			}
		}
		if (root.val > key)
			root.left = deleteNode(root.left, key);
		if (root.val < key)
			root.right = deleteNode(root.right, key);
		return root;
	}
}