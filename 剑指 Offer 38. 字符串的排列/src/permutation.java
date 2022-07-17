import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//回溯法 时间复杂度n!n 空间复杂度n2
class Solution {
	List<String> res = new LinkedList<>();
	char[] c;

	public String[] permutation(String s) {
//		首先将字符串转化为字符数组，字符数组为全局变量
		c = s.toCharArray();
//		然后进行深度搜索遍历
		dfs(0);
//		最后将字符串链表转换为字符串数组返回
		return res.toArray(new String[res.size()]);

	}

	void dfs(int x) {
//		终止条件，索引到最后一位,将字符数组添加到字符串链表
		if (x == c.length - 1) {
			res.add(String.valueOf(c));
			return;
		}
//		初始化集合
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if (set.contains(c[i])) {
				continue;
			}
			set.add(c[i]);
			swap(i, x);
			dfs(x + 1);
			swap(i, x);

		}
	}

//  交换字符数组的对应索引
	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}

class Solution_recall {
	List<String> reStrings = new LinkedList<>();
	char[] c;

	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return reStrings.toArray(new String[reStrings.size()]);
	}

	void dfs(int x) {
		if (x == c.length - 1) {
			reStrings.add(String.valueOf(c));
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if (set.contains(c[i])) {

				continue;
			}
			set.add(c[i]);
			swap(i, x);
			dfs(x + 1);
			swap(i, x);
		}
	}

	void swap(int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
}