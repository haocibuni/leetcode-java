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

//层次遍历法 时间复杂度为n 空间复杂度为n
//序列化时需注意节点为null时添加字符串，不为null时添加数字和在队列中添加节点
//全部出队后删除最后的，并添加]
//当最后存在null节点是对输出无影响，如[1,2,3,null,null,4,5,null,null,null,null]
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
//	首先将字符串转化为字符串数组
//	然后将首个字符串转化为数字以节点形式添加到队列
//	然后进行出队入队操作
//	字符串数组的起始下标为1，因为索引0的字符已经入栈
	public TreeNode deserialize(String data) {
		if (data.equals("[]")) {
			return null;
		}
//		endindex为索引前一些值
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