import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//���м�˫�˶��з� ʱ�临�Ӷ�1 �ռ临�Ӷ�n
//ͨ��˫�˶��д�ŴӴ�С��Ԫ��
class MaxQueue {
	Queue<Integer> queue;
	Deque<Integer> deque;

	public MaxQueue() {
		queue = new LinkedList<Integer>();
		deque = new LinkedList<Integer>();
	}

	public int max_value() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.peekFirst();

	}

	public void push_back(int value) {

		while (!deque.isEmpty() && deque.peekLast() < value) {
			deque.pollLast();
		}
		deque.offerLast(value);
		queue.offer(value);

	}

	public int pop_front() {
		if (queue.isEmpty()) {
			return -1;
		}
		int ans = queue.poll();
		if (ans == deque.peekFirst()) {
			deque.pollFirst();
		}
		return ans;

	}
}

/**
 * Your MaxQueue object will be instantiated and called as such: MaxQueue obj =
 * new MaxQueue(); int param_1 = obj.max_value(); obj.push_back(value); int
 * param_3 = obj.pop_front();
 */