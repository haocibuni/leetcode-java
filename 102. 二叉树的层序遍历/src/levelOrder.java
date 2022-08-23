import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

class Solution {
	public List<List<Integer>> resList = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		// checkFun01(root,0);
		checkFun02(root);

		return resList;
	}

	// DFS--�ݹ鷽ʽ
	public void checkFun01(TreeNode node, Integer deep) {
		if (node == null)
			return;
		deep++;

		if (resList.size() < deep) {
			// ���㼶����ʱ��list��ItemҲ���ӣ�����list������ֵ���в㼶�綨
			List<Integer> item = new ArrayList<Integer>();
			resList.add(item);
		}
		resList.get(deep - 1).add(node.val);

		checkFun01(node.left, deep);
		checkFun01(node.right, deep);
	}

	// BFS--������ʽ--��������
	public void checkFun02(TreeNode node) {
		if (node == null)
			return;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(node);

		while (!que.isEmpty()) {
			List<Integer> itemList = new ArrayList<Integer>();
			int len = que.size();

			while (len > 0) {
				TreeNode tmpNode = que.poll();
				itemList.add(tmpNode.val);

				if (tmpNode.left != null)
					que.offer(tmpNode.left);
				if (tmpNode.right != null)
					que.offer(tmpNode.right);
				len--;
			}

			resList.add(itemList);
		}

	}
}