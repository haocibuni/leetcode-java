
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//������ ʱ�临�Ӷ�n �ռ临�Ӷ�1
//����������ȵĶ��壺 ��ڵ� rootroot Ϊ�ڵ� p,q ��ĳ�������ȣ�
//�������ӽڵ� root.leftroot.left �����ӽڵ� root.rightroot.right ������ p,q �Ĺ������ȣ�
//��� rootroot �� ������Ĺ������ȡ� ��
//�������
//�����ڵ��ڹ������ȵ�����
//pΪ�������ȣ���q��p������������������
//qΪ�������ȣ���p��q������������������
class Solution_for {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val < p.val && root.val < q.val) // p,q ���� root ����������
				root = root.right; // ���������ӽڵ�
			else if (root.val > p.val && root.val > q.val) // p,q ���� root ����������
				root = root.left; // ���������ӽڵ�
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
