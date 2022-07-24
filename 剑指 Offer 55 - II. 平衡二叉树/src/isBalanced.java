
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//后序遍历加剪枝法 时间复杂度n 空间复杂度n
class Solution_DFS {
	boolean res = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		dfs(root);
		return res;
	}

	public int dfs(TreeNode root) {
		if (root == null || res == false) {
			return 0;
		}

		int left = dfs(root.left);
		int right = dfs(root.right);
		if (Math.abs(left - right) > 1) {
			res = false;
		}
		return Math.max(left, right) + 1;
	}
}

//后序遍历加剪枝法 时间复杂度n 空间复杂度n
class Solution {
	public boolean isBalanced(TreeNode root) {
//    	若返回值不等于-1则表示该树成立
		return recur(root) != -1;
	}

	private int recur(TreeNode root) {
		if (root == null)
			return 0;
		int left = recur(root.left);
//      获取到左子树的深度后，若左子树有不平衡节点则直接返回，不需要再递归右子树
		if (left == -1)
			return -1;
		int right = recur(root.right);
//      获取到右子树的深度后，若右子树有不平衡节点则直接返回，不需要再判断左右子树的差值
		if (right == -1)
			return -1;
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
}