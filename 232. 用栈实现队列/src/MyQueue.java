import java.util.Stack;

//ģ�ⷨ ʱ�临�Ӷ�n �ռ临�Ӷ�n
//ģ��һ�����ջ��һ������ջ����push���ݵ�ʱ�����ݷ�������ջ����������ݵ�ʱ��
//�����ջΪ�գ��������ջ������ȫ������
class MyQueue {

	Stack<Integer> stackIn;
	Stack<Integer> stackOut;

	/** Initialize your data structure here. */
	public MyQueue() {
		stackIn = new Stack<>(); // �����ջ
		stackOut = new Stack<>(); // �����ջ
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stackIn.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		dumpstackIn();
		return stackOut.pop();
	}

	/** Get the front element. */
	public int peek() {
		dumpstackIn();
		return stackOut.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stackIn.isEmpty() && stackOut.isEmpty();
	}

	// ���stackOutΪ�գ���ô��stackIn�е�Ԫ��ȫ���ŵ�stackOut��
	private void dumpstackIn() {
		if (!stackOut.isEmpty())
			return;
		while (!stackIn.isEmpty()) {
			stackOut.push(stackIn.pop());
		}
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */