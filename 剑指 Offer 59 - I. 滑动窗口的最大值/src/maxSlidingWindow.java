import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//������ ���� �������ڴ�С��ȷ��
class Solution_force {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0||k=0) {
			return new int[0];
		}
		int i = 0, j = k - 1;
		List<Integer> res = new ArrayList<>();
		while (j < nums.length) {
			res.add(Math.max(nums[i], Math.max(nums[i + 1], nums[j])));
			i++;
			j++;
		}
		int[] arr = new int[res.size()];
		for (int l = 0; l < res.size(); l++) {
			arr[l] = res.get(l);
		}
		return arr;
	}
}

//���з� 
//��߽��1-k��ʼ �ұ߽��0��ʼ
//��������Ѿ�����������һλ�����ж϶������ֵ�Ƿ�����߽��ǰһ��Ԫ�أ��������Ƴ����е����Ԫ��
//���۴����Ƿ����������ѱȵ�ǰֵС��Ԫ��ȥ����Ȼ����ӵ�ǰԪ�أ��γ�һ�������С�Ķ���
//��������Ѿ�����������߽�Ԫ����ӵ�res����
class Solution_queue {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
			if (i > 0 && deque.peekFirst() == nums[i - 1]) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
				deque.removeLast();
			}
			deque.addLast(nums[j]);
			if (i >= 0) {
				res[i] = deque.peekFirst();
			}
		}
		return res;

	}
}