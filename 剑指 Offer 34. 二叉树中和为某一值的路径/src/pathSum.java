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

//���������·����¼�� ʱ�临�Ӷ�n �ռ临�Ӷ�n
//��ִ�����������ע�������������ֹ����Ϊ�ڵ�Ϊnull�����Բ�����ǰ�ж����ҽڵ��Ƿ�Ϊnull
//����������Ĺ����н��ڵ��ֵ���뵽·���У�������������뵽�������
//ע��path�б�����¸�ֵ��ɾ����β�ڵ�
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
//		��·������ӽڵ㲢ִ���ж�
		path.add(root.val);
		target = target - root.val;
		if (target == 0 && root.left == null && root.right == null) {
			resList.add(new LinkedList<>(path));
		}
		recur(root.left, target);
		recur(root.right, target);
//		���ýڵ�ɾ�������л���
		path.removeLast();

	}
}