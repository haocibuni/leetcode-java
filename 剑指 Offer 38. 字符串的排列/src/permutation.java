import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//���ݷ� ʱ�临�Ӷ�n!n �ռ临�Ӷ�n2
class Solution {
	List<String> res = new LinkedList<>();
	char[] c;

	public String[] permutation(String s) {
//		���Ƚ��ַ���ת��Ϊ�ַ����飬�ַ�����Ϊȫ�ֱ���
		c = s.toCharArray();
//		Ȼ����������������
		dfs(0);
//		����ַ�������ת��Ϊ�ַ������鷵��
		return res.toArray(new String[res.size()]);

	}

	void dfs(int x) {
//		��ֹ���������������һλ,���ַ�������ӵ��ַ�������
		if (x == c.length - 1) {
			res.add(String.valueOf(c));
			return;
		}
//		��ʼ������
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

//  �����ַ�����Ķ�Ӧ����
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