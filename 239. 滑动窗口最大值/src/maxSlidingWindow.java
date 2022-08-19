import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
	Deque<Integer> deque = new LinkedList<>();

	// ����Ԫ��ʱ���Ƚϵ�ǰҪ��������ֵ�Ƿ���ڶ��г��ڵ���ֵ���������򵯳�
	// ͬʱ�ж϶��е�ǰ�Ƿ�Ϊ��
	void poll(int val) {
		if (!deque.isEmpty() && val == deque.peek()) {
			deque.poll();
		}
	}

	// ���Ԫ��ʱ�����Ҫ��ӵ�Ԫ�ش�����ڴ���Ԫ�أ��ͽ����Ԫ�ص���
	// ��֤����Ԫ�ص����ݼ�
	// �����ʱ����Ԫ��3,1��2��Ҫ��ӣ���1������1��������ʱ���У�3,2
	void add(int val) {
		while (!deque.isEmpty() && val > deque.getLast()) {
			deque.removeLast();
		}
		deque.add(val);
	}

	// ���жӶ�Ԫ��ʼ��Ϊ���ֵ
	int peek() {
		return deque.peek();
	}
}

class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 1) {
			return nums;
		}
		int len = nums.length - k + 1;
		// ��Ž��Ԫ�ص�����
		int[] res = new int[len];
		int num = 0;
		// �Զ������
		MyQueue myQueue = new MyQueue();
		// �Ƚ�ǰk��Ԫ�ط������
		for (int i = 0; i < k; i++) {
			myQueue.add(nums[i]);
		}
		res[num++] = myQueue.peek();
		for (int i = k; i < nums.length; i++) {
			// ���������Ƴ���ǰ���Ԫ�أ��Ƴ����жϸ�Ԫ���Ƿ�������
			myQueue.poll(nums[i - k]);
			// �������ڼ���������Ԫ��
			myQueue.add(nums[i]);
			// ��¼��Ӧ�����ֵ
			res[num++] = myQueue.peek();
		}
		return res;
	}
}

//�ⷨ��
//����˫�˶����ֶ�ʵ�ֵ�������
/**
 * ��һ�������������洢��Ӧ���±꣬ÿ�����ڻ�����ʱ��ֱ��ȡ���е�ͷ��ָ���Ӧ��ֵ������������ ������������ ��tail -->�� 3 --> 2 -->
 * 1 --> 0 (--> head) (�ұ�Ϊͷ��㣬Ԫ�ش�����±�)
 */
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			// �������⣬iΪnums�±꣬��Ҫ��[i - k + 1, i] ��ѡ�����ֵ��ֻ��Ҫ��֤����
			// 1.����ͷ�����Ҫ��[i - k + 1, i]��Χ�ڣ���������Ҫ����
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			// 2.��Ȼ�ǵ�������Ҫ��֤ÿ�ηŽ�ȥ������Ҫ��ĩβ�Ķ��󣬷���Ҳ����
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			deque.offer(i);

			// ��Ϊ��������i���������ϵ�һ��k��Χ��ʱ��ÿ����һ����������ͷ�ڵ������������
			if (i >= k - 1) {
				res[idx++] = nums[deque.peek()];
			}
		}
		return res;
	}
}