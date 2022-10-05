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

//������� ���ӽڵ�״̬�����ڵ㸳ֵ״̬
class Solution {
//	�������
	int result = 0;

	public int minCameraCover(TreeNode root) {
//		�ݹ飬���жϸ��ڵ�״̬�������ڵ��޸��ǣ����ڸ��ڵ���Ӽ��
		if (recur(root) == 0) {
			result++;
		}
		return result;
	}

	public int recur(TreeNode root) {
//		����ǰ�ڵ�Ϊnull������Ϊ����״̬
		if (root == null) {
			return 2;
		}
//		�ݹ������������
		int left = recur(root.left);
		int right = recur(root.right);
//		������ҽڵ㶼�����ǣ��򱾽ڵ�״̬Ϊ�޸���
		if (left == 2 && right == 2) {
			return 0;
//		��������޸��� �� ���޸��ǣ��򱾽ڵ����Ӽ�أ�״̬Ϊ1
		} else if (left == 0 || right == 0) {
			result++;
			return 1;
//		���������Ϊ����״̬
		} else {
			return 2;
		}
	}
}