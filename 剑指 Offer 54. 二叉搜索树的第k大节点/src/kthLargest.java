public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//中序遍历的倒序法 时间复杂度n 空间复杂度n
//设全局变量res和k
class Solution {
	int res, k;

	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	void dfs(TreeNode root) {
//		若第k大节点为右节点,则返回res后,左节点依然会继续递归,所以在k<=0后其它节点也可终止
		if (root == null || k <= 0) {
			return;
		}
		dfs(root.right);
//		若当前节点为第k大节点则
		if (--k == 0) {
			res = root.val;
			return;

		}
		dfs(root.left);
	}
}