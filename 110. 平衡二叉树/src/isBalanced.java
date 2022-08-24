import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
	/**
	 * �ݹ鷨
	 */
	public boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = getHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		// ���������߶Ȳ����1��return -1��ʾ�Ѿ�����ƽ������
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

class Solution {
	/**
	 * ��������Ч�ʽϵͣ�����߶�ʱ���ظ����� ʱ�临�Ӷȣ�O(n^2)
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode inNode = stack.peek();
			// �ҽ��Ϊnull���Ѿ�������
			if (inNode.right == null || inNode.right == pre) {
				// �Ƚ����������ĸ߶Ȳ���
				if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
					return false;
				}
				stack.pop();
				pre = inNode;
				root = null;// ��ǰ����£�û��Ҫ�����Ľ����
			} else {
				root = inNode.right;// �ҽ�㻹û�����������ҽ��
			}
		}
		return true;
	}

	/**
	 * �������������ĸ߶�
	 */
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		int depth = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode poll = deque.poll();
				if (poll.left != null) {
					deque.offer(poll.left);
				}
				if (poll.right != null) {
					deque.offer(poll.right);
				}
			}
		}
		return depth;
	}
}

class Solution {
	/**
	 * �Ż�����������Ա�����������getHeight�������Ż�������TreeNode.val�����浱ǰ���ĸ߶ȣ������Ͳ������ظ�����
	 * ��ȡ�߶��㷨ʱ�临�Ӷȿ��Խ���O(1)���ܵ�ʱ�临�ӶȽ�ΪO(n)�� ʱ�临�Ӷȣ�O(n)
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode inNode = stack.peek();
			// �ҽ��Ϊnull���Ѿ�������
			if (inNode.right == null || inNode.right == pre) {
				// ���
				if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
					return false;
				}
				stack.pop();
				pre = inNode;
				root = null;// ��ǰ����£�û��Ҫ�����Ľ����
			} else {
				root = inNode.right;// �ҽ�㻹û�����������ҽ��
			}
		}
		return true;
	}

	/**
	 * ����ĸ߶�
	 */
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = root.left != null ? root.left.val : 0;
		int rightHeight = root.right != null ? root.right.val : 0;
		int height = Math.max(leftHeight, rightHeight) + 1;
		root.val = height;// ��TreeNode.val�����浱ǰ���ĸ߶�
		return height;
	}
}