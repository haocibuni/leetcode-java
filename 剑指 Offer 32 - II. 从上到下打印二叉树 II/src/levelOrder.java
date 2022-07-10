import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new Queue<TreeNode>() { root;
		};
		temp.add(root.val);
		res.add(temp);
		while(!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			temp.add(root.val);
			if () {
				
			}
			
		}

	}
}