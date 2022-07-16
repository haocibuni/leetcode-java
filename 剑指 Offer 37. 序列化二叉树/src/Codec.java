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

//��α����� ʱ�临�Ӷ�Ϊn �ռ临�Ӷ�Ϊn
//���л�ʱ��ע��ڵ�Ϊnullʱ����ַ�������Ϊnullʱ������ֺ��ڶ�������ӽڵ�
//ȫ�����Ӻ�ɾ�����ģ������]
//��������null�ڵ��Ƕ������Ӱ�죬��[1,2,3,null,null,4,5,null,null,null,null]
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "[]";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		Queue<TreeNode> queue = new LinkedList<>() {
			{
				add(root);
			}
		};
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				stringBuilder.append("null");
			} else {
				stringBuilder.append(node.val);
				queue.add(node.left);
				queue.add(node.right);
			}
			stringBuilder.append(",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	// Decodes your encoded data to tree.
//	���Ƚ��ַ���ת��Ϊ�ַ�������
//	Ȼ���׸��ַ���ת��Ϊ�����Խڵ���ʽ��ӵ�����
//	Ȼ����г�����Ӳ���
//	�ַ����������ʼ�±�Ϊ1����Ϊ����0���ַ��Ѿ���ջ
	public TreeNode deserialize(String data) {
		if (data.equals("[]")) {
			return null;
		}
//		endindexΪ����ǰһЩֵ
		String[] valStrings = data.substring(1, data.length() - 1).split(",");
		TreeNode root = new TreeNode(Integer.parseInt(valStrings[0]));
		Queue<TreeNode> queue = new LinkedList<>() {
			{
				add(root);
			}
		};
		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (!valStrings[i].equals("null")) {
				node.left = new TreeNode(Integer.parseInt(valStrings[i]));
				queue.add(node.left);
			}
			i++;
			if (!valStrings[i].equals("null")) {
				node.right = new TreeNode(Integer.parseInt(valStrings[i]));
				queue.add(node.right);
			}
			i++;
		}
		return root;

	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));