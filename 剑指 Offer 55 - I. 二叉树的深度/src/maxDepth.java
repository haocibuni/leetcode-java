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

//��α����� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//temp������ʱ�洢��һ��ڵ㣬��ȡ��һ��ڵ�󣬽�queueֱ�Ӹ�ֵΪtemp����
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
//��ȱ����� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//�ݹ�ʵ����ȱ�������ȡÿ���ڵ������������������������ֵ�����ϵ�ǰ�ڵ�Ĳ��
class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		
	}

	
		
	}
}