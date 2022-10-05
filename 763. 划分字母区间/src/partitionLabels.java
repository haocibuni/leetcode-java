import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> partitionLabels(String s) {
//		һά���ͽ������
		List<Integer> result = new ArrayList<>();
//		26����ĸ���һ�����±�
		int[] edge = new int[26];
//		���ַ���ת��Ϊ�ַ�����
		char[] chars = s.toCharArray();
//		��������ĸ������±�
		for (int i = 0; i < chars.length; i++) {
			edge[chars[i] - 'a'] = i;
		}
		int idx = 0;
		int last = -1;
//		��ͷ�����ַ��������µ�ǰ��������±�
		for (int i = 0; i < chars.length; i++) {

			idx = Math.max(idx, edge[chars[i] - 'a']);
//			����ǰ��������±���ڵ�ǰ�±������
			if (idx == i) {
				result.add(i - last);
				last = i;
			}
		}
		return result;
	}
}