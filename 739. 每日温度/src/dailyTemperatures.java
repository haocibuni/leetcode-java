import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//������
class Solution1 {
	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
//		�ش�����
		int[] ans = new int[length];
//		��¼ÿ���¶ȵ�һ�γ��ֵ��±�
		int[] next = new int[101];
//		��ʼ��Ϊ���
		Arrays.fill(next, Integer.MAX_VALUE);
		for (int i = length - 1; i >= 0; --i) {
			int warmerIndex = Integer.MAX_VALUE;
			for (int t = temperatures[i] + 1; t <= 100; ++t) {
//				����һ������¶��±�
				if (next[t] < warmerIndex) {
					warmerIndex = next[t];
				}
			}
//			�������¶��±겻�����ֵ
			if (warmerIndex < Integer.MAX_VALUE) {
//				�򷵻�����±�-��ǰ�¶��±�
				ans[i] = warmerIndex - i;
			}
//			��ǰ�¶ȵ�ֵΪ�±�i
			next[temperatures[i]] = i;
		}
		return ans;
	}
}

//����ջ��
class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int length = temperatures.length;
//		�ش�����
		int[] ans = new int[length];
//		����ջ
		Deque<Integer> queue = new LinkedList<Integer>();
//		�±��ջ����ΪҪ��¼����º͵�ǰ���µĲ�ֵ
		queue.add(0);
		for (int i = 1; i < temperatures.length; i++) {
//			ջ��Ԫ�ش��ڵ��ڵ�ǰԪ�أ����ջ
			if (temperatures[i] <= temperatures[queue.peek()]) {
				queue.push(i);
			} else {
//				���򣬶�С�ڵ�ǰԪ�صĽ��г�ջ
				while (!queue.isEmpty() && temperatures[queue.peek()] < temperatures[i]) {
//					�±��Ӧ�Ļش�Ϊ��ǰ�±�-�±�
					ans[queue.peek()] = i - queue.peek();
					queue.poll();
				}
//				�������ջ
				queue.push(i);
			}
		}
		return ans;
	}
}
