import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
	// 递归
	TreeNode max;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		// 左
		boolean left = isValidBST(root.left);
		if (!left) {
			return false;
		}
		// 中
		if (max != null && root.val <= max.val) {
			return false;
		}
		max = root;
		// 右
		boolean right = isValidBST(root.right);
		return right;
	}
}

class Solution1 {
	// 迭代
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;// 左
			}
			// 中，处理
			TreeNode pop = stack.pop();
			if (pre != null && pop.val <= pre.val) {
				return false;
			}
			pre = pop;

			root = pop.right;// 右
		}
		return true;
	}
}