import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//模拟法 时间复杂度n 空间复杂度n
//q1用于存储栈内元素 q2作为入栈操作的辅助队列
//push时将元素入队q2，然后将q1的所有元素出队并入队q2
//交换q1和q2
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
	// Deque 接口继承了 Queue 接口
	// 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
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
		// 将 que1 导入 que2 ，但留下最后一个值
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
