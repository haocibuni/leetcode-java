import java.util.LinkedList;
import java.util.List;

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

//先序遍历加路径记录法 时间复杂度n 空间复杂度n
//先执行先序遍历，注意先序遍历的终止条件为节点为null，所以不用提前判断左右节点是否为null
//在先序遍历的过程中将节点的值加入到路径中，满足条件后加入到结果队列
//注意path列表的重新赋值和删除队尾节点
class Solution {
	LinkedList<List<Integer>> resList = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		recur(root, target);
		return resList;
	}

	public void recur(TreeNode root, int target) {
		if (root == null) {
			return;
		}
//		在路径中添加节点并执行判断
		path.add(root.val);
		target = target - root.val;
		if (target == 0 && root.left == null && root.right == null) {
			resList.add(new LinkedList<>(path));
		}
		recur(root.left, target);
		recur(root.right, target);
//		将该节点删除，进行回溯
		path.removeLast();

	}
}