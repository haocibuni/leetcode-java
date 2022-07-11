import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//������ҷ� ����
class Solution_leveladd {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root != null) {
			queue.offer(root);
		}
		boolean flag = true;
		int num = 0;
		while (!queue.isEmpty()) {

			if (num == 2) {
				flag = !flag;
				num = 0;
			}
			num = num + 1;
			List<Integer> templist = new ArrayList<Integer>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode treeNode = queue.poll();
				templist.add(treeNode.val);
				if (flag) {
					if (treeNode.right != null) {
						queue.offer(treeNode.right);
					}
					if (treeNode.left != null) {
						queue.offer(treeNode.left);
					}

				} else {
					if (treeNode.left != null) {
						queue.offer(treeNode.left);
					}
					if (treeNode.right != null) {
						queue.offer(treeNode.right);

					}
				}

			}
			list.add(templist);

		}
		return list;

	}
}

//linkedlist��żǰ���巨 ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//����linkedlist��addLast��addFirst����
//ÿ�㶼��Ҫ����linkedlist�ж������㻹��ż����
class Solution_parity {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		boolean flag;
		while (!queue.isEmpty()) {
//			ÿ���������Ҫ��ʱlist
			LinkedList<Integer> temp = new LinkedList<>();
			if (res.size() % 2 == 0) {
				flag = true;
			} else {
				flag = false;
			}

			for (int i = queue.size(); i > 0; i--) {
//				ÿ��ѭ������Ҫ��ʱtreenode
				TreeNode tempNode = queue.poll();
				if (flag) {
					temp.addLast(tempNode.val);
				} else {
					temp.addFirst(tempNode.val);
				}
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			res.add(temp);
		}
		return res;

	}
}

//��ż���Ϸ� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ͨ��������ż������������һ��ѭ���Ӷ������ж�ÿ�����ż��
//����Ҫ����ż�м��������Ƿ�Ϊ�յ��жϺ������ʱ����Ĵ���
class Solution_parity_normalizing {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			LinkedList<Integer> temp = new LinkedList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode tempNode = queue.poll();
				temp.addLast(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			res.add(temp);
			if (queue.isEmpty()) {
				break;
			}
			temp = new LinkedList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode tempNode = queue.poll();
				temp.addFirst(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			res.add(temp);
		}
		return res;

	}
}

//��ת�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//����ÿ�����ż�ԣ���Ϊ�����㣬ͨ��Collections.reverse()������ת��ʱ����
class Solution_reverse {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		boolean flag;
		while (!queue.isEmpty()) {
//			ÿ���������Ҫ��ʱlist
			LinkedList<Integer> temp = new LinkedList<>();

			for (int i = queue.size(); i > 0; i--) {
//				ÿ��ѭ������Ҫ��ʱtreenode
				TreeNode tempNode = queue.poll();
				temp.offer(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			if (res.size() % 2 == 1) {
				Collections.reverse(temp);
			}
			res.add(temp);
		}
		return res;

	}
}