import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
//先左后右法 错误
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

//linkedlist奇偶前插后插法 时间复杂度为n 空间复杂度为n
//利用linkedlist的addLast和addFirst函数
//每层都需要借助linkedlist判断奇数层还是偶数层
class Solution_parity {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		boolean flag;
		while (!queue.isEmpty()) {
//			每次输出都需要临时list
			LinkedList<Integer> temp = new LinkedList<>();
			if (res.size() % 2 == 0) {
				flag = true;
			} else {
				flag = false;
			}

			for (int i = queue.size(); i > 0; i--) {
//				每次循环都需要临时treenode
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

//奇偶整合法 时间复杂度n 空间复杂度n
//通过将奇数偶数层的情况放入一个循环从而不用判断每层的奇偶性
//但需要在奇偶中间插入队列是否为空的判断和清空临时数组的代码
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

//反转法 时间复杂度n 空间复杂度n
//根据每层的奇偶性，若为奇数层，通过Collections.reverse()函数反转临时数组
class Solution_reverse {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		boolean flag;
		while (!queue.isEmpty()) {
//			每次输出都需要临时list
			LinkedList<Integer> temp = new LinkedList<>();

			for (int i = queue.size(); i > 0; i--) {
//				每次循环都需要临时treenode
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