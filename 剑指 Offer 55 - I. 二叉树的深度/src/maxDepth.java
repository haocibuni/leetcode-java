import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//层次遍历法 时间复杂度n 空间复杂度n
//temp队列临时存储下一层节点，获取下一层节点后，将queue直接赋值为temp队列
class Solution_BFS {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>(), temp;
		queue.offer(root);
		while (!queue.isEmpty()) {
			temp = new LinkedList<>();
			for (TreeNode node : queue) {
				if (node.left != null) {
					temp.offer(node.left);
				}
				if (node.right != null) {
					temp.offer(node.right);
				}
			}
			res++;
			queue = temp;
		}
		return res;

	}
}
//深度遍历法 时间复杂度n 空间复杂度n
//递归实现深度遍历，获取每个节点左子树和右子树层数的最大值并加上当前节点的层次
class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		
	}

	
		
	}
}