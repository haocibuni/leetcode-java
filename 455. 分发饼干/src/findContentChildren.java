import java.util.Arrays;

class Solution {
	public int findContentChildren(int[] g, int[] s) {
//		��θ��g�ͱ���s���д�С��������
		Arrays.sort(g);
		Arrays.sort(s);
//		ѧ���±�
		int index = 0;
//		ι��ѧ��������
		int count = 0;
//		С������ι��Сθ��
		for (int i = 0; i < s.length && index < g.length; i++) {
			if (g[index] <= s[i]) {
				index++;
				count++;
			}
		}
		return count;
	}
}