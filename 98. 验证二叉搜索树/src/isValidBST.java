import java.util.Stack;

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

class Solution1 {
	// ����
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;// ��
			}
			// �У�����
			TreeNode pop = stack.pop();
			if (pre != null && pop.val <= pre.val) {
				return false;
			}
			pre = pop;

			root = pop.right;// ��
		}
		return true;
	}
}