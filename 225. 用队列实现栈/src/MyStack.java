import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//ģ�ⷨ ʱ�临�Ӷ�n �ռ临�Ӷ�n
//q1���ڴ洢ջ��Ԫ�� q2��Ϊ��ջ�����ĸ�������
//pushʱ��Ԫ�����q2��Ȼ��q1������Ԫ�س��Ӳ����q2
//����q1��q2
class MyStack {
	Queue<Integer> queue1;
	Queue<Integer> queue2;

	/** Initialize your data structure here. */
	public MyStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue2.offer(x);
		while (!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue1.poll();
	}

	/** Get the top element. */
	public int top() {
		return queue1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty();
	}
}

class MyStack_deque {
	// Deque �ӿڼ̳��� Queue �ӿ�
	// ���� Queue �е� add��poll��peek��Ч�� Deque �е� addLast��pollFirst��peekFirst
	Deque<Integer> que1;

	/** Initialize your data structure here. */
    public MyStack() {
        que1 = new ArrayDeque<>();
    }

	/** Push element x onto stack. */
	public void push(int x) {
		que1.addLast(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int size = que1.size();
		size--;
		// �� que1 ���� que2 �����������һ��ֵ
		while (size-- > 0) {
			que1.addLast(que1.peekFirst());
			que1.pollFirst();
		}

		int res = que1.pollFirst();
		return res;
	}

	/** Get the top element. */
	public int top() {
		return que1.peekLast();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return que1.isEmpty();
	}
}
