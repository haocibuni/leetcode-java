import java.util.ArrayDeque;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	/**
	 * ǰ������������� �����У���Ϊ�����ӽ������ӣ��ٸ��������ӣ�������Һ����Ѿ������ԭ�������ӣ������Һ��ӽ������ӣ���ʱ��ʵ�Ƕ�ԭ����������������
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		invertTree(root.left);
		invertTree(root.right);
		swapChildren(root);
		return root;
	}

	private void swapChildren(TreeNode root) {
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}
}

// BFS
class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayDeque<TreeNode> deque = new ArrayDeque<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size-- > 0) {
				TreeNode node = deque.poll();
				swap(node);
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
			}
		}
		return root;
	}

	public void swap(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}