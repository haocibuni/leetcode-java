
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//迭代法 时间复杂度n 空间复杂度1
//最近公共祖先的定义： 设节点 rootroot 为节点 p,q 的某公共祖先，
//若其左子节点 root.leftroot.left 和右子节点 root.rightroot.right 都不是 p,q 的公共祖先，
//则称 rootroot 是 “最近的公共祖先” 。
//三种情况
//两个节点在公共祖先的两侧
//p为公共祖先，且q在p的左子树或者右子树
//q为公共祖先，且p在q的左子树或者右子树
class Solution_for {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
				root = root.right; // 遍历至右子节点
			else if (root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
				root = root.left; // 遍历至左子节点
			else
				break;
		}
		return root;
	}
}

class Solution_recur {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		return root;
	}
}
