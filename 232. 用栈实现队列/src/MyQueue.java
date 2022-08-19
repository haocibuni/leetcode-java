import java.util.Stack;

//模拟法 时间复杂度n 空间复杂度n
//模拟一个输出栈和一个输入栈，在push数据的时候将数据放入输入栈，在输出数据的时候
//若输出栈为空，则把输入栈的数据全部导入
class MyQueue {

	Stack<Integer> stackIn;
	Stack<Integer> stackOut;

	/** Initialize your data structure here. */
	public MyQueue() {
		stackIn = new Stack<>(); // 负责进栈
		stackOut = new Stack<>(); // 负责出栈
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

	// 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
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