import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int leftValue = sumOfLeftLeaves(root.left); // ×ó
		int rightValue = sumOfLeftLeaves(root.right); // ÓÒ

		int midValue = 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			midValue = root.left.val;
		}
		int sum = midValue + leftValue + rightValue; // ÖÐ
		return sum;
	}
}

class Solution1 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		int result = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null && node.left.left == null && node.left.right == null) {
				result += node.left.val;
			}
			if (node.right != null)
				stack.add(node.right);
			if (node.left != null)
				stack.add(node.left);
		}
		return result;
	}
}