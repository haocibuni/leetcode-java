
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
	public int rob(TreeNode root) {
		int[] res = robhelp(root);
		return Math.max(res[0], res[1]);
	}

//  后序遍历
	public int[] robhelp(TreeNode root) {
		int[] res = new int[2];
//		若当前节点为空，则偷与不偷都为0
		if (root == null) {
			return res;
		}
//		左节点偷与不偷的金额
		int[] left = robhelp(root.left);
//		右节点偷与不偷的金额
		int[] right = robhelp(root.right);
//		不偷当前节点，则选取左右节点的最大值
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//		偷当前节点
		res[1] = left[0] + right[0] + root.val;
		return res;
	}
}