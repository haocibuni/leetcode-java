import java.util.ArrayList;

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

//中序遍历获取顺序数组 加二分查找先序构造二叉树
class Solution {
	ArrayList<Integer> list = new ArrayList<>();

	public void nodetolist(TreeNode root) {
		if (root == null) {
			return;
		}
		nodetolist(root.left);
		list.add(root.val);
		nodetolist(root.right);
	}

	public TreeNode twofind(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = twofind(left, mid - 1);
		root.right = twofind(mid + 1, right);
		return root;

	}

	public TreeNode balanceBST(TreeNode root) {
		nodetolist(root);
		return twofind(0, list.size() - 1);

	}
}