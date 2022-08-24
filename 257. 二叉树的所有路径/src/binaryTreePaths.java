import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

//�ⷨһ
class Solution {
	/**
	 * �ݹ鷨
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<Integer> paths = new ArrayList<>();
		traversal(root, paths, res);
		return res;
	}

	private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
		paths.add(root.val);
		// Ҷ�ӽ��
		if (root.left == null && root.right == null) {
			// ���
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < paths.size() - 1; i++) {
				sb.append(paths.get(i)).append("->");
			}
			sb.append(paths.get(paths.size() - 1));
			res.add(sb.toString());
			return;
		}
		if (root.left != null) {
			traversal(root.left, paths, res);
			paths.remove(paths.size() - 1);// ����
		}
		if (root.right != null) {
			traversal(root.right, paths, res);
			paths.remove(paths.size() - 1);// ����
		}
	}
}

//�ⷨ2
class Solution {
	/**
	 * ������
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<Object> stack = new Stack<>();
		// �ڵ��·��ͬʱ��ջ
		stack.push(root);
		stack.push(root.val + "");
		while (!stack.isEmpty()) {
			// �ڵ��·��ͬʱ��ջ
			String path = (String) stack.pop();
			TreeNode node = (TreeNode) stack.pop();
			// ���ҵ�Ҷ�ӽڵ�
			if (node.left == null && node.right == null) {
				result.add(path);
			}
			// ���ӽڵ㲻Ϊ��
			if (node.right != null) {
				stack.push(node.right);
				stack.push(path + "->" + node.right.val);
			}
			// ���ӽڵ㲻Ϊ��
			if (node.left != null) {
				stack.push(node.left);
				stack.push(path + "->" + node.left.val);
			}
		}
		return result;
	}
}