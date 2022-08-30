import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
	TreeNode pre;// ��¼��һ�������Ľ��
	int result = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;
		traversal(root);
		return result;
	}

	public void traversal(TreeNode root) {
		if (root == null)
			return;
		// ��
		traversal(root.left);
		// ��
		if (pre != null) {
			result = Math.min(result, root.val - pre.val);
		}
		pre = root;
		// ��
		traversal(root.right);
	}
}

class Solution1 {
	TreeNode pre;
	Stack<TreeNode> stack;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;
		stack = new Stack<>();
		TreeNode cur = root;
		int result = Integer.MAX_VALUE;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur); // �����ʵĽڵ�Ž�ջ
				cur = cur.left; // ��
			} else {
				cur = stack.pop();
				if (pre != null) { // ��
					result = Math.min(result, cur.val - pre.val);
				}
				pre = cur;
				cur = cur.right; // ��
			}
		}
		return result;
	}
}