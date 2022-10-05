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

//后序遍历 以子节点状态给父节点赋值状态
class Solution {
//	监控数量
	int result = 0;

	public int minCameraCover(TreeNode root) {
//		递归，并判断根节点状态，若根节点无覆盖，则在根节点添加监控
		if (recur(root) == 0) {
			result++;
		}
		return result;
	}

	public int recur(TreeNode root) {
//		若当前节点为null，则标记为覆盖状态
		if (root == null) {
			return 2;
		}
//		递归遍历左右子树
		int left = recur(root.left);
		int right = recur(root.right);
//		如果左右节点都被覆盖，则本节点状态为无覆盖
		if (left == 2 && right == 2) {
			return 0;
//		若左或右无覆盖 或 都无覆盖，则本节点增加监控，状态为1
		} else if (left == 0 || right == 0) {
			result++;
			return 1;
//		其它情况都为覆盖状态
		} else {
			return 2;
		}
	}
}